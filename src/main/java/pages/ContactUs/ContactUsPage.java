package pages.ContactUs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class ContactUsPage {
    final By contactUsPage = By.xpath("//a[@href='/contact_us']");
    protected WebDriver driver;

    //Constructor for the page
    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }

    //open the contact us page
    public void getContactUsPage() {
        driver.findElement(contactUsPage).click();
    }

    //asserting the contact us page
    public void assertContactUsPage() {
        Assert.assertEquals(driver.getTitle(), "Automation Exercise - Contact Us");
    }

}
