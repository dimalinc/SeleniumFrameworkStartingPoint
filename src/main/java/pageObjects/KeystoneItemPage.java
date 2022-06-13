package pageObjects;

import elements.base.BaseElement;
import elements.webelements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageObjects.forms.BaseForm;

import java.util.ArrayList;
import java.util.List;

public class KeystoneItemPage extends BaseForm {

    public KeystoneItemPage() {
        super (uniqueElement,"KeystoneItemPage");
    }


    private static final BaseElement uniqueElement = new Label
            (By.xpath("//div[@class='product-detail-ordering-header']\n"),"KeystoneItemPage uniqueElement");

private  Label thisFitsTab = new Label(By.xpath("//*[@id=\"ThisFits\"]"),"thisFitsTab");

public void thisFitsTabClick() {
    thisFitsTab.click();
}








}
