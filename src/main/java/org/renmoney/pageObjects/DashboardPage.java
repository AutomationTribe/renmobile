package org.renmoney.pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {

    public AndroidDriver driver;
    public WebDriverWait wait;

    public DashboardPage(AndroidDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(id="com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    private WebElement locationAccess;

    @AndroidFindBy(className="android.widget.Button")
    private WebElement closeBtn;

    @AndroidFindBy(xpath="//android.view.View[@index='17']")
    private WebElement getLoan;

    @AndroidFindBy(accessibility = "Get a loan")
    private WebElement getALoan;

    @AndroidFindBy(className = "android.widget.CheckBox")
    private WebElement acceptTerms;

    @AndroidFindBy(accessibility = "Continue")
    private WebElement continueBtn;

    @AndroidFindBy(id="com.android.permissioncontroller:id/permission_allow_button")
    private WebElement allowContacts;


    public void closeSlide(){
        WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.Button")));
        closeBtn.click();
    }

    public void clickAllowContacts(){
        allowContacts.click();
        allowContacts.click();
    }
    public void clickContinueBtn(){
        continueBtn.click();
    }

    public void checkTerms(){
        acceptTerms.click();
    }

    public void setLocationAccess(){
        locationAccess.click();
    }

    public  void clickCloseBtn(){
        closeBtn.click();
    }

    public void clickGetLoan(){
        getLoan.click();
    }

    public void clickGetALoan(){
        getALoan.click();
    }
}
