package pages.RegisterUser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class AccountCreated {
    final By accountIsCreated = By.xpath("//div[@class='col-sm-9 col-sm-offset-1']");
    final By submitBtn = By.xpath("//a[contains(text(),'Continue')]");
    protected WebDriver driver;

    //Constructor for the page
    public AccountCreated(WebDriver driver) {
        this.driver = driver;
    }


    //asserting the account created page
    public void assertAccountCreatedPage() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getTitle(), "Automation Exercise - Account Created");
        softAssert.assertAll();
    }

    public void verifyAccountCreation() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        String str = driver.findElement(accountIsCreated).getText();
        if (str.contains("account has been successfully created")) {
            System.out.println("Congrats! Your account has been created successfully!");
        } else {
            System.out.println("unfortunately! Your account has been not created!");
        }

        driver.findElement(submitBtn).click();
    }


}
