/* 
*  Copyright (c) 2019. All right reserved
 * Created on 2023-01-12 ( Date ISO 2023-01-12 - Time 16:01:43 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */

/*
 * Created on 2023-01-12 ( 16:01:43 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */


package com.maan.eway.bean;


import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import java.util.Date;
import javax.persistence.*;




/**
* Domain class for entity "PolicyCoverData"
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
@IdClass(PolicyCoverDataId.class)
@Table(name="policy_cover_data")


public class PolicyCoverData implements Serializable {
 
private static final long serialVersionUID = 1L;
 
    //--- ENTITY PRIMARY KEY 
    @Id
    @Column(name="QUOTE_NO", nullable=false, length=60)
    private String     quoteNo ;

    @Id
    @Column(name="REQUEST_REFERENCE_NO", nullable=false, length=60)
    private String     requestReferenceNo ;

    @Id
    @Column(name="VEHICLE_ID", nullable=false)
    private Integer    vehicleId ;

    @Id
    @Column(name="PRODUCT_ID", nullable=false)
    private Integer    productId ;

    @Id
    @Column(name="SECTION_ID", nullable=false)
    private Integer    sectionId ;

    @Id
    @Column(name="COVER_ID", nullable=false)
    private Integer    coverId ;

    @Id
    @Column(name="SUB_COVER_YN", nullable=false, length=60)
    private String     subCoverYn ;

    @Id
    @Column(name="SUB_COVER_ID", nullable=false)
    private Integer    subCoverId ;

    @Id
    @Column(name="DISC_LOAD_ID", nullable=false)
    private Integer    discLoadId ;

    @Id
    @Column(name="TAX_ID", nullable=false)
    private Integer    taxId ;

    @Id
    @Column(name="DISCOUNT_COVER_ID")
    private Integer    discountCoverId;
     
    @Id
    @Column(name="ENDT_COUNT")
    private BigDecimal     endtCount ;
    
    //--- ENTITY DATA FIELDS 
    @Column(name="CD_REFNO", length=60)
    private String     cdRefno ;

    @Column(name="VD_REFNO", length=60)
    private String     vdRefno ;

    @Column(name="MS_REFNO", length=60)
    private String     msRefno ;

    @Column(name="COMPANY_ID", length=60)
    private String     companyId ;

    @Column(name="COVER_NAME", length=300)
    private String     coverName ;

    @Column(name="COVER_DESC", length=600)
    private String     coverDesc ;

    @Column(name="SUB_COVER_NAME", length=300)
    private String     subCoverName ;

    @Column(name="SUB_COVER_DESC", length=600)
    private String     subCoverDesc ;

    @Column(name="CALC_TYPE", length=60)
    private String     calcType ;

    @Column(name="MINIMUM_PREMIUM")
    private Double     minimumPremium ;

    @Column(name="SUM_INSURED")
    private Double     sumInsured ;

    @Column(name="RATE")
    private Double     rate ;

    @Column(name="CURRENCY", length=60)
    private String     currency ;

    @Column(name="EXCHANGE_RATE")
    private Double     exchangeRate ;

    @Column(name="PREMIUM_BEFORE_DISCOUNT_FC")
    private Double     premiumBeforeDiscountFc ;

    @Column(name="PREMIUM_BEFORE_DISCOUNT_LC")
    private Double     premiumBeforeDiscountLc ;

    @Column(name="PREMIUM_AFTER_DISCOUNT_FC")
    private Double     premiumAfterDiscountFc ;

    @Column(name="PREMIUM_AFTER_DISCOUNT_LC")
    private Double     premiumAfterDiscountLc ;

    @Column(name="PREMIUM_EXCLUDED_TAX_FC")
    private Double     premiumExcludedTaxFc ;

    @Column(name="PREMIUM_EXCLUDED_TAX_LC")
    private Double     premiumExcludedTaxLc ;

    @Column(name="PREMIUM_INCLUDED_TAX_FC")
    private Double     premiumIncludedTaxFc ;

    @Column(name="PREMIUM_INCLUDED_TAX_LC")
    private Double     premiumIncludedTaxLc ;

    @Column(name="FACTOR_TYPE_ID")
    private Double     factorTypeId ;

    @Column(name="DEPENDENT_COVER_YN", length=60)
    private String     dependentCoverYn ;

    @Column(name="DEPENDENT_COVER_ID")
    private Integer    dependentCoverId ;

    @Column(name="COVERAGE_TYPE", length=60)
    private String     coverageType ;

    @Column(name="IS_SELECTED", length=60)
    private String     isSelected ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="ENTRY_DATE")
    private Date       entryDate ;

    @Column(name="STATUS", length=60)
    private String     status ;

    @Column(name="CREATED_BY", length=300)
    private String     createdBy ;

    @Column(name="TAX_RATE")
    private Double     taxRate ;

    @Column(name="TAX_AMOUNT")
    private Double     taxAmount ;

    @Column(name="TAX_DESC", length=300)
    private String     taxDesc ;

    @Column(name="TAX_CALC_TYPE", length=3)
    private String     taxCalcType ;

    @Column(name="IS_TAX_EXTEMPTED", length=90)
    private String     isTaxExtempted ;

    @Column(name="TAX_EXEMPT_TYPE", length=60)
    private String     taxExemptType ;

    @Column(name="TAX_EXEMPT_CODE", length=60)
    private String     taxExemptCode ;

    @Column(name="MAX_LODING_AMOUNT")
    private Double     maxLodingAmount ;

    @Column(name="Is_REFERRAL", length=15)
    private String     isReferral ;

    @Column(name="referral_description", length=3000)
    private String     referralDescription ;

    @Column(name="REGULATORY_CODE", length=50)
    private String     regulatoryCode ;


    @Column(name="REGUL_SUM_INSURED")
    private BigDecimal     regulSumInsured ;
    //--- ENTITY LINKS ( RELATIONSHIP )


    @Column(name="cover_based_on", length=100)
    private String     coverBasedOn ;

    @Column(name="MULTI_SELECT_YN")
    private String       multiSelectYn;


    @Column(name="MINIMUM_PREMIUM_YN")
    private String    minimumPremiumYn ;
    
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="COVER_PERIOD_FROM")
    private Date       coverPeriodFrom;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="COVER_PERIOD_TO")
    private Date       coverPeriodTo;
    
    @Column(name="NO_OF_DAYS")
    private BigDecimal    noOfDays;
    
    @Column(name="POLICY_NO")
    private String    policyNo ;
    
    @Column(name="PRO_RATA_YN")
    private String    proRataYn ;
    
    @Column(name="PRO_RATA_PERCENT")
    private BigDecimal    proRataPercent ;

    //--- ENTITY LINKS ( RELATIONSHIP )


}



