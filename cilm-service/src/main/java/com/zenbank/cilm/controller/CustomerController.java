package com.zenbank.cilm.controller;


import com.zenbank.cilm.dto.*;

import com.zenbank.cilm.entity.CustomerNominee;
import com.zenbank.cilm.repository.CustomerNomineeRepository;

import com.zenbank.cilm.entity.CustomerPreference;

import com.zenbank.cilm.service.CustomerService;
import com.zenbank.cilm.utility.ApiResponseUtil;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> createCustomer(@Valid @RequestBody CustomerRequestDto requestDto) {
        CustomerResponseDto responseDto = customerService.createCustomer(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponseUtil.created(responseDto));
    }
    

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllCustomers() {
        List<CustomerResponseDto> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(ApiResponseUtil.success(customers));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id)
                .map(customer -> ResponseEntity.ok(ApiResponseUtil.success(customer)))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(ApiResponseUtil.error("Customer not found")));
    }


    @PutMapping("/{customerId}/status")
    public ResponseEntity<String> updateCustomerStatus(
            @PathVariable Long customerId,
            @RequestBody CustomerStatusUpdateRequest request) {

        customerService.updateCustomerStatus(customerId, request.getStatus());
        return ResponseEntity.ok("Customer status updated successfully");
    }
  
    

    @GetMapping("/search")
    public ResponseEntity<Map<String, Object>> searchCustomer(
    		@RequestParam(required = false) Long customerId,
    		@RequestParam(required = false) String cif,
    		@RequestParam(required = false) String phoneNumber,
    		@RequestParam(required = false) String pan,
    		@RequestParam(required = false) String aadhaar,
    		@RequestParam(required = false) String status,
    		@RequestParam(defaultValue = "0") int page,
    		@RequestParam(defaultValue = "10") int size
    		) {
    	
    	return ResponseEntity.ok(ApiResponseUtil.success(customerService.searchCustomer(customerId,
    			cif, phoneNumber,
    			pan, aadhaar, 
    			status, page,
    			size)));
    }

    
    @GetMapping("/{customerId}/addresses")
    public ResponseEntity<Map<String, Object>> getCustomerAddresses(
            @PathVariable Long customerId) {

        Map<String, Object> response =
                customerService.getCustomerAddresses(customerId);

        if ("FAILED".equals(response.get("status"))) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/{customerId}/addresses/{addressId}")
    public ResponseEntity<Map<String,Object>> deleteCustomerAddress(
            @PathVariable Long customerId,
            @PathVariable Long addressId){

        Map<String,Object> response=
                customerService.deleteCustomerAddress(customerId,addressId);

        if("FAILED".equals(response.get("status"))){

            return ResponseEntity.badRequest().body(response);

        }

        return ResponseEntity.ok(response);
    }
    



 
    @PutMapping("/{customerId}/nominess/{nomineeId}")
    public ResponseEntity<Map<String, Object>> updateNominee(
    		@PathVariable Long customerId,
    		@PathVariable Long nomineeId,
    		@RequestBody CustomerRequestDto dto) {
    	
    	try{
    		customerService.updateNominee(customerId, nomineeId, dto);
  
    	
    	Map<String, Object> response = new LinkedHashMap<>();
    	response.put("status", "SUCCESS");
    	response.put("massege", "Nominee updated Successfully.");
    	
    	return ResponseEntity.ok(response);
    	}catch(RuntimeException e) {
    		
    		Map<String, Object> response= new LinkedHashMap<>();
    		response.put("status", "FAILED");
    		response.put("errorCode", "NOM_002");
    		response.put("message", e.getMessage());
    		
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    		
    	}
    }


    @GetMapping("/{customerId}/preferences")
    public ResponseEntity<Map<String, Object>> getCustomerPreference(
            @PathVariable Long customerId) {

        CustomerPreferenceResponseDto response =
                customerService.getCustomerPreference(customerId);

        return ResponseEntity.ok(ApiResponseUtil.success(response));
    }
    
    @PostMapping("/{customerId}/preferences")
    public ResponseEntity<Map<String, Object>> createPreference(
            @PathVariable Long customerId,
            @RequestBody CustomerPreference preference){

        CustomerPreference saved =
                customerService.createPreference(customerId, preference);

        return ResponseEntity.ok(ApiResponseUtil.success(saved));
    }
  
    
/**    @DeleteMapping("/{customerId}/nominee/{nomineeId}")
    public ResponseEntity<Map<String, Object>> deleteNominee(
    		@PathVariable Long customerId,
    		@PathVariable Long nomineeId) { 
    	
    	
    	
    	try {
    		customerService.deleteNominee(customerId, nomineeId);
    		
    		Map<String, Object> response=new LinkedHashMap<>();
    		response.put("status", "SUCCESS");
    		response.put("message", "Nominee deleted Successfully");
    		
    		return ResponseEntity.ok(response);
    			
    	}catch(RuntimeException e) {
    		
    		Map<String, Object> response=new LinkedHashMap<>();
    		response.put("status", "FAILED");
    		response.put("message", e.getMessage());
    		
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    	}
    	
    } 
*/
    
    @PutMapping("/{customerId}")
    public ResponseEntity<Map<String, Object>> updateCustomer(
            @PathVariable Long customerId,
            @RequestBody CustomerRequestDto requestDto) {

        customerService.updateCustomer(customerId, requestDto);

        return ResponseEntity.ok(
                ApiResponseUtil.success("Customer Updated Successfully")
        );
    }


    @PutMapping("/{customerId}/preferences/notifications")
    public ResponseEntity<Map<String, Object>> updateNotificationPreferences(
            @PathVariable Long customerId,
            @RequestBody CustomerPreference preference) {

        customerService.updateNotificationPreferences(customerId, preference);

        return ResponseEntity.ok(
                ApiResponseUtil.success("Notification preferences updated successfully"));
    
    }




	@PostMapping("/{customerId}/addresses")
	public ResponseEntity<AddressResponseDto> addAddress(@Valid  @PathVariable String customerId,
	                                                     @RequestBody AddressRequestDto request) {
		AddressResponseDto response = customerService.addAddress(customerId, request);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	@PutMapping("/{customerId}/nominees/{nomineeId}/verify")
	public ResponseEntity<Map<String, Object>> checkverify(
			@PathVariable Long customerId,
			@PathVariable Long nomineeId,
			@RequestBody CustomerRequestDto dto
			) {
		
		try {
			
			customerService.verifyNominee(customerId, nomineeId, dto);
			
			Map<String, Object> response= new LinkedHashMap<>();
			response.put("status", "SUCCESS");
			response.put("message", "Nominee verified successfully");
			response.put("verificationStatus", "VERIFIED");
			
			return ResponseEntity.ok(response);
			
		}catch(RuntimeException e) {
			
			Map<String, Object> response=new LinkedHashMap<>();
			
			response.put("status", "FAILED");
			response.put("errorCode", "NOM_004");
			response.put("message", e.getMessage());
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}
		@GetMapping("/{customerId}/kyc")
		public ResponseEntity<Map<String, Object>> getCustomerKyc(
		        @PathVariable Long customerId) {

		    CustomerKycResponseDto response =
		            customerService.getCustomerKyc(customerId);

		    return ResponseEntity.ok(ApiResponseUtil.success(response));
	}
		
		@PostMapping("/{customerId}/kyc")
		public ResponseEntity<Map<String, Object>> addCustomerKyc(
		        @PathVariable Long customerId,
		        @RequestBody CustomerKycRequestDto requestDto) {

		    customerService.addCustomerKyc(customerId, requestDto);

		    return ResponseEntity.ok(
		            ApiResponseUtil.success("Customer KYC added successfully")
		    );
		}
	
}


