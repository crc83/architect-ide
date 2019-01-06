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
//    : wbsSubItemStart ITEM_DESCRIPTION WS? wbsEstimate? WS? wbsAddressed? WS? COMMENT? NL #subItem
    : wbsItemStart ITEM_DESCRIPTION WS? wbsEstimate? WS? wbsAddressed? WS? COMMENT? NL #item
    ;

wbsSubItemStart
    : DOT+ WS?
    ;

wbsItemStart
    : DOT WS?
    ;

wbsEstimate
    : ESTIMATE WS INT EST_SCALE WS MIN WS INT EST_SCALE WS MAX WS INT EST_SCALE #fullEstimate
//    | ESTIMATE WS INT EST_SCALE #shortEstimate
    ;

wbsAddressed
    : ADDRESSED wbsItemRef      #addressedOneItem
    | ADDRESSED wbsItemRefs     #addressedItemList
    ;

wbsItemRef
    : WS REFERENCE
    ;

wbsItemRefs
    : WS? LSQBRACE WS? (REFERENCE WS? COMA)+ WS? REFERENCE RSQBRACE
    ;