package com.maan.eway.tira.util;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Function;

import com.maan.eway.bean.PolicyCoverData;
import com.maan.eway.req.push.DiscountOffered;
import com.maan.eway.req.push.DiscountsOffered;
import com.maan.eway.req.push.RiskCovered;
import com.maan.eway.req.push.TaxCharged;
import com.maan.eway.req.push.TaxesCharged;

public class CoverFromData  implements Function<PolicyCoverData,RiskCovered>{
	
	private String filterBy;
	
	private List<DiscountOffered> discounts;
	private List<DiscountOffered> loadings;
	private List<TaxCharged> taxes;
	
	public CoverFromData(String filterBy, List<DiscountOffered> discounts, List<DiscountOffered> loadings, List<TaxCharged> taxes) {
		super();
		this.filterBy = filterBy;
		this.discounts=discounts;
		this.loadings=loadings;
		this.taxes=taxes;
		
	}
	@Override
	public RiskCovered apply(PolicyCoverData t) {
		if(t.getCoverageType().equalsIgnoreCase(filterBy) && t.getPremiumAfterDiscountFc()>0D) {
			RiskCovered r=RiskCovered.builder()
						.discountsOfferedBean(DiscountsOffered.builder().discountOfferedBeanList(discounts).build())
						.isMulti(null)
						.premiumAfterDiscount(t.getPremiumAfterDiscountFc().toString())
						.premiumBeforeDiscount(t.getPremiumBeforeDiscountFc().toString())
						.premiumIncludingTax(t.getPremiumIncludedTaxFc().toString())
						.premiumRate(t.getRate().toString())
						.riskCode(t.getRegulatoryCode())
						.sumInsured(new BigDecimal(t.getSumInsured()).toPlainString())
						.sumInsuredEquivalent(new BigDecimal(t.getSumInsured()).toPlainString())
						.taxesChargedBean(TaxesCharged.builder().taxChargedBean(taxes).build())
						.build();
			
			return r;
		}
		return null;
	}

}
