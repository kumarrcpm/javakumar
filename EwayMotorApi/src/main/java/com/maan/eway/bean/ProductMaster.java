/* 
*  Copyright (c) 2019. All right reserved
 * Created on 2022-11-21 ( Date ISO 2022-11-21 - Time 15:20:25 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */

/*
 * Created on 2022-11-21 ( 15:20:25 )
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
* Domain class for entity "ProductMaster"
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
@IdClass(ProductMasterId.class)
@Table(name="eway_product_master")


public class ProductMaster implements Serializable {
 
private static final long serialVersionUID = 1L;
 
    //--- ENTITY PRIMARY KEY 
    @Id
    @Column(name="PRODUCT_ID", nullable=false)
    private Integer    productId ;

    @Column(name="AMEND_ID", nullable=false)
    private Integer    amendId ;


    //--- ENTITY DATA FIELDS 
    @Column(name="PRODUCT_NAME", length=100)
    private String     productName ;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="EFFECTIVE_DATE_START", nullable=false)
    private Date       effectiveDateStart ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="EFFECTIVE_DATE_END", nullable=false)
    private Date       effectiveDateEnd ;

    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="INCEPTION_DATE")
    private Date       inceptionDate ;

    @Column(name="PRODUCT_ICON_ID")
    private Integer    productIconId ;

    @Column(name="PRODUCT_ICON_NAME", length=50)
    private String     productIconName ;

    @Column(name="MOTOR_YN",length=1)
    private String     motorYn ;

    @Column(name="DISPLAY_ORDER")
    private Integer    displayOrder ;

    @Column(name="PAYMENT_YN", length=5)
    private String     paymentYn ;

    @Column(name="PAYMENT_REDIR_URL", length=500)
    private String     paymentRedirUrl ;

    @Column(name="APP_LOGIN_URL", length=100)
    private String     appLoginUrl ;

    @Column(name="STATUS", length=1)
    private String     status ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="ENTRY_DATE")
    private Date       entryDate ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="EXPIRY_DATE")
    private Date       expiryDate ;

    @Column(name="PRODUCT_DESC", length=500)
    private String     productDesc ;

    @Column(name="REMARKS", length=100)
    private String     remarks ;

    @Column(name="REGULATORY_CODE", nullable=false, length=20)
    private String     regulatoryCode ;

    @Column(name="SUM_INSURED_START")
    private Double     sumInsuredStart ;

    @Column(name="SUM_INSURED_END")
    private Double     sumInsuredEnd ;

    @Column(name="COMMISSION_VAT_YN", length=1)
    private String     commissionVatYn ;

    @Column(name="CHECKER_YN", length=1)
    private String     checkerYn ;

    @Column(name="MAKER_YN", length=1)
    private String     makerYn ;

    @Column(name="CUST_CONFIRM_YN", length=1)
    private String     custConfirmYn ;

    @Column(name="CREATED_BY", length=100)
    private String     createdBy ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="UPDATED_DATE")
    private Date       updatedDate ;

    @Column(name="UPDATED_BY", length=20)
    private String     updatedBy ;
    
    @Column(name="CURRENCY_IDS", length=20)
    private String     currencyIds;

    @Column(name="PACKAGE_YN", length=20)
    private String     packageYn;

    //--- ENTITY LINKS ( RELATIONSHIP )


}



