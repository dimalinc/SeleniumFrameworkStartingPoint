package com.example.SeleniumFrameworkBlank.old;

import browser.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.forms.Header;

import static org.testng.Assert.assertEquals;

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
       /*
        delete old elements check
        System.out.println("getUniqueElement().getLocator() = " + getUniqueElement().getText());
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
     /*   System.out.println("UniqueElement() " + getUniqueElement().isElementVisible(driver, getUniqueElement().getLocator(), ElementStatus.VISIBLE) );
        System.out.println("CartImage() " +  getCartImage().isElementVisible(driver, getCartImage().getLocator(), ElementStatus.VISIBLE) );
        System.out.println("CartPriceLabel() " +  getCartPriceLabel().isElementVisible(driver, getCartPriceLabel().getLocator(), ElementStatus.VISIBLE) );
        System.out.println("WarrantyMenuItem() " +  getWarrantyMenuItem().isElementVisible(driver, getWarrantyMenuItem().getLocator(), ElementStatus.VISIBLE) );
        System.out.println("ShopMenuItem() " +  getShopMenuItem().isElementVisible(driver, getShopMenuItem().getLocator(), ElementStatus.VISIBLE) );
        System.out.println("MyAccountMenuItem() " +  getMyAccountMenuItem().isElementVisible(driver, getMyAccountMenuItem().getLocator(), ElementStatus.VISIBLE) );
        System.out.println("HomeMenuItem() " +  getHomeMenuItem().isElementVisible(driver, getHomeMenuItem().getLocator(), ElementStatus.VISIBLE) );
        System.out.println("ContactUsMenuItem() " +  getContactUsMenuItem().isElementVisible(driver, getContactUsMenuItem().getLocator(), ElementStatus.VISIBLE) );
        System.out.println("AboutUsMenuItem() " +  getAboutUsMenuItem().isElementVisible(driver, getAboutUsMenuItem().getLocator(), ElementStatus.VISIBLE) );
        System.out.println("SearchIcon() " +  getSearchIcon().isElementVisible(driver, getSearchIcon().getLocator(), ElementStatus.VISIBLE) );
        System.out.println("SearchInput() " +  getSearchInput().isElementVisible(driver, getSearchInput().getLocator(), ElementStatus.VISIBLE) );
*/

 /*       System.out.println(getUniqueElement().elementVisibleCheck(driver));
        System.out.println(getCartImage().elementVisibleCheck(driver));
        System.out.println(getCartPriceLabel().elementVisibleCheck(driver));
        System.out.println(getWarrantyMenuItem().elementVisibleCheck(driver));
        System.out.println(getShopMenuItem().elementVisibleCheck(driver));
        System.out.println(getMyAccountMenuItem().elementVisibleCheck(driver));
        System.out.println(getHomeMenuItem().elementVisibleCheck(driver));
        System.out.println(getAboutUsMenuItem().elementVisibleCheck(driver));
        System.out.println(getSearchIcon().elementVisibleCheck(driver));
        System.out.println(getSearchInput().elementVisibleCheck(driver));*/

    }

}
