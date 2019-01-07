package org.sbelei.archietectide.wbsgrammar;

import java.util.LinkedList;
import java.util.List;

import org.sbelei.archietectide.wbsgrammar.WbsgrammarParser.WbsAvgEstimateContext;
import org.sbelei.archietectide.wbsgrammar.WbsgrammarParser.WbsCommentContext;
import org.sbelei.archietectide.wbsgrammar.WbsgrammarParser.WbsItemContext;
import org.sbelei.archietectide.wbsgrammar.WbsgrammarParser.WbsMaxEstimateContext;
import org.sbelei.archietectide.wbsgrammar.WbsgrammarParser.WbsMinEstimateContext;
import org.sbelei.architectide.wbsmodel.WBSItem;
import org.sbelei.architectide.wbsmodel.WBSEstimate;
import org.sbelei.architectide.wbsmodel.WBSFullEstimate;

/**
 * This class responsible for building WBS model from parsed source file
 *
 * TODO: Addressed items
 * TODO: Add labels for tasks to make a reference
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
        public void exitWbsAvgEstimate(WbsAvgEstimateContext ctx) {
            WBSFullEstimate estimate = new WBSFullEstimate(
                    ctx.getToken(WbsgrammarLexer.INT, 0).getText(),
                    ctx.getToken(WbsgrammarLexer.EST_SCALE, 0).getText());
            currentItem.setEstimate(estimate);

            super.exitWbsAvgEstimate(ctx);
        }

    @Override
    public void exitWbsMinEstimate(WbsMinEstimateContext ctx) {
        currentItem.getEstimate().setMinEstimate(new WBSEstimate(
              ctx.getToken(WbsgrammarLexer.INT, 0).getText(),
              ctx.getToken(WbsgrammarLexer.EST_SCALE, 0).getText()
                ) );
        super.exitWbsMinEstimate(ctx);
    }

    @Override
    public void exitWbsMaxEstimate(WbsMaxEstimateContext ctx) {
        currentItem.getEstimate().setMaxEstimate(new WBSEstimate(
                ctx.getToken(WbsgrammarLexer.INT, 0).getText(),
                ctx.getToken(WbsgrammarLexer.EST_SCALE, 0).getText()
                  ) );
        super.exitWbsMaxEstimate(ctx);
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
