/* 
*  Copyright (c) 2019. All right reserved
 * Created on 2022-11-30 ( Date ISO 2022-11-30 - Time 17:06:50 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */

/*
 * Created on 2022-11-30 ( 17:06:50 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */


package com.maan.eway.bean;


import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import java.util.Date;
import javax.persistence.*;




/**
* Domain class for entity "MsHumanDetails"
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
@IdClass(MsHumanDetailsId.class)
@Table(name="ms_human_details")


public class MsHumanDetails implements Serializable {
 
private static final long serialVersionUID = 1L;
 
    //--- ENTITY PRIMARY KEY 
    @Id
    @Column(name="REQUEST_REFERENCE_NO", nullable=false, length=20)
    private String     requestReferenceNo ;

    @Id
    @Column(name="HUMAN_ID", nullable=false)
    private Integer    humanId ;

    @Id
    @Column(name="VD_REFNO", nullable=false)
    private Long       vdRefno ;
    
    @Id
    @Column(name="GROUP_ID")
    private Integer    groupId ;

    @Id
    @Column(name="ENDT_TYPE_ID")
    private Integer    endtTypeId ;
    
    @Id
    @Column(name="ENDT_CATEGORY_ID")
    private String    endtCategoryId ;
    
    //--- ENTITY DATA FIELDS 
    @Column(name="TRAVEL_COVER_ID")
    private Integer    travelCoverId ;

    @Column(name="SOURCE_COUNTRY", length=50)
    private String     sourceCountry ;
    
    @Column(name="CATEGORY_ID", length=50)
    private String     categoryId;
    
    @Column(name="DESTINATION_COUNTRY", length=50)
    private String     destinationCountry ;

    @Column(name="SPORTS_COVER_YN", length=20)
    private String     sportsCoverYn ;

    @Column(name="TERRORISM_COVER_YN", length=20)
    private String     terrorismCoverYn ;

    @Column(name="PLAN_TYPE_ID")
    private Integer    planTypeId ;

    @Column(name="TOTAL_PASSENGERS")
    private Integer    totalPassengers ;

    @Column(name="AGE")
    private Integer    age ;
    
    @Column(name="SUM_INSURED")
    private BigDecimal     sumInsured;

	@Column(name="Period_of_Insurance", nullable=false, length=10)
	private String     periodOfInsurance ;
	
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="ENTRY_DATE")
    private Date       entryDate ;

    @Column(name="CREATED_BY", length=100)
    private String     createdBy ;

    @Column(name="STATUS", length=1)
    private String     status ;

    @Column(name="HAVEPROMOCODE", length=10)
    private String     havepromocode ;

    @Column(name="PROMOCODE", length=100)
    private String     promocode ;
    
    @Column(name="CURRENCY")
    private String    currency ;

    @Column(name="EXCHANGE_RATE")
    private BigDecimal     exchangeRate ;
    
    @Column(name="COVID_COVER_YN", length=20)
    private String     covidCoverYn ;

  
    
    @Column(name="GROUP_COUNT")
    private Integer    groupCount ;

    
    @Column(name="NATURE_OF_BUSINESS_ID")
    private Integer       natureOfBusinessId ;
    
    @Column(name="TOTAL_NO_OF_EMPLOYEES")
    private Long       totalNoOfEmployees;
    
    @Column(name="TOTAL_EXCLUDED_EMPLOYEES")
    private Long       totalExcludedEmployees ;
    
    @Column(name="TOTAL_REJOINED_EMPLOYEES")
    private Long       totalRejoinedEmployees ;
    
    @Column(name="ACCOUNT_OUTSTANDING_EMPLOYEES")
    private Long       accountOutstandingEmployees;
    
    @Column(name="ACCOUNT_AUDITENT_TYPE")
    private Integer       accountAuditentType ;
    
    @Column(name="TOTAL_OUTSTANDING_AMOUNT")
    private Long       totalOutstandingAmount;
    
    @Column(name="LIABILITY_SI")
    private BigDecimal       liabilitySi;
    
    @Column(name="FID_EMP_COUNT")
    private BigDecimal       fidEmpCount;
    
    @Column(name="FID_EMP_SI")
    private BigDecimal       fidEmpSi;
    
    //--- ENTITY LINKS ( RELATIONSHIP )
    @Column(name="EMP_LIABILITY_SI")
    private BigDecimal       empLiabilitySi;

    @Column(name="PERSONAL_LIABILITY_OCCUPATION")
    private String       personalLiabilityOccupation; 
    
    @Column(name="PERSONAL_LIABILITY_SI")
    private BigDecimal       personalLiabilitySi; 
    
    @Column(name="PERSONAL_LIABILITY_CATEGORY")
    private BigDecimal       personalLiabilityCategory; 
}


