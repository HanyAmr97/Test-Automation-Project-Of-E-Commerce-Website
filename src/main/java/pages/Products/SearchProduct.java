package pages.Products;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.FileReader;
import java.util.List;
import java.util.NoSuchElementException;

public class SearchProduct {

    final By searchArea = By.cssSelector("#search_product");
    final By searchBtn = By.cssSelector("#submit_search");
    final By searchedProductText= By.xpath("//h2[@class='title text-center']");
    final By searchedproducts = By.xpath("//div[@class='productinfo text-center']");


    protected WebDriver driver;

    //Constructor for the page
    public SearchProduct(WebDriver driver){
        this.driver=driver;
    }


    //Searching for product
    public void SearchForProduct() throws Exception {

        JSONParser jsonParser= new JSONParser();
        FileReader reader=new FileReader("src/test/java/Resources/TestDataFiles/RegisterData.json");
        Object obj=jsonParser.parse(reader);
        JSONObject searchWordOb=(JSONObject) obj;
        driver.findElement(searchArea).sendKeys((String)searchWordOb.get("Search Word"));
        driver.findElement(searchBtn).click();
    }
    //Assert on search product

    public void assertSearchedProductsText() {
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(driver.findElement(searchedProductText).getText(),"Searched Products");
    }

    //Checking on visibility of the product

    public void verifyProductsAreVisible() {
        // Get all product elements matching the 'searchedproducts' locator
        List<WebElement> productElements = driver.findElements(searchedproducts);

        // Ensure there are products found
        if (productElements.isEmpty()) {
            throw new NoSuchElementException("No products found with the specified locator");
        }

        // Check if each product is displayed
        for (WebElement productElement : productElements) {
            Assert.assertTrue(productElement.isDisplayed(), "Product is not displayed");
        }
    }


}
