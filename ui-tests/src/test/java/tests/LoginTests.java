package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    @Test(groups = {"smoke"})
    public void SMK_01_validLogin_shouldGoToInventory() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"),
                "User should land on inventory page after valid login");
    }

    @Test(groups = {"regression"})
    public void FN_01_invalidLogin_shouldShowError() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "wrong_password");

        Assert.assertTrue(loginPage.getErrorMessage().toLowerCase().contains("username and password"),
                "Error message should appear for invalid login");
    }
}
