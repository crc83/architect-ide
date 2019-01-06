package org.sbelei.archietectide.wbsgrammar;

import java.util.LinkedList;
import java.util.List;

import org.sbelei.archietectide.wbsgrammar.WbsgrammarParser.ItemContext;
import org.sbelei.architectide.wbsmodel.WBSItem;

/**
 * This class responsible for building WBS model from parsed source file
 * @author Serhii Belei
 *
 */
public class WbsParserListener extends WbsgrammarParserBaseListener {

    List<WBSItem> items = new LinkedList<>();

    @Override
    public void exitItem(ItemContext ctx) {
        // TODO Auto-generated method stub
        WBSItem item = new WBSItem(ctx.getChild(1).getText());
        items.add(item);

        for (int i =0 ; i<ctx.getChildCount(); i++) {
            System.out.println(ctx.getChild(i).getText());
            System.out.println(ctx.getChild(i).getChildCount());
        }
        super.exitItem(ctx);
    }

}
