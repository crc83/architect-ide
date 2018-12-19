package org.sbelei.architectide.wbsmodel;

import java.util.LinkedList;

/**
 * 
 * @author Serhii Belei
 *
 */
public class WBSProject {

	//since it's mandatory to preserve an order
	LinkedList<WBSItem> items;
	private WBSItem lastItem;
	
	public WBSProject() {
		items = new LinkedList<>();
	}
	
	public void addItem(WBSItem item) {
		items.add(item);
		lastItem = item;
	}
	
	public void addSubItem(WBSItem item) {
		lastItem.addSubItem(item);
		lastItem = item;
	}
}
