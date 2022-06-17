package com.example.SeleniumFrameworkBlank.pageTests.KEY;

import org.testng.annotations.Test;
import utils.FileOperations;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class KeyGetLinksFromFilesInFolder {

    @Test
    public void test() {

        ArrayList<String> filesList = new ArrayList<String>() ;

        String dirPath = "C:\\Users\\dmitr\\OneDrive\\Рабочий стол\\AirLift";

        try {
            filesList = FileOperations.listFilesUsingDirectoryStream(dirPath);
        } catch (IOException e) {e.printStackTrace();}

        for (String fileString:filesList) {
            File file = new File(fileString);
            try {
            System.out.println(dirPath + "\\" + file.getPath());
            }catch (Exception e) {e.printStackTrace();}
            try {
                System.out.println(FileOperations.whenReadSmallFileJava7_thenCorrect
                        (dirPath + "\\" + file.getPath()));
            }catch (IOException e) {e.printStackTrace();}


        }

    }

}
