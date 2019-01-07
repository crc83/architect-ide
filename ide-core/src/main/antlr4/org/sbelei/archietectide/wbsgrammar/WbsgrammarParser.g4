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
    : wbsItemStart ITEM_DESCRIPTION WS? wbsFullEstimate? WS? wbsAddressed? WS? COMMENT? NL #item
    ;

wbsSubItemStart
    : DOT+ WS+?
    ;

wbsItemStart
    : DOT WS+?
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
    : ADDRESSED wbsItemRef      #addressedOneItem
    | ADDRESSED wbsItemRefs     #addressedItemList
    ;

wbsItemRef
    : WS REFERENCE
    ;

wbsItemRefs
    : WS? LSQBRACE WS? (REFERENCE WS? COMA)+ WS? REFERENCE RSQBRACE
    ;