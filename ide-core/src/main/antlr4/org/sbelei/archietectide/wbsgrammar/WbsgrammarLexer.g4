lexer grammar WbsgrammarLexer;

@header {

}
ESTIMATE    : [Ee][Ss][Tt][Ii][Mm][Aa][Tt][Ee];
ADDRESSED   : [Aa][Dd][Dd][Rr][Ee][Ss][Ss][Ee][Dd];
MIN : [Mm][Ii][Nn];
MAX : [Mm][Aa][Xx];
DOT         : '.';
LSQBRACE : '[';
RSQBRACE : ']';
COMA : ',';
NL : '\r'?'\n';
fragment DSLASH      : '//'          ;
fragment PIPE        : '|'           ;
fragment REFERENCE_CHAR : DIGIT | LETTER | [-_];
fragment DIGIT : [0-9] ;
fragment LETTER: [a-zA-Z\u0080-\u00FF];
fragment WS_CHAR: [\t,' '];
fragment CONTENT_CHAR: DIGIT | LETTER | WS_CHAR;
WS : WS_CHAR+;
REFERENCE : LETTER REFERENCE_CHAR+;
COMMENT : DSLASH CONTENT_CHAR+;
INT : DIGIT+ ;
ITEM_DESCRIPTION : PIPE CONTENT_CHAR+ PIPE;
fragment DAYS : [Dd][Aa][Ys][Ss] | [Dd] ;
fragment HRS  : [Hh][Oo][Uu][Rr][Ss] | [Hh][Rr][Ss] | [Hh] ;
EST_SCALE : DAYS | HRS;

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