package org.sbelei.archietectide.wbsgrammar;

import java.util.LinkedList;
import java.util.List;

import org.sbelei.archietectide.wbsgrammar.WbsgrammarParser.WbsCommentContext;
import org.sbelei.archietectide.wbsgrammar.WbsgrammarParser.WbsFullEstimateContext;
import org.sbelei.archietectide.wbsgrammar.WbsgrammarParser.WbsItemContext;
import org.sbelei.architectide.wbsmodel.WBSItem;
import org.sbelei.architectide.wbsmodel.WBSItemEstimate;

/**
 * This class responsible for building WBS model from parsed source file
 *
 * TODO: Addressed items TODO: Comments TODO: Add labels for tasks to make a
 * reference
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
        items.add(currentItem);
        super.enterWbsItem(ctx);
    }

    @Override
    public void exitWbsFullEstimate(WbsFullEstimateContext ctx) {
        WBSItemEstimate estimate = new WBSItemEstimate(ctx.wbsAvgEstimate().getToken(WbsgrammarLexer.INT, 0).getText(),
                ctx.wbsAvgEstimate().getToken(WbsgrammarLexer.EST_SCALE, 0).getText(),
                ctx.wbsMinEstimate().getToken(WbsgrammarLexer.INT, 0).getText(),
                ctx.wbsMinEstimate().getToken(WbsgrammarLexer.EST_SCALE, 0).getText(),
                ctx.wbsMaxEstimate().getToken(WbsgrammarLexer.INT, 0).getText(),
                ctx.wbsMaxEstimate().getToken(WbsgrammarLexer.EST_SCALE, 0).getText());
        currentItem.setEstimate(estimate);
        super.exitWbsFullEstimate(ctx);
    }

    @Override
    public void exitWbsComment(WbsCommentContext ctx) {
        currentItem.setComment( ctx.getToken(WbsgrammarLexer.COMMENT, 0).getText());
        super.exitWbsComment(ctx);
    }

    @Override
    public void exitWbsItem(WbsItemContext ctx) {
        currentItem.setItemDescription(ctx.getToken(WbsgrammarLexer.ITEM_DESCRIPTION, 0).getText());
        items.add(currentItem);
        currentItem = null;
        super.exitWbsItem(ctx);
    }

}
