package com.maan.crm.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(CampaignDetailsId.class)
@Table(name="campaign_details")
public class CampaignDetails implements Serializable {

	@Id
	@Column(name="CAMPAIGN_ID",length=100, nullable=false)
	private String campaignId;
	
	@Id
	@Column(name="CUSTOMER_ID",length=100, nullable=false)
	private String customerId;
	
	@Column(name="CLIENT_NAME", length =100, nullable=false)
	private String clientName;
	
	
	@Column(name="MOBILE_NUMBER",nullable=false, length=10)
	private String mobileNumber;
	

	@Column(name="EMAIL_ID", length=100, nullable=false)
	private String emailId;
	
	
	@Column(name="OCCUPATION", length=100, nullable=false)
	private String occupation;
	
	
	@Column(name="CRNO", length=100, nullable=false)
	private String crno;
	
	
	@Column(name="CLIENT_REF_NO", length=100, nullable=false)
	private String clientRefNo;
	
	
	@Column(name="LEAD_ID",nullable = false)
	private Integer leadId;
	

	@Column(name="CLIENT_TYPE", length=100, nullable=false)
	private String clientType;
	

	@Column(name="CLIENT_TYPE_ID")
	private Integer clientTypeId;

	@Column(name="TITLE", length=10, nullable=false)
	private String title;
	

	@Column(name="TITLE_ID")
	private Integer titleId;
	
}
