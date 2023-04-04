package Appium;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import static Appium.FirstAndroid.driver;
  public class AndroidGestures {
    public static void main(String[] args) throws Exception {
        FirstAndroid.main();
        FirstAndroid.click();
        LongClickGesture((AndroidDriver) driver);


    }

    public static void LongClickGesture(AndroidDriver driver) {
        driver.findElement(By.className("android.widget.TextView")).click();  //views
        driver.findElement(By.id("android:id/text1")).click();   //Drag and drop
        WebElement element = driver.findElement(By.id("com.touchboarder.android.api.demos:id/drag_dot_1")); //first


        driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId()
        ));


    }

}
