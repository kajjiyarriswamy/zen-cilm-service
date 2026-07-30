package com.zenbank.ams.account_management_service.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ActivateDormantAccountRequest {

    @NotBlank(message = "Remarks is required")
    private String remarks;

}