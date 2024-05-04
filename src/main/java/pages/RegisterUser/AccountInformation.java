package pages.RegisterUser;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.FileReader;

public class AccountInformation {

    final By maletitle = By.xpath("//input[@id='id_gender1']");
    final By femaletitle = By.xpath("//input[@id='id_gender2']");
    final By password = By.cssSelector("#password");
    final By birthDay = By.xpath("//select[@id='days']");
    final By birthMonth = By.cssSelector("#months");
    final By birthYear = By.cssSelector("#years");
    final By option = By.cssSelector("#optin");

    protected WebDriver driver;

    //Constructor for the page
    public AccountInformation(WebDriver driver) {
        this.driver = driver;
    }

    //Checking male
    public void clickOnMrTitle() {
        driver.findElement(maletitle).click();
    }

    //Checking female
    public void clickOnMrsTitle() {
        driver.findElement(femaletitle).click();
    }

    //Entering the account information
    public void setAccountInformation(String title) throws Exception {
        if (title.equalsIgnoreCase("mr") || title.equalsIgnoreCase("Mr")) {
            clickOnMrTitle();
        } else {
            clickOnMrsTitle();
        }
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("src/test/java/Resources/TestDataFiles/RegisterData.json");
        Object obj = jsonParser.parse(reader);

        JSONObject passwordObj = (JSONObject) obj;
        driver.findElement(password).sendKeys((String) passwordObj.get("Password"));

        JSONObject dayObj = (JSONObject) obj;
        new Select(driver.findElement(birthDay)).selectByVisibleText((String) dayObj.get("Day of Birth"));

        JSONObject monthObj = (JSONObject) obj;
        new Select(driver.findElement(birthMonth)).selectByVisibleText((String) monthObj.get("Month of Birth"));

        JSONObject yearObj = (JSONObject) obj;
        new Select(driver.findElement(birthYear)).selectByValue((String) yearObj.get("Year of Birth"));
        driver.findElement(option).click();

    }


}
