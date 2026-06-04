package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    public static WebDriver driver;

public static WebDriver initDriver() {

    ChromeOptions options = new ChromeOptions();

    options.addArguments("--headless=new");
    options.addArguments("--window-size=1920,1080");
    options.addArguments("--disable-gpu");
    options.addArguments("--disable-extensions");
    options.addArguments("--disable-dev-shm-usage");
    options.addArguments("--remote-allow-origins=*");
    options.addArguments("--disable-background-networking");
    options.addArguments("--disable-features=Translate");

    driver = new ChromeDriver(options);

    return driver;
}

    public static void quitDriver() {

        if(driver != null) {
            driver.quit();
        }
    }
}