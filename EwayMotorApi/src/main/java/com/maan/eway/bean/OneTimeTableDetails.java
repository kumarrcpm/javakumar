/* 
*  Copyright (c) 2019. All right reserved
 * Created on 2022-08-24 ( Date ISO 2022-08-24 - Time 12:58:27 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */

/*
 * Created on 2022-08-24 ( 12:58:27 )
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
@Table(name="one_time_table_details")


public class OneTimeTableDetails implements Serializable {
 
private static final long serialVersionUID = 1L;
 
    //--- ENTITY PRIMARY KEY 
    @Id
    @Column(name="ITEM_ID", nullable=false)
    private Integer     itemId ;

    //--- ENTITY DATA FIELDS 

    @Column(name="PARENT_ID", nullable=false)
    private Integer     parentId;

    
    @Column(name="ITEM_TYPE", length=300)
    private String     itemType ;

    @Column(name="ITEM_CODE", length=10)
    private String     itemCode ;

    @Column(name="ITEM_VALUE", length=300)
    private String     itemValue ;
    
    @Temporal(TemporalType.DATE)
    @Column(name="ENTRY_DATE")
    private Date       entryDate ;

    @Column(name="STATUS", length=30)
    private String     status ;



}



