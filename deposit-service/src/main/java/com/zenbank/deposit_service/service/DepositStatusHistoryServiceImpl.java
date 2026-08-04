package com.zenbank.deposit_service.service;



import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zenbank.deposit_service.dto.DepositStatusHistoryGetApiResponse;
import com.zenbank.deposit_service.dto.DepositStatusHistoryRequest;
import com.zenbank.deposit_service.dto.DepositStatusHistoryResponse;
import com.zenbank.deposit_service.entity.DepositStatusHistory;
import com.zenbank.deposit_service.entity.DepositTransaction;
import com.zenbank.deposit_service.repository.DepositStatusHistoryRepository;
import com.zenbank.deposit_service.repository.DepositTransactionRepository;
import com.zenbank.deposit_service.service.DepositStatusHistoryService;

@Service
public class DepositStatusHistoryServiceImpl implements DepositStatusHistoryService {

    @Autowired
    private DepositStatusHistoryRepository depositStatusHistoryRepository;

    @Autowired
    private DepositTransactionRepository depositTransactionRepository;

    @Override
    public DepositStatusHistoryResponse createStatusHistory(DepositStatusHistoryRequest request) {

        DepositTransaction transaction = depositTransactionRepository
                .findById(request.getDepositId())
                .orElseThrow(() -> new RuntimeException("Deposit Transaction not found"));

        DepositStatusHistory history = new DepositStatusHistory();
        history.setDepositTransaction(transaction);
        history.setPreviousStatus(request.getPreviousStatus());
        history.setCurrentStatus(request.getCurrentStatus());
        history.setChangedBy(request.getChangedBy());
        history.setChangedDate(LocalDateTime.now());
        history.setReason(request.getReason());
        history.setRemarks(request.getRemarks());
        history.setCreatedBy(request.getChangedBy());
        history.setCreatedDate(LocalDateTime.now());

        DepositStatusHistory savedHistory = depositStatusHistoryRepository.save(history);

        DepositStatusHistoryResponse response = new DepositStatusHistoryResponse();
        response.setOldStatus(savedHistory.getPreviousStatus());
        response.setNewStatus(savedHistory.getCurrentStatus());
        response.setChangedBy(savedHistory.getChangedBy());
        response.setChangedDate(savedHistory.getChangedDate());

        return response;
    }

	@Override
	public DepositStatusHistoryGetApiResponse getStatusHistoryByDepositId(Long depositId) {
		// TODO Auto-generated method stub
        List<DepositStatusHistory> historyList =
                depositStatusHistoryRepository.findByDepositTransactionDepositId(depositId);

        DepositStatusHistoryGetApiResponse response = new DepositStatusHistoryGetApiResponse();

        if (historyList.isEmpty()) {
            response.setStatus("FAILED");
            response.setMessage("No status history available.");
            response.setData(null); // or Collections.emptyList() if preferred
            return response;
        }

        List<DepositStatusHistoryResponse> data = historyList.stream().map(history -> {
            DepositStatusHistoryResponse dto = new DepositStatusHistoryResponse();
            dto.setOldStatus(history.getPreviousStatus());
            dto.setNewStatus(history.getCurrentStatus());
            dto.setChangedBy(history.getChangedBy());
            dto.setChangedDate(history.getChangedDate());
            return dto;
        }).toList();

        response.setStatus("SUCCESS");
        response.setMessage("Status history fetched successfully.");
        response.setData(data);

        return response;
	}
    
}