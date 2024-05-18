
public class CommonResponse {

}
package com.maan.motor.res;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.maan.motor.auth.dto.resp.DefaultAllResponse;
import com.maan.motor.error.Error;

import lombok.Data;

@Data
public class CommonResponse {

	@JsonProperty("Message")
	private String message;

	@JsonProperty("IsError")	
	private Boolean isError;

	@JsonProperty("ErrorMessage")
	private List<Error> errorMessage;

	//Dynamic
	@JsonProperty("Result")
	private Object commonResponse;
	
	@JsonProperty("ErroCode")
	private int erroCode;

	@JsonProperty("AdditionalData")
	private DefaultAllResponse defaultValue;
}
