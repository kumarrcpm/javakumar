package com.maan.claim.req;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ActInfoReq {

	@JsonProperty("ActArabic")
	private String actarabic;
	
	@JsonProperty("ActEnglish")
	private String actenglish;
	
	@JsonProperty("EntryDate")
	private String entryDate;
	
	@JsonProperty("Status")
	private String status;
	
	@JsonProperty("Remarks")
	private String remarks;
	
	@JsonProperty("SequenceNumber")
	private String sequenceNumber;
	
	@JsonProperty("VehicleId")
	private String vehicleId;
	
	@JsonProperty("Casenumber")
	private String casenumber;
	
}
