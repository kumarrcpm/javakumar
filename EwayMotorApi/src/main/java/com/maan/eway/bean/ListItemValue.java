/* 
*  Copyright (c) 2019. All right reserved
 * Created on 2022-11-21 ( Date ISO 2022-11-21 - Time 15:20:09 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */

/*
 * Created on 2022-11-21 ( 15:20:09 )
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
* Domain class for entity "ListItemValue"
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
@IdClass(ListItemValueId.class)
@Table(name="eway_list_item_value")


public class ListItemValue implements Serializable {
 
private static final long serialVersionUID = 1L;
 
    //--- ENTITY PRIMARY KEY 
    @Id
    @Column(name="ITEM_ID", nullable=false)
    private Integer     itemId ;
    
    @Id
    @Column(name="AMEND_ID", nullable=false)
    private Integer     amendId;
    
    @Id
    @Column(name="COMPANY_ID", nullable=false)
    private String companyId ;
    
    @Id
    @Column(name="BRANCH_CODE", nullable=false)
    private String branchCode ;

    //--- ENTITY DATA FIELDS 
    @Column(name="ITEM_TYPE", length=300)
    private String     itemType ;

    @Column(name="ITEM_CODE", length=20)
    private String     itemCode ;

    @Column(name="ITEM_VALUE", length=300)
    private String     itemValue ;

    @Column(name="PARAM_1", length=100)
    private String     param1 ;

    @Column(name="PARAM_2", length=100)
    private String     param2 ;

    @Temporal(TemporalType.DATE)
    @Column(name="ENTRY_DATE")
    private Date       entryDate ;

    @Column(name="STATUS", length=30)
    private String     status ;

    @Column(name="CORE_APP_CODE", length=20)
    private String     coreAppCode ;

    @Column(name="REGULATORY_CODE", length=20)
    private String     regulatoryCode ;

    @Column(name="REMARKS", length=100)
    private String     remarks ;
    
    @Column(name="CREATED_BY", length=100)
    private String     createdBy ;
    
    @Column(name="UPDATED_BY", length=100)
    private String     updatedBy ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="EFFECTIVE_DATE_START", nullable=false)
    private Date       effectiveDateStart ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="EFFECTIVE_DATE_END", nullable=false)
    private Date       effectiveDateEnd ;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="UPDATED_DATE", nullable=false)
    private Date       updatedDate;
    
    //--- ENTITY LINKS ( RELATIONSHIP )


}



