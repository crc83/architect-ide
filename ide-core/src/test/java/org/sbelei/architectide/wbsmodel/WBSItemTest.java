package org.sbelei.architectide.wbsmodel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.sbelei.architectide.wbsmodel.WBSItem;
import org.sbelei.architectide.wbsmodel.WBSItemEstimate;

public class WBSItemTest {

    @Test
    @DisplayName("WBSItem of level 0 parsed correctly")
    void testItem_0_level_parsed() throws Exception {
        WBSItem actual = new WBSItem("Zero level item :0h:");
        assertAll(
                () -> assertEquals(0, actual.level),
                () -> assertEquals("Zero level item", actual.itemDescription),
                () -> assertEquals(new WBSItemEstimate("0h", null, null), actual.estimate));
    }


    @Test
    @DisplayName("WBSItem of level 1 parsed correctly")
    void testItem_1_level_parsed() throws Exception {
        WBSItem actual = new WBSItem("# First level item :0h:");
        assertAll(
                () -> assertEquals(1, actual.level),
                () -> assertEquals("First level item", actual.itemDescription),
                () -> assertEquals(new WBSItemEstimate("0h", null, null), actual.estimate));
    }
}
