package Tests.TestFeatures;

import Tests.Browser.SetUp_Website;
import jdk.jfr.Description;
import org.testng.annotations.Test;
import pages.PlaceOrder.PlaceOrder;
import pages.Products.FirstProduct;
import pages.Products.Products;
import pages.RegisterUser.*;
import pages.RegisterUser.DeleteAccount;

public class PlaceOrderRegisterBeforeCheckout extends SetUp_Website {
    @Description("Test Case 11: Place Order: Register before Checkout")
    @Test
    public void VerifyingPlaceOrder() throws Exception {
        HomePage homePage = new HomePage(driver);
        homePage.openUrl(website);
        homePage.clickOnSignupLogin();

        SignUpPage signUp = new SignUpPage(driver);
        signUp.assertSignupPage();
        signUp.userSignup();

        AccountInformation accountInformation = new AccountInformation(driver);
        accountInformation.setAccountInformation("mr");

        AddressInformation addressInformation = new AddressInformation(driver);
        addressInformation.setAddressInformation();

        AccountCreated accountCreated = new AccountCreated(driver);
        accountCreated.assertAccountCreatedPage();
        accountCreated.verifyAccountCreation();


        Products products = new Products(driver);
        products.getProductsPage();
        products.assertProductsPage();
        products.assertProductsList();
        products.getFirstProduct();

        FirstProduct firstProduct = new FirstProduct(driver);
        firstProduct.firstProductDetails();

        PlaceOrder placeOrder = new PlaceOrder(driver);
        placeOrder.makeOrder();
        placeOrder.assertOrderIsPlaced();

        DeleteAccount deleteAccount = new DeleteAccount(driver);
        deleteAccount.accountDelete();

    }
}
