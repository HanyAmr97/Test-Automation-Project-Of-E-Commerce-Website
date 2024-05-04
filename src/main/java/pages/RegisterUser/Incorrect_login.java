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

public class Incorrect_login {
    final By login = By.xpath("//a[@href='/login']");
    final By loginEmail = By.xpath("//input[@type='email']");
    final By loginPass = By.xpath("//input[@type='password']");
    final By loginBtn = By.xpath("//button[contains(text(),'Login')]");
    final By errorMessage = By.xpath("//p[contains(text(),'Your email or password is incorrect!')]");


    protected WebDriver driver;

    //Constructor for the page
    public Incorrect_login(WebDriver driver) {
        this.driver = driver;
    }

    //clicking incorrect login with incorrect email
    public void incorrectEmailVerification() throws Exception {
        driver.findElement(login).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        Assert.assertEquals(driver.getTitle(), "Automation Exercise - Signup / Login");

        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("src/test/java/Resources/TestDataFiles/RegisterData.json");
        Object obj = jsonParser.parse(reader);

        JSONObject emailObj = (JSONObject) obj;
        driver.findElement(loginEmail).sendKeys((String) emailObj.get("IncorrectEmail"));

        JSONObject emailPassObj = (JSONObject) obj;
        driver.findElement(loginPass).sendKeys((String) emailPassObj.get("Password"));
        driver.findElement(loginBtn).click();
        String str = driver.findElement(errorMessage).getText();
        if (str.contains("email or password is incorrect")) {
            System.out.println("Your email or password is incorrect!");
        } else {
            System.out.println("Your email or password is incorrect!");
        }

    }

    //clicking incorrect login with incorrect password
    public void incorrectPasswordVerification() throws Exception {
        driver.findElement(login).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn));

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getTitle(), "Automation Exercise - Signup / Login");
        softAssert.assertAll();

        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("src/test/java/Resources/TestDataFiles/RegisterData.json");
        Object obj = jsonParser.parse(reader);

        JSONObject emailObj = (JSONObject) obj;
        driver.findElement(loginEmail).sendKeys((String) emailObj.get("Email"));

        JSONObject emailPassObj = (JSONObject) obj;
        driver.findElement(loginPass).sendKeys((String) emailPassObj.get("IncorrectPassword"));
        driver.findElement(loginBtn).click();
        String str = driver.findElement(errorMessage).getText();
        if (str.contains("email or password is incorrect")) {
            System.out.println("Your email or password is incorrect!");
        } else {
            System.out.println("Your email or password is incorrect!");
        }

    }

}
