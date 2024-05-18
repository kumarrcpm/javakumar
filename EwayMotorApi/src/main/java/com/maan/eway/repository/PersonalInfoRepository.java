/*
 * Java domain class for entity "PersonalInfo" 
 * Created on 2022-11-09 ( Date ISO 2022-11-09 - Time 18:32:27 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */
 
 /*
 * Created on 2022-11-09 ( 18:32:27 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */


package com.maan.eway.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.maan.eway.bean.PersonalInfo;
import com.maan.eway.bean.PersonalInfoId;
/**
 * <h2>PersonalInfoRepository</h2>
 *
 * createdAt : 2022-11-09 - Time 18:32:27
 * <p>
 * Description: "PersonalInfo" Repository
 */
 
 
 
public interface PersonalInfoRepository  extends JpaRepository<PersonalInfo,PersonalInfoId > , JpaSpecificationExecutor<PersonalInfo> {
 

	PersonalInfo findByCustomerId(String customerId);
 
	List<PersonalInfo> findByCompanyIdAndCustomerId(String companyId,String customerId);
} 
