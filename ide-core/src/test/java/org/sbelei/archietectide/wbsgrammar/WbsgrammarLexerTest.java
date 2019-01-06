package org.sbelei.archietectide.wbsgrammar;

import static org.junit.jupiter.api.Assertions.*;

import java.util.BitSet;
import java.util.Iterator;
import java.util.stream.Stream;

import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.sbelei.archietectide.wbsgrammar.WbsgrammarParser.WbsContext;

public class WbsgrammarLexerTest {

    @SuppressWarnings("unused")
    private static Stream<Arguments> createWbsItems() {
        return Stream.of(
Arguments.of("1st level full estimate, multiple addressed",
". | Analyze 1 existing WBS approach   | estimate 5 min 1 max 20 addressed [R-10, C-20] //comment"),
Arguments.of("1st level full estimate, ONE addressed",
        ". | Analyze 1 existing WBS approach   | estimate 5 min 1 max 20 addressed R-10 //comment"),
Arguments.of("1st level with keywords inside item description",
". | Analyze addressed items and estimate 1 existing WBS approach   | estimate 5 min 1 max 20 addressed [R-10, C-20] //comment")
                );
    }


    @ParameterizedTest(name="{0}")
    @MethodSource("createWbsItems")
    void testLexter(String description, String wbsItemUnderTest) throws Exception {

        WbsgrammarLexer lexer = new WbsgrammarLexer(CharStreams.fromString(wbsItemUnderTest));

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

    @ParameterizedTest(name="{0}")
    @MethodSource("createWbsItems")
    void testGrammar(String description, String wbsItemUnderTest) throws Exception {
        WbsgrammarLexer lexer = new WbsgrammarLexer(CharStreams.fromString(wbsItemUnderTest));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        WbsgrammarParser parser = new WbsgrammarParser(tokens);
        parser.setTrace(true);
        var listener = new WbsgrammarParserBaseListener() {
            int errorCount =0 ;

            public void visitErrorNode(ErrorNode node) {
                errorCount ++;
                System.err.println("|##|" + node.getText());
            }
        };
        parser.addParseListener(listener);
        WbsContext context = parser.wbs();
        assertNotNull(context);
        assertEquals(0, listener.errorCount);
        for (int i=0; i<context.getChildCount(); i++) {
            System.out.println("####" + context.getChild(i).toString());
        }
    }
}
