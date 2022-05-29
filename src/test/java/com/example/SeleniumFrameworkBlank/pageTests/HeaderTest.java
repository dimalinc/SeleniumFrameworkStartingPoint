package com.example.SeleniumFrameworkBlank.pageTests;

import browser.BrowserFactory;
import elements.basicElements.ElementStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.Header;
import pageObjects.MainPage;
import pageObjects.old_MainPage;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static pageObjects.Header.*;

public class HeaderTest {
    private WebDriver driver;
    private Header header;

    @BeforeTest
    public void setUp() {

        driver = BrowserFactory.getDriver();
        driver.get(BrowserFactory.prop.getProperty("url"));

       /* ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);

        //driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);*/

        header = new Header();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testAllElements() {
      //  driver.get("https://www.bilsteinlifts.com/");
       /* System.out.println("getUniqueElement().getLocator() = " + getUniqueElement().getText());
        System.out.println("getSearchInput().getLocator() = " + getSearchInput().getText());
        System.out.println("getSearchIcon().getLocator() = " + getSearchIcon().getText());
        System.out.println("getAboutUsMenuItem().getLocator() = " + getAboutUsMenuItem().getText());
        System.out.println("getContactUsMenuItem().getLocator() = " + getContactUsMenuItem().getText());
        System.out.println("getHomeMenuItem().getLocator() = " + getHomeMenuItem().getText());
        System.out.println("getMyAccountMenuItem().getLocator() = " + getMyAccountMenuItem().getText());
        System.out.println("getShopMenuItem().getLocator() = " + getShopMenuItem().getText());
        System.out.println("getWarrantyMenuItem().getLocator() = " + getWarrantyMenuItem().getText());
        System.out.println("getCartImage().getLocator() = " + getCartImage().getText());
        System.out.println("getCartPriceLabel().getLocator() = " + getCartPriceLabel().getText());
*/

        System.out.println( getUniqueElement().isElementVisible(driver,
                getUniqueElement().getLocator(), ElementStatus.VISIBLE) );

    }

}
