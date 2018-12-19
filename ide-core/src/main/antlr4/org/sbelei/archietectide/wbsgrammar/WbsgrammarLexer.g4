lexer grammar WbsgrammarLexer;

// import WbsgrammarFragments;

@header {

}

// -------------------------
// Comments

ITEM_START
    : [#]+
    ;

COMMENTS
    : //*.?\n
    ;

ESTIMATE
    : 'estimate'*.?
    ;

ADDRESSED
    : 'addressed'*.?
    ;

ITEM_DESCRIPTION
    : '|'*.?'|'
    ;

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