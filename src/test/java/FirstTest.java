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
    private static LoginLayout loginLayout;
    private static RegisterLayout registerLayout;
    private static BudgetLayout budgetLayout;
    private static AddExpenseLayout addExpenseLayout;
    static String email = "loging@login.com";
    static String pwd = "loging123123123";
    static String username = "user";
    @BeforeClass
    public static void prepareTest() {
        driverManager = new AndroidDriverManager();
        driver = driverManager.getDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        loginLayout = new LoginLayout(driver);
    }
    @Test
    public void test1() throws InterruptedException {
        loginLayout.verify();
    }
    @Test
    public void test2() throws InterruptedException{
        registerLayout = loginLayout.toRegisterLayout();
        registerLayout.verify();
    }
    @Test
    public void test3() throws InterruptedException{
        loginLayout = registerLayout.registerNewAccount(email, username, pwd);
        loginLayout.verify();
    }
    @Test
    public void test4() throws InterruptedException{
        budgetLayout = loginLayout.enterEmailAndPassword(email, pwd);
        budgetLayout.verify("Internet VPN", "30$", "Medical");
    }
    @Test
    public void test5() throws InterruptedException{
        addExpenseLayout = budgetLayout.toAddExpense();
        addExpenseLayout.verify();
    }
    @Test
    public void test6() throws InterruptedException{
        budgetLayout = addExpenseLayout.addExpense("Cat", "1", "04/14/2020 10:22", "Pet");
        budgetLayout.verify("Cat","1$","Pet");
    }
}
