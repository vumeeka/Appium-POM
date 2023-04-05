package TestCases;

import com.qa.BaseTest;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;

import java.lang.reflect.Method;


public class LoginTest extends BaseTest {
    pages.LoginPage loginPage;
    static pages.ProductPage ProductPage;

    @BeforeClass
    public void beforeClass(){


    }
    @AfterClass
    public void afterClass(){

    }

    //static LoginPage loginPAge  = new LoginPage();
    @BeforeMethod
    public void beforeMethod(Method m){
        loginPage = new LoginPage();
        System.out.println("\n" + "Starting Test"+ m.getName());



    }

    @AfterMethod
    public void afterMethod(){

    }
    @Test
    public void invalidUserName(){
       loginPage.enterUserName("invalidusername");
       loginPage.enterPassword("secret_sauce");
       loginPage.pressLoginBtn();

        String actualErrTxt = loginPage.getErrTxt();
        String expectedErrTxt = "Username and password do not match any user in this service.";

        Assert.assertEquals(actualErrTxt, expectedErrTxt);

    }

    @Test
    public void invalidPassword(){
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("invalidpassword");
        loginPage.pressLoginBtn();


        String actualErrTxt = loginPage.getErrTxt();
        String expectedErrTxt = "Username and password do not match any user in this service.";

        Assert.assertEquals(actualErrTxt, expectedErrTxt);

    }

    @Test
    public void successfulLogin(){
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("invalidpassword");
        loginPage.pressLoginBtn();



        String actualProductTitle = ProductPage.getTitle();
        String expectedProductTitle = "PRODUCTS";

        Assert.assertEquals(actualProductTitle, expectedProductTitle);

    }


}

