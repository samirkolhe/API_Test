package utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import org.apache.http.ParseException;

import java.io.IOException;

public class JsonArrayReader {
    public static JsonArray getJsonArray(String responseBody) throws IOException, ParseException {
        return JsonParser.parseString(responseBody).getAsJsonArray();
    }
}
