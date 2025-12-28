package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getExtent() {
        if (extent == null) {
            String reportPath = System.getProperty("user.dir")
                    + File.separator + "test-output"
                    + File.separator + "extent-report.html";

            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
            spark.config().setDocumentTitle("Retail QA Automation Report");
            spark.config().setReportName("UI Smoke/Regression Test Results");

            extent = new ExtentReports();
            extent.attachReporter(spark);

            extent.setSystemInfo("Project", "Retail QA Automation Suite");
            extent.setSystemInfo("Browser", "Microsoft Edge");
            extent.setSystemInfo("Framework", "Selenium + TestNG + Maven");
        }
        return extent;
    }
}
