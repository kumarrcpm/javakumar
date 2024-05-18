package com.maan.travel.serviceimpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.maan.travel.entity.VisTravelRatingEntity;
import com.maan.travel.repository.VisTravelRatingRepository;
import com.maan.travel.req.PremiumCalculationReq;
import com.maan.travel.res.PremiumCalculationRes;
import com.maan.travel.service.PremiumCalculationService;

public class PremiumCalculationServiceImpl implements PremiumCalculationService {

	
	@Autowired
	private VisTravelRatingRepository repository;

	Gson  json =new Gson();

	
	private Logger log = LogManager.getLogger(PremiumCalculationServiceImpl.class);
	SimpleDateFormat  sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	
	@Override
	public List<PremiumCalculationRes> getPremiumCalculation(PremiumCalculationReq req) {
		// TODO Auto-generated method stub
		
		List<PremiumCalculationRes> resList = new ArrayList<PremiumCalculationRes>();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
			List<VisTravelRatingEntity> vistravel = repository.findByTypeIdAndCoverIdAndTravelStartDateGreaterThanEqualAndTravelEndDateLessThanEqualAndAgeFromGreaterThanAndAgeToLessThanEqualAndAgencyCode(req.getTypeId(),req.getCoverId(), req.getTravelStartDate(),req.getTravelEndDate(), req.getAgeFrom(), req.getAgeTo(), req.getAgencyCode() );

			for (VisTravelRatingEntity data : vistravel) {
				PremiumCalculationRes res = new PremiumCalculationRes();
			
				res.setRating(data.getRating() ==null?"": data.getRating().toString());
				resList.add(res);

		}
		
	} catch (Exception e) {
		e.printStackTrace();
		log.info("Exception is ---> " + e.getMessage());
		return null;
	}
	return resList;

}

	
}
