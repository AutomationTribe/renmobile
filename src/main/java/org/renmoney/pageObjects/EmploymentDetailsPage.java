package org.renmoney.pageObjects;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EmploymentDetailsPage {

    public AndroidDriver driver;
    WebDriverWait wait;
    public EmploymentDetailsPage(AndroidDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(xpath="//android.widget.ImageView[@text=\"Oil and Gas\"]")
    private WebElement sector;


    @AndroidFindBy(accessibility = "Submit")
    private WebElement submitBtn;

    public void clickSubmitBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Submit")));
        submitBtn.click();
    }

    public void clickNextBtn(){
        driver.findElement(AppiumBy.accessibilityId("Next")).click();
    }

    public void setSector(String sector){
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId(sector)));
        driver.findElement(AppiumBy.accessibilityId(sector)).click();
    }

    public void setIndustry(String industry){
        driver.findElement(AppiumBy.accessibilityId(industry)).click();
    }

    public void setMonthlySalary(String salary){
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text=\"" + salary + "\"]")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text=\"" + salary + "\"]")).clear();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text=\"" + salary + "\"]")).sendKeys(salary);
    }

    public void NextScroll(){
        WebElement nextButton = driver.findElement(
                new AppiumBy.ByAndroidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true))" +
                                ".scrollIntoView(new UiSelector().text(\"Next\"))"
                )
        );
        nextButton.click();
    }
}
