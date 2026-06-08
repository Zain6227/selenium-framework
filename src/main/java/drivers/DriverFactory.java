package drivers;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import constants.FrameworkConstants;
import enums.BrowserType;
import utils.ConfigReader;
import utils.LoggerUtils;

public class DriverFactory {

    private static final Logger logger =
            LoggerUtils.getLogger(DriverFactory.class);

    public static WebDriver driver;

    public static WebDriver initDriver() {

        logger.info("Setting up ChromeDriver");

        BrowserType browserType = ConfigReader.getBrowser();

        if (browserType != BrowserType.CHROME) {
            throw new IllegalArgumentException("Unsupported browser: " + browserType);
        }

        ChromeOptions options = new ChromeOptions();
        options.setBinary(
            FrameworkConstants.DEFAULT_CHROME_BINARY
        );

        if (ConfigReader.getBoolean("headless", false)) {
            options.addArguments("--headless=new");
        }

        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-background-networking");
        options.addArguments("--disable-features=Translate");
        options.addArguments("--disable-software-rasterizer");

        logger.info("Launching Chrome Browser");
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        logger.info("Browser launched successfully");

        return driver;
    }

    public static WebDriver getDriver() {

        return driver;
    }

    public static void quitDriver() {

        if(driver != null) {

            logger.info("Closing Browser");
            driver.quit();
            logger.info("Browser Closed");
        }
    }
}