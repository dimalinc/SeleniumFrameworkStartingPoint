package com.example.SeleniumFrameworkBlank.pageTests.KEY;

import com.example.SeleniumFrameworkBlank.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.KEY.KeystoneItemPage;
import pageObjects.forms.KeystoneLoginPage;
import utils.PageOperations;
import utils.Random;
import utils.Wait;

import java.util.List;

public class KeyGetGoodsLinksFromPage extends BaseTest {

    @Test
    public void test() {
        driver.get("https://wwwsc.ekeystone.com/search/detail?pid=PRS924502&ssid=c5592564-01dd-4fed-bad7-e6f6844c1b48&allin=true");

        KeystoneLoginPage keystoneLoginPage = new KeystoneLoginPage();

        if (keystoneLoginPage.isOpen()) {
            keystoneLoginPage.coockiesClick();
            keystoneLoginPage.populateFields();
            keystoneLoginPage.loginClick();
        }

        Wait.wait(3000);
        driver.get("https://wwwsc.ekeystone.com/Search?browse=sub%7cHeadlight+Bulb");

        Wait.wait(5000);

        //List<WebElement> goodsLinks = driver.findElements(By.xpath("//a[contains(@class, 'detail-link')]"));
        List<WebElement> goodsLinks = driver.findElements
                (By.xpath("//*[@class='detail-link']"));

        int n = 0;
        String linksTextString = new String();
        try {
            for (WebElement element : goodsLinks) {
                if (element.isDisplayed()) {
                    Wait.wait(Random.random(100));
                    System.out.println(n++);
                    linksTextString = linksTextString + element.getAttribute("href") + "\n";
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        try {
            PageOperations.whenWriteStringUsingBufferedWritter_thenCorrect("goodsLinks.txt",linksTextString);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}