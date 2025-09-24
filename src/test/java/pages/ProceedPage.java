package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.math.BigDecimal;

public class ProceedPage {
    private final AppiumDriver driver;

    private final By SauceBackpacksLabel = By.xpath("//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/titleTV\"]");
    private final By Quantity = By.xpath("//android.widget.ImageView[@content-desc=\"Displays color of selected product\"]");
    private final By OnePrice = By.xpath("//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/priceTV\"]");
    private final By TotalPrice = By.xpath("//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/totalPriceTV\"]");
    private final By Proceed = By.xpath("//android.widget.Button[@content-desc=\"Confirms products for checkout\"]");

    public ProceedPage(AppiumDriver driver){
        this.driver = driver;
    }

    public void verifyData(){
        String actualLabel = driver.findElement(SauceBackpacksLabel).getText();
        Assert.assertEquals(actualLabel, "Sauce Lab Back Packs", "Product label not matched!");

        String number = driver.findElement(Quantity).getText();
        Assert.assertEquals(number, "2", "The number of product not match with requirements!");
    }

    public void verifyTotalPrice() {
        // Ambil harga dari UI
        String rawPrice = driver.findElement(OnePrice).getText();
        String cleanPrice = rawPrice.replace("$", "").trim();
        BigDecimal actualUnitPrice = new BigDecimal(cleanPrice);

        String rawTotalPrice = driver.findElement(TotalPrice).getText();
        String cleanTotalPrice = rawTotalPrice.replace("$", "").trim();
        BigDecimal expectedTotalPrice = new BigDecimal(cleanTotalPrice);

        BigDecimal actualTotal = actualUnitPrice.multiply(new BigDecimal(2));
        Assert.assertEquals(actualTotal, expectedTotalPrice, "Total price mismatch!");
    }

    public void proceed(){
        driver.findElement(Proceed).click();
    }

}
