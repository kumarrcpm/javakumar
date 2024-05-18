/* 
*  Copyright (c) 2019. All right reserved
 * Created on 2022-11-16 ( Date ISO 2022-11-16 - Time 16:18:45 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */

/*
 * Created on 2022-11-16 ( 16:18:45 )
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
* Domain class for entity "DropdownTableDetails"
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
@IdClass(DropdownTableDetailsId.class)
@Table(name="dropdown_table_details")


public class DropdownTableDetails implements Serializable {
 
private static final long serialVersionUID = 1L;
 
    //--- ENTITY PRIMARY KEY 
    @Id
    @Column(name="REQUEST_ID", nullable=false)
    private Integer    requestId ;

    @Id
    @Column(name="ITEM_ID", nullable=false)
    private Integer    itemId ;

    @Id
    @Column(name="COMPANY_ID", nullable=false, length=20)
    private String     companyId ;

    @Id
    @Column(name="BRANCH_CODE", nullable=false, length=20)
    private String     branchCode ;

    @Id
    @Column(name="PRODUCT_ID", nullable=false)
    private Integer    productId ;

    @Id
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="EFFECTIVE_DATE_START", nullable=false)
    private Date       effectiveDateStart ;

    @Id
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="EFFECTIVE_DATE_END", nullable=false)
    private Date       effectiveDateEnd ;

    //--- ENTITY DATA FIELDS 
    @Column(name="REQUEST_JSON_KEY", length=100)
    private String     requestJsonKey ;

    @Column(name="REQUEST_COLUMN", length=100)
    private String     requestColumn ;

    @Column(name="REQUEST_TABLE", length=100)
    private String     requestTable ;

    @Column(name="STATUS", length=1)
    private String     status ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="ENTRY_DATE")
    private Date       entryDate ;

    @Column(name="AMEND_ID")
    private Integer    amendId ;

    @Column(name="CREATED_BY", length=100)
    private String     createdBy ;


    //--- ENTITY LINKS ( RELATIONSHIP )


}


