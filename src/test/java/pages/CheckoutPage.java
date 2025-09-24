package pages;

import com.github.javafaker.Faker;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class CheckoutPage {
    private final AppiumDriver driver;
    Faker faker = new Faker();

    private final By Fullname = By.xpath("//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/fullNameET\"]");
    private final By Address = By.xpath("//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/address1ET\"]");
    private final By City = By.xpath("//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/cityET\"]");
    private final By ZipCode = By.xpath("//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/zipET\"]");
    private final By Country = By.xpath("//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/countryET\"]");
    private final By ToPayment = By.xpath("//android.widget.Button[@content-desc=\"Saves user info for checkout\"]");

    public CheckoutPage(AppiumDriver driver){
        this.driver = driver;
    }

    public void setFullname(){
        String fullname = faker.name().fullName();
        driver.findElement(Fullname).sendKeys(fullname);
    }

    public void setAddress(){
        String address = faker.address().fullAddress();;
        driver.findElement(Address).sendKeys(address);
    }

    public void setCity(){
        String city = faker.address().city();
        driver.findElement(City).sendKeys(city);
    }

    public void setZipCode(){
        String zipCode = faker.address().zipCode();;
        driver.findElement(ZipCode).sendKeys(zipCode);
    }

    public void setCountry(){
        String country = faker.country().name();
        driver.findElement(Country).sendKeys(country);
    }

    public void clickPayment(){
        driver.findElement(ToPayment).click();
    }
}
