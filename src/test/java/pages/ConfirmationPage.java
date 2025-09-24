package pages;

import com.github.javafaker.Faker;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ConfirmationPage {
    private final AppiumDriver driver;
    Faker faker = new Faker();

    private final By SuccessLabel = By.xpath("//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/nameET\"]");

    public ConfirmationPage(AppiumDriver driver){
        this.driver = driver;
    }

    public void verifyLabel(){
        Assert.assertTrue(driver.findElement(SuccessLabel).isDisplayed());
        String success = driver.findElement(SuccessLabel).getText();
        Assert.assertEquals(success, "Checkout Complete");
    }
}
