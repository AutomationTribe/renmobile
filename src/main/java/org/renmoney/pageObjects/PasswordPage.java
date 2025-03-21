package org.renmoney.pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PasswordPage {

    public AndroidDriver driver;

    public PasswordPage(AndroidDriver driver){

        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }


    @AndroidFindBy(className = "android.widget.EditText")
    private WebElement passwordField;

    @AndroidFindBy(accessibility = "Sign in")
    private WebElement signinBtn;

    public void enterPassword(String password){
        passwordField.click();
        passwordField.sendKeys(password);
    }

    public void clickSigninBtn(){
        signinBtn.click();
    }
}
