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
@IdClass(CityMasterId.class)
@Table(name="eway_city_master")


public class CityMaster implements Serializable {
 
private static final long serialVersionUID = 1L;
 
    //--- ENTITY PRIMARY KEY 
    @Id
    @Column(name="CITY_ID", nullable=false)
    private Integer     cityId ;

    @Id
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="EFFECTIVE_DATE_START", nullable=false)
    private Date       effectiveDateStart ;

    @Id
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="EFFECTIVE_DATE_END", nullable=false)
    private Date       effectiveDateEnd ;

    @Id
    @Column(name="STATE_ID",length=20,nullable=false)
    private String     stateId ;
    
//    @Id
//    @Column(name="REGION_ID",length=20,nullable=false)
//    private String     regionId ;
    
    @Id
    @Column(name="COUNTRY_ID",length=20,nullable=false)
    private String countryId ;
    
    
    //--- ENTITY DATA FIELDS 
    @Column(name="CITY_NAME", length=100)
    private String     cityName ;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="ENTRY_DATE")
    private Date       entryDate ;

    @Column(name="STATUS", length=1)
    private String     status ;
    

    @Column(name="AMEND_ID",nullable=false)
    private Integer     amendId ;

    @Column(name="REMARKS", length=100)
    private String     remarks ;

    @Column(name="REGULATORY_CODE", length=20,nullable=false)
    private String     regulatoryCode;

    @Column(name="CREATED_BY", length=100,nullable=false)
    private String     createdBy;

}



