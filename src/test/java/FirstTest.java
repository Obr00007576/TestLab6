import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class FirstTest {
    private static AndroidDriverManager driverManager;
    static AndroidDriver<AndroidElement> driver;
    private LoginLayout loginLayout;
    private RegisterLayout registerLayout;
    private BudgetLayout budgetLayout;
    private AddExpenseLayout addExpenseLayout;
    static String email = "loging@login.com";
    static String pwd = "loging123123123";
    static String username = "user";
    @BeforeClass
    public static void prepareTest() {
        driverManager = new AndroidDriverManager();
        driver = driverManager.getDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @Before
    public void initPageObject() {
        loginLayout = new LoginLayout(driver);
    }
    @Test
    public void test() throws InterruptedException {
        loginLayout.verify();
        registerLayout = loginLayout.toRegisterLayout();
        registerLayout.verify();
        loginLayout = registerLayout.registerNewAccount(email, username, pwd);
        loginLayout.verify();
        budgetLayout = loginLayout.enterEmailAndPassword(email, pwd);
        budgetLayout.verify("Internet VPN", "30$", "Medical");
        addExpenseLayout = budgetLayout.toAddExpense();
        addExpenseLayout.verify();
        budgetLayout = addExpenseLayout.addExpense("Cat", "1", "04/14/2020 10:22", "Pet");
        budgetLayout.verify("Cat","1$","Pet");
        Thread.sleep(5000);
    }
}
