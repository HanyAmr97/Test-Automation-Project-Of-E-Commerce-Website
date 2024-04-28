package pages.RegisterUser;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import java.io.FileReader;

public class SignUpPage {

    final By signupName=By.name("name");
    final By signupEmail=By.xpath("//input[@data-qa='signup-email']");
    final By signupBtn=By.xpath("//button[contains(text(),'Signup')]");


    protected WebDriver driver;

    //Constructor for the page
    public SignUpPage(WebDriver driver)
    {
        this.driver=driver;
    }

    //Asserting the signup page
    public void assertSignupPage() {
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(driver.getTitle(),"Automation Exercise - Signup / Login");
        softAssert.assertAll();
    }

    //Entering email and password
    public void userSignup() throws Exception {
        JSONParser jsonParser= new JSONParser();
        FileReader reader=new FileReader("src/test/java/Resources/TestDataFiles/RegisterData.json");
        Object obj = jsonParser.parse(reader);

        JSONObject nameObj= (JSONObject)obj;
        driver.findElement(signupName).sendKeys((String)nameObj.get("Name"));

        JSONObject emailObj= (JSONObject)obj;
        driver.findElement(signupEmail).sendKeys((String)emailObj.get("Email"));
        driver.findElement(signupBtn).click();
    }

    
}
