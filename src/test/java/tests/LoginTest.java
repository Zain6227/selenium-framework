package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import base.BaseTest;
import drivers.DriverFactory;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    @Test
public void verifyBrowserStarts() throws Exception {

    WebDriver driver = DriverFactory.initDriver();

    System.out.println("Chrome Started");

    Thread.sleep(10000);

    driver.quit();
}

    // @Test
    // public void verifyLogin() {

    //     driver.get("https://the-internet.herokuapp.com/login");

    //     LoginPage login = new LoginPage(driver);

    //     login.enterUsername("tomsmith");
    //     login.enterPassword("SuperSecretPassword!");

    //     login.clickLogin();
    // }
}