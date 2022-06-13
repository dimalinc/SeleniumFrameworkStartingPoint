package com.example.SeleniumFrameworkBlank;

import com.example.SeleniumFrameworkBlank.pageTests.MainPageCarFilterTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import utils.Wait;

public class LoginTest extends BaseTest{

    static final Logger rootLogger = LogManager.getRootLogger();
    static final Logger test1Logger = LogManager.getLogger(MainPageCarFilterTest.class);

    @Test
    public void test() {
        driver.get("https://www.bilsteinlifts.com/my-account-2/");
        LoginPage loginPage = new LoginPage();
        Assert.assertTrue(loginPage.isOpen());
        test1Logger.debug("opening mainPage");
        loginPage.populateFields();
        System.out.println(loginPage.loginInputGetText() + "    " + loginPage.loginPassGetText());
        loginPage.setRememberMeOn();
        loginPage.setRememberMeOff();
        loginPage.loginButtonClick();


        Wait.wait(3000);

    }
}
