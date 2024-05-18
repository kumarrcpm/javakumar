/* 
*  Copyright (c) 2019. All right reserved
 * Created on 2022-09-02 ( Date ISO 2022-09-02 - Time 18:14:54 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */

/*
 * Created on 2022-09-02 ( 18:14:54 )
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
* Domain class for entity "SectionMaster"
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
@IdClass(SectionMasterId.class)
@Table(name="section_master")


public class SectionMaster implements Serializable {
 
private static final long serialVersionUID = 1L;
 
    //--- ENTITY PRIMARY KEY 
    @Id
    @Column(name="SECTION_ID", nullable=false)
    private Integer    sectionId ;

    @Id
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="EFFECTIVE_DATE_START", nullable=false)
    private Date       effectiveDateStart ;

    @Id
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="EFFECTIVE_DATE_END", nullable=false)
    private Date       effectiveDateEnd ;

    //--- ENTITY DATA FIELDS 
    @Column(name="SECTION_NAME", length=100)
    private String     sectionName ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="ENTRY_DATE")
    private Date       entryDate ;

    @Column(name="STATUS", length=1)
    private String     status ;

    @Column(name="REGULATORY_CODE", length=20,nullable=false)
    private String    regulatoryCode ;
 
    @Column(name="CREATED_BY", length=20)
    private String     createdBy ;

    @Column(name="AMEND_ID")
    private Integer     amendId ;

    @Column(name="REMARKS", length=100)
    private String     remarks ;

    @Column(name="MOTOR_YN", length=1)
    private String     motorYn;

}



