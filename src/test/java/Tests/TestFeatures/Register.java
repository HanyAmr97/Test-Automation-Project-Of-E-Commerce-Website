package Tests.TestFeatures;

import Tests.Browser.SetUp_Website;
import jdk.jfr.Description;
import org.testng.annotations.Test;
import pages.RegisterUser.*;
import pages.RegisterUser.DeleteAccount;

public class Register extends SetUp_Website {

    @Description("Test Case 1: Register User")
    @Test
    public void completeRegister() throws Exception {
        HomePage homePage = new HomePage(driver);
        homePage.openUrl(website);
        homePage.clickOnSignupLogin();

        SignUpPage signUp = new SignUpPage(driver);
        signUp.assertSignupPage();
        signUp.userSignup();

        AccountInformation accountInformation = new AccountInformation(driver);
        accountInformation.setAccountInformation("mr");

        AddressInformation addressInformation = new AddressInformation(driver);
        addressInformation.setAddressInformation();

        AccountCreated accountCreated = new AccountCreated(driver);
        accountCreated.assertAccountCreatedPage();
        accountCreated.verifyAccountCreation();

        DeleteAccount deleteAccount = new DeleteAccount(driver);
        deleteAccount.accountDelete();


    }

}
