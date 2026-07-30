package com.zenbank.ams.account_management_service.utility;

import java.util.LinkedHashMap;
import java.util.Map;

public class ApiResponseUtility {

		Map<String, Object> response = new LinkedHashMap<>();
		response.put("status", "SUCCESS");
		return response;
	}

	public static Map<String, Object> accountCreated(Object data) {
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("status", "SUCCESS");
		response.put("message", "Account created successfully.");
		response.put("data", data);
		return response;
	}

		Map<String, Object> response = new LinkedHashMap<>();
		return response;
	}
}