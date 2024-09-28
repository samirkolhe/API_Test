package core;

import com.github.javafaker.Faker;
import com.relevantcodes.extentreports.LogStatus;
import helper.BaseTestHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import utils.ExtentReportUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    public static final String setEnv = BaseTestHelper.getEnv("env");
    public final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName() + ".class");
    public static Faker faker = new Faker();

    @BeforeTest
    public static Map<String, String> header() {
        Map<String, String> headers = new HashMap<>();
        headers.put("accept", "*/*");
        return headers;
    }

    @BeforeSuite(alwaysRun = true)
    public void config() throws IOException {
        // Initialize the ExtentReport using the utility class
        ExtentReportUtil.initialize();
    }

    @AfterMethod(alwaysRun = true)
    public void getResult(ITestResult result) {
        if (result.getStatus() == ITestResult.SUCCESS) {
            ExtentReportUtil.extentLog.log(LogStatus.PASS, "Test Case : " + result.getName() + " is passed ");
        } else if (result.getStatus() == ITestResult.FAILURE) {
            ExtentReportUtil.extentLog.log(LogStatus.FAIL, "Test case : " + result.getName() + " is failed ");
            ExtentReportUtil.extentLog.log(LogStatus.FAIL, "Test case is failed due to:  " + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            ExtentReportUtil.extentLog.log(LogStatus.SKIP, "Test case is Skipped " + result.getName());
        }
        ExtentReportUtil.extentReport.endTest(ExtentReportUtil.extentLog);
    }

    @AfterSuite(alwaysRun = true)
    public void endReport() {
        ExtentReportUtil.extentReport.flush();
        ExtentReportUtil.extentReport.close();
    }
}
