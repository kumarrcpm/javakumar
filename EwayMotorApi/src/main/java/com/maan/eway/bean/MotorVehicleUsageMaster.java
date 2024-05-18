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
import javax.persistence.Table;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@DynamicInsert
@DynamicUpdate
@Builder
@IdClass(MotorVehicleUsageMasterId.class)
@Table(name="motor_vehicleusage_master")


public class MotorVehicleUsageMaster implements Serializable {
 
private static final long serialVersionUID = 1L;
 
    //--- ENTITY PRIMARY KEY 
    @Id
    @Column(name="VEHICLE_USAGE_ID")
    private Integer   vehicleUsageId;
    
    @Id
    @Column(name="SECTION_ID")
    private String   sectionId;

    @Id
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="EFFECTIVE_DATE_START", nullable=false)
    private Date       effectiveDateStart ;

    @Id
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="EFFECTIVE_DATE_END", nullable=false)
    private Date       effectiveDateEnd ;

    //--- ENTITY DATA FIELDS 
    @Column(name="VEHICLE_USAGE_DESC", length=100)
    private String   vehicleUsageDesc ;

    @Column(name="AMEND_ID")
    private Integer     amendId ;

    @Column(name="STATUS", length=1)
    private String     status ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="ENTRY_DATE")
    private Date       entryDate ;

    @Column(name="REMARKS", length=100)
    private String     remarks ;  

    @Column(name="CLAIM_STATUS", length=1)
    private String     claimStatus ;

    @Column(name="B2C_STATUS", length=1)
    private String     b2cStatus ;



}



