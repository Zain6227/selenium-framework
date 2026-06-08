package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import constants.FrameworkConstants;

public final class ScreenshotUtils {

    private static final Logger logger =
            LoggerUtils.getLogger(ScreenshotUtils.class);

    private ScreenshotUtils() {
    }

    public static String capture(WebDriver driver,
                                 String testName) {

        logger.info(
                "Capturing screenshot for {}",
                testName);

        String timestamp =
                LocalDateTime.now()
                        .format(
                                DateTimeFormatter
                                        .ofPattern(
                                                "yyyyMMdd_HHmmss"));

        String screenshotPath =
                FrameworkConstants.SCREENSHOTS_DIR
                        + File.separator
                        + testName
                        + "_"
                        + timestamp
                        + ".png";

        File source =
                ((TakesScreenshot) driver)
                        .getScreenshotAs(
                                OutputType.FILE);

        File destination =
                new File(screenshotPath);

        destination.getParentFile().mkdirs();

        try {

            Files.copy(
                    source.toPath(),
                    destination.toPath(),
                    StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {

            throw new RuntimeException(e);
        }

        logger.info(
                "Screenshot saved at {}",
                screenshotPath);

        return screenshotPath;
    }
}