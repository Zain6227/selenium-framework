package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ConfigReader;

public class LoginTest extends BaseTest {
    @Test
    public void verifyLogin() {

        driver.get(ConfigReader.get("url"));

        LoginPage login = new LoginPage(driver);

        login.enterUsername(ConfigReader.get("username"));
        login.enterPassword(ConfigReader.get("password"));

        login.clickSubmit();
    }
}