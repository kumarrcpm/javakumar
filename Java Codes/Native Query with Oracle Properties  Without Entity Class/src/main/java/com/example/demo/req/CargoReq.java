package com.example.demo.req;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CargoReq {

	@JsonProperty("McdReferenceNo")
	private Integer mcdReferenceNo;

}
