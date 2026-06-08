package base;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import drivers.DriverFactory;
import utils.LoggerUtils;

public class BaseTest {

    private static final Logger logger =
            LoggerUtils.getLogger(BaseTest.class);

    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setup() {

        logger.info("Launching Browser");
        driver = DriverFactory.initDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void teardown() {

        logger.info("Closing Browser");
        DriverFactory.quitDriver();
    }
}