/* 
*  Copyright (c) 2019. All right reserved
 * Created on 2022-10-06 ( Date ISO 2022-10-06 - Time 15:40:39 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */

/*
 * Created on 2022-10-06 ( 15:40:39 )
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
* Domain class for entity "MotorVehicleInfo"
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
@IdClass(MotorVehicleInfoArchId.class)
@Table(name="motor_vehicle_info_arch")


public class MotorVehicleInfoArch implements Serializable {
 
private static final long serialVersionUID = 1L;
 
    //--- ENTITY PRIMARY KEY 
	@Id
	@Column(name="ARCH_ID", nullable=false, length=20)
	private String     archId ;

    @Id
    @Column(name="REQ_REG_NUMBER", nullable=false, length=20)
    private String     reqRegNumber ;

    @Id
    @Column(name="REQ_CHASSIS_NUMBER", nullable=false, length=20)
    private String     reqChassisNumber ;

    //--- ENTITY DATA FIELDS 
    @Column(name="REQ_REQUEST_ID", length=20)
    private String     reqRequestId ;

    @Column(name="REQ_COMPANY_CODE", length=20)
    private String     reqCompanyCode ;

    @Column(name="REQ_SYSTEM_CODE", length=100)
    private String     reqSystemCode ;

    @Column(name="REQ_MOTOR_CATEGORY")
    private Integer    reqMotorCategory ;

    @Column(name="REQ_MSG_SIGNATURE", length=500)
    private String     reqMsgSignature ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="ENTRY_DATE")
    private Date       entryDate ;

    @Column(name="STATUS", length=1)
    private String     status ;

    @Column(name="CREATED_BY", length=200)
    private String     createdBy ;

    @Column(name="RES_RESPONSE_ID")
    private Integer    resResponseId ;

    @Column(name="RES_REQUEST_ID", length=20)
    private String     resRequestId ;

    @Column(name="RES_STATUS_CODE", length=20)
    private String     resStatusCode ;

    @Column(name="RES_STATUS_DESC", length=20)
    private String     resStatusDesc ;

    @Column(name="RES_MOTOR_CATEGORY")
    private Integer    resMotorCategory ;

    @Column(name="RES_REG_NUMBER", length=20)
    private String     resRegNumber ;

    @Column(name="RES_CHASSIS_NUMBER", length=20)
    private String     resChassisNumber ;

    @Column(name="RES_MAKE", length=20)
    private String     resMake ;

    @Column(name="RES_MODEL", length=20)
    private String     resModel ;

    @Column(name="RES_BODY_TYPE", length=20)
    private String     resBodyType ;

    @Column(name="RES_COLOR", length=20)
    private String     resColor ;

    @Column(name="RES_ENGINE_NUMBER", length=20)
    private String     resEngineNumber ;

    @Column(name="RES_ENGINE_CAPACITY", length=20)
    private String     resEngineCapacity ;

    @Column(name="RES_FUEL_USED", length=20)
    private String     resFuelUsed ;

    @Column(name="RES_NUMBER_OF_AXLES")
    private Integer    resNumberOfAxles ;

    @Column(name="RES_AXLE_DISTANCE")
    private Double     resAxleDistance ;

    @Column(name="RES_SITTING_CAPACITY")
    private Integer    resSittingCapacity ;

    @Column(name="RES_YEAR_OF_MANUFACTURE")
    private Integer    resYearOfManufacture ;

    @Column(name="RES_TARE_WEIGHT")
    private Double     resTareWeight ;

    @Column(name="RES_GROSS_WEIGHT")
    private Double     resGrossWeight ;

    @Column(name="RES_MOTOR_USAGE", length=20)
    private String     resMotorUsage ;

    @Column(name="RES_OWNER_NAME", length=150)
    private String     resOwnerName ;

    @Column(name="RES_OWNER_CATEGORY", length=150)
    private String     resOwnerCategory ;

    @Column(name="RES_MSG_SIGNATURE", length=500)
    private String     resMsgSignature ;

    @Column(name="SAVED_FROM", length=500)
    private String     savedFrom ;
    
    @Column(name="POLICY_YN", length=500)
    private String     policyYn ;
    //--- ENTITY LINKS ( RELATIONSHIP )


}



