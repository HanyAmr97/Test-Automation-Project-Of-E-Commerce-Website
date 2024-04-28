package pages.RegisterUser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class LogoutAccount {
    final By loggingOut=By.xpath("//a[@href='/logout']");
    protected WebDriver driver;

    //Constructor for the page
    public LogoutAccount(WebDriver driver)
    {
        this.driver=driver;
    }

    //Checking the logout
    public void logoutUser(){
        driver.findElement(loggingOut).click();
    }

    //Asserting the logout
    public void assertLogout(){
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(driver.getTitle(),"Automation Exercise - Signup / Login");
        softAssert.assertAll();
        System.out.println("You have successfully logged out!!");
    }


}
