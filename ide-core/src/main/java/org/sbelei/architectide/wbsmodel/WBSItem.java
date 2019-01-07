package org.sbelei.architectide.wbsmodel;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

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
    Map<String, ReqItem> addressReqItems;
    String comment;
    LinkedList<WBSItem> subItems;

    public WBSItem() {
        subItems = new LinkedList<>();
        addressReqItems = new LinkedHashMap<>();
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
                + ", address " + addressReqItems.size() + " count , comment=" + comment + "]";
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

    public void insertAddressedItem(String itemCode) {
        if (itemCode != null) {
            addressReqItems.put(itemCode.trim(), null);
        }
    }

    public Map<String, ReqItem> getAddressReqItems() {
        return Collections.unmodifiableMap(addressReqItems);
    }

    public void setComment(String comment) {
        this.comment = trimComment(comment);
    }

    private String trimComment(String comment) {
        if (comment != null && comment.length()>=2) {
            return comment.substring(2, comment.length()).strip();
        }
        return "";
    }

    public String getComment() {
        return comment;
    }
}
