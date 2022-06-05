package browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BrowserFactory {

    private static WebDriver driver;
    public static Properties prop;

    public static WebDriver getDriver() {
        if (driver == null)
           driver = initializeDriver();
        return driver;
    }

    public static void initProperties() {
        prop = new Properties();
        try {
            FileInputStream fis =
                    new FileInputStream(".\\src\\main\\java\\utils\\params.properties");
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static WebDriver initializeDriver() {

        initProperties();

        String browserName = prop.getProperty("browser");
        int windowHeight = Integer.parseInt(prop.getProperty("windowHeight"));
        int windowWidth = Integer.parseInt(prop.getProperty("windowWidth"));

        switch (browserName) {

            case "chrome": {
                //Set up driver
                ChromeOptions options = new ChromeOptions();
                // ToDo: можно было использовать здесь String.format()
                options.addArguments("window-size=" + windowHeight + "," + windowWidth);
                options.setCapability("applicationCacheEnabled", false);
                WebDriverManager.chromedriver().setup();
                WebDriver driver = Browsers.CHROME.create();

                return driver;
                //return new ChromeDriver(options);

            }

            case "firefox":
               /* FirefoxOptions options = new FirefoxOptions();
                options.addArguments("window-size=" + windowHeight + "," + windowWidth);
                options.setCapability("applicationCacheEnabled", false);
                */
                FirefoxProfile profile = new FirefoxProfile();
                profile.setPreference("browser.download.folderList", 1);
                profile.setPreference("browser.download.manager.showWhenStarting", false);
                profile.setPreference("browser.download.manager.focusWhenStarting", false);
                profile.setPreference("browser.download.useDownloadDir", true);
                profile.setPreference("browser.helperApps.alwaysAsk.force", false);
                profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
                profile.setPreference("browser.download.manager.closeWhenDone", true);
                profile.setPreference("browser.download.manager.showAlertOnComplete", false);
                profile.setPreference("browser.download.manager.useWindow", false);
                profile.setPreference("browser.helperApps.alwaysAsk.force", false);
                // You will need to find the content-type of your app and set it here.
                profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream");

                FirefoxOptions capabilities = new FirefoxOptions();
                capabilities.setCapability("browser", "Firefox");
                capabilities.setCapability("browser_version", "latest");
                capabilities.setCapability("os", "Windows");
                capabilities.setCapability("os_version", "10");
                capabilities.setCapability("build", "Selenium Java Firefox Profile");
                capabilities.setCapability(FirefoxDriver.PROFILE, profile);

                capabilities.setProfile(profile);

                WebDriverManager.firefoxdriver().setup();
                return Browsers.FIREFOX.create();
            default:
                throw new RuntimeException("Incorrect BrowserName");
        }
    }

    public static void driverQuit() {
        driver.quit();
    }

    public static void setWebDriverNull() {
        BrowserFactory.driver = null;
    }
}

