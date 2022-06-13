package pageObjects.forms;

import elements.webelements.Button;
import elements.webelements.Input;
import elements.webelements.Label;
import elements.webelements.Link;
import org.openqa.selenium.By;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class KeystoneLoginPage extends BaseForm{

    public KeystoneLoginPage() {
        super(uniqueElement,"KeystoneLoginPage uniqueElement");
    }

    private static final Label uniqueElement = new Label(By.xpath("//*[@id=\"LoginForm\"]/div[1]/h2"),
            "labelPleaseSignIn");
    private static final Label labelPleaseSignIn = new Label(By.xpath("//*[@id=\"LoginForm\"]/div[1]/h2"),
            "labelPleaseSignIn");
    private static final Button coockiesConfirmButton = new Button(By.xpath("/html/body/div[3]/div[3]/a"),
            "coockiesConfirmButton");

    private static Input inputLogin = new Input(By.xpath("//*[@id=\"Username\"]"),"input field for login");
    private static Input inputPass = new Input(By.xpath("//*[@id=\"Password\"]"),"input field for pass");
    private static Button buttonLogin = new Button(By.xpath("//*[@id=\"SignInButton\"]"),"buttonLogin");
    // <div class="login-forgotpassword">
    //                <a>Forgot Password</a>
    //            </div>
    private static Button buttonForgotPassword = new Button(By.xpath("//div[@class='login-forgotpassword']"),"buttonForgotPassword");


    private static Properties prop = new Properties();

    public static void initLoginProperties() {
        try {
            FileInputStream fis =
                    new FileInputStream(".\\src\\main\\resources\\credsKey.properties");
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void populateFields() {
        initLoginProperties();
        String loginString = prop.getProperty("LOGIN");
        String passString = prop.getProperty("PASS");
        inputLogin.sendKeys(loginString);
        inputPass.sendKeys(passString);
    }

    public void loginClick() {
        buttonLogin.click();
    }

    public void coockiesClick() {
        coockiesConfirmButton.click();
    }

}
