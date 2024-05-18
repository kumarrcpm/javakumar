package com.maan.eway.tira.util;

import java.util.function.Function;

import com.maan.eway.bean.PolicyCoverData;
import com.maan.eway.req.push.DiscountOffered;
import com.maan.eway.req.push.DiscountsOffered;

public class DiscountFromData implements Function<PolicyCoverData,DiscountOffered>	 {

	  
	@Override
	public DiscountOffered apply(PolicyCoverData t) {
		if(t.getCoverageType().equalsIgnoreCase("D") && t.getPremiumAfterDiscountFc()>0D) {
			DiscountOffered d=DiscountOffered.builder()
					.discountAmount(t.getPremiumAfterDiscountFc().toString())
					.discountRate(t.getRate().toString())
					.discountType("1")
					.build();
			return d;
		}
		return null;
	}

}
