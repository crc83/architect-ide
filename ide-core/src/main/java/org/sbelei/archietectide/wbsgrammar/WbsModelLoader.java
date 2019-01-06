package org.sbelei.archietectide.wbsgrammar;

import java.util.Collections;
import java.util.List;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.sbelei.archietectide.wbsgrammar.WbsgrammarParser.WbsContext;
import org.sbelei.architectide.wbsmodel.WBSItem;

public class WbsModelLoader {

    private WbsContext context;
    private List<WBSItem> model;

    public void loadWbsModelFrom(String text) {
        WbsgrammarLexer lexer = new WbsgrammarLexer(CharStreams.fromString(text));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        WbsgrammarParser parser = new WbsgrammarParser(tokens);
        parser.setTrace(true);
        var listener = new WbsParserListener();
        parser.addParseListener(listener);
        context = parser.wbs();
        model = Collections.unmodifiableList(listener.items);
    }

    public List<WBSItem> getModel() {
        return model;
    }

    public WbsContext getContext() {
        return context;
    }
}
