parser grammar WbsgrammarParser;

options {
    tokenVocab = WbsgrammarLexer;
}

@header {

}

wbs
    : wbsItem+
    ;

wbsItem
    : wbsItemStart ITEM_DESCRIPTION WS? wbsEstimate WS? wbsAddressed WS? COMMENT #item
    | wbsItemStart ITEM_DESCRIPTION #unestimatedUnaddressedItem
    ;

wbsItemStart
    : DOT+? WS?
    ;

wbsEstimate
    : ESTIMATE WS INT EST_SCALE WS MIN WS INT EST_SCALE WS MAX WS INT EST_SCALE
    ;

wbsAddressed
    : ADDRESSED wbsItemRef
    | ADDRESSED wbsItemRefs
    ;

wbsItemRef
    : WS REFERENCE
    ;

wbsItemRefs
    : WS? LSQBRACE WS? (REFERENCE WS? COMA)+ WS? REFERENCE RSQBRACE
    ;