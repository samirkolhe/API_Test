package api.faker.rest.authors;


import com.relevantcodes.extentreports.LogStatus;
import core.BaseTest;
import core.StatusCodes;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.ExtentReportUtil;
import utils.HTTPMethods;
import utils.PropertyReader;

import java.io.IOException;


public class DELETE_Author extends BaseTest {

    static String getId = "200";

    public static Response deleteAuthorById() {
        return HTTPMethods.deleteRequest("/api/v1/Authors/" + getId, header(), StatusCodes.SUCCESS);
    }

    @BeforeClass(alwaysRun = true)
    public void setup() {
        HTTPMethods.setBaseURI(PropertyReader.propertyReader("config/setup_" + setEnv + ".properties", "baseURI"));
    }

    @Test(description = "Validate the GET request is displaying the exchange rate of given currency")
    public void exchangeRateCurrencyCheck() throws IOException {
        ExtentReportUtil.extentLog = ExtentReportUtil.extentReport.startTest("BookingAPI_" + this.getClass().getSimpleName(), "Validate the GET request is displaying the exchange rate of given currency");
        // Send request
        Response res = deleteAuthorById();

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
    }
}
