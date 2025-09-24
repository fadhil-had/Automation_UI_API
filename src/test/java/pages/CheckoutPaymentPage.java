package pages;

import com.github.javafaker.Faker;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class CheckoutPaymentPage {
    private final AppiumDriver driver;
    Faker faker = new Faker();

    private final By FullName = By.xpath("//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/nameET\"]");
    private final By CardNumber = By.xpath("//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/cardNumberET\"]");
    private final By ExpirationDate = By.xpath("//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/expirationDateET\"]");
    private final By SecurityCode = By.xpath("//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/securityCodeET\"]");
    private final By Review = By.xpath("//android.widget.Button[@content-desc=\"Saves payment info and launches screen to review checkout data\"]");

    public CheckoutPaymentPage(AppiumDriver driver){
        this.driver = driver;
    }

    public void setFullname(){
        String fullname = faker.name().fullName();
        driver.findElement(FullName).sendKeys(fullname);
    }

    public void setCardNumber(){
        driver.findElement(CardNumber).sendKeys("1111222233334444");
    }

    public void setExpirationDate(){
        driver.findElement(ExpirationDate).sendKeys("12/30");
    }

    public void setSecurityCode(){
        driver.findElement(SecurityCode).sendKeys("123");
    }

    public void clickPayment(){
        driver.findElement(Review).click();
    }
}
