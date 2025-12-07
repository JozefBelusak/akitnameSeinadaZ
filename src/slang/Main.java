// ---------------------------------------------------------------------------
// Main.java
// SLANG main program.
// $Id: Main.java,v 1.16 2025/02/10 09:35:13 schreine Exp schreine $
//
// (c) 2023 https://www.risc.jku.at/research/formal/software/SLANG
// Wolfgang.Schreiner <Wolfgang.Schreiner@risc.jku.at>
// William Steingartner <william.steingartner@tuke.sk>
//
// This program is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with this program.  If not, see <http://www.gnu.org/licenses/>.
// ----------------------------------------------------------------------------
package slang;

import java.io.*;
import java.nio.charset.*;
import java.util.*;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;

import slang.syntax.*;
import slang.parser.*;
import slang.types.*;
import slang.code.*;

public class Main
{
  // the program information
  public final static String VERSION = "1.0.3 (January 10, 2025)";
  public final static String COPYRIGHT =
    "SLANG Semantics-Based Language Generator " + VERSION + "\n" +
    "(c) 2023 https://www.risc.jku.at/research/formal/software/SLANG\n" +
    "This is free software distributed under the terms of the GNU GPL.\n" +
    "Execute \"SLANG -h\" to see the available command line options.\n" +
    "-----------------------------------------------------------------";
  
  // the character set
  public static final String CHAR_SET_NAME = "UTF-8";
  public static final Charset CHAR_SET = Charset.forName(CHAR_SET_NAME);
  
  // the current input/output interface
  private static BufferedReader in = null;
  private static PrintWriter out = null;
  public static BufferedReader getIn() { return in; }
  public static PrintWriter getOut() { return out; }
  
  // the path of the input file
  private static String path = null;
  
  // execution options
  private static boolean optionAST = false; // print abstract syntax tree
  private static String dirPath = System.getProperty("user.dir"); // path of output directory
  
  /****************************************************************************
   * SLANG [ <options> ] [ <path> ]
   * @param args see help() for command line options
   ***************************************************************************/
  public static void main(String[] args)
  {
    in = new BufferedReader(new InputStreamReader(System.in, CHAR_SET));
    out = new PrintWriter(System.out, true);
    out.println(COPYRIGHT);
    processArguments(args);
    Source source = readSource();
    AST.Language language = parseSource(source);
    if (optionAST) System.out.println(language);
    TypeChecker.check(language);
    File directory = new File(dirPath);
    CodeGeneratorJava.generate(language, directory);
    System.out.println("SUCCESS: execution successfully completed.");
  }
  
  /***************************************************************************
   * Print help on command line arguments and exit.
   **************************************************************************/
  private static void help()
  {
    out.println("SLANG [ <options> ] [ <path> ]");
    out.println("<path>: path of language file (if none, read from stdin)");
    out.println("<options>: the following command line options");
    out.println("-h: print this message and exit");
    out.println("-ast: print abstract syntax tree of language specification");
    out.println("-d <path>: path of directory in which to generate code");
    System.exit(-1);
  }
  
  /***************************************************************************
   * Process command line arguments.
   * @args the arguments.
   **************************************************************************/
  private static void processArguments(String[] args)
  {
    int n = args.length;
    int i = 0;
    while (i < n)
    {
      String arg = args[i];
      i++;
      switch (arg)
      {
      case "-h" :
        help();
        break;
      case "-ast" :
        optionAST = true;
        break;
      case "-d" :
        if (i == n) 
        { 
          out.println("option -d requires argument <path>");
          help();
        }
        dirPath = args[i];
        i++;
        break;
      default:
        if (arg.startsWith("-") || i < n) 
        {
          out.println("Unknown command line option: " + arg);
          help();
        }
        path = arg;
      }
    }
  }
  
  /***************************************************************************
   * Print error message and exit.
   * @param msg the error message.
   **************************************************************************/
  public static void exit(String msg)
  {
    out.println("ERROR: " + msg + ".");
    System.exit(-1);
  }
  
  // the source to be processed
  private static class Source
  {
    public final List<String> lines; // the sequence of lines
    public final String text;        // its complete content
    public Source(List<String> lines, String text)
    {
      this.lines = lines;
      this.text = text;
    }
  }
  
  /****************************************************************************
   * read source denoted by path (stdin, if path is null)
   * aborts if file could not be read
   ***************************************************************************/
  private static Source readSource()
  {
    File file = path == null ? null : new File(path); 
    List<String> lines = readFile(file);
    if (lines == null) { return null; }
    StringBuilder builder = new StringBuilder();
    String eol = System.lineSeparator();
    for (String line : lines) builder.append(line).append(eol);
    String text = builder.toString();
    return new Source(lines, text);
  }
  
  /***************************************************************************
   * Read denoted file and return its contents.
   * @param file the file (null, if from standard input is to be read)
   * @return the lines of the file (null, if something went wrong; in
   *         this case a warning is printed).
   **************************************************************************/
  public static List<String> readFile(File file)
  {
    if (file == null)
    {
      out.println("Reading standard input.");
    }
    else
    {
      out.println("Reading file " + file.getAbsolutePath() + ".");
    }
    try(BufferedReader fileReader = file == null ? in : 
        new BufferedReader(new FileReader(file, CHAR_SET));)
    { 
      List<String> result = new ArrayList<String>();
      while (true)
      {
        String line = fileReader.readLine();
        if (line == null) return result;
        result.add(line);
      }
    }
    catch(IOException e)
    {
      exit(e.getMessage());
      return null;
    }
  }
  
  // prevent infinite error recovery loop (e.g. "for i:T=...")
  private static class ErrorStrategy extends DefaultErrorStrategy
  {
    private int attempts;
    public ErrorStrategy(int attempts)
    {
      this.attempts = attempts;
    }
    public void sync(Parser recognizer) 
    { 
      attempts--;
      if (attempts < 0) throw new ParseCancellationException("");
    }
  }
  
  // the handling of parse errors
  private static class ErrorListener extends BaseErrorListener
  {
    private Source source = null;
    private int errors = 0;
    private ErrorListener(Source source)
    {
      this.source = source;
      errors = 0;
    }
    public int getErrors() { return errors; }
    public void syntaxError(Recognizer<?,?> recognizer,
      Object offendingSymbol, int line, int charPositionInLine,
      String msg, RecognitionException e)
    {
      errors++;
      try { Thread.sleep(1); } catch(Exception ex) { }
      if (line >= 1 && line <= source.lines.size())
      {
        out.println(source.lines.get(line-1));
        for (int i = 0; i < charPositionInLine; i++)
          out.print(' ');
        out.println('^');
      }
      out.println("line " + line + ": " + msg);
    }
  }
  
  /***************************************************************************
   * Parse source.
   * @param source the source to be parsed.
   * @return the resulting language description.
   **************************************************************************/
  private static AST.Language parseSource(Source source)
  {
    ErrorListener listener = null;
    try
    {
      CodePointCharStream input = CharStreams.fromString(source.text);
      SLANGLexer lexer = new SLANGLexer(input);
      TokenStream tokens = new CommonTokenStream(lexer);
      SLANGParser parser = new SLANGParser(tokens);
      parser.setErrorHandler(new ErrorStrategy(50000));
      listener = new ErrorListener(source);
      parser.removeErrorListeners();
      parser.addErrorListener(listener);
      SLANGParser.LanguageContext context = parser.language();
      int errors = listener.getErrors();
      if (errors > 0) exit(errors + " syntax errors");
      TreeTranslator translator = new TreeTranslator();
      return (AST.Language)translator.visit(context);
    }
    /*
    catch(ParseCancellationException e)
    {
      if (listener == null)
        exit("syntax errors");
      else
        exit(listener.getErrors() + " syntax errors");
    }
    */
    catch(Exception e)
    {
      StringWriter w = new StringWriter();
      e.printStackTrace(new PrintWriter(w));
      exit("parser error (" + w.toString() +")");
    }
    return null;
  }
}
// ---------------------------------------------------------------------------
// end of file
// ---------------------------------------------------------------------------
