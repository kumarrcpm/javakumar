package com.maan.eway.req.push;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;
@Data
//@XmlRootElement(name="CoverNoteAddon")
@ToString
@Jacksonized
@XmlAccessorType(XmlAccessType.FIELD)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CoverNoteAddon {

	@JsonProperty("AddonAmount") 
	@XmlElement(name = "AddonAmount")
	private String addonAmount;
	@JsonProperty("AddonDesc") 
	@XmlElement(name = "AddonDesc")
	private String addonDesc;
	@JsonProperty("AddonPremiumRate") 
	@XmlElement(name = "AddonPremiumRate")
	private String addonPremiumRate;
	@JsonProperty("AddonReference") 
	@XmlElement(name = "AddonReference")
	private String addonReference;
	@JsonProperty("IsMulti") 
	@XmlElement(name = "IsMulti")
	private String isMulti;
	@JsonProperty("PremiumExcludingTax")
	@XmlElement(name = "PremiumExcludingTax")
	private String premiumExcludingTax;
	@JsonProperty("PremiumExcludingTaxEquivalent")
	@XmlElement(name = "PremiumExcludingTaxEquivalent")
	private String premiumExcludingTaxEquivalent;
	@JsonProperty("PremiumIncludingTax")
	@XmlElement(name = "PremiumIncludingTax")
	private String premiumIncludingTax;

	@JsonProperty("TaxesCharged") 
	@XmlElement(name = "TaxesCharged")
	private TaxesCharged taxesChargedBean ;


}