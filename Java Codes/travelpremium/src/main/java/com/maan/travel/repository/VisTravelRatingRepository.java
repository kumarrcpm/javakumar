package com.maan.travel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.maan.travel.entity.VisTravelRatingEntity;

public interface VisTravelRatingRepository extends JpaRepository<VisTravelRatingEntity,Double > , JpaSpecificationExecutor<VisTravelRatingEntity>{

	
//	List<VisTravelRatingEntity> findByTypeIdAndCoverIdAndTravelStartDateGreaterThanEqualAndTravelEndDateLessThanEqualAndAgeFromGreaterThanAndAgeToLessThanEqualAndAgencyCode(String typeId, BigDecimal coverId,Date travelStartDate, Date travelEndDate, BigDecimal ageFrom, BigDecimal ageTo, String agencyCode );

	List<VisTravelRatingEntity> findByTypeIdAndCoverIdAndTravelStartDateGreaterThanEqualAndTravelEndDateLessThanEqualAndAgeFromGreaterThanAndAgeToLessThanEqualAndAgencyCode(
			String typeId, String coverId, String travelStartDate, String travelEndDate, String ageFrom, String ageTo,
			String agencyCode);



}
