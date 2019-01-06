package org.sbelei.architectide.wbsmodel;

import java.util.LinkedList;

/**
 *
 * @author Serhii Belei
 *
 * @license
 *
 */
public class WBSItem {

    public int level;
    String itemDescription;
    WBSItemEstimate estimate;
    String relatedReqItem;
    String comment;
    LinkedList<WBSItem> subItems;

    //raw data is usefull for debug and investigation
    String raw;

    public WBSItem(String itemDescription) {
        subItems = new LinkedList<>();
        //maybe it's necessary to remove starting and ending symbol
        this.itemDescription =  itemDescription;
    }

    public void addSubItem(WBSItem item) {
        subItems.add(item);
    }

    @Override
    public String toString() {
        return "WBSItem [level=" + level + ", itemDescription=" + itemDescription + ", estimate=" + estimate
                + ", relatedReqItem=" + relatedReqItem + ", comment=" + comment + "]";
    }


}
