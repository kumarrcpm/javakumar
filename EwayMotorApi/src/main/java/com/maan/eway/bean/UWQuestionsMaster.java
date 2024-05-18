/* 
*  Copyright (c) 2019. All right reserved
 * Created on 2022-08-24 ( Date ISO 2022-08-24 - Time 12:58:26 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */

/*
 * Created on 2022-08-24 ( 12:58:26 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */


package com.maan.eway.bean;


import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

import java.util.Date;
import javax.persistence.*;




/**
* Domain class for entity "BranchMaster"
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
@IdClass(UWQuestionsMasterId.class)
@Table(name="uw_questions_master")


public class UWQuestionsMaster implements Serializable {
 
private static final long serialVersionUID = 1L;
 
    //--- ENTITY PRIMARY KEY 
    @Id
    @Column(name="COMPANY_ID", nullable=false, length=20)
    private String     companyId ;

    @Id
    @Column(name="PRODUCT_ID", nullable=false)
    private Integer  productId;

    @Id
    @Column(name="AMEND_ID", nullable=false)
    private Integer     amendId ;

    @Id
    @Column(name="UW_QUESTION_ID", nullable=false)
    private Integer  uwQuestionId;
    
    @Id
	@Column(name="BRANCH_CODE",length=20, nullable=false)
	private String branchCode;
	
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="EFFECTIVE_DATE_START")
    private Date       effectiveDateStart ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="EFFECTIVE_DATE_END")
    private Date       effectiveDateEnd ;

    
    //--- ENTITY DATA FIELDS 
    @Column(name="UW_QUESTION_DESC", length=100)
    private String   uwQuestionDesc;

    @Column(name="QUESTION_TYPE", length=100)
    private String   questionType;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="ENTRY_DATE")
    private Date       entryDate ;

    @Column(name="STATUS", length=2)
    private String     status ;

    
    @Column(name="REMARKS", length=100)
    private String     remarks ;

    @Column(name="MANDATORY_YN", length=2)
    private String  mandatoryYn;

    @Column(name="DATA_TYPE", length=100)
    private String    dataType ;

    @Column(name="CREATED_BY",length=100)
	private String createdBy;
	
	@Column(name="UPDATED_BY",length=100)
	private String updatedBy;
	
	@Column(name="CORE_APP_CODE",length=20)
	private String coreAppCode;
	
	@Column(name="REGULATORY_CODE",length=20)
	private String regulatoryCode;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPDATED_DATE")
	private Date updatedDate;
	
	
}



