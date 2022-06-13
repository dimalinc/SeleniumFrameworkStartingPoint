package com.example.SeleniumFrameworkBlank.pageTests;

import com.example.SeleniumFrameworkBlank.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.KeystoneItemPage;
import pageObjects.forms.KeystoneLoginPage;
import pageObjects.forms.ThisFitsTab;
import utils.Wait;

public class KeystoneItemPageTest extends BaseTest {

    @Test
    public void test() {
        driver.get("https://wwwsc.ekeystone.com/search/detail?pid=PRS924502&ssid=c5592564-01dd-4fed-bad7-e6f6844c1b48&allin=true");

        KeystoneLoginPage keystoneLoginPage = new KeystoneLoginPage();

        if (keystoneLoginPage.isOpen()) {
            keystoneLoginPage.coockiesClick();
            keystoneLoginPage.populateFields();
            keystoneLoginPage.loginClick();
        }

        Wait.wait(10000);
        driver.get("https://wwwsc.ekeystone.com/search/detail?pid=PRS924502&ssid=c5592564-01dd-4fed-bad7-e6f6844c1b48&allin=true");
        KeystoneItemPage keystoneItemPage = new KeystoneItemPage();
        Assert.assertTrue(keystoneItemPage.isOpen());

        ThisFitsTab thisFitsTab = new ThisFitsTab();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath("//*[@id=\"ThisFits\"]")) );
        driver.findElement(By.xpath("//*[@id=\"ThisFits\"]")).click();


        //Assert.assertTrue(thisFitsTab.isOpen());

        int n=0;
        thisFitsTab.plusesWebElementsList = driver.findElements(By.xpath(thisFitsTab.plusXpath));
        for (WebElement element : thisFitsTab.plusesWebElementsList) {
            if (element.isDisplayed()) {

               // js.executeScript("arguments[0].scrollIntoView();", element);
                element.click();
              //  Wait.wait(500);
                System.out.println(n++);

            }
        }

        Wait.wait(5000);
        //  keystoneItemPage.thisFitsTabClick();
    }

}
