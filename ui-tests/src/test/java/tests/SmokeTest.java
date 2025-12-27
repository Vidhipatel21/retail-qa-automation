package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class SmokeTest {

    @Test
    public void openSauceDemoHomePage() {
        System.setProperty("webdriver.edge.driver",
                "C:\\selenium webdriver\\edgedriver\\msedgedriver.exe");

        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        System.out.println("Title is: " + driver.getTitle());

        driver.quit();
    }
}
