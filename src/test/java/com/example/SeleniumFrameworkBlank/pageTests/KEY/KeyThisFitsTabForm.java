package com.example.SeleniumFrameworkBlank.pageTests.KEY;

import elements.base.BaseElement;
import elements.webelements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageObjects.forms.BaseForm;

import java.util.ArrayList;
import java.util.List;

public class KeyThisFitsTabForm extends BaseForm {

    public KeyThisFitsTabForm() {
        super(uniqueElement,"KeyThisFitsTabForm");
    }

    //div[@class='product-detail-fitment-list']/div
    //*[contains(text(),'ABC')]


    private static Label uniqueElement = new Label(By.xpath("//div[contains(text(),'Some vehicles may require additional products. Please click on ')]"),
            "Some vehicles may require additional products. Please click on ");


    private  ArrayList<WebElement> plusesWebElementsList;

    public String plusXpath = "//span[@class='expand-collapse-icon fa fa-plus-square']\n";

    public List<WebElement> getPlusesWebElementsList() {
        return plusesWebElementsList;
    }
}
