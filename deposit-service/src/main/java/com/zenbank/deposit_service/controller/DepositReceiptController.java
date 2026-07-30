package com.zenbank.deposit_service.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.zenbank.deposit_service.dto.DepositReceiptResponseDto;
import com.zenbank.deposit_service.service.IDepositReceiptService;

@RestController
@RequestMapping("/api/v1/deposits")
public class DepositReceiptController {

    @Autowired
    private IDepositReceiptService depositReceiptService;

    // JIRA-425
    @PostMapping("/{depositId}/receipt")
    public ResponseEntity<DepositReceiptResponseDto> createReceipt(
            @PathVariable Long depositId) throws Exception {

        DepositReceiptResponseDto response =
                depositReceiptService.createDepositReceipt(depositId);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // JIRA-426
    @GetMapping("/{depositId}/receipt/download")
    public ResponseEntity<byte[]> downloadReceipt(
            @PathVariable Long depositId) throws IOException {

        byte[] pdf = depositReceiptService.downloadReceipt(depositId);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=DepositReceipt.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf);
    }
}