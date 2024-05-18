package com.maan.travel.serviceimpl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.maan.travel.entity.VisTravelRatingEntity;
import com.maan.travel.repository.VisTravelRatingRepository;
import com.maan.travel.req.PremiumCalculationReq;
import com.maan.travel.res.PremiumCalculationRes;
import com.maan.travel.service.PremiumCalculationService;

@Service
public class PremiumCalculationServiceImpl implements PremiumCalculationService {

	
	@Autowired
	private VisTravelRatingRepository repository;

	Gson  json =new Gson();

	
	private Logger log = LogManager.getLogger(PremiumCalculationServiceImpl.class);
	SimpleDateFormat  sdf = new SimpleDateFormat("dd/MM/yyyy");
	
    private static final DecimalFormat df = new DecimalFormat("0.00");

	@Override
	public List<PremiumCalculationRes> getPremiumCalculation(PremiumCalculationReq req) {
		// TODO Auto-generated method stub
		
		List<PremiumCalculationRes> resList = new ArrayList<PremiumCalculationRes>();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			int ageFrom = 0;
			int ageTo = 0;
			int totalMembers =0;
			 
			// 1 to 4
			ageFrom = 1;
			ageTo = 4;
			totalMembers = (Integer.valueOf(req.getAgeDetails().getOneToFour() ==null?0:Integer.valueOf(req.getAgeDetails().getOneToFour())));			
				VisTravelRatingEntity oneToFourRating = repository.findByTypeIdAndCoverIdAndTravelStartDateLessThanEqualAndTravelEndDateGreaterThanEqualAndAgeFromLessThanEqualAndAgeToGreaterThanEqualAndAgencyCode(req.getTypeId(),new BigDecimal(req.getCoverId()),new BigDecimal( req.getTravelledDays()),new BigDecimal( req.getTravelledDays()),new BigDecimal(ageFrom) ,new BigDecimal(ageTo), req.getAgencyCode() );
				 BigDecimal oneToFour = oneToFourRating.getRating() ;
			BigDecimal totalMembersRatingOne = new BigDecimal( totalMembers ).multiply(oneToFour);
			
		// 5 to 65
			ageFrom = 5;
			ageTo = 65;
			totalMembers = (Integer.valueOf(req.getAgeDetails().getFiveToSixtyFive() ==null?0: Integer.valueOf(req.getAgeDetails().getFiveToSixtyFive())));					
			VisTravelRatingEntity fiveToSixtyFiveRating = repository.findByTypeIdAndCoverIdAndTravelStartDateLessThanEqualAndTravelEndDateGreaterThanEqualAndAgeFromLessThanEqualAndAgeToGreaterThanEqualAndAgencyCode(req.getTypeId(),new BigDecimal(req.getCoverId()),new BigDecimal( req.getTravelledDays()),new BigDecimal( req.getTravelledDays()),new BigDecimal(ageFrom) ,new BigDecimal(ageTo), req.getAgencyCode() );
				 BigDecimal fiveToSixty = fiveToSixtyFiveRating.getRating() ;
				 BigDecimal totalMembersRatingTwo = new BigDecimal( totalMembers ).multiply(fiveToSixty);
				 
				// 66 to 70
			ageFrom =66;
			ageTo = 70;
			totalMembers = (Integer.valueOf(req.getAgeDetails().getSixtySixToSeventy() ==null?0: Integer.valueOf(req.getAgeDetails().getSixtySixToSeventy())));						
			VisTravelRatingEntity sixtySixtoSeventyRating = repository.findByTypeIdAndCoverIdAndTravelStartDateLessThanEqualAndTravelEndDateGreaterThanEqualAndAgeFromLessThanEqualAndAgeToGreaterThanEqualAndAgencyCode(req.getTypeId(),new BigDecimal(req.getCoverId()),new BigDecimal( req.getTravelledDays()),new BigDecimal( req.getTravelledDays()),new BigDecimal(ageFrom) ,new BigDecimal(ageTo), req.getAgencyCode() );
				BigDecimal sixtysixToSeventy = sixtySixtoSeventyRating.getRating();
				BigDecimal totalMembersRatingThree = new BigDecimal( totalMembers ).multiply(sixtysixToSeventy);
				// 71 to 80			
			ageFrom =71;
			ageTo = 80;
			totalMembers = (Integer.valueOf(req.getAgeDetails().getSeventyOneEighty() ==null?0:Integer.valueOf(req.getAgeDetails().getSeventyOneEighty())));					
			VisTravelRatingEntity seventytoEightyRating = repository.findByTypeIdAndCoverIdAndTravelStartDateLessThanEqualAndTravelEndDateGreaterThanEqualAndAgeFromLessThanEqualAndAgeToGreaterThanEqualAndAgencyCode(req.getTypeId(),new BigDecimal(req.getCoverId()),new BigDecimal( req.getTravelledDays()),new BigDecimal( req.getTravelledDays()),new BigDecimal(ageFrom) ,new BigDecimal(ageTo), req.getAgencyCode() );
				BigDecimal seventyToEighty = seventytoEightyRating.getRating();
				BigDecimal totalMembersRatingFour = new BigDecimal( totalMembers ).multiply(seventyToEighty );
				
				// Total Rating 		
				BigDecimal totalRating =  	totalMembersRatingOne.add(totalMembersRatingTwo).add(totalMembersRatingThree).add(totalMembersRatingFour);
						
				
				BigDecimal onePercentFee = new BigDecimal(1);
				BigDecimal pointSixFee = new BigDecimal(0.6D);
				BigDecimal totalFee= new BigDecimal(0);
				BigDecimal vat28per=new BigDecimal(0);
				BigDecimal vat16per=new BigDecimal(0);
				
				onePercentFee = onePercentFee.multiply(totalRating).divide(new BigDecimal(100));
				pointSixFee = (pointSixFee.multiply(totalRating)).divide(new BigDecimal(100));
				
				totalFee = onePercentFee.add(pointSixFee);
				vat28per = totalFee.multiply(new BigDecimal(28).divide(new BigDecimal(100)));
				vat16per = totalFee.multiply(new BigDecimal(16).divide(new BigDecimal(100)));
				PremiumCalculationRes res = new PremiumCalculationRes();		
				  res.setOneToFourRating(totalMembersRatingOne ==null?"": totalMembersRatingOne.toString());
					res.setFiveToSixtyFiveRating(totalMembersRatingTwo ==null?"": totalMembersRatingTwo.toString());
					res.setSixtySixtoSeventyRating(totalMembersRatingThree ==null?"": totalMembersRatingThree.toString());
					res.setSeventytoEightyRating(totalMembersRatingFour ==null?"": totalMembersRatingFour.toString());
					res.setTotalrating(totalRating.toString());							  
			        df.setRoundingMode(RoundingMode.UP);

					res.setOnePercentFee(df.format(onePercentFee));
					res.setPointSixFee(df.format(pointSixFee));
					res.setTotalFee(df.format(totalFee));	
					res.setVat28per(df.format(vat28per));
					res.setVat16per(df.format(vat16per));
					resList.add(res);
		
			
	} catch (Exception e) {
		e.printStackTrace();
		log.info("Exception is ---> " + e.getMessage());
		return null;
	}
	return resList;

}

	
}
