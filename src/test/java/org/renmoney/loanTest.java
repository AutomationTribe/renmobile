
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
       // Thread.sleep(1000);
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
        Thread.sleep(10000);

       // driver.findElement(By.className("android.widget.Button")).click();
        dashboardPage.closeSlide();
        //Thread.sleep(5000);
        //dashboardPage.setLocationAccess();
      //  Thread.sleep(1000);
       // dashboardPage.clickCloseBtn();
        Thread.sleep(5000);
        dashboardPage.clickGetLoan();
        dashboardPage.clickGetALoan();
        Thread.sleep(5000);
        dashboardPage.checkTerms();
        dashboardPage.clickContinueBtn();
        Thread.sleep(5000);
      //  dashboardPage.clickAllowContacts();
        Thread.sleep(5000);
        loan.enterLoanAmount("4000000");
        driver.hideKeyboard();
       // driver.hideKeyboard();
       // loan.selectLoanPurpose();

       // loan.clickContinueBtn();
        Thread.sleep(2000);
       // Personal Information

        //personalInfo.setSingle();
        //personalInfo.setEducationalLevel();
        personalInfo.getListOfStates();
        personalInfo.scrollToElement("Lagos");
        personalInfo.setStateOfResidence("Lagos");
        personalInfo.getLocalGovernmentList();
       // personalInfo.scrollToElement("Eti-osa");
        personalInfo.setLocalGovernment("Eti-Osa");
        scrollToText("Residential Status");
        Thread.sleep(3000);
        //personalInfo.setDateMovedIn();

        Thread.sleep(5000);



    }
}
