package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.testng.Assert;

import java.math.BigDecimal;

public class ReviewPage {
    private final AppiumDriver driver;

    private final By SauceBackpacksLabel = By.xpath("//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/titleTV\"]");
    private final By Quantity = By.xpath("//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/itemNumberTV\"]");
    private final By OnePrice = By.xpath("//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/priceTV\"]");
    private final By FeePrice = By.xpath("//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/amountTV\"]");
    private final By TotalPrice = By.xpath("//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/totalAmountTV\"]");
    private final By PlaceOrder = By.xpath("//android.widget.Button[@content-desc=\"Completes the process of checkout\"]");

    public ReviewPage(AppiumDriver driver){
        this.driver = driver;
    }

    public void verifyData(){
        String actualLabel = driver.findElement(SauceBackpacksLabel).getText();
        Assert.assertEquals(actualLabel, "Sauce Lab Back Packs", "Product label not matched!");

        String number = driver.findElement(Quantity).getText();
        Assert.assertTrue(number.contains("2"), "Expected number is 2");
    }

    public void verifyTotalPrice() {
        // Ambil harga dari UI
        String rawPrice = driver.findElement(OnePrice).getText();
        String cleanPrice = rawPrice.replace("$", "").trim();
        BigDecimal actualUnitPrice = new BigDecimal(cleanPrice);

        String rawTotalPrice = driver.findElement(TotalPrice).getText();
        String cleanTotalPrice = rawTotalPrice.replace("$", "").trim();
        BigDecimal expectedTotalPrice = new BigDecimal(cleanTotalPrice);

        String rawFeePrice = driver.findElement(FeePrice).getText();
        String cleanFeePrice = rawFeePrice.replace("$", "").trim();
        BigDecimal expectedFeePrice = new BigDecimal(cleanFeePrice);

        BigDecimal actualTotal = actualUnitPrice.multiply(new BigDecimal(2)).add(expectedFeePrice);
        Assert.assertEquals(actualTotal, expectedTotalPrice, "Total price mismatch!");
    }

    public void proceed(){
        driver.findElement(PlaceOrder).click();
    }

}
