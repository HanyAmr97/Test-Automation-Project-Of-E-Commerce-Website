package pages.RegisterUser;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.FileReader;

public class AddressInformation {

    private final By firstName= By.cssSelector("#first_name");
    private final By lastName= By.cssSelector("#last_name");
    private final By company= By.cssSelector("#company");
    private final By address1= By.cssSelector("#address1");
    private final By address2= By.cssSelector("#address2");
    private final By country= By.cssSelector("#country");
    private final By state= By.cssSelector("#state");
    private final By city= By.cssSelector("#city");
    private final By zipcode= By.cssSelector("#zipcode");
    private final By mobile_number= By.cssSelector("#mobile_number");
    private final By createAccountBtn= By.xpath("//button[contains(text(),'Create Account')]");



    protected WebDriver driver;

    //Constructor for the page
    public AddressInformation(WebDriver driver)
    {
        this.driver=driver;
    }

    //Entering the address information
    public void setAddressInformation() throws Exception {

        JSONParser jsonParser= new JSONParser();
        FileReader reader=new FileReader("src/test/java/Resources/TestDataFiles/RegisterData.json");
        Object obj = jsonParser.parse(reader);

        JSONObject firstNameObj= (JSONObject)obj;
        driver.findElement(firstName).sendKeys((String)firstNameObj.get("First Name"));

        JSONObject lastNameObj= (JSONObject)obj;
        driver.findElement(lastName).sendKeys((String)lastNameObj.get("Last Name"));

        JSONObject companyObj= (JSONObject)obj;
        driver.findElement(company).sendKeys((String)companyObj.get("Company"));

        JSONObject address1_Obj= (JSONObject)obj;
        driver.findElement(address1).sendKeys((String)address1_Obj.get("Address"));

        JSONObject address2_Obj= (JSONObject)obj;
        driver.findElement(address2).sendKeys((String)address2_Obj.get("Address 2"));

        JSONObject countryObj= (JSONObject)obj;
        new Select(driver.findElement(country)).selectByVisibleText((String)countryObj.get("Country"));

        JSONObject stateObj= (JSONObject)obj;
        driver.findElement(state).sendKeys((String)stateObj.get("State"));

        JSONObject cityObj= (JSONObject)obj;
        driver.findElement(city).sendKeys((String)cityObj.get("City"));

        JSONObject zipcodeObj= (JSONObject)obj;
        driver.findElement(zipcode).sendKeys((String)zipcodeObj.get("Zipcode"));

        JSONObject mobileNumberObj= (JSONObject)obj;
        driver.findElement(mobile_number).sendKeys((String)mobileNumberObj.get("Mobile Number"));

        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        driver.findElement(createAccountBtn).click();

    }




}
