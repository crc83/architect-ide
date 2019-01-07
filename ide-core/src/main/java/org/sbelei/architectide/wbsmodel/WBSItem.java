package org.sbelei.architectide.wbsmodel;

import java.util.LinkedList;

import org.antlr.v4.runtime.tree.TerminalNode;

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

    public WBSItem() {
        subItems = new LinkedList<>();
    }

    /**
     * It's necessary to remove starting and ending  PIPE symbol and spaces
     * @param itemDescription i.e. "|  Some Text  |"
     * @return "SomeText"
     */
    private String trimDescription(String itemDescription) {
        if (itemDescription != null
            && itemDescription.length() >=2 ) { //leading and trailing pipe
                return itemDescription.substring(1, itemDescription.length() -1).strip();
        } else {
            return "";
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

    public void setItemDescription(String description) {
        this.itemDescription = trimDescription(description);
    }

    public void setEstimate(WBSItemEstimate theEstimate) {
        estimate =  theEstimate;
    }


}
