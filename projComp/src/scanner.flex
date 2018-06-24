
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



begin = "Begin"
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



%state STR, COMMENT


%%


{white} {/*return symbol(sym.WHITE, yytext() );*/}




<YYINITIAL>{
{eq}        {return symbol(sym.EQUAL,yytext());}
{semi}      {return symbol(sym.SEMI,yytext());}
{ begin }  { return symbol(sym.BEGIN, yytext() ) ; }
 { bool }  { return symbol(sym.BOOL, yytext() ) ; }
 { break }  { return symbol(sym.BREAK, yytext() ) ; }
 { case }  { return symbol(sym.CASE, yytext() ) ; }
 { char }  { return symbol(sym.CHAR, yytext() ) ; }
 { const }  { return symbol(sym.CONST, yytext() ) ; }
 { continue }  { return symbol(sym.CONTINUE, yytext() ) ; }
 { default }  { return symbol(sym.DEFAULT, yytext() ) ; }
 { double }  { return symbol(sym.DOUBLE, yytext() ) ; }
 { else }  { return symbol(sym.ELSE, yytext() ) ; }
 { end }  { return symbol(sym.END, yytext() ) ; }
 { extern }  { return symbol(sym.EXTERN, yytext() ) ; }
 { false }  { return symbol(sym.FALSE, yytext() ) ; }
 { function }  { return symbol(sym.FUNCTION, yytext() ) ; }
 { float }  { return symbol(sym.FLOAT, yytext() ) ; }
 { for }  { return symbol(sym.FOR, yytext() ) ; }
 { goto }  { return symbol(sym.GOTO, yytext() ) ; }
 { if }  { return symbol(sym.IF, yytext() ) ; }
 { input }  { return symbol(sym.INPUT, yytext() ) ; }
 { int }  { return symbol(sym.INT, yytext() ) ; }
 { long }  { return symbol(sym.LONG, yytext() ) ; }
 { output }  { return symbol(sym.OUTPUT, yytext() ) ; }
 { return }  { return symbol(sym.RETURN, yytext() ) ; }
 { record }  { return symbol(sym.RECORD, yytext() ) ; }
 { sizeof }  { return symbol(sym.SIZEOF, yytext() ) ; }
 { static }  { return symbol(sym.STATIC, yytext() ) ; }
 { string }  { return symbol(sym.STRING, yytext() ) ; }
 { switch }  { return symbol(sym.SWITCH, yytext() ) ; }
 { true }  { return symbol(sym.TRUE, yytext() ) ; }
{id}		{return symbol(sym.ID, yytext() );}
{intNumber} {return symbol(sym.REAL_CONST, yytext() );}
{RealNumber} {return symbol(sym.INT_CONST, yytext() );}

}

<STR>{
	"*/" { }
	.   {  }
}



<COMMENT>{
	"#/" {}
	. {}

}


[^]                    { System.out.println("shit");throw new Error("Illegal character <"+yytext()+">"); }





