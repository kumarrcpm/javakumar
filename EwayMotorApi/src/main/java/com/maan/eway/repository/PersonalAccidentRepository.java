package com.maan.eway.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.maan.eway.bean.PersonalAccident;
import com.maan.eway.bean.PersonalAccidentId;

public interface PersonalAccidentRepository
		extends JpaRepository<PersonalAccident, PersonalAccidentId>, JpaSpecificationExecutor<PersonalAccident> {

	

	List<PersonalAccident> findByQuoteNoAndSectionIdOrderByPersonId(String quoteNo, String sectionId);

	PersonalAccident findByQuoteNoAndRiskIdAndPersonIdAndSectionId(String quoteNo, Integer valueOf, String personId,
			String sectionId);


	List<PersonalAccident> findByQuoteNo(String quoteNo);

	List<PersonalAccident> findByQuoteNoAndSectionId(String quoteNo, String sectionId);

	List<PersonalAccident> findByQuoteNoAndType(String quoteNo, String type);

	Long countByQuoteNoAndRiskId(String quoteNo, Integer valueOf);

	void deleteByQuoteNoAndRiskId(String quoteNo, Integer valueOf);

}
