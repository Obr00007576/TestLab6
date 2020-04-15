import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class AddExpenseLayout {
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/new_expense_title_edit")
    AndroidElement newExpenseTitleEdit;
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/new_expense_sum_edit")
    AndroidElement newExpenseSumEdit;
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/new_expense_date_edit")
    AndroidElement newExpenseDateEdit;
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/new_expense_category_picker")
    AndroidElement newExpenseCategoryPicker;
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/save_new_expense")
    AndroidElement saveNewExpense;
    private AndroidDriver<AndroidElement> driver;
    public AddExpenseLayout(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10L)), this);
    }
    public BudgetLayout addExpense(String title, String sum, String date, String categoryPicker)
    {
        newExpenseTitleEdit.sendKeys(title);
        newExpenseSumEdit.sendKeys(sum);
        newExpenseDateEdit.sendKeys(date);
        newExpenseCategoryPicker.sendKeys(categoryPicker);
        saveNewExpense.click();
        return new BudgetLayout(driver);
    }
    public void verify()
    {
        Assert.assertTrue(newExpenseTitleEdit.isDisplayed()&&newExpenseSumEdit.isDisplayed()&&newExpenseDateEdit.isDisplayed()&&newExpenseCategoryPicker.isDisplayed()&&saveNewExpense.isDisplayed());
    }
}
