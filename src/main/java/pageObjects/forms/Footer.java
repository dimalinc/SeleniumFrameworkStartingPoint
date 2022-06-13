package pageObjects.forms;

import elements.base.BaseElement;
import elements.webelements.Label;
import org.openqa.selenium.By;

public class Footer extends BaseForm{
    public Footer() {
        super(uniqueElement,"Footer");
    }

    private static final BaseElement uniqueElement = new Label(By.xpath("//*[@id=\"tz_contacts-1\"]/ul/li[1]/div/span[2]"),"uniqueFooterLabel");



}
