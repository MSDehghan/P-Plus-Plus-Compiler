%{
    
    extern int yylex();
    void yyerror(const char *s) { printf("ERROR: %sn", s); }
%}



%union {

    int val;
}



%token id
%token semi
%token extern
%token openBrak
%token closedBrak
%token int
%token bool
%token float
%token long
%token char
%token double
%token string
%token void
%token auto
%token record
%token begin
%token end
%token const
%token comma
%token equal
%token beingQ
%token endQ
%token return
%token break
%token continue
%token sizeof
%token if
%token else
%token switch
%token openPranthes
%token closedPranthes
%token openCurlBrak
%token closedCurlBrak
%token of
%token case
%token int_const
%token doubleDot
%token for
%token repeat
%token unitl
%token foreach
%token in
%token minus
%token plus
%token exclem
%token mm
%token pp
%token tilda
%token mult
%token divide
%token mod
%token or
%token and
%token carot
%token eqEqual
%token notEqual
%token bigEqual
%token smallEqual
%token smaller
%token bigger
%token ANDC
%token ORC
%token NOTC
%token real_const
%token char_const
%token bool_const
%token string_const
%token long_const
%token <val>  default






%type <val>  program
%type <val>  var_dcl
%type <val>  func_extern
%type <val>  struct_dec
%type <val>  func_dcl
%type <val>  extern_dcl
%type <val>  type
%type <val>  arguments
%type <val>  block
%type <val>  var_dcl_cnt
%type <val>  variable
%type <val>  expr
%type <val>  statement
%type <val>  assignment
%type <val>  method_call
%type <val>  cond_stmt
%type <val>  loop_stmt
%type <val>  parameters
%type <val>  binary_op
%type <val>  const_val
%type <val>  arithmatic
%type <val>  conditional
%type <val>  exp1
%type <val>  exp2
%type <val>  exp3
%type <val>  exp4
%type <val>  exp5
%type <val>  exp6
%type <val>  exp7
%type <val>  exp8
%type <val>  exp9
%type <val>  exp10
%type <val>  exp11
%type <val>  exp12
%type <val>  exp13
%type <val>  exp14
%type <val>  exp15
%type <val>  exp16
%type <val>  exp17
%type <val>  exp18
%type <val>  exp19
%type <val>  exp20
%type <val>  exp21
%type <val>  exp22
%type <val>  exp23
%type <val>  exp24
%type <val>  exp25

%type <val>  argumentsOptional


%start program




%%


/* first */
program :		exp1 exp2 { };
exp1	:		exp3 { }
		|		exp4 { }
		|		exp5 { }
		;

exp2 	:		program { }
		|		/* empty */ { }
		;


exp3	:		/* empty */ { }
		|		var_dcl exp3 { }
		;


exp4	:		/* empty */ { }
		|		func_extern exp4  { }
		;



exp5	:		/* empty */ { }
		|		struct_dec exp5  { }
		;



/* second */

func_extern 	:		func_dcl { }
				|		extern_dcl { }
				;


/* third */

func_dcl		:		type id openPranthes argumentsOptional closedPranthes semi { }
				|		type id openPranthes argumentsOptional closedPranthes block { }
				;

/* forth */

extern_dcl		:		extern type id semi		{ }
				;


/* fifth */
arguments 		:		type id exp8 exp9		{ }
				;



exp6 			:		openBrak closedBrak exp7	{ }
				;
exp7			:		/* empty */ { }
				|		exp6 		{ }
				;
exp8			:		exp6 		{ }
				|		/* empty */ { }
				;
exp9			:		comma arguments 	{ }
				|		/* empty */			{ }
				;

/* sixth */
type	:	int 		{ }
		|	bool 		{ }
		|	float		{ }
		|	long 		{ }
		|	char 		{ }
		|	double 		{ }
		|	id			{ }
		|	string 		{ }
		|	void		{ }
		|	auto 		{ }
		;


/* seventh */
struct_dec	:	record id begin exp10 end record semi { }
			;
exp10		:	var_dcl exp11		{ }
			;
exp11		:	exp10				{ }
			|	/* empty */			{ }
			;

/* eightth */
var_dcl 	:	exp12 type var_dcl_cnt exp13	{ }
			;
exp12		:	const 				{ }
			|	/* empty */ 		{ } ;
exp13		:	comma var_dcl_cnt exp13		{ } 
			|	/* empty */ 				{ }
			;

/* nineth */
var_dcl_cnt		:		variable exp14	{ }
				;
exp14			:		equal expr 		{ }
				|		/* empty */		{ }
				;

/* tenth */
block		:		begin exp15 end { } 
			;
exp15		:		exp16 exp15		{ }
			|		/* empty */		{ }
			;
exp16		:		var_dcl			{ }
			|		statement		{ }
			;

/* eleventh */
statement		:		assignment			{ }
				|		method_call	semi	{ }
				|		cond_stmt			{ }
				|		loop_stmt			{ }
				|		return exp17 semi	{ }
				|		break semi			{ }
				|		continue semi		{ }
				|		sizeof openPranthes type closedPranthes		{ }
				;
exp17			:		expr				{ }
				|		/* empty */			{ }
				;

/* twelveth */
assignment		:		variable equal expr		{ }
				;

/* thirteenth */
method_call		:		id openPranthes exp18 closedPranthes	{ }	
				;
exp18			:		parameters		{ }
				|		/* empty */		{ }
				;

/* fourteenth */
parameters		:		expr	{ }
				|		expr comma parameters	{ }
				;


/* fifteenth */
cond_stmt		:		if openPranthes expr closedPranthes block exp19	{ }
				|		switch openPranthes id 	closedPranthes of doubleDot openCurlBrak exp20 default doubleDot block closedCurlBrak		{ }
				;
exp19			:		else block		{ }
				|		/* empty */		{ }
				;
exp20			:		case int_const doubleDot block exp20	{ }
				|		/* empty */								{ }
				;



/* sixteenth */
loop_stmt 		:		for openPranthes exp21 semi expr semi exp22 closedPranthes block		{ }
				|		repeat block unitl openPranthes expr closedPranthes semi				{ }
				|		foreach openPranthes id in id closedPranthes block						{ }
				;






exp21 			:		var_dcl 		{ }
				| 		/* empty */		{ }
				;


exp22			:		assignment		{ }
				|		expr			{ }
				|		/* empty */		{ }
				;




/* eighteenth */
expr		:		expr binary_op expr						{ }
			|		openPranthes expr closedPranthes		{ }
			|		method_call								{ }
			|		variable								{ }
			|		const_val								{ }
			|		minus expr								{ }
			|		exclem expr								{ }
			;



/* tweenth */
variable		:		id exp23			{ }
				|		tilda variable		{ }
				|		mm	variable		{ }
				|		pp	variable		{ }
				|		variable mm			{ }
				|		variable pp			{ }
				;

exp23			:		exp24				{ }
				|		/* empty */			{ }
				;
exp24			:		exp25 exp24			{ }
				|		/* empty */			{ }
				;
exp25			:		openBrak expr closedBrak { }
				;



/* tweny first */
binary_op		:		arithmatic		{ }
				|		conditional		{ }
				;

/* twenty second */
arithmatic		:		plus		{ }
				|		minus		{ }
				|		mult		{ }
				|		divide		{ }
				|		mod			{ }
				|		and			{ }
				|		or 			{ }
				|		carot		{ }
				;


/* twenty third */
conditional		:		eqEqual			{ }
				|		notEqual		{ }
				|		bigEqual		{ }
				|		smallEqual		{ }
				|		smaller			{ }
				|		bigger			{ }
				|		ANDC			{ }
				|		ORC 			{ }
				|		NOTC			{ }
				;


/* twenty fourth */
const_val		:		int_const		{ }
				|		real_const		{ }
				|		char_const 		{ }
				|		bool_const		{ }
				|		string_const 	{ }
				|		long_const		{ }
				;







/* addition made for the third */
argumentsOptional		:		arguments 	{ }
						|		/* empty */ { }
						;

%%





