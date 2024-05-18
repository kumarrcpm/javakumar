package com.maan.eway.tira.util;

import java.util.function.Function;

import com.maan.eway.bean.PolicyCoverData;
import com.maan.eway.req.push.DiscountOffered;

public class LoadingFromData   implements Function<PolicyCoverData,DiscountOffered>	 {

	  
	@Override
	public DiscountOffered apply(PolicyCoverData t) {
		if(t.getCoverageType().equalsIgnoreCase("L") && t.getPremiumAfterDiscountFc()>0D) {
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
