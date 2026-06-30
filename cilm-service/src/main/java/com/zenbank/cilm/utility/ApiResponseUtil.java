package com.zenbank.cilm.utility;

import java.util.LinkedHashMap;
import java.util.Map;

public final class ApiResponseUtil {

    private ApiResponseUtil() {
    }

    public static Map<String, Object> success(Object data) {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("success", true);
        response.put("data", data);
        return response;
    }

    public static Map<String, Object> error(String message) {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("success", false);
        response.put("message", message);
        return response;
    }
}
