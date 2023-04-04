package com.qa;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import utils.TestUtils;

import java.io.InputStream;
import java.net.URL;
import java.util.Properties;


public class BaseTest {
    protected static AppiumDriver driver;
    protected static Properties props;
    InputStream inputStream;
    private static MobileElement errTxt;

    public BaseTest(){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @Parameters({"platformName", "platformVersion", "deviceName"})
    @BeforeTest
    public void beforeTest(String platformName, String platformVersion, String deviceName){

        try{
            props= new Properties();
            String propFileName="config.properties";
            inputStream =getClass().getClassLoader().getResourceAsStream("propFileName");
            props.load(inputStream);
            DesiredCapabilities caps= new DesiredCapabilities();
            caps.setCapability("Platform name", platformName);
            caps.setCapability("appium:automationName", props.getProperty("androidAutomationName"));
            caps.setCapability("appium:platformVersion",  platformVersion);
            caps.setCapability("appium:deviceName",  deviceName);
            caps.setCapability("appPackage", props.getProperty("androidAppPackage"));

            caps.setCapability("appActivity", props.getProperty("androidAppActivity"));
            caps.setCapability("app", System.getProperty("user.dir")+ props.getProperty("androidAppLocation"));

            URL url= new URL(props.getProperty("AppiumURL"));



        } catch (Exception e) {
            e.printStackTrace();
        }




        }
    public static void waitForVisibility(MobileElement e){
        WebDriverWait wait= new WebDriverWait(driver, TestUtils.WAIT);
        wait.until(ExpectedConditions.visibilityOf(e));

    }

    public static void click(MobileElement e){
        waitForVisibility(e);
        e.click();

    }

    public static void sendKeys(MobileElement e, String txt){
        waitForVisibility(e);
        e.sendKeys(txt);
    }

    public static String getAttribute(MobileElement e, String Attribute){
        waitForVisibility(e);
        return e.getAttribute(Attribute);
    }

    public static String getErrTxt(){
        return getAttribute(errTxt,"text");
    }
    @AfterTest
    public void afterTest(){
        driver.quit();
    }


    }

