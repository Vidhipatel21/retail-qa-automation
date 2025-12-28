package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage {

    private WebDriver driver;
    private By completeHeader = By.className("complete-header");

    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getHeaderText() {
        return driver.findElement(completeHeader).getText();
    }
}
