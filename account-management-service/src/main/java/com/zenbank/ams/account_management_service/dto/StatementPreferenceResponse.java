package com.zenbank.ams.account_management_service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatementPreferenceResponse {

	private String status;
	private Integer page;
	private Integer size;
	private Long totalRecord;
	private Object datas;
	private String message;
	private String preferenceId;
	private StatementPreferenceData data;
	
	
	
	

	public StatementPreferenceResponse() {
	    }

	public StatementPreferenceResponse(String status, String message, String preferenceId, StatementPreferenceData data) {

		this.status = status;
		this.message = message;
		this.preferenceId = preferenceId;
		this.data=data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public Long getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(Long totalRecord) {
		this.totalRecord = totalRecord;
	}

	public Object getDatas() {
		return datas;
	}

	public void setDatas(Object datas) {
		this.datas = datas;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPreferenceId() {
		return preferenceId;
	}

	public void setPreferenceId(String preferenceId) {
		this.preferenceId = preferenceId;
	}

	public StatementPreferenceData getData() {
		return data;
	}

	public void setData(StatementPreferenceData data) {
		this.data = data;
	}
	
	
	
	
	
	
}
