package org.renmoney;

import org.renmoney.pageObjects.*;
import org.testng.annotations.Test;

public class loanTest extends Base{


    @Test
    public void instantLoan() throws InterruptedException {

        usernamePage username = new usernamePage(driver);
        PasswordPage password =  new PasswordPage(driver);
        DashboardPage dashboardPage = new DashboardPage(driver);
        GetALoanPage loan = new GetALoanPage(driver);
        PersonalInformationPage personalInfo = new PersonalInformationPage(driver);

        Thread.sleep(3000);
        username.closeGrowModal();

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

        Thread.sleep(2000);

        personalInfo.getListOfStates();
        personalInfo.scrollToElement("Lagos");
        personalInfo.setStateOfResidence("Lagos");
        personalInfo.getLocalGovernmentList();
        personalInfo.setLocalGovernment("Eti-Osa");
        scrollToText("Elias");
        Thread.sleep(3000);
        personalInfo.setResidentialStatus("Owner");
        personalInfo.setDateMovedIn("Wed, 15 December 2021");
        personalInfo.setNextOfKinFname("Elias");
        personalInfo.setNextOfKinLname("Ataga");
        personalInfo.setNextOfKinRelationship("Sibling");
        personalInfo.clickContinueBtn();

        Thread.sleep(50000);



    }
}
