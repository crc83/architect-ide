package org.sbelei.architectide.wbsmodel;

public class WBSItemEstimate {
	
	//all in hours here
	int min, exp, max;
	String scale;

	public WBSItemEstimate(String min, String avg, String max) {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Estimate optimistic:"+min+"hrs expected:" + exp + "hrs pessimistic:"+ max + "hrs";
	}
}
