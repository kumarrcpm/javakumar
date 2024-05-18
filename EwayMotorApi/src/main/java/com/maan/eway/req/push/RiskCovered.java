package com.maan.eway.req.push;
 
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@ToString
@Jacksonized
@XmlAccessorType(XmlAccessType.FIELD)
@AllArgsConstructor
@NoArgsConstructor
public class RiskCovered {
 
	  
	@JsonProperty("IsMulti") 
	@XmlElement(name = "IsMulti")
	 private String isMulti;
	
	 @JsonProperty("PremiumAfterDiscount") 
	 @XmlElement(name = "PremiumAfterDiscount")
	 private String premiumAfterDiscount;

	 @JsonProperty("PremiumBeforeDiscount")
	 @XmlElement(name = "PremiumBeforeDiscount")
	 private String premiumBeforeDiscount;
	 
	 @JsonProperty("PremiumExcludingTaxEquivalent") 
	 @XmlElement(name = "PremiumExcludingTaxEquivalent")
	 private String premiumExcludingTaxEquivalent;
	 
	 @JsonProperty("PremiumIncludingTax") 
	 @XmlElement(name = "PremiumIncludingTax")
	 private String premiumIncludingTax;
	 
	 @JsonProperty("PremiumRate") 
	 @XmlElement(name = "PremiumRate")
	 private String premiumRate;
	 
	 @JsonProperty("RiskCode") 
	 @XmlElement(name = "RiskCode")
	 private String riskCode;
	 
	 @JsonProperty("SumInsured") 
	 @XmlElement(name = "SumInsured")
	 private String sumInsured;
	 
	 @JsonProperty("SumInsuredEquivalent") 
	 @XmlElement(name = "SumInsuredEquivalent")
	 private String sumInsuredEquivalent;
	 
    @JsonProperty("DiscountsOffered") 
    @XmlElement(name = "DiscountsOffered")
    private  DiscountsOffered discountsOfferedBean ;

    @JsonProperty("TaxesCharged") 
    @XmlElement(name = "TaxesCharged")
    private TaxesCharged taxesChargedBean ;

 
}