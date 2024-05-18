package com.maan.claim.req;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ActEditReq {

	@JsonProperty("Sequencenumber")
	private String sequencenumber ;
}
