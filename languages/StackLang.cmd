@echo off
setlocal enabledelayedexpansion
rem Build + run StackLang (Windows, PowerShell not required)

set "ROOT=C:\Users\jozef\OneDrive\Desktop\Semantika_Zadanie"
set "LANG=%ROOT%\languages"
set "OUT=%LANG%\lang\stacklang"
set "CP=%ROOT%\lib\*;%LANG%"
set "ANTLR_JAR=%ROOT%\lib\antlr4.jar"

if not exist "%OUT%" mkdir "%OUT%"

echo [1/4] Generate language sources
java -cp "%CP%" slang.Main -d "%OUT%" "%LANG%\StackLang.txt" || goto :err
echo [OK] Language sources generated.

echo [2/4] Generate ANTLR lexer/parser
java -cp "%ANTLR_JAR%" org.antlr.v4.Tool -o "%OUT%" "%OUT%\StackLang.g4" || goto :err
echo [OK] Lexer/parser generated.

echo [3/4] Compile generated sources + driver
pushd "%LANG%"
for %%F in (lang\stacklang\*.java) do set LAST=%%F
if not defined LAST echo No Java sources found & goto :err
javac -cp "%ANTLR_JAR%;." lang\stacklang\*.java StackLangMain.java || goto :err
popd
echo [OK] Compilation successful.

echo.
echo ================= Vsetko je pripravene =================
echo Napiste prikazy StackLang, potom stlacte Ctrl+Z a Enter
echo Priklad: load 3 load 4 add dup mul
echo ========================================================
echo.

pushd "%LANG%"
java -cp "%ANTLR_JAR%;." StackLangMain
popd
goto :eof

:err
echo Build failed.
exit /b 1