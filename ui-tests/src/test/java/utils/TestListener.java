package utils;

import base.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class TestListener implements ITestListener, ISuiteListener {

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onStart(ISuite suite) {
        extent = ExtentManager.getExtent();
    }

    @Override
    public void onFinish(ISuite suite) {
        if (extent != null) extent.flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);

        // Optional: log groups (smoke/regression)
        String groups = String.join(", ", result.getMethod().getGroups());
        if (!groups.isBlank()) test.get().info("Groups: " + groups);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("PASSED");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.get().fail(result.getThrowable());

        try {
            Object testClass = result.getInstance();
            WebDriver driver = ((BaseTest) testClass).getDriver();

            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File dest = new File("test-output/screenshots/" + result.getMethod().getMethodName() + ".png");
            dest.getParentFile().mkdirs();

            Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);

            test.get().addScreenCaptureFromPath(dest.getPath(), "Failure Screenshot");
        } catch (Exception e) {
            test.get().warning("Screenshot capture failed: " + e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().skip("SKIPPED: " + result.getThrowable());
    }
}
