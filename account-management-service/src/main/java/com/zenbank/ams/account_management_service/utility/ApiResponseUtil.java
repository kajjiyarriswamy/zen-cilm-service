package com.zenbank.ams.account_management_service.utility;

import java.util.LinkedHashMap;
import java.util.Map;

public final class ApiResponseUtil {	//final because these are constants through the program.

	public static Map<String,Object> created(Object data){
		Map<String,Object> response = new LinkedHashMap<>();
		response.put("status","SUCCESS");
		response.put("message","Account transaction limits configured successfully.");
		response.put("data",data);
		return response;
		
	}
	
}
