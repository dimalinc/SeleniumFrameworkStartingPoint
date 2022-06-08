package com.example.SeleniumFrameworkBlank.old;



import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
import pageObjects.old_MainPage;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class oldMainPageTest {
    private WebDriver driver;
    private old_MainPage oldMainPage;

    @BeforeTest
    public void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);

        //driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.jetbrains.com/");

        oldMainPage = new old_MainPage(driver);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void search() {
        oldMainPage.searchButton.click();

        WebElement searchField = driver.findElement(By.id("header-search"));
        searchField.sendKeys("Selenium");

        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit' and text()='Search']"));
        submitButton.click();

        WebElement searchPageField = driver.findElement(By.className("js-search-input"));
        assertEquals("Selenium", searchPageField.getAttribute("value"));
    }

    @Test
    public void toolsMenu() {
        new Actions(driver)
                .moveToElement(oldMainPage.toolsMenu)
                .perform();

        WebElement menuPopup = driver.findElement(By.className("menu-main__popup-wrapper"));
        assertTrue(menuPopup.isDisplayed());
    }

    @Test
    public void navigationToAllTools() {
        oldMainPage.seeAllToolsButton.click();

        WebElement productsList = driver.findElement(By.className("products-list"));
        assertTrue(productsList.isDisplayed());
        assertEquals("All Developer Tools and Products by JetBrains", driver.getTitle());
    }
}
