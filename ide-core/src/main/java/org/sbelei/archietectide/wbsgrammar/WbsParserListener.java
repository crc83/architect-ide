package org.sbelei.archietectide.wbsgrammar;

import java.util.LinkedList;
import java.util.List;

import org.sbelei.archietectide.wbsgrammar.WbsgrammarParser.ItemContext;
import org.sbelei.archietectide.wbsgrammar.WbsgrammarParser.WbsFullEstimateContext;
import org.sbelei.architectide.wbsmodel.WBSItem;
import org.sbelei.architectide.wbsmodel.WBSItemEstimate;

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
    public void enterItem(ItemContext ctx) {
        currentItem = newWbsItem(currentItem);
        items.add(currentItem);
        super.enterItem(ctx);
    }

    private WBSItem newWbsItem(WBSItem theCurrentItem) {
        if (theCurrentItem == null) {
            return new WBSItem();
        } else {
            return theCurrentItem;
        }
    }

    @Override
    public void exitWbsFullEstimate(WbsFullEstimateContext ctx) {
        WBSItemEstimate estimate = new WBSItemEstimate(
                ctx.wbsAvgEstimate().getToken(WbsgrammarLexer.INT, 0).getText(),
                ctx.wbsAvgEstimate().getToken(WbsgrammarLexer.EST_SCALE, 0).getText(),
                ctx.wbsMinEstimate().getToken(WbsgrammarLexer.INT, 0).getText(),
                ctx.wbsMinEstimate().getToken(WbsgrammarLexer.EST_SCALE, 0).getText(),
                ctx.wbsMaxEstimate().getToken(WbsgrammarLexer.INT, 0).getText(),
                ctx.wbsMaxEstimate().getToken(WbsgrammarLexer.EST_SCALE, 0).getText());
        currentItem = newWbsItem(currentItem);
        currentItem.setEstimate(estimate);
        super.exitWbsFullEstimate(ctx);
    }

    @Override
    public void exitItem(ItemContext ctx) {
        currentItem = newWbsItem(currentItem);
        currentItem.setItemDescription(ctx.getToken(WbsgrammarLexer.ITEM_DESCRIPTION, 0).getText());
        items.add(currentItem);
        currentItem = null;
        super.exitItem(ctx);
    }

}
