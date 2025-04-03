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

public class PersonalInformationPage {

    AndroidDriver driver;
    WebDriverWait wait;
    public PersonalInformationPage(AndroidDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(accessibility = "Single")
    private WebElement single;

    @AndroidFindBy(accessibility = "Graduate")
    private WebElement graduate;

    @AndroidFindBy(accessibility = "Renting")
    private WebElement residentialStatus;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='13']")
    private WebElement listOfStates;

    @AndroidFindBy(xpath ="//android.widget.ImageView[@index='22']")
    private WebElement listOfLGA;

    @AndroidFindBy(xpath = "//android.view.View[@text=\"15/12/2021\"]")
    private WebElement getCalendar;



    @AndroidFindBy(xpath = "//android.widget.EditText[@index='4']")
    private WebElement nextOfKinLname;

    @AndroidFindBy(accessibility = "Continue")
    private WebElement continueBtn;

    public void clickContinueBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Continue"))).click();
        //continueBtn.click();
    }

    public void setNextOfKinRelationship(String relationship){

        driver.findElement(AppiumBy.accessibilityId(relationship)).click();
    }

    public void setNextOfKinLname(String lName){

        WebElement nextOfKinLname = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.EditText[@text=\"" + lName + "\"]")));
        nextOfKinLname.clear();
        nextOfKinLname.sendKeys(lName);

    }

    public void setNextOfKinFname(String fName){

       WebElement nextOfKinFname = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.EditText[@text=\"" + fName + "\"]")));
       nextOfKinFname.clear();
       nextOfKinFname.sendKeys(fName);

    }

    public void setDateMovedIn(String date){

        getCalendar.click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId(date))).click();
    }

    public void setResidentialStatus(String status){
        driver.findElement(AppiumBy.accessibilityId(status)).click();
    }

    public void getListOfStates(){
        listOfStates.click();
    }
    public void setStateOfResidence(String state) throws InterruptedException {

        WebElement stateOption = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId(state)));
        stateOption.click();
    }

    public void scrollToText(String element) {


        WebElement stateOption = driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().text(\"" + element + "\"))"
        ));
    }

    public void scrollToElement(String element) {


        WebElement stateOption = driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().description(\"" + element + "\"))"
        ));
    }


    public void getLocalGovernmentList(){
        listOfLGA.click();
    }
    public void setLocalGovernment(String lga){

        WebElement lgaOption = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId(lga)));
        lgaOption.click();
    }



}
