package utils;

import java.util.HashMap;
import java.util.Map;

public class HeaderUtils {

    static Map<String, String> headers = new HashMap<>();

    public static Map<String, String> setEmptyHeaders() {
        headers.clear();
        headers.put("Content-Type", "application/json");
        return headers;
    }

    public static Map<String, String> setHeaderUsers(String token) {
        headers.clear();
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", "Bearer " + token);
        return headers;
    }
}
