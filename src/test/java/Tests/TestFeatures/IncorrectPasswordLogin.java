package Tests.TestFeatures;

import Tests.Browser.SetUp_Website;
import jdk.jfr.Description;
import org.testng.annotations.Test;
import pages.RegisterUser.*;

public class IncorrectPasswordLogin extends SetUp_Website {

    @Description("Test Case 4: Login User with correct email and incorrect password")
    @Test
    public void verifyIncorrectPasswordLogin() throws Exception {

    HomePage homePage=new HomePage(driver);
    homePage.openUrl(website);
    homePage.clickOnSignupLogin();

    Incorrect_login incorrectPassword= new Incorrect_login(driver);
    incorrectPassword.incorrectPasswordVerification();
    }

}
