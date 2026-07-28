package com.zenbank.deposit_service.utility;

import java.util.LinkedHashMap;
import java.util.Map;

public class DepositTransactionUtil {
	
	public static Map<String, Object> created(Object data){
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("status", "SUCCESS" );
		response.put("message", "Deposit Transaction recieved successfully");
		response.put("data", data );
		return response;
		
	}

}
