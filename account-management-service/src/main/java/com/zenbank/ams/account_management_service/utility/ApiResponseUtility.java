package com.zenbank.ams.account_management_service.utility;

import java.util.LinkedHashMap;
import java.util.Map;

public class ApiResponseUtility {

	public static Map<String, Object> success(String message) {
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("status", "SUCCESS");
		response.put("message", message);
		return response;
	}

	public static Map<String, Object> accountCreated(Object data) {
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("status", "SUCCESS");
		response.put("message", "Account created successfully.");
		response.put("data", data);
		return response;
	}

	public static Map<String, Object> getAccountsByCustomerId(String customerId, Object accounts) {
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("customerId", customerId);
		response.put("accounts", accounts);
		return response;
	}
}