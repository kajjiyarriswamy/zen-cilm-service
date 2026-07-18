package com.zenbank.ams.account_management_service.utility;

import java.util.LinkedHashMap;
import java.util.Map;

public class ApiResponseUtility {

	public ApiResponseUtility() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static Map<String, Object> success(Map<String, Object> data) {

		Map<String, Object> response = new LinkedHashMap<>();

		response.put("status", "SUCCESS");
		response.putAll(data);

		return response;
	}

	public static Map<String, Object> accountCreated(Object data) {
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("status", "SUCCESS");
		response.put("message", "Account created successfully.");
		response.put("data", data);
		return response;
	}
	
	public static Map<String,Object> getAccountsByCustomerId(String custId,Object data){
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("customerId ",custId );
		response.put("accounts ",data);
		
		return response;
	}

}
