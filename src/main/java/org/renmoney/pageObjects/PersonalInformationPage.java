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

    public void getResidentialStatus(){
        residentialStatus.click();
    }

    public void setSingle(){
        single.click();
    }

    public  void setEducationalLevel(){
        graduate.click();
    }

    public WebElement setDateMovedIn(){
        return driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"15/12/2021\")"));
    }
    /*public void getStateofResidence(String state){

        listOfStates.click();
        WebElement stateOption = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\""+" state "+"\")"));
        stateOption.click();
    }*/

    public void getListOfStates(){
        listOfStates.click();
    }
    public void setStateOfResidence(String state) throws InterruptedException {

        WebElement stateOption = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId(state)));
        stateOption.click();
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
