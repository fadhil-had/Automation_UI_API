package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class ProductsPage {
    private AppiumDriver driver;

    private By SauceBackpacks = By.xpath("//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/titleTV\" and @text=\"Sauce Lab Back Packs\"]");

    public ProductsPage(AppiumDriver driver){
        this.driver = driver;
    }

    public void selectBackpack(){
        driver.findElement(SauceBackpacks).click();
    }
}
