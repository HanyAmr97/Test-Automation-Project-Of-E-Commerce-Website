package pages.Products;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FirstProduct {
    final By addToCardBtn = By.xpath("//button[@class='btn btn-default cart']");

    final By  productName =By.xpath("//h2[contains(text(),'Blue Top')]");
    final By  category =By.xpath("//p[contains(text(),'Category: Women > Tops')]");
    final By  price =By.xpath("//span[contains(text(),'Rs. 500')]");
    final By  availability =By.xpath("//b[contains(text(),'Availability:')]");
    final By  condition =By.xpath("//b[contains(text(),'Condition:')]");
    final By  brand =By.xpath("//b[contains(text(),'Brand:')]");

    protected WebDriver driver;

    //Constructor for the page
    public FirstProduct(WebDriver driver){
        this.driver=driver;
    }


    //Details of the first product
    public void firstProductDetails(){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(addToCardBtn));

       if ( driver.findElement(productName).isDisplayed()){
           System.out.println(" Product Name : " + productName);
       }
       else {
           System.out.println(" Product Name is not visible " );
       }

       if (driver.findElement(category).isDisplayed()){
           System.out.println(" Category : " + category);
       }
       else {
           System.out.println(" Category is not visible " );
       }

       if (driver.findElement(price).isDisplayed()){
            System.out.println(" Price : " + price);
       }
       else {
           System.out.println(" Price is not visible " );
       }

       if (driver.findElement(availability).isDisplayed()){
           System.out.println(" Availability : " + availability);
       }
       else {
           System.out.println(" Availability is not visible " );
       }

       if (driver.findElement(condition).isDisplayed()){
           System.out.println(" Condition : " + condition);
       }
       else {
           System.out.println(" Condition is not visible " );
       }

       if (driver.findElement(brand).isDisplayed()){
           System.out.println(" Brand : " + brand);
       }
       else {
           System.out.println(" Brand is not visible " );
       }


    }

}
