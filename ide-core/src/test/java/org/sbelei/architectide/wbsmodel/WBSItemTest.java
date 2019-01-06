package org.sbelei.architectide.wbsmodel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.sbelei.architectide.wbsmodel.WBSItem;

public class WBSItemTest {

    @Test
    void testItemDirectFlow() throws Exception {
        WBSItem actual = new WBSItem("| Zero level item  |");
        assertAll(
                () -> assertEquals(0, actual.level),
                () -> assertEquals("Zero level item", actual.itemDescription),
                () -> assertEquals(null, actual.estimate));
    }

    @Test
    void testItemTooShortDescription() throws Exception {
        WBSItem actual = new WBSItem("A");
        assertAll(
                () -> assertEquals(0, actual.level),
                () -> assertEquals("", actual.itemDescription),
                () -> assertEquals(null, actual.estimate));
    }

    @Test
    void testItemNullInputOk() throws Exception {
        WBSItem actual = new WBSItem(null);
        assertAll(
                () -> assertEquals(0, actual.level),
                () -> assertEquals("", actual.itemDescription),
                () -> assertEquals(null, actual.estimate));
    }

}
