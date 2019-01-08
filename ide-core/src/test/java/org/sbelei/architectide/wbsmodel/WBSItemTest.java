package org.sbelei.architectide.wbsmodel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.sbelei.architectide.wbsmodel.WBSItem;

public class WBSItemTest {

    @Test
    void testItemDirectFlow() throws Exception {
        WBSItem actual = new WBSItem();
        actual.setItemDescription("| Zero level item  |");
        assertAll(
                () -> assertEquals(0, actual.level),
                () -> assertEquals("Zero level item", actual.itemDescription),
                () -> assertEquals(0, actual.getAvg()));
    }

    @Test
    void testItemTooShortDescription() throws Exception {
        WBSItem actual = new WBSItem();
        actual.setItemDescription("A");
        assertAll(
                () -> assertEquals(0, actual.level),
                () -> assertEquals("", actual.itemDescription),
                () -> assertEquals(0, actual.getAvg()));
    }

    @Test
    void testItemNullInputOk() throws Exception {
        WBSItem actual = new WBSItem();
        actual.setItemDescription(null);
        assertAll(
                () -> assertEquals(0, actual.level),
                () -> assertEquals("", actual.itemDescription),
                () -> assertEquals(0, actual.getAvg()));
    }

}
