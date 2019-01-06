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

    public WBSItem(String itemDescription) {
        subItems = new LinkedList<>();
        //maybe it's necessary to remove starting and ending symbol
        if (itemDescription != null
            && itemDescription.length() >=2 ) { //leading and trailing pipe
                this.itemDescription =  itemDescription.substring(1, itemDescription.length() -1).strip();
        } else {
            this.itemDescription = "";
        }
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public WBSItemEstimate getEstimate() {
        return estimate;
    }

    public void addSubItem(WBSItem item) {
        subItems.add(item);
    }

    @Override
    public String toString() {
        return "WBSItem [level=" + level + ", itemDescription=" + itemDescription + ", estimate=" + estimate
                + ", relatedReqItem=" + relatedReqItem + ", comment=" + comment + "]";
    }

    public int getLevel() {
        return level;
    }


}
