package com.zenbank.deposit_service;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zenbank.deposit_service.dto.CreateDepositRequest;
import com.zenbank.deposit_service.repository.DepositAuditRepository;
import com.zenbank.deposit_service.repository.DepositReceiptRepository;
import com.zenbank.deposit_service.repository.DepositTransactionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class DepositControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private DepositTransactionRepository depositTransactionRepository;

    @MockBean
    private DepositReceiptRepository depositReceiptRepository;

    @MockBean
    private DepositAuditRepository depositAuditRepository;

    @Test
    public void testDeposit_Success() throws Exception {
        CreateDepositRequest request = new CreateDepositRequest(
                "CUS100001", 200001L, "CASH", "BRANCH", 25000.00, "INR", "HYD001", "Hyderabad Main Branch", "Cash deposited at branch"
        );

        mockMvc.perform(post("/api/v1/deposits")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.status").value("SUCCESS"))
                .andExpect(jsonPath("$.data.customerId").value("CUS100001"))
                .andExpect(jsonPath("$.data.availableBalance").value(125000.00))
                .andExpect(jsonPath("$.data.transactionStatus").value("SUCCESS"));
    }

    @Test
    public void testDeposit_InvalidAmount() throws Exception {
        CreateDepositRequest request = new CreateDepositRequest(
                "CUS100001", 200001L, "CASH", "BRANCH", -100.00, "INR", "HYD001", "Hyderabad Main Branch", "Cash deposited"
        );

        mockMvc.perform(post("/api/v1/deposits")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.status").value("FAILED"))
                .andExpect(jsonPath("$.errorCode").value("DEP_003"))
                .andExpect(jsonPath("$.message").value("Deposit amount should be greater than zero."));
    }

    @Test
    public void testDeposit_AccountNotFound() throws Exception {
        CreateDepositRequest request = new CreateDepositRequest(
                "CUS100001", null, "CASH", "BRANCH", 25000.00, "INR", "HYD001", "Hyderabad Main Branch", "Cash deposited"
        );

        mockMvc.perform(post("/api/v1/deposits")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.status").value("FAILED"))
                .andExpect(jsonPath("$.errorCode").value("DEP_001"))
                .andExpect(jsonPath("$.message").value("Account not found."));
    }
}
