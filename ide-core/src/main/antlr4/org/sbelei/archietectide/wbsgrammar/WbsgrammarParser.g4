parser grammar WbsgrammarParser;

options {
    tokenVocab = WbsgrammarLexer;
}

@header {

}

wbs
    : wbsItem+
    ;

//let's support only one level deeprer for start'
wbsItem
    : wbsItemStart ITEM_DESCRIPTION WS? wbsFullEstimate? WS? wbsAddressed? WS? wbsComment? NL
    ;

wbsItemStart
    : DOT+ WS+?
    ;

wbsFullEstimate
    : wbsAvgEstimate (WS wbsMinEstimate)? (WS wbsMaxEstimate)?
    ;

wbsAvgEstimate
    : ESTIMATE WS INT EST_SCALE
    ;

wbsMinEstimate
    : MIN WS INT EST_SCALE
    ;

wbsMaxEstimate
    : MAX WS INT EST_SCALE
    ;

wbsAddressed
    : ADDRESSED wbsItemRefs
    ;

wbsComment
    : COMMENT
    ;

wbsItemRefs
    : WS REFERENCE
    | WS? LSQBRACE WS? (REFERENCE WS? COMA)+ WS? REFERENCE RSQBRACE
    ;