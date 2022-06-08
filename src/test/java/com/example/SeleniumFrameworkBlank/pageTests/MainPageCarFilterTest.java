package com.example.SeleniumFrameworkBlank.pageTests;

import com.example.SeleniumFrameworkBlank.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.MainPage;

public class MainPageCarFilterTest extends BaseTest {

    static final Logger rootLogger = LogManager.getRootLogger();
    static final Logger test1Logger = LogManager.getLogger(MainPageCarFilterTest.class);

    @Test
    public void test() {

        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isOpen());
        test1Logger.debug("openining mainPage");

        mainPage.setCarYearSelect("2020");
        test1Logger.debug("setCarYearSelect");

        System.out.println( "mainPage.getCarYearSelectText() " + mainPage.getCarYearSelectedText());
    }


}
