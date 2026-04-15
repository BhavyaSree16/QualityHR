package listeners;

import org.testng.*;
import com.aventstack.extentreports.*;
import org.openqa.selenium.WebDriver;

import utils.ExtentManager;
import utils.ScreenshotUtils;

public class TestListener implements ITestListener {

    ExtentReports extent = ExtentManager.getInstance();
    ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test Passed ✅");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        if (test.get() == null) {
            ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
            test.set(extentTest);
        }

        test.get().fail("Test Failed ❌");
        test.get().fail(result.getThrowable());

        // ✅ Get driver safely
        WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");

        if (driver != null) {
            String path = ScreenshotUtils.capture(driver, result.getMethod().getMethodName());

            try {
                test.get().addScreenCaptureFromPath(path);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().skip("Test Skipped ⚠️");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}