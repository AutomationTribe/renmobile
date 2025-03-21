package org.renmoney.pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class GetALoanPage {

    public AndroidDriver driver;

    public GetALoanPage(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(className = "android.widget.EditText")
    private WebElement loanAmount;

    @AndroidFindBy(accessibility = "Rent")
    private WebElement loanPurpose;

    @AndroidFindBy(accessibility = "Continue")
    private WebElement continueBtn;

    public void  selectLoanPurpose(){
        loanPurpose.click();
    }

    public void enterLoanAmount(String amount){
        loanAmount.click();
        loanAmount.sendKeys(amount);
    }

    public void clickContinueBtn(){
        continueBtn.click();
    }


}
