package pages.RegisterUser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;

public class HomePage {

   protected WebDriver driver;
   private final By signupPage =By.xpath("//a[text()=' Signup / Login']");
   private final By getSignup =By.xpath("//h2[contains(text(),'New User Signup!')]");

    //Constructor for the homepage
    public  HomePage (WebDriver driver){
        this.driver=driver;
    }

    //navigating to the website url and asserting that the url is correct
    public void openUrl(String url){
        try {
            int respCode=200;
            HttpURLConnection huc=(HttpURLConnection) (new URL(url)).openConnection();
            huc.setRequestMethod("HEAD");
            huc.connect();
            respCode=huc.getResponseCode();
            if (respCode >= 400)
            { System.exit(0);}
        }
        catch (Exception e ){
            System.out.println("URL is wrong !!!!");
            System.exit(0);
        }
        driver.get(url);
        Assert.assertEquals(driver.getTitle(),"Automation Exercise");
    }

    //clicking on signup button
    public void clickOnSignupLogin(){
        driver.findElement(signupPage).click();
        WebElement element=driver.findElement(getSignup);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}
