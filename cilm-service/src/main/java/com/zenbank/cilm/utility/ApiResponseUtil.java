package com.zenbank.cilm.utility;

import java.util.LinkedHashMap;
import java.util.Map;

public final class ApiResponseUtil {

    private ApiResponseUtil() {
    }

    public static Map<String, Object> success(Object data) {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("success", "SUCCESS");
        response.put("data", data);
        return response;
    }

    public static Map<String, Object> created(Object data) {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("status", "SUCCESS");
        response.put("message", "Customer created successfully.");
        response.put("data", data);
        return response;
    }

    public static Map<String, Object> error(String message) {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("success", "FAILED");
        response.put("message", message);
        return response;
    }
}
