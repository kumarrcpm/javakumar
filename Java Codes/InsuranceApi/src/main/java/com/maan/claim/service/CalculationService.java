package com.maan.claim.service;

import java.util.List;

import com.maan.claim.error.Error;
import com.maan.claim.req.CalculationReq;
import com.maan.claim.res.CalculationRes;

public interface CalculationService {

	List<Error> validateReq(CalculationReq req);

	CalculationRes getCalculation(CalculationReq req);

}
