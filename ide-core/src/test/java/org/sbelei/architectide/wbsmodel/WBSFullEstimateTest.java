package org.sbelei.architectide.wbsmodel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class WBSFullEstimateTest {

    @Test
    void testDirectFlow() throws Exception {
        WBSFullEstimate actual = new WBSFullEstimate("3", "Days");
        assertAll(
                () -> assertEquals(24, actual.getAvg()),
                () -> assertEquals(0, actual.getMin()),
                () -> assertEquals(0, actual.getMax()));
    }

    @Test
    void testNulls() throws Exception {
        WBSFullEstimate actual = new WBSFullEstimate(null, "h");
        assertAll(
                () -> assertEquals(0, actual.getAvg()),
                () -> assertEquals(0, actual.getMin()),
                () -> assertEquals(0, actual.getMax()));
    }
}
