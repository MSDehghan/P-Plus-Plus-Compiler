
import java_cup.runtime.*;


%%


%line
%column
%char
%unicode

%cup



%{
    /* To create a new java_cup.runtime.Symbol with information about
       the current token, the token will have no value in this
       case. */
    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }

    /* Also creates a new java_cup.runtime.Symbol with information
       about the current token, but this object has a value. */
    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }
    StringBuilder string = new StringBuilder();

%}



white = \r|\n|\t|" "
id = ("_"|[a-z]|[A-Z])([0-9]|"_"|[a-z]|[A-Z])*
//notice int number has to come latter

PositiveDecimalInteger = 0 | [1-9][0-9]*
intNumber = [+-]?{PositiveDecimalInteger}


FloatLiteral1    = [0-9]+ \. [0-9]*
FloatLiteral2    = \. [0-9]+
FloatLiteral3    = [0-9]+
Exponent = [eE] [+-]? [0-9]+

RealNumber = [+-]?({FloatLiteral1}|{FloatLiteral2}|{FloatLiteral3}) {Exponent}?



begin = "begin"
bool = "bool"
break = "break"
case = "case"
char = "char"
const = "const"
continue = "continue"
default = "default"
double = "double"
else = "else"
end = "end"
extern = "extern"
false = "false"
function = "function"
float = "float"
for = "for"
goto = "goto"
if = "if"
input = "input"
int = "int"
long = "long"
output = "output"
return = "return"
record = "record"
sizeof = "sizeof"
static = "static"
string = "string"
switch = "switch"
true = "true"
semi = ";"
eq = "="
eqeq = "=="
notEq = "!="
smallerEq = "<="
biggerEq = ">="
smaller = "<"
bigger = ">"
notc = "not"
tilda = "~"
and = "&"
andc = "and"
or = "|"
orc = "or"
carot = "^"
mult = "*"
plus = "+"
minus = "-"
plusEqual = "+="
minusEqual = "-="
multEqual = "*="
divideEqual ="/="
divide = "/"
mode = "%"
openCurlBrak = "{"
closedCurlBrak = "}"
openPran = "("
closedPran = ")"
openBrak = "["
closedBrak = "]"
doubleDot = ":"
comma = ","
foreach = "foreach"
repeat = "repeat"
in = "in"
until = "until"

LineTerminator = \r\n|\r\n
InputCharacter = [^\r\n]
TraditionalComment = "/#" [^#] ~"#/" | "/#" "#"+ "/"
EndOfLineComment = "##" {InputCharacter}* {LineTerminator}?
DocumentationComment = "/#" "#"+ [^/#] ~"#/"
Comment = {TraditionalComment} | {EndOfLineComment} | {DocumentationComment}

StringCharacter = [^\r\n\"\\]
SingleCharacter = [^\r\n\'\\]

%state STRING, CHAR


%%


{white} {/*return symbol(sym.WHITE, yytext() );*/}

{Comment}   { }


<YYINITIAL>{

 \" { yybegin(STRING); string.setLength(0); string.append("\""); }
 \' { yybegin(CHAR);  }

{until}           {return symbol(sym.UNITL,yytext());}
{in}           {return symbol(sym.IN,yytext());}
{foreach}           {return symbol(sym.FOREACH,yytext());}
{repeat}           {return symbol(sym.REPEAT,yytext());}
{comma}           {return symbol(sym.COMMA,yytext());}
{mult}           {return symbol(sym.MULT,yytext());}
{carot}           {return symbol(sym.CAROT,yytext());}
{orc}           {return symbol(sym.ORC,yytext());}
{or}           {return symbol(sym.OR,yytext());}
{andc}           {return symbol(sym.ANDC,yytext());}
{and}           {return symbol(sym.AND,yytext());}
{tilda}           {return symbol(sym.TILDA,yytext());}
{notc}           {return symbol(sym.NOTC,yytext());}
{biggerEq}     {return symbol(sym.BIGEQUAL,yytext());}
{smallerEq}     {return symbol(sym.SMALLEQUAL,yytext());}
{smaller}     {return symbol(sym.SMALLER,yytext());}
{bigger}     {return symbol(sym.BIGGER,yytext());}
{notEq}     {return symbol(sym.NOTEQUAL,yytext());}
{eqeq}      {return symbol(sym.EQEQUAL,yytext());}
{eq}        {return symbol(sym.EQUAL,yytext());}
{semi}      {return symbol(sym.SEMI,yytext());}
{begin}  { return symbol(sym.BEGIN, yytext() ) ; }
 {bool}  { return symbol(sym.BOOL, yytext() ) ; }
 {break}  { return symbol(sym.BREAK, yytext() ) ; }
 {case}  { return symbol(sym.CASE, yytext() ) ; }
 {char}  { return symbol(sym.CHAR, yytext() ) ; }
 {const}  { return symbol(sym.CONST, yytext() ) ; }
 {continue}  { return symbol(sym.CONTINUE, yytext() ) ; }
 {default}  { return symbol(sym.DEFAULT, yytext() ) ; }
 {double}  { return symbol(sym.DOUBLE, yytext() ) ; }
 {else}  { return symbol(sym.ELSE, yytext() ) ; }
 {end}  { return symbol(sym.END, yytext() ) ; }
 {extern}  { return symbol(sym.EXTERN, yytext() ) ; }
 {false}  { return symbol(sym.BOOL_CONST, yytext() ) ; }
 {function}  { return symbol(sym.FUNCTION, yytext() ) ; }
 {float}  { return symbol(sym.FLOAT, yytext() ) ; }
 {for}  { return symbol(sym.FOR, yytext() ) ; }
 {goto}  { return symbol(sym.GOTO, yytext() ) ; }
 {if}  { return symbol(sym.IF, yytext() ) ; }
 {input}  { return symbol(sym.INPUT, yytext() ) ; }
 {int}  { return symbol(sym.INT, yytext() ) ; }
 {long}  { return symbol(sym.LONG, yytext() ) ; }
 {output}  { return symbol(sym.OUTPUT, yytext() ) ; }
 {return}  { return symbol(sym.RETURN, yytext() ) ; }
 {record}  { return symbol(sym.RECORD, yytext() ) ; }
 {sizeof}  { return symbol(sym.SIZEOF, yytext() ) ; }
 {static}  { return symbol(sym.STATIC, yytext() ) ; }
 {string}  { return symbol(sym.STRING, yytext() ) ; }
 {switch}  { return symbol(sym.SWITCH, yytext() ) ; }
 {true}  { return symbol(sym.BOOL_CONST, yytext() ) ; }

{id}		{return symbol(sym.ID, yytext() );}
{RealNumber} {return symbol(sym.INT_CONST, yytext() );}
{intNumber} {return symbol(sym.REAL_CONST, yytext() );}



{divideEqual}    {return symbol(sym.DIVIDEEQUAL,yytext());}

{multEqual}           {return symbol(sym.MULTEQUAL,yytext());}
{minusEqual}           {return symbol(sym.MINUSEQUAL,yytext());}
{plusEqual}           {return symbol(sym.PLUSEQUAL,yytext());}
{plus}           {return symbol(sym.PLUS,yytext());}
{minus}           {return symbol(sym.MINUS,yytext());}
{divide}           {return symbol(sym.DIVIDE,yytext());}
{mode}           {return symbol(sym.MOD,yytext());}
{openCurlBrak}           {return symbol(sym.OPENCURLBRAK,yytext());}
{closedCurlBrak}           {return symbol(sym.CLOSEDBRAK,yytext());}
{openPran}           {return symbol(sym.OPENPRANTHES,yytext());}
{closedPran}           {return symbol(sym.CLOSEDPRANTHES,yytext());}
{openBrak}           {return symbol(sym.OPENBRAK,yytext());}
{closedBrak}           {return symbol(sym.CLOSEDBRAK,yytext());}
{doubleDot}           {return symbol(sym.DOUBLEDOT,yytext());}





}

<STRING>{
\" {yybegin(YYINITIAL); StringBuilder temp = string ; string = new StringBuilder(); return symbol(sym.STRING_CONST, temp.toString() ); }
 {StringCharacter}+  { string.append( yytext() ); }
 \\. { string.append(yytext()  ); }
}



<CHAR>{
  {SingleCharacter}\' {yybegin(YYINITIAL); return symbol(sym.CHAR_CONST, yytext() ); }
  \\.\' {yybegin(YYINITIAL); return symbol(sym.CHAR_CONST, yytext() ); }
}


[^]                    { System.out.println("shit");throw new Error("Illegal character <"+yytext()+">"); }





