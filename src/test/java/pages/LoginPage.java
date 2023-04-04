package pages;

import com.qa.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends BaseTest {

    @AndroidFindBy(accessibility = "test-Username")
    private static MobileElement UserNameTxtFld;
    @AndroidFindBy(accessibility = "test-Password")
    private static MobileElement PasswordTxtFld;
    @AndroidFindBy(accessibility = "test-LOGIN")
    private static MobileElement LoginBtn;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView")
    private MobileElement errTxt;


    public LoginPage enterUserName(String username) {
        sendKeys(UserNameTxtFld, username);
        return this;

    }

    public LoginPage enterPassword(String password) {
        sendKeys(PasswordTxtFld, password);
        return this;

    }

    public  ProductPage pressLoginBtn(){
        click(LoginBtn);
        return new ProductPage();
    }
}


