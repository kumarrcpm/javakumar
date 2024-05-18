package com.maan.claim.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.maan.claim.entity.AccidentInfo;

//pass BigDecimal if table contains only one primary key in table
public interface AccidentInfoRepository
		extends JpaRepository<AccidentInfo, BigDecimal>, JpaSpecificationExecutor<AccidentInfo> {
	
	AccidentInfo findByCasenumber(BigDecimal casenumber);
	
	//List<AccidentInfo> OrderByCasenumberDesc();
	List<AccidentInfo> OrderByEntrydateDesc();

	List<AccidentInfo> findByCityidOrderByEntrydateDesc(String cityId);

	List<AccidentInfo> OrderByCasenumberDesc();
}