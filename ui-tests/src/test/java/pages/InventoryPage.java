package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InventoryPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By inventoryContainer = By.id("inventory_container");
    private By cartIcon = By.className("shopping_cart_link");
    private By cartBadge = By.className("shopping_cart_badge");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(inventoryContainer));
    }

    // Most stable way: build id from item name
    // Example: "Sauce Labs Backpack" -> "add-to-cart-sauce-labs-backpack"
    public void addItemToCartByName(String itemName) {
        String id = "add-to-cart-" + itemName.toLowerCase().replace(" ", "-");
        By addBtn = By.id(id);

        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(addBtn));
        button.click();
    }

    public void openCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartIcon)).click();
    }

    public int getCartBadgeCount() {
        return driver.findElements(cartBadge).isEmpty()
                ? 0
                : Integer.parseInt(driver.findElement(cartBadge).getText());
    }
}
