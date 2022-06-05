package com.example.SeleniumFrameworkBlank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerTest {

    private WebDriver driver;

    public static void main(String[] args) {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(chromeOptions);

        // Navigate to the i.ua website
        driver.get("https://i.ua");
        driver.quit();

    }

}
