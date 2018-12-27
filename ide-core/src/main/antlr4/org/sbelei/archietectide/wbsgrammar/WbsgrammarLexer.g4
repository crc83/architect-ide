lexer grammar WbsgrammarLexer;

@header {

}
ESTIMATE    : 'estimate'    ;
ADDRESSED   : 'addressed'   ;
DOT         : '.'           ;
DSLASH      : '//'          ;
PIPE        : '|'           ;
INT : DIGIT+ ; // references the DIGIT helper rule
ITEM_DESCRIPTION : PIPE CONTENT+ PIPE;
COMMENT : DSLASH CONTENT+;
fragment DIGIT : [0-9] ; // not a token by itself
fragment LETTER: [A-Z,a-z];
fragment WS_CHAR: [\t,' '];
fragment CONTENT: DIGIT | LETTER | WS_CHAR;
WS  :   WS_CHAR+;

// -------------------------
// Punctuation
/*
COLON		: Colon			;
COLONCOLON	: DColon		;
COMMA		: Comma			;
SEMI		: Semi			;
LPAREN		: LParen		;
RPAREN		: RParen		;
LBRACE		: LBrace		;
RBRACE		: RBrace		;
RARROW		: RArrow		;
LT			: Lt			;
GT			: Gt			;
ASSIGN		: Equal			;
QUESTION	: Question		;
STAR		: Star			;
PLUS_ASSIGN	: PlusAssign	;
PLUS		: Plus			;
OR			: Pipe			;
DOLLAR		: Dollar		;
RANGE		: Range			;
DOT			: Dot			;
AT			: At			;
POUND		: Pound			;
NOT			: Tilde			;

 */
// -------------------------
// Identifiers
/*
ID	: NameStartChar NameChar* ;
 */
// -------------------------
// Whitespace
/*
WS	:	( Hws | Vws )+	-> channel(HIDDEN)	;

ERRCHAR
    :	.	-> channel(HIDDEN)
    ;
*/