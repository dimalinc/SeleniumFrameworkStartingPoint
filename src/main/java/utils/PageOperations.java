package utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PageOperations {

    public static void whenWriteStringUsingBufferedWritter_thenCorrect(String fileName, String contents)
            throws IOException {
        String str = contents;
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        writer.write(str);

        writer.close();
    }
}
