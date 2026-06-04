package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

By username = By.id("username");
By password = By.id("password");
By loginBtn = By.cssSelector("button[type='submit']");

    public LoginPage(WebDriver driver) {

        this.driver = driver;
    }

    public void enterUsername(String user) {

        driver.findElement(username).sendKeys(user);
    }

    public void enterPassword(String pass) {

        driver.findElement(password).sendKeys(pass);
    }

    public void clickLogin() {

        driver.findElement(loginBtn).click();
    }
}