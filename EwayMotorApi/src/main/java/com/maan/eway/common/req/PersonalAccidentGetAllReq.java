package com.maan.eway.common.req;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PersonalAccidentGetAllReq {

	@JsonProperty("QuoteNo")
	private String quoteNo;

	@JsonProperty("SectionId")
	private String sectionId;

}
