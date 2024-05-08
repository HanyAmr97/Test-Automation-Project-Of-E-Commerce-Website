package pages.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;


public class TestCasesPage {

    final By testCasesPage = By.xpath("//i[@class='fa fa-list']");


    protected WebDriver driver;

    //Constructor for the page
    public TestCasesPage(WebDriver driver) {
        this.driver = driver;
    }

    //Get the test cases page
    public void getTestCasesPage() {
        driver.findElement(testCasesPage).click();
    }

    //Assert the test cases
    public void assertTestCasesPage() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals
                (driver.getTitle(), "Automation Practice Website for UI Testing - Test Cases");
        softAssert.assertAll();
    }


}
