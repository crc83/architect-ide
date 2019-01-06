package org.sbelei.archietectide.wbsgrammar;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.sbelei.architectide.wbsmodel.WBSItem;
import org.sbelei.architectide.wbsmodel.WBSItemEstimate;

public class WbsModelLoaderTest {

    @Test
    void testModelGeneration() {
        WbsModelLoader loader =  new WbsModelLoader();
        loader.loadWbsModelFrom(". | Analyze 1 existing WBS approach   | estimate 5h min 1h max 20h addressed [R-10, C-20] //comment");
        assertNotNull(loader.getContext());

        System.out.println(Arrays.toString(loader.getModel().toArray()));

        // it's expected that only one item loaded
        WBSItem actual = loader.getModel().get(0);
        assertAll(
                () -> assertEquals(0, actual.getLevel()),
                () -> assertEquals("Analyze 1 existing WBS approach", actual.getItemDescription()),
                () -> assertEquals(new WBSItemEstimate("5h", "1h", "20h"), actual.getEstimate()));
    }
}
