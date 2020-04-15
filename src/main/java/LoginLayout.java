import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class LoginLayout {

    @FindBy(id = "platkovsky.alexey.epamtestapp:id/login_email")
    AndroidElement loginEmail;
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/login_pwd")
    AndroidElement loginPwd;
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/email_sign_in_button")
    AndroidElement signInButton;
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/register_button")
    AndroidElement registerButton;
    private AndroidDriver<AndroidElement> driver;
    public LoginLayout(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10L)), this);
    }
    public BudgetLayout enterEmailAndPassword(String email, String password) {
        loginEmail.sendKeys(email);
        loginPwd.sendKeys(password);
        signInButton.click();
        return new BudgetLayout(driver);
    }
    public RegisterLayout toRegisterLayout()
    {
        registerButton.click();
        return new RegisterLayout(driver);
    }
    public void verify()
    {
        Assert.assertTrue(loginEmail.isDisplayed()&&loginPwd.isDisplayed()&&signInButton.isDisplayed()&&registerButton.isDisplayed());
    }
}
