package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import dataproviders.LoginDataProvider;
import pages.LoginPage;
import utils.ConfigReader;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "loginData",
          dataProviderClass = LoginDataProvider.class)
    public void verifyLogin(String username,
                            String password) {

        driver.get(ConfigReader.get("url"));

        LoginPage login = new LoginPage(driver);

        login.enterUsername(username);

        login.enterPassword(password);

        login.clickSubmit();
    }
}