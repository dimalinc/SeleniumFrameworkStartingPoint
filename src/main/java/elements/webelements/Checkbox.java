package elements.webelements;

import elements.base.BaseElement;
import org.openqa.selenium.By;

public class Checkbox extends BaseElement {

    public Checkbox(By locator, String elementName) {
        super(locator, elementName);
    }

    public boolean isEnabled() {
        return findElement().isEnabled();
    }

    public boolean isSelected() {
        return findElement().isSelected();
    }

    public void setOn() {
        if(!findElement().isSelected())
            findElement().click();
    }

    public void setOff() {
        if(findElement().isSelected())
        findElement().click();
    }
}
