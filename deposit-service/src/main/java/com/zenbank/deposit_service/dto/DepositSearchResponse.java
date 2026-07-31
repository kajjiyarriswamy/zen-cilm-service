package com.zenbank.deposit_service.dto;

import java.util.List;

public class DepositSearchResponse {
	  
	private Long totalRecords;
	private Integer page;
	private Integer size;
	private List<DepositTransactionResponse> deposits;
	       
		public DepositSearchResponse() {
			
			super();
			// TODO Auto-generated constructor stub
		}

		public DepositSearchResponse(Long totalrecords, Integer page, Integer size,
				
				List<DepositTransactionResponse> deposits) {
			
			super();
			
			this.totalRecords = totalrecords;
			this.page = page;
			this.size = size;
			this.deposits = deposits;
		}

		public Long getTotalrecords() {
			return totalRecords;
		}

		public void setTotalrecords(Long totalrecords) {
			this.totalRecords = totalrecords;
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

		public List<DepositTransactionResponse> getDeposits() {
			return deposits;
		}

		public void setDeposits(List<DepositTransactionResponse> deposits) {
			this.deposits = deposits;
		}
	              
 }



