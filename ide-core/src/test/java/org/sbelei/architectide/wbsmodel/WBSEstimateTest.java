package org.sbelei.architectide.wbsmodel;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class WBSEstimateTest {
//, "Hrs", "50", "Hours"
//, "", "H", "text", "DAYS"

    @Test
    void testDirectFlow() throws Exception {
        WBSEstimate actual = new WBSEstimate("3", "Days");
        assertAll(
                () -> assertEquals(24, actual.getEstimate()));
    }

    @Test
    void testNulls() throws Exception {
        WBSEstimate actual = new WBSEstimate(null, "h");
        assertAll(
                () -> assertEquals(0, actual.getEstimate()));
    }
}
