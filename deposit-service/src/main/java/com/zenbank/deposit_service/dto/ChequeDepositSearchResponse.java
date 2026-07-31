package com.zenbank.deposit_service.dto;

import java.util.List;

public class ChequeDepositSearchResponse {
	
	private Long totalRecords;
	private Integer page;
	private Integer size;
	private List<ChequeDepositDto> chequeDeposits;
	
	public ChequeDepositSearchResponse() {
		
		super();
		// TODO Auto-generated constructor stub
	}

	public ChequeDepositSearchResponse(Long totalRecords, Integer page, Integer size,
			
			List<ChequeDepositDto> chequeDeposits) {
		
		super();
		
		this.totalRecords = totalRecords;
		this.page = page;
		this.size = size;
		this.chequeDeposits = chequeDeposits;
	
	}

	public Long getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(Long totalRecords) {
		this.totalRecords = totalRecords;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public List<ChequeDepositDto> getChequeDeposits() {
		return chequeDeposits;
	}

	public void setChequeDeposits(List<ChequeDepositDto> chequeDeposits) {
		this.chequeDeposits = chequeDeposits;
	}
	
}
