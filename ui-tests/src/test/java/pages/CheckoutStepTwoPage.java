package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutStepTwoPage {

    private WebDriver driver;
    private By finishBtn = By.id("finish");

    public CheckoutStepTwoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickFinish() {
        driver.findElement(finishBtn).click();
    }
}
