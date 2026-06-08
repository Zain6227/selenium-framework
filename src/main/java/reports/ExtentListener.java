package reports;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;

import drivers.DriverFactory;
import utils.LoggerUtils;
import utils.ScreenshotUtils;

public class ExtentListener implements ITestListener {

    private static final Logger logger =
            LoggerUtils.getLogger(ExtentListener.class);

    @Override
    public void onStart(ITestContext context) {

        ExtentManager.getExtentReports();
    }

    @Override
    public void onTestStart(ITestResult result) {

        logger.info(
            "Starting Test: {}",
            result.getMethod().getMethodName());

        ExtentTest test =
                ExtentManager
                        .getExtentReports()
                        .createTest(result.getMethod().getMethodName());

        ExtentTestManager.setTest(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        logger.info(
            "Test Passed: {}",
            result.getMethod().getMethodName());

        ExtentTestManager
                .getTest()
                .pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        logger.error(
            "Test Failed: {}",
            result.getMethod().getMethodName());

        logger.error(
            result.getThrowable());

        ExtentTestManager
                .getTest()
                .fail(result.getThrowable());

        if (DriverFactory.getDriver() == null) {
            return;
        }

        String screenshotPath =
                ScreenshotUtils.capture(
                        DriverFactory.getDriver(),
                        result.getMethod().getMethodName());

        ExtentTestManager
            .getTest()
            .addScreenCaptureFromPath(screenshotPath);
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        logger.info(
            "Test Skipped: {}",
            result.getMethod().getMethodName());

        ExtentTestManager
                .getTest()
                .skip("Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {

        ExtentManager
                .getExtentReports()
                .flush();

        ExtentTestManager.unload();
    }
}