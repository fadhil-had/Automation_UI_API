package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.github.javafaker.Faker;

public class LoginPage {
    private final AppiumDriver driver;
    Faker faker = new Faker();

    private final By Username = By.xpath("//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/nameET\"]");
    private final By Password = By.xpath("//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/passwordET\"]");
    private final By ExistingUser = By.xpath("//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/username1TV\"]");
    private final By Login = By.xpath("//android.widget.Button[@content-desc=\"Tap to login with given credentials\"]");

    public LoginPage(AppiumDriver driver){
        this.driver = driver;
    }

    public void setUsername(){
        String username = faker.name().username();
        driver.findElement(Username).sendKeys(username);
    }

    public void setPassword(){
        driver.findElement(Password).sendKeys("Password123#");
    }

    public void useExisting(){
        driver.findElement(ExistingUser).click();
    }

    public void clickLogin(){
        driver.findElement(Login).click();
    }
}
