package com.maan.eway.req;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.maan.eway.req.DiscountSaveReq;
import com.maan.eway.res.calc.Cover;
import com.maan.eway.res.calc.CoverException;
import com.maan.eway.res.calc.Discount;
import com.maan.eway.res.calc.Loading;
import com.maan.eway.res.calc.Tax;

import lombok.Data;

@Data
public class CoverListSaveReq {

	 	@JsonProperty("CoverId") 
	    public String coverId;
	    @JsonProperty("CalcType") 
	    public String calcType;
	    @JsonProperty("CoverName") 
	    public String coverName;
	    @JsonProperty("CoverDesc") 
	    public String coverDesc;
	    @JsonProperty("MinimumPremium") 
	    public BigDecimal minimumPremium;
	    @JsonProperty("IsSubCover") 
	    public String isSubCover;
	    @JsonProperty("SumInsured") 
	    public BigDecimal sumInsured;
	    @JsonProperty("Rate") 
	    public Double rate;
	    @JsonProperty("SubCoverId") 
	    public String subCoverId;
	    @JsonProperty("SubCoverDesc") 
	    public String subCoverDesc;
	    @JsonProperty("SubCoverName") 
	    public String subCoverName;
	    @JsonProperty("PremiumBeforeDiscount") 
	    public BigDecimal premiumBeforeDiscount;
	    @JsonProperty("PremiumAfterDiscount") 
	    public BigDecimal premiumAfterDiscount;
	    @JsonProperty("PremiumExcluedTax") 
	    public Double premiumExcluedTax;
	    @JsonProperty("PremiumIncludedTax") 
	    public BigDecimal premiumIncludedTax;
	    @JsonProperty("Discounts") 
	    public List<DiscountSaveReq> discounts;
	  
	    @JsonProperty("SubCovers") 
	    public List<CoverListSaveReq> subcovers;
	    
	    @JsonProperty("FactorTypeId")
	    private String factorTypeId;
	    
	    @JsonProperty("DependentCoverYN")
	    private String dependentCoveryn;

	    @JsonProperty("DependentCoverId")
	    private String dependentCoverId;
	    
	   	    @JsonProperty("CoverageType") 
	    private String coverageType;
	    @JsonProperty("isSelected") 
	    private String isselected;
	    
}
