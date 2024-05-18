package com.example.demo.auth.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonRes {

	@JsonProperty("Message")
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getIsError() {
		return isError;
	}

	public void setIsError(Boolean isError) {
		this.isError = isError;
	}

	public List<Error> getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(List<Error> errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Object getCommonResponse() {
		return commonResponse;
	}

	public void setCommonResponse(Object commonResponse) {
		this.commonResponse = commonResponse;
	}

	@JsonProperty("IsError")
	private Boolean isError;
	
	@JsonProperty("ErrorMessage")
	private List<Error> errorMessage;
	
	@JsonProperty("CommonResponse")
	private Object commonResponse;
	


}
