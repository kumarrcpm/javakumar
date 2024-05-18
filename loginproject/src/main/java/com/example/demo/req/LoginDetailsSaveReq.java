package com.example.demo.req;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class LoginDetailsSaveReq {

	@JsonProperty("UserName")
	private String userName;
}
