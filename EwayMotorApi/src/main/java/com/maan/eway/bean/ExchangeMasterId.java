/*
 * Created on 2022-08-24 ( 12:58:26 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */
package com.maan.eway.bean;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


import java.util.Date;

/**
 * Composite primary key for entity "BankMaster" ( stored in table "bank_master" )
 *
 * @author Telosys
 *
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ExchangeMasterId implements Serializable {

    private static final long serialVersionUID = 1L;

	private Integer sNo;
	private Integer exchangeId;
	private Date effectiveDateStart;
	private Date effectiveDateEnd;

     
}
