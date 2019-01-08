package org.sbelei.archietectide.wbsgrammar;

import java.util.LinkedList;
import java.util.List;

import org.antlr.v4.runtime.tree.TerminalNode;
import org.sbelei.archietectide.wbsgrammar.WbsgrammarParser.WbsAvgEstimateContext;
import org.sbelei.archietectide.wbsgrammar.WbsgrammarParser.WbsCommentContext;
import org.sbelei.archietectide.wbsgrammar.WbsgrammarParser.WbsItemContext;
import org.sbelei.archietectide.wbsgrammar.WbsgrammarParser.WbsItemRefsContext;
import org.sbelei.archietectide.wbsgrammar.WbsgrammarParser.WbsItemStartContext;
import org.sbelei.archietectide.wbsgrammar.WbsgrammarParser.WbsMaxEstimateContext;
import org.sbelei.archietectide.wbsgrammar.WbsgrammarParser.WbsMinEstimateContext;
import org.sbelei.architectide.wbsmodel.WBSItem;
import org.sbelei.architectide.wbsmodel.WBSEstimate;

/**
 * This class responsible for building WBS model from parsed source file
 *
 * @author Serhii Belei
 *
 */
public class WbsParserListener extends WbsgrammarParserBaseListener {

    List<WBSItem> items = new LinkedList<>();
    WBSItem currentItem;

    @Override
    public void enterWbsItem(WbsItemContext ctx) {
        currentItem = new WBSItem();
        super.enterWbsItem(ctx);
    }

    @Override
    public void exitWbsItemStart(WbsItemStartContext ctx) {
        currentItem.setLevel( ctx.DOT().size()-1);
        super.exitWbsItemStart(ctx);
    }

    @Override
    public void exitWbsAvgEstimate(WbsAvgEstimateContext ctx) {
        WBSEstimate estimate = new WBSEstimate(ctx.getToken(WbsgrammarLexer.INT, 0).getText(),
                ctx.getToken(WbsgrammarLexer.EST_SCALE, 0).getText());
        currentItem.setAvg(estimate);

        super.exitWbsAvgEstimate(ctx);
    }

    @Override
    public void exitWbsMinEstimate(WbsMinEstimateContext ctx) {
        currentItem.setMin(new WBSEstimate(ctx.getToken(WbsgrammarLexer.INT, 0).getText(),
                ctx.getToken(WbsgrammarLexer.EST_SCALE, 0).getText()));
        super.exitWbsMinEstimate(ctx);
    }

    @Override
    public void exitWbsMaxEstimate(WbsMaxEstimateContext ctx) {
        currentItem.setMax(new WBSEstimate(ctx.getToken(WbsgrammarLexer.INT, 0).getText(),
                ctx.getToken(WbsgrammarLexer.EST_SCALE, 0).getText()));
        super.exitWbsMaxEstimate(ctx);
    }

    @Override
    public void exitWbsComment(WbsCommentContext ctx) {
        currentItem.setComment(ctx.getToken(WbsgrammarLexer.COMMENT, 0).getText());
        super.exitWbsComment(ctx);
    }

    @Override
    public void exitWbsItemRefs(WbsItemRefsContext ctx) {
        for(TerminalNode node : ctx.getTokens(WbsgrammarLexer.REFERENCE)) {
            currentItem.insertAddressedItem( node.getText());
        }
        super.exitWbsItemRefs(ctx);
    }

    @Override
    public void exitWbsItem(WbsItemContext ctx) {
        currentItem.setItemDescription(ctx.getToken(WbsgrammarLexer.ITEM_DESCRIPTION, 0).getText());
        items.add(currentItem);
        currentItem = null;
        super.exitWbsItem(ctx);
    }

}
