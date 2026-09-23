package com.zenbank.deposit_service.utility;

import java.util.LinkedHashMap;
import java.util.Map;

//for DepositReceipt
public class ApiResponseUtil {
	
	public static Map<String,Object> created(Object data){
		var response=new LinkedHashMap<String,Object>();
		response.put("status", "SUCCESS");
		response.put("message", "Deposit receipt generated successfully.");
		response.put("data", data);
		return response;
		
	}
	
	public static Map<String,Object> success(Object data){
		var response=new LinkedHashMap<String,Object>();
		response.put("status", "SUCCESS");
		response.put("message", "Deposit receipt generated successfully.");
		response.put("data", data);
		return response;

	}
}
