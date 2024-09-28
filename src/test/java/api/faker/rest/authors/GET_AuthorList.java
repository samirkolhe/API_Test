package api.faker.rest.authors;


import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.relevantcodes.extentreports.LogStatus;
import core.BaseTest;
import core.StatusCodes;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.*;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;


public class GET_AuthorList extends BaseTest {

    public static Response getAuthorList() {
        return HTTPMethods.getRequest("/api/v1/Authors", header(), StatusCodes.SUCCESS);
    }

    @BeforeClass(alwaysRun = true)
    public void setup() {
        HTTPMethods.setBaseURI(PropertyReader.propertyReader("config/setup_" + setEnv + ".properties", "baseURI"));
    }

    @Test(description = "Validate the GET request is displaying the exchange rate of given currency")
    public void exchangeRateCurrencyCheck() throws IOException {
        ExtentReportUtil.extentLog = ExtentReportUtil.extentReport.startTest("BookingAPI_" + this.getClass().getSimpleName(), "Validate the GET request is displaying the exchange rate of given currency");
        // Send request
        Response res = getAuthorList();

        // Get response details
        int statusCode = res.getStatusCode();
        String responseBody = res.getBody().asString();

        // Print response to console
        logger.info("Response Status Code: " + statusCode);

        // Validate the status code and log the result
        HTTPMethods.verifyStatusCode(statusCode, StatusCodes.SUCCESS);

        // Assert content type of response
        AssertionUtil.assertEquals(res.contentType(), "application/json; charset=utf-8; v=1.0", "Assertion contentType passed");

        JsonArray jsonArray = JsonArrayReader.getJsonArray(responseBody);
        Map<String, String> map = new LinkedHashMap<>();
        for (JsonElement element : jsonArray) {
            JsonObject jsonObject = element.getAsJsonObject();
            // Extract and validate fields
            String id = jsonObject.get("id").getAsString();
            String firstName = jsonObject.get("firstName").getAsString();
            map.put(id, firstName);
            ExtentReportUtil.extentReport.endTest(ExtentReportUtil.extentLog);
        }
        map.forEach((key, value) -> {
            ExtentReportUtil.extentLog.log(LogStatus.PASS, "Author id: " + key + "\n Author Name: " + value);
        });

    }
}
