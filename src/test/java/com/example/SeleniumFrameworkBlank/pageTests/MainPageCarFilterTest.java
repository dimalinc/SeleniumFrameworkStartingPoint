package com.example.SeleniumFrameworkBlank.pageTests;

import browser.BrowserFactory;
import com.example.SeleniumFrameworkBlank.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
        test1Logger.debug("opening mainPage");

        mainPage.setCarYearSelect("2020");
        test1Logger.debug("setCarYearSelect");
        mainPage.setCarMakeSelect("Audi");
        test1Logger.debug("setCarMakeSelect");
        mainPage.setCarModelSelect("A3");
        test1Logger.debug("setCarModelSelect");

        mainPage.clickFindButtonLink();
        test1Logger.debug("clickFindButtonLink");

        System.out.println(BrowserFactory.getDriver().getCurrentUrl());


        //  driver.findElement(By.partialLinkText("https://www.bilsteinlifts.com/?swoof=1&pa_vehicle-year=")).click();

    }


}
