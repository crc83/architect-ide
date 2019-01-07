package org.sbelei.architectide.wbsmodel;

import static org.sbelei.archietectide.utils.WbsLogger.LOG;

public class WBSItemEstimate {

    // all in hours here
    int min, avg, max;

    public WBSItemEstimate(String avg, String avgScale, String min, String minScale, String max, String maxScale) {
        this.avg = convertToHours(avg, avgScale);
        this.min = convertToHours(min, minScale);
        this.max = convertToHours(max, maxScale);
    }

    private int convertToHours(String estimateString, String scale) {
        int estimate = 0;
        try {
            estimate = Integer.parseInt(estimateString);
        } catch (NumberFormatException nfe) {
            LOG.logException("Estimate value is not a number", nfe);
        }
        int multiplier = 8;
        switch (scale.toUpperCase()) {
        case "HOURS":
        case "HRS":
        case "H":
            multiplier = 1;
            break;
        case "DAYS":
        case "D":
        case "":
            multiplier = 8;
            break;
        default :
            LOG.logError("Estimate scale is not defined correctly, using 'days'");
        }

        return estimate * multiplier;
    }

    public int getAvg() {
        return avg;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + avg;
        result = prime * result + max;
        result = prime * result + min;
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
        WBSItemEstimate other = (WBSItemEstimate) obj;
        if (avg != other.avg)
            return false;
        if (max != other.max)
            return false;
        if (min != other.min)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Estimate optimistic:" + min + "hrs expected:" + avg + "hrs pessimistic:" + max + "hrs";
    }
}
