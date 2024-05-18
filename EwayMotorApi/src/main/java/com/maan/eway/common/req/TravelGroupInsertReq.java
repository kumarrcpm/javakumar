package com.maan.eway.common.req;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class TravelGroupInsertReq {

	@JsonProperty("GroupId")
    private String    groupId     ;
//	@JsonProperty("GroupDesc")
//    private String    groupDesc     ;
	@JsonProperty("GroupMembers")
    private String    groupMembers    ;
	
	
}
