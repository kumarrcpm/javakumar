/* 
\*  Copyright (c) 2019. All right reserved
 * Created on 2022-11-19 ( Date ISO 2022-11-19 - Time 13:30:10 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */

/*
 * Created on 2022-11-19 ( 13:30:10 )
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
* Domain class for entity "EserviceBuildingDetails"
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
@IdClass(EserviceCommonDetailsId.class)
@Table(name="eservice_common_details")


public class EserviceCommonDetails implements Serializable {
 
private static final long serialVersionUID = 1L;
 
    //--- ENTITY PRIMARY KEY 
    @Id
    @Column(name="REQUEST_REFERENCE_NO", nullable=false, length=20)
    private String     requestReferenceNo ;

    @Id
    @Column(name="RISK_ID", nullable=false)
    private Integer    riskId ;

    @Id
    @Column(name="CUSTOMER_REFERENCE_NO", nullable=false, length=20)
    private String     customerReferenceNo ;
    
 
    @Column(name="OCCUPATION_TYPE", length=100)
    private String occupationType ;

    //--- ENTITY DATA FIELDS 
    @Column(name="PRODUCT_ID", length=20)
    private String  productId ;

    @Column(name="POLICY_NO", length=100)
    private String     policyNo;

    
    @Column(name="PRODUCT_DESC", length=100)
    private String  productDesc ;

    @Column(name="SECTION_ID", length=20)
    private String  sectionId ;

    @Column(name="SECTION_DESC", length=100)
    private String sectionDesc ;

    @Column(name="OCCUPATION_DESC", length=100)
    private String occupationDesc ;
    
    @Column(name="COMPANY_ID", length=20)
    private String     companyId ;

    @Column(name="COMPANY_NAME", length=100)
    private String companyName ;

    
    @Column(name="BRANCH_CODE", length=20)
    private String     branchCode ;
       

    @Column(name="BRANCH_Name", length=100)
    private String     branchName;
       
    @Column(name="AGENCY_CODE", length=100)
    private String     agencyCode;
    
    @Column(name="CATEGORY_ID", length=20)
    private String     categoryId ;
    
    @Column(name="SUM_INSURED")
    private BigDecimal sumInsured;
    
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="ENTRY_DATE")
    private Date       entryDate ;

    @Column(name="CREATED_BY", length=100)
    private String     createdBy ;

    @Column(name="STATUS", length=2)
    private String     status ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="UPDATED_DATE")
    private Date       updatedDate ;

    @Column(name="UPDATED_BY", length=100)
    private String     updatedBy ;

    @Column(name="COUNT")
    private Integer count;

    
    @Column(name="ADMIN_LOGIN_ID", length=100)
    private String    adminLoginId ;

    @Column(name="ADMIN_REMARKS", length=100)
    private String    adminRemarks ;
    
    @Column(name="REFERAL_REMARKS", length=100)
    private String    referalRemarks ;
    
    @Column(name="REJECT_REASON", length=100)
    private String    rejectReason ;
    
    @Column(name="LOGIN_ID", length=100)
    private String    loginId;
    
    @Column(name="BROKER_CODE", length=100)
    private String  brokerCode;
    
    @Column(name="POLICY_PERIOD", length=100)
    private Integer policyPeriod;
    
    @Column(name="AC_EXECUTIVE_ID", length=100)
    private String    acExecutiveId;
    
    @Column(name="QUOTE_NO", length=100)
    private String    quoteNo;
    
    @Column(name="APPLICATION_ID", length=100)
    private String    applicationId ;
    
    @Column(name="BROKER_BRANCH_CODE", length=100)
    private String brokerBranchCode ;
    
    @Column(name="BROKER_BRANCH_NAME", length=100)
    private String   brokerBranchName ;
    
   
    @Column(name="CUSTOMER_ID", length=100)
    private String  customerId;
    
    @Column(name="OLD_REQ_REF_NO", length=100)
    private String   oldReqRefNo;
    
    @Column(name="BENEFIT_COVER_MONTH")
    private Integer benefitCoverMonth;
    
    @Column(name="SALARY_PER_ANNUM")
    private BigDecimal salaryPerAnnum;
    
    @Column(name="CURRENCY", length=20)
    private String     currency;
    
    @Column(name="EXCHANGE_RATE", length=20)
    private BigDecimal     exchangeRate ;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="POLICY_START_DATE")
    private Date       policyStartDate ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="POLICY_END_DATE")
    private Date       policyEndDate ;

    @Column(name="ACTUAL_PREMIUM_FC")
    private BigDecimal     actualPremiumFc ;

    
    @Column(name="ACTUAL_PREMIUM_LC")
    private BigDecimal     actualPremiumLc ;

    @Column(name="OVERALL_PREMIUM_LC")
    private BigDecimal     overallPremiumLc ;

    @Column(name="OVERALL_PREMIUM_FC")
    private BigDecimal     overallPremiumFc ;
    
    @Column(name="HAVEPROMOCODE", length=20)
    private String     havepromocode;

    @Column(name="PROMOCODE", length=100)
    private String     promocode;
    
    @Column(name="CUSTOMER_NAME", length=100)
    private String     customerName;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="DOB")
    private Date       dob ;
     
    @Column(name="JOB_JOINING_MONTH", length=100)
    private String    jobJoiningMonth;
    
    @Column(name="BETWEEN_DISCONTINUED", length=10)
    private String  betweenDiscontinued;
    
    @Column(name="ETHICAL_WORK_INVOLVED", length=10)
    private String  ethicalWorkInvolved;
    

    @Column(name="BANK_CODE", length=100)
    private String   bankCode;    
    
    @Column(name="SOURCE_TYPE", length=100)
    private String   sourceType;  
    
    @Column(name="CUSTOMER_CODE", length=100)
    private String   customerCode;  
    
    @Column(name="BDM_CODE", length=100)
    private String  bdmCode;
    
    @Column(name="MANUAL_REFERAL_YN", length=100)
    private String  manualReferalYn;
    
    @Column(name="ENDORSEMENT_TYPE")
    private Integer    endorsementType ;

    @Column(name="ENDORSEMENT_TYPE_DESC", length=100)
    private String     endorsementTypeDesc ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="ENDORSEMENT_DATE")
    private Date       endorsementDate ;

    @Column(name="ENDORSEMENT_REMARKS", length=500)
    private String     endorsementRemarks ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="ENDORSEMENT_EFFDATE")
    private Date       endorsementEffdate ;

    @Column(name="ORIGINAL_POLICY_NO", length=500)
    private String     originalPolicyNo ;

    @Column(name="ENDT_PREV_POLICY_NO", length=500)
    private String     endtPrevPolicyNo ;

    @Column(name="ENDT_PREV_QUOTE_NO", length=500)
    private String     endtPrevQuoteNo ;

    @Column(name="ENDT_COUNT")
    private BigDecimal endtCount ;

    @Column(name="ENDT_STATUS", length=10)
    private String     endtStatus ;
    
    
    
    @Column(name="IS_FINYN", length=10)
    private String     isFinaceYn ;
    
    
    @Column(name="ENDT_CATEG_DESC", length=10)
    private String     endtCategDesc ;
    
    
    @Column(name="ENDT_PREMIUM")
    private Double       endtPremium ;
    
    @Column(name="NATURE_OF_BUSINESS_ID")
    private Integer       natureOfBusinessId ;
    
    @Column(name="NATURE_OF_BUSINESS_DESC")
    private String natureOfBusinessDesc ;
    
    @Column(name="TOTAL_NO_OF_EMPLOYEES")
    private Long       totalNoOfEmployees;
    
    @Column(name="TOTAL_EXCLUDED_EMPLOYEES")
    private Long       totalExcludedEmployees ;
    
    @Column(name="TOTAL_REJOINED_EMPLOYEES")
    private Long       totalRejoinedEmployees ;
    
    @Column(name="ACCOUNT_OUTSTANDING_EMPLOYEES")
    private Long       accountOutstandingEmployees;
    
    @Column(name="TOTAL_OUTSTANDING_AMOUNT")
    private Long       totalOutstandingAmount;
    
    @Column(name="ACCOUNT_AUDITENT_TYPE")
    private Integer       accountAuditentType ;
    
    @Column(name="AUDITENT_TYPE_DESC")
    private String       auditentTypeDesc;
    
    @Column(name="INDUSTRY_NAME")
    private String       industryName;
    
    @Column(name="LIABILITY_SI")
    private BigDecimal       liabilitySi;
    
    @Column(name="FID_EMP_COUNT")
    private BigDecimal       fidEmpCount;
    
    @Column(name="FID_EMP_SI")
    private BigDecimal       fidEmpSi;
    
    @Column(name="EMP_LIABILITY_SI")
    private BigDecimal       empLiabilitySi;
    
    @Column(name="PERSONAL_LIABILITY_OCCUPATION")
    private String       personalLiabilityOccupation; 
    
    @Column(name="PERSONAL_LIABILITY_SI")
    private BigDecimal       personalLiabilitySi; 
    
    @Column(name="PERSONAL_LIABILITY_CATEGORY")
    private BigDecimal       personalLiabilityCategory; 
}


