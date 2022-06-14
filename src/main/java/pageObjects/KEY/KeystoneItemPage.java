package pageObjects.KEY;

import elements.base.BaseElement;
import elements.webelements.Label;
import org.openqa.selenium.By;
import pageObjects.forms.BaseForm;

public class KeystoneItemPage extends BaseForm {

    public KeystoneItemPage() {
        super (uniqueElement,"KeystoneItemPage");
    }


    private static final BaseElement uniqueElement = new Label
            (By.xpath("//div[@class='product-detail-ordering-header']\n"),"KeystoneItemPage uniqueElement");

    //*[@id="ThisFits"]/div/div
private  Label thisFitsTab = new Label(By.xpath("//*[@id=\"ThisFits\"]"),"thisFitsTab");

public void thisFitsTabClick() {
    thisFitsTab.click();
}







}
