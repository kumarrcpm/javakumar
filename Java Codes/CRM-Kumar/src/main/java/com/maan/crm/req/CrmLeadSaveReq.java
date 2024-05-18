package com.maan.crm.req;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CrmLeadSaveReq {

	@JsonProperty("LeadId")
	private String leadId;
	
	@JsonProperty("ClientId")
	private String clientId;

	@JsonProperty("BusinessType")
	private String businessType;
		
	@JsonProperty("BusinessTypeId")
	private String businessTypeId;
	
	@JsonProperty("ClassDesc")
	private String classDesc;
		
	@JsonProperty("ClassId")
	private String classId;
	
	@JsonProperty("PolicyType")
	private String policyType;
		
	@JsonProperty("PolicyTypeId")
	private String policyTypeId;
	
	@JsonProperty("LeadGenDate")
	private String leadGenDate;
		
	@JsonProperty("DueDate")
	private String dueDate;
	
	@JsonProperty("BrokenPolicy")
	private String brokenPolicy;
	
	@JsonProperty("Classification")
	private String classification;
		
	@JsonProperty("ClassificationId")
	private String classificationId;

	@JsonProperty("Source")
	private String source;
	
	@JsonProperty("SourceId")
	private String sourceId;
	
	@JsonProperty("Referredby")
	private String referredby;
		
	@JsonProperty("ReferredbyId")
	private String referredbyId;

	@JsonProperty("Othertype")
	private String othertype;
	
	@JsonProperty("OthertypeId")
	private String othertypeId;
	
	@JsonProperty("Pos")
	private String pos;
		
	@JsonProperty("PosId")
	private String posId;

	@JsonProperty("ReferenceName")
	private String referenceName;
	
	@JsonProperty("AssigntoGroup")
	private String assigntoGroup;
	
	@JsonProperty("AssigntoGroupId")
	private String assigntoGroupId;
		
	@JsonProperty("AssigntoUser")
	private String assigntoUser;
	
	@JsonProperty("AssigntoUserId")
	private String assigntoUserId;
	
	@JsonProperty("Remarks")
	private String remarks;
	
	
	
}
