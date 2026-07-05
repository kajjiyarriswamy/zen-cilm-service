package com.zenbank.cilm.controller;


import com.zenbank.cilm.dto.*;
import com.zenbank.cilm.entity.CustomerPreference;
import com.zenbank.cilm.service.CustomerContactService;
import com.zenbank.cilm.service.CustomerService;
import com.zenbank.cilm.utility.ApiResponseUtil;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/customers")
public class CustomerController {


    private final CustomerService customerService;

    private final CustomerContactService customerContactService;


    public CustomerController(
            CustomerService customerService,
            CustomerContactService customerContactService) {

        this.customerService = customerService;
        this.customerContactService = customerContactService;
    }


    // CREATE CUSTOMER

    @PostMapping
    public ResponseEntity<Map<String,Object>> createCustomer(
            @Valid @RequestBody CustomerRequestDto requestDto) {


        CustomerResponseDto response =
                customerService.createCustomer(requestDto);


        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponseUtil.created(response));
    }



    // GET ALL CUSTOMERS

    @GetMapping
    public ResponseEntity<Map<String,Object>> getAllCustomers(){


        List<CustomerResponseDto> customers =
                customerService.getAllCustomers();


        return ResponseEntity.ok(
                ApiResponseUtil.success(customers));
    }



    // GET CUSTOMER BY ID

    @GetMapping("/{id}")
    public ResponseEntity<Map<String,Object>> getCustomerById(
            @PathVariable Long id){


        return customerService.getCustomerById(id)

                .map(customer ->
                        ResponseEntity.ok(
                                ApiResponseUtil.success(customer)))

                .orElseGet(() ->
                        ResponseEntity
                                .status(HttpStatus.NOT_FOUND)
                                .body(
                                   ApiResponseUtil.error(
                                   "Customer not found")));
    }



    // UPDATE CUSTOMER STATUS

    @PutMapping("/{customerId}/status")
    public ResponseEntity<String> updateCustomerStatus(
            @PathVariable Long customerId,
            @RequestBody CustomerStatusUpdateRequest request){


        customerService.updateCustomerStatus(
                customerId,
                request.getStatus());


        return ResponseEntity.ok(
                "Customer status updated successfully");
    }





    // SEARCH CUSTOMER


    @GetMapping("/search")
    public ResponseEntity<Map<String,Object>> searchCustomer(

            @RequestParam(required=false) Long customerId,

            @RequestParam(required=false) String cif,

            @RequestParam(required=false) String phoneNumber,

            @RequestParam(required=false) String pan,

            @RequestParam(required=false) String aadhaar,

            @RequestParam(required=false) String status,

            @RequestParam(defaultValue="0") int page,

            @RequestParam(defaultValue="10") int size){



        return ResponseEntity.ok(

                ApiResponseUtil.success(

                customerService.searchCustomer(
                        customerId,
                        cif,
                        phoneNumber,
                        pan,
                        aadhaar,
                        status,
                        page,
                        size)));

    }





    // ADD CUSTOMER ADDRESS


    @PostMapping("/{customerId}/addresses")
    public ResponseEntity<AddressResponseDto> addAddress(

            @Valid
            @PathVariable Long customerId,

            @RequestBody AddressRequestDto request){


        AddressResponseDto response =
                customerService.addAddress(
                        customerId,
                        request);


        return new ResponseEntity<>(
                response,
                HttpStatus.CREATED);
    }




    // GET ADDRESSES


    @GetMapping("/{customerId}/addresses")
    public ResponseEntity<Map<String,Object>>
    getCustomerAddresses(

            @PathVariable Long customerId){



        Map<String,Object> response =
                customerService
                        .getCustomerAddresses(customerId);


        if("FAILED".equals(
                response.get("status"))){

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(response);
        }


        return ResponseEntity.ok(response);
    }





    // DELETE ADDRESS


    @DeleteMapping("/{customerId}/addresses/{addressId}")
    public ResponseEntity<Map<String,Object>>
    deleteCustomerAddress(

            @PathVariable Long customerId,

            @PathVariable Long addressId){


        Map<String,Object> response =
                customerService
                        .deleteCustomerAddress(
                                customerId,
                                addressId);


        if("FAILED".equals(response.get("status"))){

            return ResponseEntity
                    .badRequest()
                    .body(response);
        }


        return ResponseEntity.ok(response);

    }







    // UPDATE NOMINEE


    @PutMapping("/{customerId}/nominees/{nomineeId}")
    public ResponseEntity<Map<String,Object>>
    updateNominee(

            @PathVariable Long customerId,

            @PathVariable Long nomineeId,

            @RequestBody CustomerRequestDto dto){



        try {


            customerService.updateNominee(
                    customerId,
                    nomineeId,
                    dto);



            Map<String,Object> response =
                    new LinkedHashMap<>();


            response.put(
                    "status",
                    "SUCCESS");


            response.put(
                    "message",
                    "Nominee updated Successfully.");


            return ResponseEntity.ok(response);



        }catch(RuntimeException e){


            Map<String,Object> response =
                    new LinkedHashMap<>();


            response.put(
                    "status",
                    "FAILED");


            response.put(
                    "errorCode",
                    "NOM_002");


            response.put(
                    "message",
                    e.getMessage());



            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(response);

        }

    }







    // CUSTOMER PREFERENCES


    @GetMapping("/{customerId}/preferences")
    public ResponseEntity<Map<String,Object>>
    getCustomerPreference(

            @PathVariable Long customerId){


        CustomerPreferenceResponseDto response =
                customerService
                        .getCustomerPreference(customerId);



        return ResponseEntity.ok(

                ApiResponseUtil.success(response));

    }





    @PostMapping("/{customerId}/preferences")
    public ResponseEntity<Map<String,Object>>
    createPreference(

            @PathVariable Long customerId,

            @RequestBody CustomerPreference preference){



        CustomerPreference saved =
                customerService
                .createPreference(
                        customerId,
                        preference);



        return ResponseEntity.ok(

                ApiResponseUtil.success(saved));

    }







    // UPDATE NOTIFICATION PREFERENCES


    @PutMapping("/{customerId}/preferences/notifications")
    public ResponseEntity<Map<String,Object>>
    updateNotificationPreferences(

            @PathVariable Long customerId,

            @RequestBody CustomerPreference preference){



        customerService.updateNotificationPreferences(
                customerId,
                preference);



        return ResponseEntity.ok(

                ApiResponseUtil.success(

                "Notification preferences updated successfully"));

    }






    // UPDATE CUSTOMER


    @PutMapping("/{customerId}")
    public ResponseEntity<Map<String,Object>>
    updateCustomer(

            @PathVariable Long customerId,

            @RequestBody CustomerRequestDto requestDto){



        customerService.updateCustomer(
                customerId,
                requestDto);



        return ResponseEntity.ok(

                ApiResponseUtil.success(
                "Customer Updated Successfully"));

    }







    // UPDATE PREFERRED CONTACT MODE
    // NEW REQUIREMENT


    @PutMapping("/{customerId}/contacts/preferred-mode")
    public ResponseEntity<CommonResponseDto>
    updatePreferredContactMode(

            @PathVariable Long customerId,

            @RequestBody PreferredContactModeRequestDto request){



        CommonResponseDto response =
                customerContactService
                        .updatePreferredMode(
                                customerId,
                                request);



        if("FAILED".equals(
                response.getStatus())){


            return ResponseEntity
                    .badRequest()
                    .body(response);

        }



        return ResponseEntity.ok(response);

    }


}