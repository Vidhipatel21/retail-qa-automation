package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private WebDriver driver;

    private By checkoutBtn = By.id("checkout");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isItemPresent(String itemName) {
        By item = By.xpath("//div[@class='inventory_item_name' and text()='" + itemName + "']");
        return !driver.findElements(item).isEmpty();
    }

    public void clickCheckout() {
        driver.findElement(checkoutBtn).click();
    }
    

}
