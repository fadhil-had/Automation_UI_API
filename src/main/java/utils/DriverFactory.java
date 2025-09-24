package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class DriverFactory {
    private static AppiumDriver driver;

    public static AppiumDriver getDriver() throws MalformedURLException {
        if (driver == null){
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName", "Android");
            caps.setCapability("automationName", "UiAutomator2");
            caps.setCapability("deviceName", "JFK7A6L7OZUC8PXG"); //Please replace it with your device name

            // APK yang disimpan di folder "app/"
            caps.setCapability("app", System.getProperty("user.dir") + "/app/mda-1.0.13-15.apk");

            driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);
        }
        return driver;
    }
}
