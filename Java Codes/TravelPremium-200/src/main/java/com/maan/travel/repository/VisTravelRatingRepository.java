package com.maan.travel.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.maan.travel.entity.VisTravelRatingEntity;
import com.maan.travel.req.AgeTypeReq;

public interface VisTravelRatingRepository extends JpaRepository<VisTravelRatingEntity,BigDecimal > , JpaSpecificationExecutor<VisTravelRatingEntity>{

	
//	List<VisTravelRatingEntity> findByTypeIdAndCoverIdAndTravelStartDateGreaterThanEqualAndTravelEndDateLessThanEqualAndAgeFromGreaterThanAndAgeToLessThanEqualAndAgencyCode(String typeId, BigDecimal coverId,Date travelStartDate, Date travelEndDate, BigDecimal ageFrom, BigDecimal ageTo, String agencyCode );

	
VisTravelRatingEntity findByTypeIdAndCoverIdAndTravelStartDateLessThanEqualAndTravelEndDateGreaterThanEqualAndAgeFromLessThanEqualAndAgeToGreaterThanEqualAndAgencyCode(
			String typeId, BigDecimal coverId, BigDecimal travelStartDate, BigDecimal travelEndDate,
			BigDecimal ageFrom, BigDecimal ageTo, String agencyCode);
/*
	List<VisTravelRatingEntity> findByTypeIdAndCoverIdAndTravelStartDateLessThanEqualAndTravelEndDateGreaterThanEqualAndAgeFromLessThanEqualAndAgeToGreaterThanEqualAndAgencyCode(
			String typeId, BigDecimal coverId, BigDecimal travelDays, String agencyCode,
			AgeTypeReq ageDetails); */

	



}
