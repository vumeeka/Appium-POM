package AppiumSaucelab;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestCaseLogin {
    static AppiumDriver driver;

    @Test
    public static void invalidUserName(){

        MobileElement Username= (MobileElement) driver.findElementByAccessibilityId("test-Username");

        MobileElement Password= (MobileElement) driver.findElementByAccessibilityId("test-Password");
        MobileElement cl= (MobileElement) driver.findElementByAccessibilityId("test-LOGIN");




        Username.sendKeys("invalidusername");
        Password.sendKeys("12345678");
        cl.click();




        WebElement errTxt = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView"));
        String actualErrTxt = errTxt.getAttribute("text");
        String expectedErrTxt = "Username and password do not match any user in this service.";

        Assert.assertEquals(actualErrTxt, expectedErrTxt);

    }

    @Test
    public static void invalidPassword(){
        MobileElement Username= (MobileElement) driver.findElementByAccessibilityId("test-Username");

        MobileElement Password= (MobileElement) driver.findElementByAccessibilityId("test-Password");
        MobileElement cl= (MobileElement) driver.findElementByAccessibilityId("test-LOGIN");

        Username.sendKeys("standard_user");

        Password.sendKeys("invalidpassword");
        cl.click();




        WebElement errTxt = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView"));
        String actualErrTxt = errTxt.getAttribute("text");
        String expectedErrTxt = "Username and password do not match any user in this service.";

        Assert.assertEquals(actualErrTxt, expectedErrTxt);

    }

    @Test
    public static void successfulLogin(){
        MobileElement Username= (MobileElement) driver.findElementByAccessibilityId("test-Username");

        MobileElement Password= (MobileElement) driver.findElementByAccessibilityId("test-Password");
        MobileElement cl= (MobileElement) driver.findElementByAccessibilityId("test-LOGIN");

        Username.sendKeys("standard_user");
        Password.sendKeys("secret_sauce");
        cl.click();




        WebElement productTitleText = driver.findElement(By.xpath("\t\n" +
                "//android.view.ViewGroup[@content-desc=\"test-Cart drop zone\"]/android.view.ViewGroup/android.widget.TextView"));
        String actualProductTitle = productTitleText.getAttribute("text");
        String expectedProductTitle = "PRODUCTS";

        Assert.assertEquals(actualProductTitle, expectedProductTitle);

    }



    @BeforeTest
    public static void main() throws MalformedURLException {
//        UiAutomator2Options options = new UiAutomator2Options();
//        options.setApp("C:\\Users\\Vanilla\\AppData\\Local\\Android\\Sdk\\platform-tools\\Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
//        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),options);



        DesiredCapabilities caps= new DesiredCapabilities();
        caps.setCapability("Platform name", "Android");
        caps.setCapability("appium:automationName", "Appium");
        caps.setCapability("appium:platformVersion", "12.0");
        caps.setCapability("appium:deviceName", "Android Emulator");
        caps.setCapability("appPackage", "com.swaglabsmobileapp");
        caps.setCapability("appActivity", "com.swaglabsmobileapp.MainActivity");
        caps.setCapability("app", System.getProperty("user.dir")+"/apps/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }



    @AfterTest
    public void tearDown(){


        if (null != driver) {
            driver.quit();
        }
    }

}
