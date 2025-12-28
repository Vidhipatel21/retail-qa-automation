package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutStepOnePage {

    private WebDriver driver;

    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By postalCode = By.id("postal-code");
    private By continueBtn = By.id("continue");

    public CheckoutStepOnePage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillInfoAndContinue(String fn, String ln, String zip) {
        driver.findElement(firstName).sendKeys(fn);
        driver.findElement(lastName).sendKeys(ln);
        driver.findElement(postalCode).sendKeys(zip);
        driver.findElement(continueBtn).click();
    }
}
