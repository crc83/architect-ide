package org.sbelei.archietectide.wbsgrammar;

import static org.junit.jupiter.api.Assertions.*;

import java.util.BitSet;
import java.util.Iterator;

import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.junit.jupiter.api.Test;

public class WbsgrammarLexerTest {

    //This is what I expect to parse here
    private static final String WBS_ITEM_UNDER_TEST =
            "1. | Analyze existing WBS approach   | estimate 10d min 2d max 20d   addressed R-01		//comment";

    @Test
    void testLexterGoesFine() throws Exception {

        WbsgrammarLexer lexer = new WbsgrammarLexer(CharStreams.fromString(WBS_ITEM_UNDER_TEST));

        //Error listener for tests.
        //Aimed just to count all lexer errors
        var listener = new ANTLRErrorListener() {

            int errorCount = 0;
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine,
                    String msg, RecognitionException e) {
                errorCount++;
            }

            @Override
            public void reportContextSensitivity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, int prediction,
                    ATNConfigSet configs) {
                errorCount++;

            }

            @Override
            public void reportAttemptingFullContext(Parser recognizer, DFA dfa, int startIndex, int stopIndex,
                    BitSet conflictingAlts, ATNConfigSet configs) {
                errorCount++;
            }

            @Override
            public void reportAmbiguity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, boolean exact,
                    BitSet ambigAlts, ATNConfigSet configs) {
                errorCount++;
            }
        };
        lexer.addErrorListener(listener);

        // test itself
        Iterator<? extends Token> itea =  lexer.getAllTokens().iterator();
        assertEquals(0, listener.errorCount, "Lexer pharsed wbs item without errors");

        while (itea.hasNext()) {
           System.out.println( itea.next());
        };

    }
}
