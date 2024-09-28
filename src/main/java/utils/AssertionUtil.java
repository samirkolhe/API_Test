package utils;

import com.relevantcodes.extentreports.LogStatus;
import core.BaseTest;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsNot.not;

public class AssertionUtil {

    static BaseTest baseTest = new BaseTest();

    // Method to assert equality and log the result
    public static void assertEquals(Object actual, Object expected, String message) {
        try {
            assertThat(actual, equalTo(expected));
            ExtentReportUtil.extentLog.log(LogStatus.PASS, message + " Expected : '" + expected + "' equals Actual : '" + actual + "'");
            baseTest.logger.info(message + ": " + actual + " equals " + expected);
        } catch (AssertionError e) {
            ExtentReportUtil.extentLog.log(LogStatus.FAIL, message + " - Assertion Failed: " + e.getMessage());
        }
    }

    // Method to assert inequality and log the result
    public static void assertNotEquals(Object actual, Object expected, String message) {
        try {
            assertThat(actual, not(equalTo(expected)));
            ExtentReportUtil.extentLog.log(LogStatus.PASS, message + " Expected : '" + expected + "' is not equal to Actual : '" + actual + "'");
            baseTest.logger.info(actual + " does not equal " + expected);
        } catch (AssertionError e) {
            ExtentReportUtil.extentLog.log(LogStatus.FAIL, "Assertion Failed: " + e.getMessage());
        }
    }

    // Method to assert null value and log the result
    public static void assertNull(Object actual, String message) {
        try {
            assertThat(actual, nullValue());
            ExtentReportUtil.extentLog.log(LogStatus.PASS, actual + " is null");
            baseTest.logger.info(actual + " does not equal ");
        } catch (AssertionError e) {
            ExtentReportUtil.extentLog.log(LogStatus.FAIL, "Assertion Failed: " + e.getMessage());
        }
    }

    // Method to assert not null value and log the result
    public static void assertNotNull(Object actual, String message) {
        try {
            assertThat(actual, notNullValue());
            ExtentReportUtil.extentLog.log(LogStatus.PASS, message + " : '" + actual + "' is not null");
            baseTest.logger.info(actual + " is not null");
        } catch (AssertionError e) {
            ExtentReportUtil.extentLog.log(LogStatus.FAIL, "Assertion Failed: " + e.getMessage());
        }
    }

    // Method to assert true and log the result
    public static void assertTrue(boolean condition, String message) {
        try {
            assertThat(condition, is(true));
            ExtentReportUtil.extentLog.log(LogStatus.PASS, message + ": Condition is true");
            baseTest.logger.info(message + ": " + condition + " is true");
        } catch (AssertionError e) {
            ExtentReportUtil.extentLog.log(LogStatus.FAIL, "Assertion Failed: " + e.getMessage());
        }
    }

    // Method to assert false and log the result
    public static void assertFalse(boolean condition, String message) {
        try {
            assertThat(condition, is(false));
            ExtentReportUtil.extentLog.log(LogStatus.PASS, message + ": Condition is false");
            baseTest.logger.info(message + ": " + condition + " is false");
        } catch (AssertionError e) {
            ExtentReportUtil.extentLog.log(LogStatus.FAIL, "Assertion Failed: " + e.getMessage());
        }
    }
    // Method to assert if expected data contains required value
    public static void assertContainsString(String actual, String expectedSubstring, String message) {
        try {
            assertThat(actual, containsString(expectedSubstring));
            ExtentReportUtil.extentLog.log(LogStatus.PASS, message + "  contains '" + expectedSubstring + "'");
            baseTest.logger.info(message + " contains: " + expectedSubstring);
        } catch (AssertionError e) {
            ExtentReportUtil.extentLog.log(LogStatus.FAIL, message + " - Assertion Failed: " + e.getMessage());
        }
    }

    // Method to check if an array is not empty
    public static void assertArrayNotEmpty(Object[] array, String message) {
        try {
            assertThat(array, not(emptyArray()));
            ExtentReportUtil.extentLog.log(LogStatus.PASS, message + " : Array is not empty");
            baseTest.logger.info("Array is not empty");
        } catch (AssertionError e) {
            ExtentReportUtil.extentLog.log(LogStatus.FAIL, message+" Assertion Failed: " + e.getMessage());
        }
    }

    // Method to assert list contains and log the result
    public static void assertListContains(Object list, String expected, String message) {
        try {
            if (list.toString().contains(expected)) {
                ExtentReportUtil.extentLog.log(LogStatus.PASS, message + ": List contains '" + expected + "'");
                baseTest.logger.info(message + ": List contains '" + expected + "'");
            } else {
                throw new AssertionError("List does not contain expected string: " + expected);
            }
        } catch (AssertionError e) {
            ExtentReportUtil.extentLog.log(LogStatus.FAIL, message + " - Assertion Failed: " + e.getMessage());
            baseTest.logger.error(message + " - Assertion Failed: " + e.getMessage());
        }
    }
    public static void assertListContain(Object list, String expected, String message) {
        try {
            if (list.toString().contains(expected)) {
                ExtentReportUtil.extentLog.log(LogStatus.PASS, message + ": List contains '" + expected + "'");
                baseTest.logger.info(message + ": List contains '" + expected + "'");
            } else {
                throw new AssertionError("List does not contain expected string: " + expected);
            }
        } catch (AssertionError e) {
            ExtentReportUtil.extentLog.log(LogStatus.FAIL, message + " - Assertion Failed: " + e.getMessage());
            baseTest.logger.error(message + " - Assertion Failed: " + e.getMessage());
        }
    }
    // Method to check if list is not empty
    public static void assertListNotEmpty(List<?> list, String message) {
        try {
            assertThat(list, not(empty()));
            ExtentReportUtil.extentLog.log(LogStatus.PASS, message + " : '" + list + "' List is not empty");
            baseTest.logger.info("List is not empty");
        } catch (AssertionError e) {
            ExtentReportUtil.extentLog.log(LogStatus.FAIL, "Assertion Failed: " +message+" "+ e.getMessage());
        }
    }
}
