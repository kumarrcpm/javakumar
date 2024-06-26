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
@IdClass(CompanyStateMasterId.class)
@Table(name="company_state_master")


public class CompanyStateMaster implements Serializable {
 
private static final long serialVersionUID = 1L;
 
    //--- ENTITY PRIMARY KEY 
    @Id
    @Column(name="STATE_ID", nullable=false)
    private Integer     stateId ;

    @Id
    @Column(name="STATE_SHORT_CODE", nullable=false, length=20)
    private String stateShortCode;

    @Id
    @Column(name="COMPANY_ID", nullable=false, length=20)
    private String     companyId;
    
    @Id
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="EFFECTIVE_DATE_START", nullable=false)
    private Date       effectiveDateStart ;

    @Id
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="EFFECTIVE_DATE_END", nullable=false)
    private Date       effectiveDateEnd ;
    
    @Id
    @Column(name="COUNTRY_ID",nullable=false)
    private String     countryId ;

    @Id
    @Column(name="REGION_CODE",nullable=false)
    private String   regionCode;

    
    //--- ENTITY DATA FIELDS 
    @Column(name="STATE_NAME", length=100)
    private String     stateName ;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="ENTRY_DATE")
    private Date       entryDate ;

    @Column(name="STATUS", length=1)
    private String     status ;

    @Column(name="CORE_APP_CODE", length=20)
    private String     coreAppCode ;

    @Column(name="AMEND_ID")
    private Integer     amendId ;

    @Column(name="REMARKS", length=100)
    private String     remarks ;
    
    @Column(name="REGULATORY_CODE", length=20)
    private String    regulatoryCode;

    @Column(name="CREATED_BY", length=20)
    private String   createdBy ;
}



