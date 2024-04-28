package Tests.TestFeatures;

import Tests.Browser.SetUp_Website;
import jdk.jfr.Description;
import org.testng.annotations.Test;
import pages.PlaceOrder.PlaceOrderRegister;
import pages.PlaceOrder.RemoveProducts;
import pages.Products.Products;
import pages.RegisterUser.HomePage;

public class RemoveProduct extends SetUp_Website {
    @Description("Test Case 12: Remove Products From Cart")
    @Test
    public void VerifyingRemoveProduct() throws Exception {
        HomePage homePage = new HomePage(driver);
        homePage.openUrl(website);

        Products products = new Products(driver);
        products.getProductsPage();
        products.assertProductsPage();
        products.assertProductsList();
        products.getFirstProduct();

        RemoveProducts removeProducts=new RemoveProducts(driver);
        removeProducts.makeOrder();
        removeProducts.deleteProduct();
        removeProducts.assertDeletedProduct();

    }
}
