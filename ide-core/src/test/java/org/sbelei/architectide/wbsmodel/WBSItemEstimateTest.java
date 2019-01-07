package org.sbelei.architectide.wbsmodel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class WBSItemEstimateTest {

    @Test
    void testDirectFlow() throws Exception {
        WBSItemEstimate actual = new WBSItemEstimate("3", "Days", "2", "Hrs", "50", "Hours");
        assertAll(
                () -> assertEquals(24, actual.getAvg()),
                () -> assertEquals(2, actual.getMin()),
                () -> assertEquals(50, actual.getMax()));
    }

    @Test
    void testNulls() throws Exception {
        WBSItemEstimate actual = new WBSItemEstimate(null, "h", "", "H", "text", "DAYS");
        assertAll(
                () -> assertEquals(0, actual.getAvg()),
                () -> assertEquals(0, actual.getMin()),
                () -> assertEquals(0, actual.getMax()));
    }
}
