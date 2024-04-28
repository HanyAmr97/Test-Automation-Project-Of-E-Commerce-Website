package Tests.TestFeatures;

import Tests.Browser.SetUp_Website;
import jdk.jfr.Description;
import org.testng.annotations.Test;
import pages.RegisterUser.HomePage;
import pages.TestCases.TestCasesPage;

public class TestCases extends SetUp_Website {
    @Description("Test Case 7: Verify Test Cases Page")
    @Test
    public void verifyingTestCasesPage(){
        HomePage homePage = new HomePage(driver);
        homePage.openUrl(website);

        TestCasesPage testCasesPage = new TestCasesPage(driver);
        testCasesPage.getTestCasesPage();
        testCasesPage.assertTestCasesPage();
    }

}
