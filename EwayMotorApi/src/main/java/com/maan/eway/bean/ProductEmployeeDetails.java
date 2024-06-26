/* 
*  Copyright (c) 2019. All right reserved
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
@IdClass(ProductEmployeeDetailsId.class)
@Table(name="product_employee_details")


public class ProductEmployeeDetails implements Serializable {
 
private static final long serialVersionUID = 1L;
 
    //--- ENTITY PRIMARY KEY 
    @Id
    @Column(name="QUOTE_NO", nullable=false, length=20)
    private String     quoteNo ;

    @Id
    @Column(name="RISK_ID", nullable=false)
    private Integer    riskId ;

    @Id
    @Column(name="EMPLOYEE_ID", nullable=false)
    private Long employeeId ;
    
    @Id
    @Column(name="PRODUCT_ID", length=20)
    private Integer  productId ;

    @Id
    @Column(name="COMPANY_ID", length=20)
    private String     companyId ;
    
    @Id
    @Column(name="NATIONALITY_ID", length=20)
    private String     nationalityId ;

    //--- ENTITY DATA FIELDS
    
    @Column(name="REQUEST_REFERENCE_NO",  length=20)
    private String     requestReferenceNo;
    
    @Column(name="PRODUCT_DESC", length=20)
    private String  productDesc ;

    @Column(name="POLICY_NO", length=100)
    private String     policyNo;
    
   @Column(name="EMPLOYEE_NAME")
    private String employeeName;
 
    @Column(name="OCCUPATION_ID")
    private String occupationId;
    
    @Column(name="OCCUPATION_DESC")
    private String occupationDesc;
    
    @Column(name="CREATED_BY")
    private String createdBy;
    
    @Column(name="STATUS")
    private String status;
    
    @Column(name="SALARY")
    private BigDecimal salary;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="ENTRY_DATE")
    private Date       entryDate ;

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
	  
	  @Temporal(TemporalType.TIMESTAMP)
	  @Column(name="DATE_OF_BIRTH")
	  private Date       dateOfBirth;
	  
	  @Column(name="DATE_OF_JOINING_YEAR")
	  private Integer dateOfJoiningYear;
	  
	  @Column(name="DATE_OF_JOINING_MONTH", length=10)
	  private String dateOfJoiningMonth;
      
}



