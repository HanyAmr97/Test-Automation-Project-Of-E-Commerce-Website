package Tests.TestFeatures;

import Tests.Browser.SetUp_Website;
import jdk.jfr.Description;
import org.testng.annotations.Test;
import pages.RegisterUser.DeleteAccount;
import pages.RegisterUser.HomePage;
import pages.RegisterUser.LoginPage;

public class DeleteTheAccount extends SetUp_Website  {

    @Test
    public void verifyingDeleteAccount() throws Exception {
        HomePage homePage=new HomePage(driver);
        homePage.openUrl(website);
        homePage.clickOnSignupLogin();
        LoginPage login=new LoginPage(driver);
        login.assertLoginPage();
        login.loginVerification();
        login.assertLoginVerification();

        DeleteAccount deleteAccount=new DeleteAccount(driver);
        deleteAccount.accountDelete();
    }

}
