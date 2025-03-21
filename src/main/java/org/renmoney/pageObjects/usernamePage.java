package org.renmoney.pageObjects;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class usernamePage {

    AndroidDriver driver;
    WebDriverWait wait;
    public usernamePage(AndroidDriver driver){
        this.driver = driver;
        wait =  new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(id="com.renmoney.android:id/collapse_button")
    private WebElement growModal;

    @AndroidFindBy(accessibility = "Get Started")
    private WebElement getStarted;

    @AndroidFindBy(className = "android.widget.EditText")
    private WebElement emailField;

    @AndroidFindBy(accessibility = "@gmail.com")
    private WebElement gmailProviderField;

    @AndroidFindBy(accessibility = "Continue")
    private WebElement continueBtn;

    public void closeGrowModal(){
        growModal.click();
    }

    public void clickGetStarted(){

        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Get Started")));
       // wait.until(ExpectedConditions.stalenessOf(element)); // Wait until the previous reference is gone
        element = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Get Started"))); // Re-locate
        element.click();
    }

    public void enterEmailAddress(String email){
        emailField.click();
        emailField.sendKeys(email);
    }

    public void clickGmailProvider(){
        gmailProviderField.click();
    }

    public void clickContinueBtn(){
        continueBtn.click();
    }
}
