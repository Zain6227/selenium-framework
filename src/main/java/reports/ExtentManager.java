package reports;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import constants.FrameworkConstants;

public final class ExtentManager {

    private static ExtentReports extent;

    private ExtentManager() {
    }

    public static ExtentReports getExtentReports() {

        if (extent == null) {

            String reportPath =
                    FrameworkConstants.REPORTS_DIR +
                    File.separator +
                    "ExtentReport.html";

            ExtentSparkReporter spark =
                    new ExtentSparkReporter(reportPath);

            spark.config().setReportName("Automation Execution Report");

            spark.config().setDocumentTitle("Selenium Framework Report");

            extent = new ExtentReports();

            extent.attachReporter(spark);

            extent.setSystemInfo("Framework", "Selenium Java");

            extent.setSystemInfo("Tester", "Zain");
        }

        return extent;
    }
}