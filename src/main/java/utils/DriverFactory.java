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
        if (driver == null) {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName", "Android");
            caps.setCapability("appium:automationName", "UiAutomator 2");

            // ubah sesuai device / emulator
            caps.setCapability("appium:deviceName", "JFK7A6L7OZUC8PXG");
            caps.setCapability("appium:udid", "JFK7A6L7OZUC8PXG");

            // kalau mau Appium install APK tiap run
            caps.setCapability("appium:app", System.getProperty("user.dir") + "/app/mda-1.0.13-15.apk");

            // atau kalau app sudah terinstall
            // caps.setCapability("appium:appPackage", "com.saucelabs.mydemoapp.android");
            // caps.setCapability("appium:appActivity", "com.saucelabs.mydemoapp.android.view.activities.MainActivity");

            driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
