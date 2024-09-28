package utils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import helper.BaseTestHelper;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportUtil {

    public static ExtentReports extentReport = null;
    public static ExtentTest extentLog;

    // Method to initialize the Extent Report
    public static void initialize() {
        // Generate folder name with timestamp for dynamic report folder
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String reportFolder = System.getProperty("user.dir") + "/reports/" + timestamp;
        File folder = new File(reportFolder);

        // Create the folder if it doesn't exist
        if (!folder.exists()) {
            folder.mkdirs();
        }

        // Initialize the report with a dynamic name
        String reportPath = reportFolder + "/API_Execution_Automation.html";
        extentReport = new ExtentReports(reportPath, true);

        // Add system info dynamically
        extentReport.addSystemInfo("Host Name", "NEOM");
        extentReport.addSystemInfo("Environment", BaseTestHelper.getEnv("env").toUpperCase());
        extentReport.addSystemInfo("OS", System.getProperty("os.name"));

        // Load the extent-config.xml dynamically
        extentReport.loadConfig(new File(System.getProperty("user.dir") + "/resources/extent-config.xml"));
    }

    // Method to log collapsible steps dynamically
    public static void logCollapsibleStep(String stepTitle, String stepDetails) {
        // Log the step with summary and details (collapsed by default)
        extentLog.log(com.relevantcodes.extentreports.LogStatus.INFO,
                "<span class='step-summary' onclick='toggleStep(this)'>" + stepTitle + "</span>"
                        + "<div class='step-details'>" + stepDetails + "</div>");
    }

    // Method to finalize and flush the report
    public static void finalizeReport() {
        if (extentReport != null) {
            extentReport.flush();  // Ensure all logs are flushed to the report
            extentReport.close();  // Close the report after execution completes
        }
    }
}
