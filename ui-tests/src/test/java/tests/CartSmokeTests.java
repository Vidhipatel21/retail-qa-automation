package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;
import pages.CartPage;

public class CartSmokeTests extends BaseTest {

    @Test(groups = {"smoke"})
    public void SMK_02_addItemToCart_shouldShowInCart() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        String itemName = "Sauce Labs Backpack";
        inventoryPage.addItemToCartByName(itemName);

        Assert.assertEquals(inventoryPage.getCartBadgeCount(), 1, "Cart badge should be 1 after adding 1 item");

        inventoryPage.openCart();

        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.isItemPresent(itemName), "Added item should appear in cart");
    }
}
