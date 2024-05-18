/* 
*  Copyright (c) 2019. All right reserved
 * Created on 2022-11-08 ( Date ISO 2022-11-08 - Time 16:28:23 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */

/*
 * Created on 2022-11-08 ( 16:28:23 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */


package com.maan.eway.bean;


import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.*;




/**
* Domain class for entity "FactorRateRequestDetails"
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
@IdClass(FactorRateRequestDetailsId.class)
@Table(name="factor_rate_request_details")


public class FactorRateRequestDetails implements Serializable {
 
private static final long serialVersionUID = 1L;
 
    //--- ENTITY PRIMARY KEY 
    @Id
    @Column(name="REQUEST_REFERENCE_NO", nullable=false, length=20)
    private String     requestReferenceNo ;

    @Id
    @Column(name="COMPANY_ID", nullable=false, length=20)
    private String     companyId ;

    @Id
    @Column(name="PRODUCT_ID", nullable=false)
    private Integer    productId ;
    
    @Id
    @Column(name="VEHICLE_ID", nullable=false)
    private Integer    vehicleId ;

    @Id
    @Column(name="SECTION_ID", nullable=false)
    private Integer    sectionId ;

    @Id
    @Column(name="COVER_ID", nullable=false)
    private Integer    coverId ;

    @Id
    @Column(name="SUB_COVER_YN", nullable=false, length=20)
    private String     subCoverYn ;

    @Id
    @Column(name="SUB_COVER_ID", nullable=false)
    private Integer    subCoverId ;
    
    @Id
    @Column(name="TAX_ID")
    private Integer taxId;
   
    @Id
    @Column(name="DISCOUNT_COVER_ID")
    private Integer    discountCoverId;
     
    @Id
    @Column(name="ENDT_COUNT")
    private BigDecimal     endtCount ;
    
    @Id
    @Column(name="DISC_LOAD_ID", nullable=false)
    private Integer    discLoadId ;

    @Column(name="CD_REFNO", nullable=false)
    private String       cdRefno ;

    @Column(name="MS_REFNO", nullable=false)
    private String       msRefno ;

    @Column(name="VD_REFNO", nullable=false)
    private String       vdRefno ;
    
    //--- ENTITY DATA FIELDS 
    @Column(name="COVER_NAME", length=100)
    private String     coverName ;

    @Column(name="COVER_DESC", length=200)
    private String     coverDesc ;

    @Column(name="SUB_COVER_NAME", length=100)
    private String     subCoverName ;

    @Column(name="SUB_COVER_DESC", length=200)
    private String     subCoverDesc ;

    @Column(name="CALC_TYPE", length=20)
    private String     calcType ;

    @Column(name="MINIMUM_PREMIUM")
    private Double     minimumPremium ;

    @Column(name="SUM_INSURED")
    private Double     sumInsured ;

    @Column(name="RATE")
    private Double     rate ;
    
    @Column(name="CURRENCY")
    private String currency ;

    @Column(name="EXCHANGE_RATE")
    private Double exchageRate ;
    
    @Column(name="PREMIUM_BEFORE_DISCOUNT_FC")
    private Double     premiumBeforeDiscountFc ;

    @Column(name="PREMIUM_AFTER_DISCOUNT_FC")
    private Double     premiumAfterDiscountFc ;

    @Column(name="PREMIUM_EXCLUDED_TAX_FC")
    private Double     premiumExcludedTaxFc ;

    @Column(name="PREMIUM_INCLUDED_TAX_FC")
    private Double     premiumIncludedTaxFc ;
    
    @Column(name="PREMIUM_BEFORE_DISCOUNT_LC")
    private Double     premiumBeforeDiscountLc ;

    @Column(name="PREMIUM_AFTER_DISCOUNT_LC")
    private Double     premiumAfterDiscountLc ;

    @Column(name="PREMIUM_EXCLUDED_TAX_LC")
    private Double     premiumExcludedTaxLc ;

    @Column(name="PREMIUM_INCLUDED_TAX_LC")
    private Double     premiumIncludedTaxLc ;

    @Column(name="FACTOR_TYPE_ID")
    private Integer     factorTypeId ;

    @Column(name="DEPENDENT_COVER_YN", length=20)
    private String     dependentCoverYn ;

    @Column(name="DEPENDENT_COVER_ID")
    private Integer    dependentCoverId ;

    @Column(name="COVERAGE_TYPE", length=20)
    private String     coverageType ;
    
    @Column(name="IS_SELECTED", length=20)
    private String     isSelected ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="ENTRY_DATE")
    private Date       entryDate ;

    @Column(name="CREATED_BY", length=100)
    private String     createdBy ;
    
    @Column(name="STATUS", length=20)
    private String     status;


    @Column(name="TAX_RATE")
    private Double taxRate;
    
    @Column(name="TAX_AMOUNT")
    private Double taxAmount;
    
    @Column(name="TAX_DESC")
    private String taxDesc;
    
    @Column(name="TAX_CALC_TYPE")
    private String taxCalcType;
    
    @Column(name="IS_TAX_EXTEMPTED")
    private String isTaxExtempted ;
    
    @Column(name="TAX_EXEMPT_TYPE")
    private String taxExtemptType;
    
    @Column(name="TAX_EXEMPT_CODE")
    private String taxExemptCode;
    
    @Column(name="Is_REFERRAL", length=5)
    private String     isReferral ;

    @Column(name="referral_description", length=1000)
    private String     referralDescription ;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="COVER_PERIOD_FROM")
    private Date       coverPeriodFrom;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="COVER_PERIOD_TO")
    private Date       coverPeriodTo;
    
    @Column(name="NO_OF_DAYS")
    private BigDecimal    noOfDays;
    
    @Column(name="PRO_RATA_YN")
    private String    proRataYn ;
    
    @Column(name="PRO_RATA_PERCENT")
    private BigDecimal    proRataPercent ;

    
    //--- ENTITY LINKS ( RELATIONSHIP )


}


