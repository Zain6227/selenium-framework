package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.WaitUtils;

public class DashboardPage extends HomePage {

    private static final int WAIT_SECONDS = 10;

    private final By successMessage = By.tagName("body");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public String getPageText() {
        return WaitUtils.waitForVisibility(driver, successMessage, WAIT_SECONDS).getText();
    }
}