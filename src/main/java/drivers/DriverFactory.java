package drivers;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigReader;
import utils.LoggerUtils;

public final class DriverFactory {

    private static final Logger logger =
            LoggerUtils.getLogger(DriverFactory.class);

    private static final ThreadLocal<WebDriver> driver =
        new ThreadLocal<>();

    private DriverFactory() {
    }

    public static WebDriver initDriver() {

        logger.info(
            "Thread : {}",
            Thread.currentThread().threadId());

        String browser =
                ConfigReader.get("browser");

        switch (browser.toLowerCase()) {

            case "firefox":

                logger.info("Setting up FirefoxDriver");
                WebDriverManager.firefoxdriver().setup();

                logger.info("Launching Firefox Browser");
                driver.set(new FirefoxDriver());

                break;

            case "edge":

                logger.info("Setting up EdgeDriver");
                WebDriverManager.edgedriver().setup();

                logger.info("Launching Edge Browser");
                driver.set(new EdgeDriver());

                break;

            case "chrome":

            default:

                logger.info("Setting up ChromeDriver");
                WebDriverManager.chromedriver().setup();

                logger.info("Launching Chrome Browser");
                driver.set(new ChromeDriver());

                break;
        }

        getDriver().manage().window().maximize();

        logger.info("Browser launched successfully");

        return getDriver();
    }

    public static WebDriver getDriver() {

        return driver.get();
    }

    public static void quitDriver() {

        WebDriver currentDriver = getDriver();

        if(currentDriver != null) {

            logger.info("Closing Browser");

            try {
                currentDriver.quit();
            } catch (WebDriverException exception) {
                logger.warn(
                        "Browser quit reported an error on thread {}",
                        Thread.currentThread().threadId(),
                        exception);
            } finally {
                driver.remove();
                logger.info("Browser Closed");
            }
        }
    }
}