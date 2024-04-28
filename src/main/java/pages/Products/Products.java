package pages.Products;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.NoSuchElementException;

public class Products {

    final By productsPage = By.xpath("//i[@class='material-icons card_travel']");
    final By allProductText=By.xpath("//h2[contains(text(),'All Products')]");
    final By productsList = By.xpath("//div[@class='productinfo text-center']");
    final By firstProduct = By.xpath("//a[@href='/product_details/1']");

    protected WebDriver driver;

    //Constructor for the page
    public Products(WebDriver driver){
        this.driver=driver;
    }

    //open the products page
    public void getProductsPage(){
        driver.findElement(productsPage).click();

    }

    //asserting the product page
    public void assertProductsPage(){
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(driver.findElement(allProductText).getText(),"ALL PRODUCTS");
        softAssert.assertAll();
    }

    //asserting the product list
    public void assertProductsList(){
        List<WebElement> productElements = driver.findElements(productsList);

        // Ensure there are products found
        if (productElements.isEmpty()) {
            throw new NoSuchElementException("No products found");
        }

        // Check if each product is displayed
        for (WebElement productElement : productElements) {
            Assert.assertTrue(productElement.isDisplayed(), "Product is not visible");
        }


    }

    //Choosing the first product
    public void getFirstProduct(){
    driver.findElement(firstProduct).click();

    }

}



