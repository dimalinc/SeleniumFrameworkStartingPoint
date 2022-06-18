package com.example.SeleniumFrameworkBlank.pageTests.KEY;

import com.example.SeleniumFrameworkBlank.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.KEY.KeystoneItemPage;
import pageObjects.forms.KeystoneLoginPage;
import utils.FileOperations;
import utils.PageOperations;
import utils.Random;
import utils.Wait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class KeySaveItemPagesFromFileWithLinksTest extends BaseTest {

    @Test
    public void test() {
        driver.get("https://wwwsc.ekeystone.com/search/detail?pid=PRS924502&ssid=c5592564-01dd-4fed-bad7-e6f6844c1b48&allin=true");

        KeystoneLoginPage keystoneLoginPage = new KeystoneLoginPage();
        if (keystoneLoginPage.isOpen()) {
            keystoneLoginPage.coockiesClick();
            keystoneLoginPage.populateFields();
            keystoneLoginPage.loginClick();
        }
        Wait.wait(1000);

        // Todo: вернуть обратно чтение ссылок из файла
        //    ArrayList<String> goodsLinksArrayList = FileOperations.readFromTxtToArraylistString("goodsLinks.txt");
        ArrayList<String> goodsLinksArrayList = new ArrayList<>();
        goodsLinksArrayList.add("https://wwwsc.ekeystone.com/search/detail?pid=SKYH7006");
        goodsLinksArrayList.add("https://wwwsc.ekeystone.com/search/detail?pid=SKYH7020");

        for (String link : goodsLinksArrayList) {
            driver.get(link);
            KeystoneItemPage keystoneItemPage = new KeystoneItemPage();
            Assert.assertTrue(keystoneItemPage.isOpen());

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id=\"ThisFits\"]")));
            driver.findElement(By.xpath("//*[@id=\"ThisFits\"]")).click();
            keystoneItemPage.thisFitsTabClick();

            //Assert.assertTrue(thisFitsTab.isOpen());
            KeyThisFitsTabForm keyThisFitsTabForm = new KeyThisFitsTabForm();
            List<WebElement> plusesWebElementsList = keyThisFitsTabForm.getPlusesWebElementsList();
            plusesWebElementsList = driver.findElements(By.xpath(keyThisFitsTabForm.plusXpath));

            int n = 0;
            for (WebElement element : plusesWebElementsList) {
                if (element.isDisplayed()) {
                    // js.executeScript("arguments[0].scrollIntoView();", element);
                    element.click();
                    Wait.wait(Random.random(2350));
                    System.out.println(n++);
                }
            }

            String pageSource = driver.getPageSource();


            try {
                Robot robot = new Robot();

                robot.delay(2000);


                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_S);
                robot.keyRelease(KeyEvent.VK_CONTROL);
                robot.keyRelease(KeyEvent.VK_S);

                robot.delay(2000);
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);

                robot.delay(12000);
            } catch (Exception e) {e.printStackTrace();}



            Wait.wait(12000);

            try {
                PageOperations.whenWriteStringUsingBufferedWritter_thenCorrect(driver.getCurrentUrl()
                                .replaceAll("[\\*/\\\\!\\|:?<>]", "_")
                                .replaceAll("(%22)", "_"),
                        driver.getCurrentUrl() + "\n" + "\n" + pageSource);


                try {
                    FileOperations.whenAppendStringUsingBufferedWritter_thenOldContentShouldExistToo(
                            "savingDone.txt", driver.getCurrentUrl());
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            Wait.wait(500);

        }


    }
}