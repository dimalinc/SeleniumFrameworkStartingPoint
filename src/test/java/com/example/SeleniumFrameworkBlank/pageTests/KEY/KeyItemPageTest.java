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

public class KeyItemPageTest extends BaseTest {

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
        driver.get("https://wwwsc.ekeystone.com/search/detail?pid=PRS924502&ssid=c5592564-01dd-4fed-bad7-e6f6844c1b48&allin=true");
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
                Wait.wait(Random.random(100));

                System.out.println(n++);

            }
        }

        String pageSource = driver.getPageSource();

        try {
            PageOperations.whenWriteStringUsingBufferedWritter_thenCorrect(driver.getCurrentUrl()
                            .replaceAll("[\\*/\\\\!\\|:?<>]", "_")
                            .replaceAll("(%22)", "_"),
                    driver.getCurrentUrl() + "\n" + "\n" + pageSource);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Wait.wait(5000);
        //  keystoneItemPage.thisFitsTabClick();
    }
}