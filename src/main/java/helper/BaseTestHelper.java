package helper;

public class BaseTestHelper {

    public static String getEnv(String key) {
        String value = System.getProperty(key);
        return value != null ? value : "uat";
    }
}
