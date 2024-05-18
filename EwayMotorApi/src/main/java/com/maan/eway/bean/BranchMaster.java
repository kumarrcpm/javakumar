/* 
*  Copyright (c) 2019. All right reserved
 * Created on 2022-11-21 ( Date ISO 2022-11-21 - Time 15:19:51 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */

/*
 * Created on 2022-11-21 ( 15:19:51 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */


package com.maan.eway.bean;


import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.Table;

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
@IdClass(BranchMasterId.class)
@Table(name="eway_branch_master")


public class BranchMaster implements Serializable {
 
private static final long serialVersionUID = 1L;
 
    //--- ENTITY PRIMARY KEY 
    @Id
    @Column(name="BRANCH_CODE", nullable=false, length=20)
    private String     branchCode ;

    @Id
    @Column(name="AMEND_ID",nullable=false)
    private Integer    amendId ;

    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="EFFECTIVE_DATE_START", nullable=false)
    private Date       effectiveDateStart ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="EFFECTIVE_DATE_END", nullable=false)
    private Date       effectiveDateEnd ;

    //--- ENTITY DATA FIELDS 
    @Column(name="BRANCH_NAME", length=100)
    private String     branchName ;

    @Column(name="REGION_CODE", length=20)
    private String     regionCode ;

    @Column(name="COMPANY_ID", length=20)
    private String     companyId ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="ENTRY_DATE")
    private Date       entryDate ;

    @Column(name="STATUS", length=1)
    private String     status ;

    @Column(name="CORE_APP_CODE", length=20)
    private String     coreAppCode ;

    
    @Column(name="REMARKS", length=100)
    private String     remarks ;

    @Column(name="CREATED_BY", length=100)
    private String     createdBy ;

    @Column(name="STATE_CODE")
    private Integer    stateCode ;

    @Column(name="STATE_NAME", length=100)
    private String     stateName ;

    @Column(name="CITY_CODE")
    private Integer    cityCode ;

    @Column(name="CITY_NAME", length=100)
    private String     cityName ;

    @Column(name="COUNTRY_ID", length=100)
    private String     countryId ;

    @Column(name="ADDRESS1", nullable=false, length=100)
    private String     address1 ;

    @Column(name="ADDRESS2", nullable=false, length=100)
    private String     address2 ;

    @Column(name="EMAIL", nullable=false, length=100)
    private String     email ;

    @Column(name="MOBILE_NUMBER", nullable=false, length=10)
    private String     mobileNumber ;

    @Column(name="BRANCH_TYPE", nullable=false, length=10)
    private String     branchType ;

    @Column(name="REGULATORY_CODE", nullable=false, length=20)
    private String     regulatoryCode ;

    @Column(name="UPDATED_BY", length=100)
    private String    updatedBy ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="UPDATED_DATE")
    private Date       updatedDate ;
    
    @Column(name="DIRECT_BROKER_ID", length=100)
    private String    directBrokerId;
    
    @Column(name="BROKER_AGENCY_CODE", length=100)
    private String    brokerAgencyCode;

}


