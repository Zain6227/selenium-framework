package listeners;

import org.apache.logging.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import utils.LoggerUtils;

public class RetryAnalyzer implements IRetryAnalyzer {

    private static final Logger logger =
            LoggerUtils.getLogger(RetryAnalyzer.class);

    private int currentRetry = 0;

    private static final int MAX_RETRY_COUNT = 2;

    @Override
    public boolean retry(ITestResult result) {

        if (currentRetry < MAX_RETRY_COUNT) {

            currentRetry++;

            logger.warn(
                    "Retrying test {} - Attempt {}",
                    result.getMethod().getMethodName(),
                    currentRetry);

            return true;
        }

        return false;
    }
}