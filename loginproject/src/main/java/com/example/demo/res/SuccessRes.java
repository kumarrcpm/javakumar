package com.example.demo.res;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class SuccessRes {

	@JsonProperty("Code")
	private Integer code;

	@JsonProperty("CodeDesc")
	private String codeDesc;

}
