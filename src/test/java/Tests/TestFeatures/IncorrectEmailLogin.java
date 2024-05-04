package Tests.TestFeatures;

import Tests.Browser.SetUp_Website;
import jdk.jfr.Description;
import org.testng.annotations.Test;
import pages.RegisterUser.*;

public class IncorrectEmailLogin extends SetUp_Website {

    @Description("Test Case 3: Login User with incorrect email and correct password")
    @Test
    public void verifyIncorrectEmailLogin() throws Exception {

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

        LogoutAccount logout = new LogoutAccount(driver);
        logout.logoutUser();
        logout.assertLogout();

        Incorrect_login incorrectEmail = new Incorrect_login(driver);
        incorrectEmail.incorrectEmailVerification();
    }


}
