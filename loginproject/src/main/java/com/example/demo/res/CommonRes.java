package com.example.demo.res;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import com.example.demo.res.Error;
@Data
public class CommonRes {

	@JsonProperty("Message")
	private String message;
	
	@JsonProperty("IsError")
	private Boolean isError;
	
	@JsonProperty("ErrorMessage")
	private List<Error> errorMessage;
	
	@JsonProperty("Result")
	private Object commonResponse;
}
