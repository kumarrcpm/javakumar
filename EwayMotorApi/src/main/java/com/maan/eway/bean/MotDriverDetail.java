/* 
*  Copyright (c) 2019. All right reserved
 * Created on 2023-03-03 ( Date ISO 2023-03-03 - Time 18:58:32 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */

/*
 * Created on 2023-03-03 ( 18:58:32 )
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
* Domain class for entity "MotDriverDetail"
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
@IdClass(MotDriverDetailId.class)
@Table(name="mot_driver_detail")


public class MotDriverDetail implements Serializable {
 
private static final long serialVersionUID = 1L;
 
    //--- ENTITY PRIMARY KEY 
    @Id
    @Column(name="REQUESTREFERENCENO", nullable=false, length=15)
    private String     requestreferenceno ;

    @Id
    @Column(name="SERIAL_NO", nullable=false)
    private Double     serialNo ;

    //--- ENTITY DATA FIELDS 
    @Column(name="SERVICE_ID", length=40)
    private String     serviceId ;

    @Column(name="SERVICE_ACTION", length=40)
    private String     serviceAction ;

    @Column(name="QUOTATION_POLICY_NO", length=60)
    private String     quotationPolicyNo ;

    @Column(name="SEC_CODE", length=12)
    private String     secCode ;

    @Column(name="L1S2_ID")
    private Long       l1s2Id ;

    @Column(name="ITERATION_NO", length=5)
    private String     iterationNo ;

    @Column(name="NAME", length=240)
    private String     name ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="DATE_OF_BIRTH")
    private Date       dateOfBirth ;

    @Column(name="SEX", length=12)
    private String     sex ;

    @Column(name="ID_RESIDENT_NO", length=240)
    private String     idResidentNo ;

    @Column(name="TYPE_OF_CLASS", length=12)
    private String     typeOfClass ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="REQUEST_TIME")
    private Date       requestTime ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="RESPONSE_TIME")
    private Date       responseTime ;

    @Column(name="STATUS", length=50)
    private String     status ;

    @Column(name="P_WS_RESPONSE_TYPE", length=100)
    private String     pWsResponseType ;

    @Column(name="P_WS_ERROR", length=500)
    private String     pWsError ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="ENTRY_DATE")
    private Date       entryDate ;

    @Column(name="QUOTE_NO",length=100)
    private String    quoteNo ;

    @Column(name="RENEWAL_POLICY_NO", length=100)
    private String     renewalPolicyNo ;

    @Column(name="PRODUCT_CODE", length=50)
    private String     productCode ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="LICENSE_ISSUED_ON")
    private Date       licenseIssuedOn ;


    //--- ENTITY LINKS ( RELATIONSHIP )


}



