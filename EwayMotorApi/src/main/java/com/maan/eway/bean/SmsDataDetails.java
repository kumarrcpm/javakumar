/* 
*  Copyright (c) 2019. All right reserved
 * Created on 2022-11-21 ( Date ISO 2022-11-21 - Time 15:19:49 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */

/*
 * Created on 2022-11-21 ( 15:19:49 )
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
* Domain class for entity "AcExecutiveMaster"
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
@IdClass(SmsDataDetailsId.class)
@Table(name="eway_sms_data_details")


public class SmsDataDetails implements Serializable {
 
private static final long serialVersionUID = 1L;
 
    //--- ENTITY PRIMARY KEY 
    @Id
    @Column(name="S_NO", nullable=false, length=100)
    private String sNo;

    @Column(name="SMS_FROM", length=100)
    private String   smsFrom;
  
 
    @Column(name="MOBILE_NO", length=50)
    private String   mobileNo;
 
    @Column(name="SMS_TYPE", length=50)
    private String   smsType;
    
    @Column(name="SMS_CONTENT", length=1000)
    private String   smsContent;   
    
           
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="REQ_TIME")
    private Date       reqTime ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="RES_TIME")
    private Date       resTime ;   
    
    @Column(name="RES_STATUS", length=50)
    private String  resStatus;    
    
    @Column(name="RES_MESSAGE", length=1000)
    private String  resMessage;
        
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="ENTRY_DATE")
    private Date       entryDate ;


    
}


