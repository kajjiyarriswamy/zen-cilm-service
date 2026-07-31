package com.zenbank.deposit_service.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.zenbank.deposit_service.dto.ChequeDepositDto;
import com.zenbank.deposit_service.dto.ChequeDepositSearchResponse;
import com.zenbank.deposit_service.entity.ChequeDeposit;
import com.zenbank.deposit_service.exception.InvalidDateRangeException;
import com.zenbank.deposit_service.exception.InvalidSearchParameterException;
import com.zenbank.deposit_service.repository.ChequeDepositRepository;

@Service
public class ChequeDepositServiceImpl implements ChequeDepositService {

	@Autowired
	private ChequeDepositRepository chequeDepositRepository;

	@Override
	public ChequeDepositSearchResponse searchChequeDeposit(Long chequeDepositId, String chequeNumber, Long customerId,
			Long account, String issuingBank, String ifscCode, String chequeStatus, String transactionaStatus,
			LocalDate fromDate, LocalDate toDate, Integer page, Integer size, String sortBy, String sortDirection) {
		
		if (fromDate != null && toDate != null && fromDate.isAfter(toDate)) {
		    throw new InvalidDateRangeException();
		}
		
		if (chequeStatus != null &&
		        !(chequeStatus.equalsIgnoreCase("RECIEVED")
		        || chequeStatus.equalsIgnoreCase("VERIFIED")
		        || chequeStatus.equalsIgnoreCase("CLEARED")
			    || chequeStatus.equalsIgnoreCase("CLEARED"))){
			
		    throw new InvalidSearchParameterException();
		}

		if (transactionaStatus != null &&
		        !(transactionaStatus.equalsIgnoreCase("SUCCESS")
		        || transactionaStatus.equalsIgnoreCase("PENDING")
		        || transactionaStatus.equalsIgnoreCase("FAILED")
			    || transactionaStatus.equalsIgnoreCase("PENDING_CLEARANCE"))) {

		    throw new InvalidSearchParameterException();
		}

		Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortBy));

		Page<ChequeDeposit> cheque = null;
		try {
			cheque = chequeDepositRepository.searchChequeDeposit(chequeDepositId, chequeNumber, customerId, account,
					issuingBank, ifscCode, chequeStatus, transactionaStatus, fromDate, toDate, pageable);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		List<ChequeDepositDto> records = new ArrayList<>();
		if ( cheque!=null && cheque.getContent() != null) {
			for (ChequeDeposit deposit : cheque.getContent()) {

				ChequeDepositDto dto = new ChequeDepositDto();

				BeanUtils.copyProperties(deposit, dto);

				records.add(dto);

			}
		}

		ChequeDepositSearchResponse response = new ChequeDepositSearchResponse();

		response.setTotalRecords(cheque.getTotalElements());
		response.setPage(cheque.getNumber());
		response.setSize(cheque.getSize());
		response.setChequeDeposits(records);

		return response;

	}

}
