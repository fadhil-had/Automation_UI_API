package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class OrderPage {
    private final AppiumDriver driver;

    private final By SauceBackpacksLabel = By.xpath("//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/productTV\"]");
    private final By BlueColor = By.xpath("//android.widget.ImageView[@content-desc=\"Blue color\"]");
    private final By Quantity = By.xpath("//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/noTV\"]");
    private final By Plus = By.xpath("//android.widget.ImageView[@content-desc=\"Increase item quantity\"]");
    private final By AddCart = By.xpath("//android.widget.Button[@content-desc=\"Tap to add product to cart\"]");
    private final By CartTwo = By.xpath("//android.widget.RelativeLayout[@content-desc=\"View cart\"]");
    private final By NextCart = By.xpath("//android.widget.ImageView[@content-desc=\"Displays number of items in your cart\"]");

    public OrderPage(AppiumDriver driver){
        this.driver = driver;
    }

    public void verifyLabel(){
        String actualLabel = driver.findElement(SauceBackpacksLabel).getText();
        Assert.assertEquals(actualLabel, "Sauce Lab Back Packs", "Product label not matched!");
    }

    public void selectColor(){ driver.findElement(BlueColor).click(); }
    public void setQuantity(String quantity){
        int current = Integer.parseInt(driver.findElement(Quantity).getText());
        while (current < Integer.parseInt(quantity)){
            driver.findElement(Plus).click(); //Selama masih dibawah 2 akan ditambah
            current++;
        }
    }

    public void setAddCart(){
        driver.findElement(AddCart).click();
        String cartNumb = driver.findElement(CartTwo).getText();
        Assert.assertEquals(cartNumb, "2", "The number of product not match with requirements!");

        driver.findElement(NextCart).click();
    }
}
