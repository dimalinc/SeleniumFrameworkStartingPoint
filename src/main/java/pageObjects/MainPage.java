package pageObjects;

import browser.Browser;
import browser.BrowserFactory;
import elements.webelements.Button;
import elements.webelements.Image;
import elements.webelements.Label;
import elements.webelements.SeleniumSelect;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.forms.BaseForm;
import pageObjects.forms.Footer;
import pageObjects.forms.Header;

import java.util.List;

public class MainPage extends BaseForm {


    private Header header = new Header();
    private Footer footer = new Footer();
    private Label selectYourVehiclelabel = new Label(By.xpath("//*[@id=\"post-701\"]/div/section[1]/div/div/div/div/div[1]/div/div/h2/strong"), "selectYourVehiclelabel");

    private SeleniumSelect carYearSelect = new SeleniumSelect(By.xpath("//select[contains(@class,'car-year')]"), "carYearSelect");
    private SeleniumSelect carMakeSelect = new SeleniumSelect(
            By.xpath("//select[contains(@class,'car-make')]"), "carMakeSelect");
    private SeleniumSelect carModelSelect = new SeleniumSelect(By.xpath("//select[contains(@class,'car-model')]"), "carModelSelect");
    private String findLinkRegex;

    private Button findButton = new Button(By.xpath(
            "//div[contains(@class,'load-submit')]"), "findButton");

    private Button buttonDisabled = new Button(By.xpath("//p[contains(@class,'disabled-link')]"),"disabled button");

    private Button findButtonLink = new Button
                    (By.xpath("//*[@id=\"post-701\"]/div/section[1]/div/div/div/div/div[2]/div/div/form/div[4]/a"), "findButtonLink");

    public MainPage() {
        super(new Label(By.xpath("//*[@id=\"post-701\"]/div/section[1]/div/div/div/div/div[1]/div/div/h2/strong"),
                "uniqueElementMainPage"), "MainPage");
    }

    public SeleniumSelect getCarYearSelect() {
        return carYearSelect;
    }
    public SeleniumSelect getCarMakeSelect() {
        return carMakeSelect;
    }
    public SeleniumSelect getCarModelSelect() {
        return carModelSelect;
    }
    public Button getFindButton() {
        return findButton;
    }

    public void setCarYearSelect(String inputYear) {
        WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(), 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(carYearSelect.getLocator()));
        element.click();
        element.sendKeys(inputYear);
        element.sendKeys(Keys.ENTER);
    }

    public void setCarMakeSelect(String inputMake) {
        WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(), 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(carMakeSelect.getLocator()));
        element.click();
        element.sendKeys(inputMake);
        element.sendKeys(Keys.ENTER);
    }

    public void setCarModelSelect(String inputModel) {
        WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(), 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(carModelSelect.getLocator()));
        element.click();
        element.sendKeys(inputModel);
        element.sendKeys(Keys.ENTER);
    }

    public void clickFindButton() {
        WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(), 10);
       // wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(buttonDisabled.getLocator())));

       /* JavascriptExecutor executor = (JavascriptExecutor) BrowserFactory.getDriver();
        executor.executeScript("arguments[0].scrollIntoView(true);", element);*/

        /*Actions actions = new Actions(BrowserFactory.getDriver());
        WebElement buttonFindWebElement = BrowserFactory.getDriver().findElement(findButton.getLocator());
        actions.moveToElement(buttonFindWebElement).click().perform();

        System.out.println("findButton.click()");
        */


        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(BrowserFactory.getDriver().getCurrentUrl());

    }

    public void clickFindButtonLink () {
        findButtonLink.click();
    }

    public String getCarYearSelectedText() {
        return carYearSelect.getSelectedOption().getText();
    }


}
