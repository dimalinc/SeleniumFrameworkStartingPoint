package pageObjects;

import elements.webelements.Button;
import elements.webelements.Image;
import elements.webelements.Label;
import elements.webelements.SeleniumSelect;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pageObjects.forms.BaseForm;
import pageObjects.forms.Footer;
import pageObjects.forms.Header;

public class MainPage extends BaseForm {


    private Header header = new Header();
    private Footer footer = new Footer();
    private Label selectYourVehiclelabel = new Label(By.xpath("//*[@id=\"post-701\"]/div/section[1]/div/div/div/div/div[1]/div/div/h2/strong"), "selectYourVehiclelabel");

    private SeleniumSelect carYearSelect = new SeleniumSelect(By.xpath("//select[contains(@class,'car-year')]"), "carYearSelect");
    private SeleniumSelect carMakeSelect = new SeleniumSelect(By.xpath("//select[contains(@class,'car-make')]"), "carMakeSelect");
    private SeleniumSelect carModelSelect = new SeleniumSelect(By.xpath("//select[contains(@class,'car-model')]"), "carModelSelect");
    private String findLinkRegex;
    private Button findButton = new Button(By.xpath("//div[contains(@class,'load-submit')]"), "findButton");

    public MainPage() {
        super(new Label(By.xpath("//*[@id=\"post-701\"]/div/section[1]/div/div/div/div/div[1]/div/div/h2/strong"),
                "uniqueElementMainPage"), "MainPage");
    }

    public void setCarYearSelect(String inputYear) {
        carYearSelect.click();
        carYearSelect.sendKeys(inputYear);
        carYearSelect.sendKeys(Keys.ENTER);
    }

    public String getCarYearSelectedText() {
        return carYearSelect.getSelectedOption().getText();
    }


}
