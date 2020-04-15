import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BudgetLayout {
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/add_new_expense")
    AndroidElement addNewExpense;
    private AndroidDriver<AndroidElement> driver;
    public BudgetLayout(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10L)), this);
    }
    public AddExpenseLayout toAddExpense()
    {
        addNewExpense.click();
        return new AddExpenseLayout(driver);
    }
    public void verify(String title, String sum, String categoryPicker)
    {
        List<AndroidElement> list = driver.findElements(By.xpath("//android.widget.ListView[@resource-id='platkovsky.alexey.epamtestapp:id/expenses_list']/android.widget.LinearLayout"));
        for(AndroidElement element: list)
        {
            String title1 = element.findElement(By.xpath("//android.widget.TextView[@resource-id='platkovsky.alexey.epamtestapp:id/expense_title']")).getText();
            String sum1 = element.findElement(By.xpath("//android.widget.TextView[@resource-id='platkovsky.alexey.epamtestapp:id/expense_sum']")).getText();
            String categoryPicker1 = element.findElement(By.xpath("//android.widget.TextView[@resource-id='platkovsky.alexey.epamtestapp:id/expense_category']")).getText();
            if(title1.equals(title)&&sum1.equals(sum)&&categoryPicker1.equals(categoryPicker))
            {
                Assert.assertTrue(true);
                return;
            }
        }
        Assert.fail();
    }
}
