package utils;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.stream.Collectors;

public class FileOperations {

    public static ArrayList<String> listFilesUsingDirectoryStream(String dir) throws IOException {
        ArrayList<String> fileList = new ArrayList<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(dir))) {
            for (Path path : stream) {
                if (!Files.isDirectory(path)) {
                    fileList.add(path.getFileName()
                            .toString());
                }
            }
        }
        return fileList;
    }


    public static String whenReadSmallFileJava7_thenCorrect(String filePath)
            throws IOException {

        Path path = Paths.get(filePath);
        String fileTextContents = Files.readAllLines(path).toString();
        return fileTextContents;
    }
}
