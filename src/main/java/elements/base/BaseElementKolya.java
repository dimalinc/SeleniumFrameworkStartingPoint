package elements.base;

import browser.Browser;
import browser.BrowserFactory;
import browser.BrowserFactory2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseElementKolya {
    private By locator;
    private String elementName;
    private static Logger log;

    public BaseElementKolya(By locator, String elementName) {
        this.locator = locator;
        this.elementName = elementName;
        log = Logger.getLogger(BaseElementKolya.this.elementName);
        log.log(Level.INFO, "Create object ==>" + this.elementName);
    }

    public By getLocator() {
        return locator;
    }

    protected WebElement findElement() {
        return Browser.getInstanceOfWebDriver().getDriver().findElement(locator);
    }

    protected List<WebElement> findElements() {
        return BrowserFactory.getDriver().findElements(locator);
    }

    public void click() {
        log.log(Level.INFO, "Click element ==>" + this.elementName);
        findElement().click();
    }

    public boolean isDisplayed() {
        return findElement().isDisplayed();
    }

    public boolean isPresent() {
        return (findElements().size() > 0);
    }

    public String getText() {
        log.log(Level.INFO, "get text element  ==>" + this.elementName+"="+findElement().getText());
        return findElement().getText();
    }

    public boolean isSelected() {
        return findElement().isSelected();
    }
    public void moveToClick() {
        log.log(Level.INFO, "Move to  element and Click  ==>" + this.elementName);
        new Actions(Browser.getInstanceOfWebDriver().getDriver()).moveToElement(findElement()).click().perform();
    }
    public void moveToElement() {
        log.log(Level.INFO, "Move to  element ==>" + this.elementName);
        new Actions(Browser.getInstanceOfWebDriver().getDriver()).moveToElement(findElement()).perform();
    }
}
