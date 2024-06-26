package Tests.TestFeatures;

import Tests.Browser.SetUp_Website;
import jdk.jfr.Description;
import org.testng.annotations.Test;
import pages.Products.FirstProduct;
import pages.Products.Products;
import pages.RegisterUser.HomePage;

public class ProductsPage extends SetUp_Website {
    @Description("Test Case 8: Verify All Products and product detail  page")
    @Test
    public void VerifyingProducts() {
        HomePage homePage = new HomePage(driver);
        homePage.openUrl(website);

        Products products = new Products(driver);
        products.getProductsPage();
        products.assertProductsPage();
        products.assertProductsList();
        products.getFirstProduct();

        FirstProduct firstProduct = new FirstProduct(driver);
        firstProduct.firstProductDetails();
    }


}
