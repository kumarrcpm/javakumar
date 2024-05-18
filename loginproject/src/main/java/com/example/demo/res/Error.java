package com.example.demo.res;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Error {

	@JsonProperty("Code")
	private String code;
	
	@JsonProperty("Field")
	private String field;
	
	@JsonProperty("Message")
	private String message;
	
}
