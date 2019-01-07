package org.sbelei.archietectide.wbsgrammar;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.sbelei.architectide.wbsmodel.WBSItem;

public class WbsModelLoaderTest {

    @Test
    void testRowGeneration() {
        WbsModelLoader loader =  new WbsModelLoader();
        loader.loadWbsModelFrom(". | Analyze 1 existing WBS approach   | estimate 5h min 1h max 20h addressed [R-10, C-20] //comment");
        assertNotNull(loader.getContext());

        // it's expected that only one item loaded
        WBSItem actual = loader.getModel().get(0);
        assertAll(
                () -> assertEquals(0, actual.getLevel()),
                () -> assertEquals("Analyze 1 existing WBS approach", actual.getItemDescription()),
                () -> assertEquals("comment", actual.getComment()),
                () -> assertEquals(5, actual.getEstimate().getAvg()),
                () -> assertEquals(1, actual.getEstimate().getMin()),
                () -> assertEquals(20, actual.getEstimate().getMax()));
    }

    @Test
    void testRowGenerationWithoutComment() {
        WbsModelLoader loader =  new WbsModelLoader();
        loader.loadWbsModelFrom(". | Analyze 1 existing WBS approach   | estimate 5h min 1h max 20h addressed [R-10, C-20]");
        assertNotNull(loader.getContext());

        // it's expected that only one item loaded
        WBSItem actual = loader.getModel().get(0);
        assertAll(
                () -> assertEquals(0, actual.getLevel()),
                () -> assertEquals("Analyze 1 existing WBS approach", actual.getItemDescription()),
                () -> assertEquals("", actual.getComment()),
                () -> assertEquals(5, actual.getEstimate().getAvg()),
                () -> assertEquals(1, actual.getEstimate().getMin()),
                () -> assertEquals(20, actual.getEstimate().getMax()));
    }

    @Test
    void testRowGenerationWithShortEstimate() {
        WbsModelLoader loader =  new WbsModelLoader();
        loader.loadWbsModelFrom(". | Analyze 1 existing WBS approach   | estimate 5h");
        assertNotNull(loader.getContext());

        // it's expected that only one item loaded
        WBSItem actual = loader.getModel().get(0);
        assertAll(
                () -> assertEquals(0, actual.getLevel()),
                () -> assertEquals("Analyze 1 existing WBS approach", actual.getItemDescription()),
                () -> assertEquals("", actual.getComment()),
                () -> assertEquals(5, actual.getEstimate().getAvg()),
                () -> assertEquals(0, actual.getEstimate().getMin()),
                () -> assertEquals(0, actual.getEstimate().getMax()));
    }

}
