package Tests.TestFeatures;

import Tests.Browser.SetUp_Website;
import jdk.jfr.Description;
import org.testng.annotations.Test;
import pages.RegisterUser.*;

public class Logout extends SetUp_Website {
    @Description("Test Case 5: Verify logout User")
    @Test
    public void verifyingLogout() throws Exception {

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

    }
}
