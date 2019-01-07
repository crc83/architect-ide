package org.sbelei.architectide.wbsmodel;

public class WBSFullEstimate {

    // all in hours here
    WBSEstimate min, avg, max;

    public WBSFullEstimate(String avgStr, String avgScale) {
        avg = new WBSEstimate(avgStr, avgScale);
        min = new WBSEstimate("0", "h");
        max = new WBSEstimate("0", "h");
    }

    public int getAvg() {
        return avg.getEstimate();
    }

    public int getMin() {
        return min.getEstimate();
    }

    public int getMax() {
        return max.getEstimate();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + avg.getEstimate();
        result = prime * result + max.getEstimate();
        result = prime * result + min.getEstimate();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        WBSFullEstimate other = (WBSFullEstimate) obj;
        if (avg.getEstimate() != other.avg.getEstimate())
            return false;
        if (max.getEstimate() != other.max.getEstimate())
            return false;
        if (min.getEstimate() != other.min.getEstimate())
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Estimate optimistic:" + min.getEstimate() + "hrs expected:" + avg.getEstimate() + "hrs pessimistic:"
                + max.getEstimate() + "hrs";
    }

    public void setMinEstimate(WBSEstimate wbsEstimate) {
        min = wbsEstimate;
    }

    public void setMaxEstimate(WBSEstimate wbsEstimate) {
        max = wbsEstimate;

    }
}
