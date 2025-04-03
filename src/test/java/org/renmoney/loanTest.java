package org.renmoney;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.renmoney.pageObjects.*;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class loanTest extends Base{


    @Test
    public void instantLoan() throws InterruptedException {

        usernamePage username = new usernamePage(driver);
        PasswordPage password =  new PasswordPage(driver);
        DashboardPage dashboardPage = new DashboardPage(driver);
        GetALoanPage loan = new GetALoanPage(driver);
        PersonalInformationPage personalInfo = new PersonalInformationPage(driver);
        EmploymentDetailsPage employee = new EmploymentDetailsPage(driver);

        Thread.sleep(3000);
        //username.closeGrowModal();

        username.clickGetStarted();

        Thread.sleep(3000);
        username.enterEmailAddress("murrayataga");
        Thread.sleep(2000);
        username.clickGmailProvider();
        driver.hideKeyboard();
        username.clickContinueBtn();
        Thread.sleep(5000);
        password.enterPassword("Elias@2021");
        driver.hideKeyboard();
        password.clickSigninBtn();
        Thread.sleep(2000);

        clickCloseButton();

        Thread.sleep(5000);
        dashboardPage.clickGetLoan();
        dashboardPage.clickGetALoan();
        Thread.sleep(5000);
        dashboardPage.checkTerms();
        dashboardPage.clickContinueBtn();
        Thread.sleep(5000);

        Thread.sleep(5000);
        loan.enterLoanAmount("4000000");
        driver.hideKeyboard();

        scrollByBounds(driver, 32, 1580, 688, 190);  // Scrolls more

        personalInfo.clickContinueBtn();
        employee.setSector("Agriculture");
        employee.setIndustry("Crop Production");
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollForward();"));

        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollForward();"));
        employee.clickNextBtn();
        Thread.sleep(5000);
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollForward();"));
        employee.clickNextBtn();
        Thread.sleep(3000);
        employee.clickSubmitBtn();
        Thread.sleep(120000);
       // WaitForOffer(driver);
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollForward();"));
        employee.clickNextBtn();
        Thread.sleep(60000);

        driver.findElement(AppiumBy.className("android.widget.ImageView")).click();
        /*driver.findElement(AppiumBy.accessibilityId("Adding a debit card\nYou're about to enter your repayment details. Enter the debit card linked to the bank statement you shared earlier\nContinue"))
                .click();*/

    }


}
