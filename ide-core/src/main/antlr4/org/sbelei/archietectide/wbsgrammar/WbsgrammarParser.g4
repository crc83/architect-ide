parser grammar WbsgrammarParser;

options {
    tokenVocab = WbsgrammarLexer;
    superClass = WBSGrammar;
}

@header {

}

wbsItem
    : ITEM_START ITEM_DESCRIPTION ESTIMATE ADDRESSED COMMENTS
    ;