package pages.PlaceOrder;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.io.FileReader;
import java.time.Duration;

public class PlaceOrder {
    final By addToCardBtn = By.xpath("//button[@class='btn btn-default cart']");
    final By continueShopping = By.xpath("//button[contains(text(),'Continue Shopping')]");
    final By cartPage = By.xpath("//i[@class='fa fa-shopping-cart']");
    final By proceedCheckout =By.xpath("//a[contains(text(),'Proceed To Checkout')]");
    final By placeOrder =By.xpath("//a[contains(text(),'Place Order')]");
    final By nameOnCard=By.xpath("//input[@data-qa='name-on-card']");
    final By cardNumber=By.xpath("//input[@data-qa='card-number']");
    final By cvc=By.xpath("//input[@data-qa='cvc']");
    final By expiryMonth=By.xpath("//input[@data-qa='expiry-month']");
    final By expiryYear=By.xpath("//input[@data-qa='expiry-year']");
    final By payBtn =By.cssSelector("#submit");
    final By orderPlacedText =By.xpath("//p[contains(text(),'Congratulations! Your order has been confirmed!')]");
    final By continueBtn =By.xpath("//a[@class='btn btn-primary']");

    protected WebDriver driver;

    //Constructor for the page
    public PlaceOrder(WebDriver driver){
        this.driver=driver;
    }


    //Place order and checkout
    public void makeOrder() throws Exception {
        driver.findElement(addToCardBtn).click();
        driver.findElement(continueShopping).click();
        driver.findElement(cartPage).click();

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(proceedCheckout));
        driver.findElement(proceedCheckout).click();

        wait.until(ExpectedConditions.elementToBeClickable(placeOrder));
        driver.findElement(placeOrder).click();


        JSONParser jsonParser=new JSONParser();
        FileReader reader=new FileReader("src/test/java/Resources/TestDataFiles/RegisterData.json");
        Object obj=jsonParser.parse(reader);

        JSONObject nameOnCardObj=(JSONObject) obj;
        driver.findElement(nameOnCard).sendKeys((String)nameOnCardObj.get("Name on Card"));

        JSONObject cardNumberObj=(JSONObject) obj;
        driver.findElement(cardNumber).sendKeys((String)cardNumberObj.get("Card Number"));

        JSONObject cvcObj=(JSONObject) obj;
        driver.findElement(cvc).sendKeys((String)cvcObj.get("CVC"));

        JSONObject expiryMonthObj=(JSONObject) obj;
        driver.findElement(expiryMonth).sendKeys((String)expiryMonthObj.get("Expiration Month"));

        JSONObject expiryYearObj=(JSONObject) obj;
        driver.findElement(expiryYear).sendKeys((String)expiryYearObj.get("Expiration Year"));

       driver.findElement(payBtn).click();

    }


    //Assert on the completion of the order
    public void assertOrderIsPlaced(){
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(driver.findElement(orderPlacedText).getText(),"Congratulations! Your order has been confirmed!");
        softAssert.assertAll();
        driver.findElement(continueBtn).click();
        System.out.println("Order is placed successfully !!");
    }

}
