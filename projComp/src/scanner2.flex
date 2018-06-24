
import java_cup.runtime.*;


%%


%line
%column
%char
%unicode


%type String



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
{eq}        {return yytext()+" eq ";}
{semi}      {return yytext() +" semi ";}
{ begin }  { return yytext() + " begin " ; }
 { bool }  { return yytext() + " bool "; }
 { break }  { return yytext() + " break " ; }
 { case }  { return yytext() + " case "; }
 { char }  { return yytext() + " char "; }
 { const }  { return yytext() + " const "; }
 { continue }  { return yytext() +" continue "; }
 { default }  { return yytext() +" default "; }
 { double }  { return yytext() + " double "; }
 { else }  { return yytext() + " else "; }
 { end }  { return yytext() + " end "; }
 { extern }  { return yytext() + " extern "; }
 { false }  { return yytext() + " false "; }
 { function }  { return yytext() +" function "; }
 { float }  { return yytext() +" float "; }
 { for }  { return yytext() +" for "; }
 { goto }  { return yytext() + " goto "; }
 { if }  { return yytext() +" if "; }
 { input }  { return yytext() +  " input "; }
 { int }  { return yytext() + " int " ; }
 { long }  { return yytext() +  " long "; }
 { output }  { return yytext() + " output "; }
 { return }  { return yytext() + " return "; }
 { record }  { return yytext() + " record "; }
 { sizeof }  { return yytext() +" sizeof "; }
 { static }  { return yytext() + " static "; }
 { string }  { return yytext() +" string "; }
 { switch }  { return yytext() +" switch "; }
 { true }  { return yytext() +" true "; }
{id}		{return yytext()+" id ";}
{intNumber} {return yytext()+" int ";}
{RealNumber} {return yytext()+" RL ";}
}

<STR>{
	"*/" { }
	.   {  }
}



<COMMENT>{
	"#/" {}
	. {}

}


[^]                    { throw new Error("Illegal character <"+yytext()+">"); }





