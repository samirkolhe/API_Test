package utils;

import com.relevantcodes.extentreports.LogStatus;
import core.BaseTest;
import core.StatusCodes;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import java.io.File;
import java.util.Map;

public class HTTPMethods extends BaseTest {

    public static void setBaseURI(String baseURI) {
        RestAssured.baseURI = baseURI;
    }

    public static Response getRequest(String endpoint, Map<String, String> headers, int expectedStatusCode) {
        RequestSpecification request = given().headers(headers);
        ExtentReportUtil.extentLog.log(LogStatus.INFO, "Request URL: " + RestAssured.baseURI + endpoint);
        return request.when().get(endpoint).then().statusCode(expectedStatusCode).extract().response();
    }

    public static Response getRequest(String endpoint, Map<String, String> headers, Map<String, String> queryParams, int expectedStatusCode) {
        RequestSpecification request = given().headers(headers).queryParams(queryParams);
        ExtentReportUtil.extentLog.log(LogStatus.INFO, "Request URL: " + RestAssured.baseURI + endpoint + queryParams);
        return request.when().get(endpoint).then().statusCode(expectedStatusCode).extract().response();
    }

    public static Response postRequest(String endpoint, Map<String, String> headers, Map<String, Object> body, int expectedStatusCode) {
        RequestSpecification request = given().headers(headers).contentType(ContentType.JSON).body(body);
        ExtentReportUtil.extentLog.log(LogStatus.INFO, "Request URL: " + RestAssured.baseURI + endpoint);
        return request.when().post(endpoint).then().statusCode(expectedStatusCode).extract().response();
    }

    public static Response postRequest(String endpoint, Map<String, String> headers, String body, int expectedStatusCode) {
        RequestSpecification request = given().headers(headers).contentType(ContentType.JSON).body(body);
        ExtentReportUtil.extentLog.log(LogStatus.INFO, "Request URL: " + RestAssured.baseURI + endpoint);
        return request.when().post(endpoint).then().statusCode(expectedStatusCode).extract().response();
    }

    public static Response postRequest(String endpoint, Map<String, String> headers, File file, int expectedStatusCode) {
        RequestSpecification request = given().headers(headers).contentType(ContentType.MULTIPART).multiPart(file);
        ExtentReportUtil.extentLog.log(LogStatus.INFO, "Request URL: " + RestAssured.baseURI + endpoint);
        return request.when().post(endpoint).then().statusCode(expectedStatusCode).extract().response();
    }

    public static Response postRequest(String endpoint, Map<String, String> headers, Map<String, String> queryParams, Map<String, Object> body, int expectedStatusCode) {
        RequestSpecification request = given().headers(headers).queryParams(queryParams).contentType(ContentType.JSON).body(body);
        ExtentReportUtil.extentLog.log(LogStatus.INFO, "Request URL: " + RestAssured.baseURI + endpoint);
        return request.when().post(endpoint).then().statusCode(expectedStatusCode).extract().response();
    }

    public static Response putRequest(String endpoint, Map<String, String> headers, String body, int expectedStatusCode) {
        RequestSpecification request = given().headers(headers).contentType(ContentType.JSON).body(body);
        ExtentReportUtil.extentLog.log(LogStatus.INFO, "Request URL: " + RestAssured.baseURI + endpoint);
        return request.when().put(endpoint).then().statusCode(expectedStatusCode).extract().response();
    }

    public static Response putRequest(String endpoint, Map<String, String> headers, Map<String, Object> body, int expectedStatusCode) {
        RequestSpecification request = given().headers(headers).contentType(ContentType.JSON).body(body);
        ExtentReportUtil.extentLog.log(LogStatus.INFO, "Request URL: " + RestAssured.baseURI + endpoint);
        return request.when().put(endpoint).then().statusCode(expectedStatusCode).extract().response();
    }

    public static Response putRequest(String endpoint, Map<String, String> headers, File file, int expectedStatusCode) {
        RequestSpecification request = given().headers(headers).contentType(ContentType.MULTIPART).multiPart(file);
        ExtentReportUtil.extentLog.log(LogStatus.INFO, "Request URL: " + RestAssured.baseURI + endpoint);
        return request.when().put(endpoint).then().statusCode(expectedStatusCode).extract().response();
    }

    public static Response putRequest(String endpoint, Map<String, String> headers, Map<String, String> queryParams, String body, int expectedStatusCode) {
        RequestSpecification request = given().headers(headers).queryParams(queryParams).contentType(ContentType.JSON).body(body);
        ExtentReportUtil.extentLog.log(LogStatus.INFO, "Request URL: " + RestAssured.baseURI + endpoint);
        return request.when().put(endpoint).then().statusCode(expectedStatusCode).extract().response();
    }

    public static Response putRequest(String endpoint, Map<String, String> headers, int expectedStatusCode) {
        RequestSpecification request = given().headers(headers).contentType(ContentType.JSON);
        ExtentReportUtil.extentLog.log(LogStatus.INFO, "Request URL: " + RestAssured.baseURI + endpoint);
        return request.when().put(endpoint).then().statusCode(expectedStatusCode).extract().response();
    }

    public static Response deleteRequest(String endpoint, Map<String, String> headers, int expectedStatusCode) {
        RequestSpecification request = given().headers(headers);
        ExtentReportUtil.extentLog.log(LogStatus.INFO, "Request URL: " + RestAssured.baseURI + endpoint);
        return request.when().delete(endpoint).then().statusCode(expectedStatusCode).extract().response();
    }

    public static void verifyStatusCode(int expectedStatusCode, int actualStatusCode) {
        if (expectedStatusCode == actualStatusCode) {
            switch (expectedStatusCode) {
                case StatusCodes.SUCCESS:
                    ExtentReportUtil.extentLog.log(LogStatus.PASS, "Status code is " + StatusCodes.SUCCESS + " as expected");
                    break;
                case StatusCodes.CREATED:
                    Assert.assertEquals(StatusCodes.CREATED, expectedStatusCode);
                    ExtentReportUtil.extentLog.log(LogStatus.PASS, "Status code is " + StatusCodes.CREATED + " as expected");
                    break;
                case StatusCodes.NO_CONTENT:
                    Assert.assertEquals(StatusCodes.NO_CONTENT, expectedStatusCode);
                    ExtentReportUtil.extentLog.log(LogStatus.PASS, "Status code is " + StatusCodes.NO_CONTENT + " as expected");
                    break;
                case StatusCodes.BAD_REQUEST:
                    Assert.assertEquals(StatusCodes.BAD_REQUEST, expectedStatusCode);
                    ExtentReportUtil.extentLog.log(LogStatus.PASS, "Status code is " + StatusCodes.BAD_REQUEST + " as expected");
                    break;
                case StatusCodes.UNAUTHORIZED:
                    Assert.assertEquals(StatusCodes.UNAUTHORIZED, expectedStatusCode);
                    ExtentReportUtil.extentLog.log(LogStatus.PASS, "Status code is " + StatusCodes.UNAUTHORIZED + " as expected");
                    break;
                case StatusCodes.FORBIDDEN:
                    Assert.assertEquals(StatusCodes.FORBIDDEN, expectedStatusCode);
                    ExtentReportUtil.extentLog.log(LogStatus.PASS, "Status code is " + StatusCodes.FORBIDDEN + " as expected");
                    break;
                case StatusCodes.NOT_FOUND:
                    Assert.assertEquals(StatusCodes.NOT_FOUND, expectedStatusCode);
                    ExtentReportUtil.extentLog.log(LogStatus.PASS, "Status code is " + StatusCodes.NOT_FOUND + " as expected");
                    break;
                case StatusCodes.INTERNAL_SERVER_ERROR:
                    Assert.assertEquals(StatusCodes.INTERNAL_SERVER_ERROR, expectedStatusCode);
                    ExtentReportUtil.extentLog.log(LogStatus.PASS, "Status code is " + StatusCodes.INTERNAL_SERVER_ERROR + " as expected");
                    break;
                default:
                    ExtentReportUtil.extentLog.log(LogStatus.PASS, "Status code is not as expected, it is " + expectedStatusCode);
                    break;
            }
        } else {
            ExtentReportUtil.extentLog.log(LogStatus.FAIL, "Status code is not as expected, it is " + expectedStatusCode);
        }
    }

    private static RequestSpecification given() {
        return RestAssured.given();
    }
}
