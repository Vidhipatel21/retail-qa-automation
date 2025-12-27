package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class SmokeTest {

    @Test
    public void openSauceDemoHomePage() {
        WebDriverManager.edgedriver().setup();   // auto handles msedgedriver
        WebDriver driver = new EdgeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        System.out.println("Title is: " + driver.getTitle());

        driver.quit();
    }
}
