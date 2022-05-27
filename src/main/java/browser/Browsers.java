package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public enum Browsers {
    CHROME {
        public WebDriver create(){
            return new ChromeDriver();
        }
    },
    IE {
        public WebDriver create(){
            return new InternetExplorerDriver();
        }
    },
    FIREFOX {
        public WebDriver create() {
            return new FirefoxDriver();
        }
    },
    SAFARI {
        public WebDriver create() {
            return new SafariDriver();
        }
    }
    ;

    public WebDriver create(){
        return null;
    }
}


