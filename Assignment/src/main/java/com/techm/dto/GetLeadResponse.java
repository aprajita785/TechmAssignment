package com.techm.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.techm.entity.Lead;

@JsonInclude(Include.NON_NULL)
public class GetLeadResponse {

	private String status;
	private List<Lead> data;
	private ErrorResponse errorResponse;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<Lead> getData() {
		return data;
	}
	public void setData(List<Lead> data) {
		this.data = data;
	}
	public ErrorResponse getErrorResponse() {
		return errorResponse;
	}
	public void setErrorResponse(ErrorResponse errorResponse) {
		this.errorResponse = errorResponse;
	}
	
	
}
