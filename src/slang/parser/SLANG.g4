// ---------------------------------------------------------------------------
// SLANG.g4
// Semantic Language Generator ANTLR4 Grammar 
// $Id: SLANG.g4,v 1.21 2024/10/24 15:11:50 schreine Exp $
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

grammar SLANG;

options 
{
  language=Java;
}

@header 
{
  package slang.parser;
}

// ---------------------------------------------------------------------------
// problems and declarations
// ---------------------------------------------------------------------------

// languages
language: 'language' id '{'( ';' )* ( clause ( ';' )* )* '}' EOF ;

// clauses
clause:
  'target' 'java' '{' 'header' literal '}'    #Target
| 'code' literal                              #Code
| 'domains' '{' ( domaindef )* '}'            #Domains
| 'printer' '{' ( printerdomain )* '}'        #Printer
| 'parser' 'antlr4' '{' ( parserdomain )* '}' #Parser
| ( 'judgment' | 'judgement' ) ( in=types )? ( '⊢' | '|-' ) 
  domain=id ':' fun=id ( '(' out=types ')' )? '{' ( inference )* '}' 
  ( 'before' ( bin=ids )? ( '⊢' | '|-' ) bid=id ':' 
     before=id ( '(' bout=ids ')' )? bliteral=literal )?
  ( 'after' ( ain=ids )? ( '⊢' | '|-' ) aid=id ':' 
     after=id ( '(' aout=ids ')' )? aliteral=literal )?   #Judgment
| 'transition' ( '⟨' | '<<' )? domain=id ( ',' in=types )? ( '⟩' | '>>' )? 
    ( '→' | '->' ) ( fun=id )? 
    ( '⟨' | '<<' )? out=types ( '⟩' | '>>' )? '{' ( step )* '}' 
  ( 'before' ( bin=ids )? ( '⊢' | '|-' ) bid=id ':' 
     before=id ( '(' bout=ids ')' )? bliteral=literal )?
  ( 'after' ( ain=ids )? ( '⊢' | '|-' ) aid=id ':' 
     after=id ( '(' aout=ids ')' )? aliteral=literal )?   #Transition
| 'function' ( fun=id )? ( '〚' | '[[' ) domain=id ( '〛' | ']]' ) 
  ':' ( in=types ( '→' | '->' ) )? out=types '{' ( equation )* '}' 
  ( 'before' ( before=id )? ( '〚' | '[[' ) bid=id ( '〛' | ']]' ) 
  ( '(' bin=ids ')' )? bliteral=literal )? 
  ( 'after' ( after=id )? ( '〚' | '[[' ) aid=id ( '〛' | ']]' ) 
  ( '(' ain=ids ')' )? '=' aout=ids aliteral=literal )?   #Function
;

// domains and their constructors
domaindef: id '=' domaincon ( '+' domaincon )* ';' ;
domaincon: id ( '[' ( domainname ( ',' domainname )* ) ']' )? ;
domainname:
  id      #DomainId 
| literal #DomainLiteral 
;

// printers
printerdomain: 'domain' id '{' ( printercase )* '}' ;
printercase: 'case' domainpattern ( '→' | '->' ) literal ';' ;

// parsers
parserdomain: 'domain' id ( 'prefix' literal )? '{' ( parsercase )* '}' ;
parsercase: 'case' literal ( '→' | '->' ) domainexp ';' ;

// inferences, steps, and equations
inference : 
  'inference' ( in=ids )? ( '⊢' | '|-' ) domainpattern ':' id ( '(' out=ids ')' )?
  bodies ( 'before' before=literal )? ( 'after' after=literal )?
;
step : 
  'step' ( '⟨' | '<<' )? domainpattern ( ',' in=ids )? ( '⟩' | '>>' )? 
  ( '→' | '->' ) ( id )? ( '⟨' | '<<' )? out=ids ( '⟩' | '>>' )?
  bodies ( 'before' before=literal )? ( 'after' after=literal )?
;
equation :
  'equation' ( id )? ( '〚' | '[[' ) domainpattern ( '〛' | ']]' ) 
  ( '(' in=ids ')' )? '=' out=ids 
  bodies ( 'before' before=literal )? ( 'after' after=literal )?
;

// bodies and commands
body: '{' ( command )* '}' ;
command :
  literal                                           #CommandLiteral
| ( in=ids )? ( '⊢' | '|-' ) id ':' id ( '(' out=ids ')' )? ';' #CommandInference
| ( '⟨' | '<<' )? id ( ',' in=ids )? ( '⟩' | '>>' )? ( '→' | '->' ) ( id )? 
  ( '⟨' | '<<' )? out=ids ( '⟩' | '>>' )? ';'       #CommandStep
| variables ( '=' value )? ';'                      #Assignment
;

// auxiliaries
variable: id ( ':' type )?;
value: 
  id                       #ValueId
| literal                  #ValueLiteral
| ( fun=id )? ( '〚' | '[[' ) domain=id ( '〛' | ']]' )
  ( '(' values ')' )?      #Application
;
domainpattern: ( res=id '=' )? con=id ( '[' ids ']' )? ;
domainexp: 
  literal             #DomainExpLiteral
| id ( '[' ids ']' )? #DomainExpApplication
;
type: literal ;

// sequences
types: type ( ( '×' | '*' | ',' ) type )* ;
bodies: body ( 'or' body )* ;
values : value ( ',' value )* ;
variables: variable ( ',' variable )* ;
ids: id ( ',' id )* ;

// wrappers for lexer domains
id: ID ; 
literal: LITA | LITB | LITC | LITD ;

// ---------------------------------------------------------------------------
// lexical rules
// ---------------------------------------------------------------------------

ID   : [a-zA-Z_][a-zA-Z_0-9]* ;

LITA : '{##' .*? '##}' ;
LITB : '##' .*? '##' ;
LITC : '{#' .*? '#}' ;
LITD : '#' .*? '#' ;

WHITESPACE  : [ \t\r\n\f]+ -> skip ;
LINECOMMENT : '//' .*? '\r'? ('\n' | EOF) -> skip ;
COMMENT     : '/*' .*? '*/' -> skip ;

// matches any other character
ERROR : . ;

// ---------------------------------------------------------------------------
// end of file
// ---------------------------------------------------------------------------
