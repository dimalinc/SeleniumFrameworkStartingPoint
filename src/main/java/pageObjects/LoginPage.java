package pageObjects;

import elements.webelements.*;
import elements.webelements.Label;
import org.openqa.selenium.By;
import pageObjects.forms.BaseForm;
import pageObjects.forms.Footer;
import pageObjects.forms.Header;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoginPage extends BaseForm {

    private Header header = new Header();
    private Footer footer = new Footer();
    private Label loginLabel = new Label(By.xpath("//*[@id=\"post-1708\"]/div/div/h2"), "login label");
    private Input loginInput = new Input(By.xpath("//*[@id=\"username\"]"), "loginInput");
    private Input passInput = new Input(By.xpath("//*[@id=\"password\"]"), "passInput");
    private Button loginButton = new Button(By.xpath("//*[@id=\"post-1708\"]/div/div/form/p[3]/button"), "loginButton");
    private Checkbox checkboxRememberMe = new Checkbox(By.xpath("//*[@id=\"rememberme\"]"), "checkboxRememberMe");
    private Link linkLostPassword = new Link(By.xpath
            ("//p[@class=\"woocommerce-LostPassword lost_password\"]//following-sibling::a"), "");
    private static Properties prop = new Properties();


    public LoginPage() {
        super(new Label(By.xpath("//*[@id=\"post-1708\"]/div/div/h2"), "uniqueElementloginPage"),
                "loginPage");
    }

    public static void initLoginProperties() {
        try {
            FileInputStream fis =
                    new FileInputStream(".\\src\\main\\resources\\credsBilstein.properties");
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void populateFields() {
        initLoginProperties();
        String loginString = prop.getProperty("LOGIN");
        String passString = prop.getProperty("PASS");
        loginInput.sendKeys(loginString);
        passInput.sendKeys(passString);
    }

    public void setRememberMeOn() {
        checkboxRememberMe.setOn();
    }

    public void setRememberMeOff() {
        checkboxRememberMe.setOff();
    }

    public void loginButtonClick() {
        loginButton.click();
    }

    public String loginInputGetText() {
        return loginInput.getText();
    }

    public String loginPassGetText() {
       return passInput.getText();
    }




}
