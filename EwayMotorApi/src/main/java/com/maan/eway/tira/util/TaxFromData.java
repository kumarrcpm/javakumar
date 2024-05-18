package com.maan.eway.tira.util;

import java.util.function.Function;

import com.maan.eway.bean.PolicyCoverData;
import com.maan.eway.req.push.TaxCharged;

public class TaxFromData  implements Function<PolicyCoverData,TaxCharged>{

	@Override
	public TaxCharged apply(PolicyCoverData t) {
		if(t.getCoverageType().equalsIgnoreCase("T") && t.getTaxAmount()>0D) {
			TaxCharged d=TaxCharged.builder()
					.isTaxExempted(t.getIsTaxExtempted())
					.taxAmount(t.getTaxAmount().toString())
					.taxCode(t.getTaxDesc())
					.taxExemptionReference(t.getTaxExemptCode())
					.taxExemptionType(t.getTaxExemptType())
					.taxRate(t.getTaxRate().toString())  
					.build();
			return d;
		}
		return null;
	}

}
