package pages.ContactUs;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileReader;
import java.time.Duration;

public class ContactUsForm {
    //div[@class='status alert alert-success']

    final By name = By.name("name");
    final By email = By.name("email");
    final By subject = By.name("subject");
    final By textArea = By.xpath("//textarea[@id='message']");
    final By submitBtn = By.xpath("//input[@type='submit']");
    final By successMessage = By.xpath("//div[@class='status alert alert-success']");
    final By homeBtn = By.xpath("//header/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/a[1]");
    final By chooseFile = By.xpath("//input[@type='file']");


    protected WebDriver driver;

    //Constructor for the  page
    public ContactUsForm(WebDriver driver) {
        this.driver = driver;
    }

    //fill the contact us form
    public void contactForm() throws Exception {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("src/test/java/Resources/TestDataFiles/RegisterData.json");
        Object obj = jsonParser.parse(reader);

        JSONObject nameObj = (JSONObject) obj;
        driver.findElement(name).sendKeys((String) nameObj.get("Name"));

        JSONObject emailObj = (JSONObject) obj;
        driver.findElement(email).sendKeys((String) emailObj.get("Email"));

        JSONObject subjectObj = (JSONObject) obj;
        driver.findElement(subject).sendKeys((String) subjectObj.get("Subject"));

        JSONObject textAreaObj = (JSONObject) obj;
        driver.findElement(textArea).sendKeys((String) textAreaObj.get("TextArea"));

        File uploadFile = new File("src/main/resources/Screenshot 2024-04-22 224944.png");
        WebElement fileInput = driver.findElement(chooseFile);
        fileInput.sendKeys(uploadFile.getAbsolutePath());

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn));

        driver.findElement(submitBtn).click();

        try {
            Alert a = driver.switchTo().alert();
            a.accept();
        } catch (Exception e) {
        }

    }

    //assert on success message text
    public String ContactUsFormMessage() {

        String formSuccessionMessage = driver.findElement(successMessage).getText();
        return formSuccessionMessage;
    }

    //clicking on home button
    public void returnToHomePage() {

        driver.findElement(homeBtn).click();
    }


}
