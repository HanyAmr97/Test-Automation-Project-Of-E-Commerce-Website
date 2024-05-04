package pages.RegisterUser;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


import java.io.FileReader;
import java.time.Duration;

public class LoginPage {
    final By loggingAs = By.xpath("//a[@href='/login']");
    final By loginEmail = By.xpath("//input[@type='email']");
    final By loginPass = By.xpath("//input[@type='password']");
    final By loginBtn = By.xpath("//button[contains(text(),'Login')]");
    final By loggedAS = By.xpath("//header/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[10]/a[1]");

    protected WebDriver driver;


    //Constructor for the page
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Asserting the login page
    public void assertLoginPage() {
        SoftAssert softAssert = new SoftAssert();
        driver.findElement(loggingAs).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        softAssert.assertEquals(driver.getTitle(), "Automation Exercise - Signup / Login");
        softAssert.assertAll();
    }

    //Checking login

    public void loginVerification() throws Exception {

        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("src/test/java/Resources/TestDataFiles/RegisterData.json");
        Object obj = jsonParser.parse(reader);

        JSONObject emailObj = (JSONObject) obj;
        driver.findElement(loginEmail).sendKeys((String) emailObj.get("Email"));

        JSONObject emailPassObj = (JSONObject) obj;
        driver.findElement(loginPass).sendKeys((String) emailPassObj.get("Password"));
        driver.findElement(loginBtn).click();

    }

    //Verifying the login

    public void assertLoginVerification() throws Exception {
        SoftAssert softAssert = new SoftAssert();

        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("src/test/java/Resources/TestDataFiles/RegisterData.json");
        Object obj = jsonParser.parse(reader);

        JSONObject nameObj = (JSONObject) obj;
        String name = (String) nameObj.get("Name");
        softAssert.assertEquals(driver.findElement(loggedAS).getText(), "Logged in as " + name);
        softAssert.assertAll();
        System.out.println("You are successfully logged in !!");
    }

}
