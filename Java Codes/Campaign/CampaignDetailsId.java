package com.maan.crm.bean;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CampaignDetailsId implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String campaignId;
	
	private String customerId;



}
