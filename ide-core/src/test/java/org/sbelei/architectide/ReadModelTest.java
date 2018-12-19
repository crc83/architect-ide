package org.sbelei.architectide;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.sbelei.architectide.wbsmodel.WBSItem;

public class ReadModelTest {

    @Test
    void testName() throws Exception {
        readFile("C:\\projects\\architect-ide\\test\\resources\\sample.wbs");
    }

    private void readFile(String fileName) {
        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
//        	Project project = new Project();
            Stream<WBSItem> lines = br.lines().map(item -> new WBSItem(item));

            System.out.println("<!-----Read all lines by using BufferedReader-----!>");
            lines.forEach(System.out::println);
            lines.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
