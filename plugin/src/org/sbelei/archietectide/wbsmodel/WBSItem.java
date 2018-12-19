package org.sbelei.archietectide.wbsmodel;

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

    //# First level item :0h:
    public WBSItem(String item) {
        subItems = new LinkedList<>();
        raw =  item;
    }

    public void addSubItem(WBSItem item) {
        subItems.add(item);
    }

    @Override
    public String toString() {
        return raw;
    }
}
