/* 
*  Copyright (c) 2019. All right reserved
 * Created on 2022-05-14 ( Date ISO 2022-05-14 - Time 15:00:24 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */

/*
 * Created on 2022-05-14 ( 15:00:24 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */

package com.maan.crm.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Domain class for entity "ClaimLoginUserDetails"
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
@IdClass(ProductDetailsId.class)
@Table(name = "PRODUCT_DETAILS")

public class ProductDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	// --- ENTITY PRIMARY KEY
	@Id
	@Column(name = "PRODUCT_ID", nullable = false)
	private Integer productId;

	@Id
	@Column(name = "SUB_DETAIL_ID",nullable = false)
	private Integer subDetailId;
	
	@Id
	@Temporal(TemporalType.DATE)
	@Column(name = "EFFECTIVE_DATE", nullable = false)
	private Date effectiveDate;
	
	@Id
	@Column(name = "AMEND_ID", nullable = false)
	private Integer amendId;
	//---ENTITY

	@Column(name = "CATEGORY_ID")
	private Integer categoryId;
	
	@Column(name = "CATEGORY_NAME",length=100)
	private String categoryName;

	@Column(name = "DETAILS",length = 100)
	private String details;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "ENTRY_DATE")
	private Date entryDate;

	@Column(name = "Status",length=100)
	private String status;

}
