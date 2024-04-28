package Tests.TestFeatures;

import Tests.Browser.SetUp_Website;
import jdk.jfr.Description;
import org.testng.annotations.Test;
import pages.Products.Products;
import pages.RegisterUser.HomePage;

public class SearchProduct extends SetUp_Website {
    @Description("Test Case 9: Search Product")
    @Test
    public void VerifyingProducts() throws Exception {
        HomePage homePage = new HomePage(driver);
        homePage.openUrl(website);

        Products products = new Products(driver);
        products.getProductsPage();
        products.assertProductsPage();
        products.assertProductsList();

        pages.Products.SearchProduct searchProduct = new pages.Products.SearchProduct(driver);
        searchProduct.SearchForProduct();
        searchProduct.verifyProductsAreVisible();
        searchProduct.assertSearchedProductsText();
    }


}
