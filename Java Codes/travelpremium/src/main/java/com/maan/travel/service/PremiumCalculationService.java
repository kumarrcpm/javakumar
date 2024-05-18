package com.maan.travel.service;

import java.util.List;

import com.maan.travel.req.PremiumCalculationReq;
import com.maan.travel.res.PremiumCalculationRes;

public interface PremiumCalculationService {

	List<PremiumCalculationRes> getPremiumCalculation(PremiumCalculationReq req);
}
