package org.renmoney;

import org.renmoney.pageObjects.PasswordPage;
import org.renmoney.pageObjects.usernamePage;
import org.testng.annotations.Test;

public class loginTest extends Base{
    
    @Test
    public void ValidLogin() throws InterruptedException {

        usernamePage username = new usernamePage(driver);
        PasswordPage password =  new PasswordPage(driver);

        Thread.sleep(3000);
        username.closeGrowModal();
        Thread.sleep(3000);
        username.clickGetStarted();
        Thread.sleep(5000);

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
        Thread.sleep(5000);

    }
}
