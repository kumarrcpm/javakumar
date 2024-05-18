/*
 * Created on 2021-08-13 ( 15:03:28 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */
package com.maan.crm.bean;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * Composite primary key for entity "SessionDetails" ( stored in table
 * "SESSION_DETAILS" )
 *
 * @author Telosys
 *
 */

@Getter
@Setter
public class ProductDetailsId implements Serializable {

	private static final long serialVersionUID = 1L;

	// --- ENTITY KEY ATTRIBUTES
	private Integer productId;

	private Date effectiveDate;

	private Integer amendId;

	private Integer subDetailId;
}
