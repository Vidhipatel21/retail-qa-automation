package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class CheckoutSmokeTests extends BaseTest {

    @Test(groups = {"smoke"})
    public void SMK_03_checkout_shouldCompleteSuccessfully() {

        // 1) Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        // 2) Add item to cart
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addItemToCartByName("Sauce Labs Backpack");
        inventoryPage.openCart();

        // 3) Checkout
        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckout();

        CheckoutStepOnePage stepOne = new CheckoutStepOnePage(driver);
        stepOne.fillInfoAndContinue("Vidhi", "Patel", "12345");

        CheckoutStepTwoPage stepTwo = new CheckoutStepTwoPage(driver);
        stepTwo.clickFinish();

        // 4) Verify order completed
        CheckoutCompletePage completePage = new CheckoutCompletePage(driver);
        Assert.assertTrue(
        		 completePage.getHeaderText().toLowerCase().contains("thank you"),
                 "Order should complete with a Thank You message");
    }
}
