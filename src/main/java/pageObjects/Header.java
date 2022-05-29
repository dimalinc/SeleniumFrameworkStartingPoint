package pageObjects;

import elements.BaseElement;
import elements.basicElements.Image;
import elements.basicElements.Input;
import elements.basicElements.Label;
import org.openqa.selenium.By;

public class Header extends BaseForm{
    public Header() {
        super(uniqueElement, "Header");
    }

    private static final BaseElement uniqueElement = new Image(By.xpath("//*[@id=\"page\"]/header/div[2]/div[1]/a/img"),"BilsteinLifts Logo");
    private static final Input searchInput = new Input(By.xpath("//*[@id=\"ajaxsearchpro1_1\"]/div/div[3]/form/input[1]"),"searchInput");
    private static final Image searchIcon = new Image(By.xpath("//*[@id=\"ajaxsearchpro1_1\"]/div/div[1]/div[2]"),"searchIcon");
    private static final Image cartImage = new Image(By.xpath("//*[@id=\"ajaxsearchpro1_1\"]/div/div[1]/div[2]"),"cartImage");
    private static final Label cartPriceLabel = new Label(By.xpath("//*[@id=\"tz_woo_cart-1\"]/div[1]/span[1]/span"),"cartPriceLabel");

    private static final Label myAccountMenuItem = new Label(By.xpath("//*[@id=\"mega-menu-item-240488\"]"),"myAccountMenuItem");
    private static final Label homeMenuItem = new Label(By.xpath("//*[@id=\"mega-menu-item-240489\"]"),"homeMenuItem");
    private static final Label shopMenuItem = new Label(By.xpath("//*[@id=\"mega-menu-item-240492\"]"),"shopMenuItem");
    private static final Label aboutUsMenuItem = new Label(By.xpath("//*[@id=\"mega-menu-item-240493\"]"),"aboutUsMenuItem");
    private static final Label contactUsMenuItem = new Label(By.xpath("//*[@id=\"mega-menu-item-240494\"]"),"contactUsMenuItem");
    private static final Label warrantyMenuItem = new Label(By.xpath("//*[@id=\"mega-menu-item-311466\"]"),"warrantyMenuItem");

    public static BaseElement getUniqueElement() {
        return uniqueElement;
    }
    public static Input getSearchInput() {
        return searchInput;
    }
    public static Image getSearchIcon() {
        return searchIcon;
    }
    public static Image getCartImage() {
        return cartImage;
    }
    public static Label getMyAccountMenuItem() {
        return myAccountMenuItem;
    }
    public static Label getHomeMenuItem() {
        return homeMenuItem;
    }
    public static Label getShopMenuItem() {
        return shopMenuItem;
    }
    public static Label getAboutUsMenuItem() {
        return aboutUsMenuItem;
    }
    public static Label getContactUsMenuItem() {
        return contactUsMenuItem;
    }
    public static Label getCartPriceLabel() {
        return cartPriceLabel;
    }
    public static Label getWarrantyMenuItem() {
        return warrantyMenuItem;
    }
}
