/* 
*  Copyright (c) 2019. All right reserved
 * Created on 2022-12-15 ( Date ISO 2022-12-15 - Time 16:37:23 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */

/*
 * Created on 2022-12-15 ( 16:37:23 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */

package com.maan.eway.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Domain class for entity "TravelPassengerDetails"
 *
 * @author Telosys Tools Generator
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@DynamicInsert
@DynamicUpdate
@Builder
@IdClass(TravelPolicyTypeId.class)
@Table(name = "travel_policy_type")

public class TravelPolicyType implements Serializable {

	private static final long serialVersionUID = 1L;

	// --- ENTITY PRIMARY KEY
	@Id
	@Column(name = "POLICY_TYPE_ID", nullable = false)
	private Integer policyTypeId;

	@Id
	@Column(name = "PLAN_TYPE_ID", nullable = false)
	private Integer planTypeId;

	@Id
	@Column(name = "COVER_ID", nullable = false)
	private Integer coverId;

	@Id
	@Column(name = "SUB_COVER_ID", nullable = false)
	private Integer subCoverId;

	@Column(name = "POLICY_TYPE_DESC", length = 100)
	private String policyTypeDesc;

	@Column(name = "PLAN_TYPE_DESC", length = 100)
	private String planTypeDesc;

	@Column(name = "COVER_DESC", length = 100)
	private String coverDesc;

	@Column(name = "SUB_COVER_DESC", length = 100)
	private String subCoverDesc;

	@Column(name = "CURRENCY", length = 30)
	private String currency;

	@Column(name = "SUM_INSURED", length = 30)
	private String sumInsured;

	@Column(name = "EXCESS_AMT", length = 30)
	private String excessAmt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ENTRY_DATE")
	private Date entryDate;

	@Column(name = "STATUS", length = 1)
	private String status;

	@Column(name = "REMARKS", length = 100)
	private String remarks;

}
