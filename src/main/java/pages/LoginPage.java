package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.LoggerUtils;
import utils.WaitUtils;

public class LoginPage {

    private static final int WAIT_SECONDS = 10;
    private static final Logger logger =
            LoggerUtils.getLogger(LoginPage.class);

    private final WebDriver driver;

    private final By username = By.id("username");
    private final By password = By.id("password");
    private final By submit = By.id("submit");

    public LoginPage(WebDriver driver) {

        this.driver = driver;
    }

    public void enterUsername(String user) {

        logger.info("Entering username");
        WaitUtils.waitForVisibility(driver, username, WAIT_SECONDS).sendKeys(user);
    }

    public void enterPassword(String pass) {

        logger.info("Entering password");
        WaitUtils.waitForVisibility(driver, password, WAIT_SECONDS).sendKeys(pass);
    }

    public void clickSubmit() {

        logger.info("Clicking submit button");
        WaitUtils.waitForClickability(driver, submit, WAIT_SECONDS).click();
    }
}