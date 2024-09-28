package api.faker.rest.authors;


import com.relevantcodes.extentreports.LogStatus;
import core.BaseTest;
import core.StatusCodes;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.AssertionUtil;
import utils.ExtentReportUtil;
import utils.HTTPMethods;
import utils.PropertyReader;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class POST_AddAuthor extends BaseTest {

    static String getId = "100";

    public static Response postAuthor() {
        Map<String, Object> author = new HashMap<>();
        author.put("id", 200);
        author.put("idBook", "201");
        author.put("firstName", "First Name 200 New");
        author.put("lastName", "Last Name 200 New");
        return HTTPMethods.postRequest("/api/v1/Authors/", header(), author, StatusCodes.SUCCESS);
    }

    @BeforeClass(alwaysRun = true)
    public void setup() {
        HTTPMethods.setBaseURI(PropertyReader.propertyReader("config/setup_" + setEnv + ".properties", "baseURI"));
    }

    @Test(description = "Validate the GET request is displaying the exchange rate of given currency")
    public void exchangeRateCurrencyCheck() throws IOException {
        ExtentReportUtil.extentLog = ExtentReportUtil.extentReport.startTest("BookingAPI_" + this.getClass().getSimpleName(), "Validate the GET request is displaying the exchange rate of given currency");
        // Send request
        Response res = postAuthor();

        // Get response details
        int statusCode = res.getStatusCode();
        String responseBody = res.getBody().asString();

        // Print response to console
        logger.info("Response Status Code: " + statusCode);
        logger.info("Response Status Code: " + responseBody);

        // Log response details to ExtentReports
        ExtentReportUtil.extentLog.log(LogStatus.INFO, "Response Body: " + responseBody);

        // Validate the status code and log the result
        HTTPMethods.verifyStatusCode(statusCode, StatusCodes.SUCCESS);

        // Assert content type of response
        AssertionUtil.assertEquals(res.contentType(), "application/json; charset=utf-8; v=1.0", "Assertion contentType passed");
    }
}
