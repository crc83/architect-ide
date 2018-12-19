parser grammar WbsgrammarParser;

options {
    tokenVocab = WbsgrammarLexer;
}

@header {

}

wbsItem
    : ITEM_START ITEM_DESCRIPTION ESTIMATE ADDRESSED COMMENTS
    ;