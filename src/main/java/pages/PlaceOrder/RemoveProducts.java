package pages.PlaceOrder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class RemoveProducts {
    final By deleteItem = By.xpath("//a[@class='cart_quantity_delete']");
    final By emptyMessage = By.xpath("//p[@class='text-center']");
    final By addToCardBtn = By.xpath("//button[@class='btn btn-default cart']");
    final By continueShopping = By.xpath("//button[contains(text(),'Continue Shopping')]");
    final By cartPage = By.xpath("//i[@class='fa fa-shopping-cart']");
    final By proceedCheckout =By.xpath("//a[contains(text(),'Proceed To Checkout')]");


    protected WebDriver driver;

    //Constructor for the page
    public RemoveProducts(WebDriver driver){
        this.driver=driver;
    }


    //Place order
    public void makeOrder() throws Exception {
        driver.findElement(addToCardBtn).click();
        driver.findElement(continueShopping).click();
        driver.findElement(cartPage).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(proceedCheckout));
    }

    //Deleting the product
    public void deleteProduct(){
        driver.findElement(deleteItem).click();
    }

    //asserting that the product is deleted
    public void assertDeletedProduct(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.findElement(emptyMessage).getText(),"Cart is empty!");
        System.out.println("Cart is empty!");
    }

}
