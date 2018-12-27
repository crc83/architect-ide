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
    : wbsItemStart WS ITEM_DESCRIPTION WS ESTIMATE WS ADDRESSED WS COMMENT
    ;

wbsItemStart
    : DOT+?
    ;
