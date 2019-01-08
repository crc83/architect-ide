package org.sbelei.archietectide.wbsgrammar;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.jupiter.api.Test;
import org.sbelei.architectide.wbsmodel.WBSItem;

public class WbsModelLoaderTest {

    @Test
    void testRowGeneration() {
        WbsModelLoader loader =  new WbsModelLoader();
        loader.loadWbsModelFrom(". | Analyze 1 existing WBS approach   | estimate 5h min 1h max 20h addressed R-10 //comment");

        assertAll(
                () -> assertNotNull(loader.getContext()),
                () -> assertEquals(1, loader.getModel().size())
        );

        // it's expected that only one item loaded
        WBSItem actual = loader.getModel().get(0);
        assertAll(
                () -> assertEquals(0, actual.getLevel()),
                () -> assertEquals("Analyze 1 existing WBS approach", actual.getItemDescription()),
                () -> assertEquals("comment", actual.getComment()),
                () -> assertEquals(5, actual.getAvg()),
                () -> assertEquals(1, actual.getMin()),
                () -> assertEquals(20, actual.getMax()),
                () -> assertThat(actual.getAddressReqItems().keySet(), contains("R-10")));
    }

    @Test
    void testMultilineGeneration() {
        WbsModelLoader loader =  new WbsModelLoader();
        loader.loadWbsModelFrom(
                ". | Top item 1   | estimate 1d\n" +
                ". | Top item 2   | estimate 1d\n" +
                ".. | Subitem   | estimate 5h min 1h max 20h addressed R-10 //comment\n" +
                ". | Top item 3   | estimate 1d");

        assertAll(
                () -> assertNotNull(loader.getContext()),
                () -> assertEquals(4, loader.getModel().size())
        );
        //List is ordered, so I expect third item to be a sub item
        WBSItem actual = loader.getModel().get(2);
        assertAll(
                () -> assertEquals(1, actual.getLevel()),
                () -> assertEquals("Subitem", actual.getItemDescription()),
                () -> assertEquals("comment", actual.getComment()),
                () -> assertEquals(5, actual.getAvg()),
                () -> assertEquals(1, actual.getMin()),
                () -> assertEquals(20, actual.getMax()),
                () -> assertThat(actual.getAddressReqItems().keySet(), contains("R-10")));
    }

    @Test
    void testRowGenerationWithoutComment() {
        WbsModelLoader loader =  new WbsModelLoader();
        loader.loadWbsModelFrom(". | Analyze 1 existing WBS approach   | estimate 5h min 1h max 20h addressed [R-10, C-20]");
        assertAll(
                () -> assertNotNull(loader.getContext()),
                () -> assertEquals(1, loader.getModel().size())
        );
        // it's expected that only one item loaded
        WBSItem actual = loader.getModel().get(0);
        assertAll(
                () -> assertEquals(0, actual.getLevel()),
                () -> assertEquals("Analyze 1 existing WBS approach", actual.getItemDescription()),
                () -> assertEquals("", actual.getComment()),
                () -> assertEquals(5, actual.getAvg()),
                () -> assertEquals(1, actual.getMin()),
                () -> assertEquals(20, actual.getMax()),
                () -> assertThat(actual.getAddressReqItems().keySet(), contains("R-10", "C-20")));
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
                () -> assertEquals(5, actual.getAvg()),
                () -> assertEquals(0, actual.getMin()),
                () -> assertEquals(0, actual.getMax()));
    }

}
