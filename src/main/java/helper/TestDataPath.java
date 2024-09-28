package helper;

import static helper.BaseTestHelper.getEnv;

public class TestDataPath {
    public static String bookingDataPath = "resources/TestData/bookings/" + getEnv("env") + "_testData.properties";
    public static String paymentDataPath = "resources/TestData/payments/" + getEnv("env") + "_testData.properties";
    public static String userManagementDataPath = "resources/TestData/userManagement/" + getEnv("env") + "_testData.properties";
    public static String cmsDataPath = "resources/TestData/cms/" + getEnv("env") + "_testData.properties";
    public static String notificationDataPath = "resources/TestData/notification/" + getEnv("env") + "_testData.properties";
    public static String searchDataPath = "resources/TestData/search/" + getEnv("env") + "_testData.properties";
    public static String mediaServiceDataPath = "resources/TestData/mediaService/" + getEnv("env") + "_testData.properties";

}
