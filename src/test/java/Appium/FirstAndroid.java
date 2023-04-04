package Appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class FirstAndroid {
    static AppiumDriver driver;
    //public static AndroidTouchAction actions;

    @BeforeTest
    public static void main() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "Appium");
        caps.setCapability("platformVersion", "12.0");
        caps.setCapability("deviceName", "Android Emulator");
        caps.setCapability("appPackage", " com.touchboarder.android.api.demos");
        caps.setCapability("appActivity", "com.touchboarder.androidapidemos.MainActivity");
        caps.setCapability("app", System.getProperty("user.dir")+"/apps/API Demos for Android_v1.9.0_apkpure.com.apk");

        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
    }


    @Test
    public static void click()
    {
        WebElement cl = driver.findElement(By.xpath("//android.widget.TextView[@text='API Demos']"));
        cl.click();
    }




    @AfterTest
   public void tearDown(){


      if (null != driver) {
            driver.quit();
        }
    }
}

