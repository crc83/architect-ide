package org.sbelei.architectide.wbsmodel;

import static org.sbelei.archietectide.utils.WbsLogger.LOG;

public class WBSEstimate {

    int estimate;

    public WBSEstimate(String estimateString, String scale) {
        estimate = convertToHours(estimateString, scale);
    }

    public int getEstimate() {
        return estimate;
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
}
