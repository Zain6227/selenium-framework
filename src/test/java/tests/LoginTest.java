package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void verifyLogin() {

        driver.get("https://the-internet.herokuapp.com/login");

        LoginPage login = new LoginPage(driver);

        login.enterUsername("tomsmith");
        login.enterPassword("SuperSecretPassword!");

        login.clickLogin();
    }
}