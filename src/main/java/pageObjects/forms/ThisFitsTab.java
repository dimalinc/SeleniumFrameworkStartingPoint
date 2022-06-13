package pageObjects.forms;

import elements.webelements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ThisFitsTab extends BaseForm {


public ThisFitsTab() {
    super(uniqueElement,"ThisFitsForm");
}

 private static final Label uniqueElement = new Label
        (By.xpath("//div[contains(text(),'Some vehicles may require additional products. Please click on')]"),"uniqueElement");

    // all elements containing +
    //span[@class='expand-collapse-icon fa fa-plus-square']
    public static  List<WebElement> plusesWebElementsList = new ArrayList<WebElement>();
    public String plusXpath = "//span[@class='expand-collapse-icon fa fa-plus-square']\n";

}
