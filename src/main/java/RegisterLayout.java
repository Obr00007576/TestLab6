import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
public class RegisterLayout {
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/registration_email")
    AndroidElement registrationEmail;
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/registration_username")
    AndroidElement registrationUsername;
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/registration_password")
    AndroidElement registrationPwd;
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/registration_confirm_password")
    AndroidElement registrationConfirmPwd;
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/register_new_account_button")
    AndroidElement registerNewAccountButton;
    private AndroidDriver<AndroidElement> driver;
    public RegisterLayout(AndroidDriver<AndroidElement> driver) {
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10L)), this);
    }
    public LoginLayout registerNewAccount(String email, String username, String pwd)
    {
        registrationEmail.sendKeys(email);
        registrationUsername.sendKeys(username);
        registrationPwd.sendKeys(pwd);
        registrationConfirmPwd.sendKeys(pwd);
        registerNewAccountButton.click();
        return new LoginLayout(driver);
    }
    public void verify()
    {
        Assert.assertTrue(registrationEmail.isDisplayed()&&registrationUsername.isDisplayed()&&registrationPwd.isDisplayed()&&registrationConfirmPwd.isDisplayed()&&registerNewAccountButton.isDisplayed());
    }
}
