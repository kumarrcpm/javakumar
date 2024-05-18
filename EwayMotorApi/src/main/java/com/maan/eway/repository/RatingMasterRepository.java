/*
 * Java domain class for entity "RatingMaster" 
 * Created on 2022-08-24 ( Date ISO 2022-08-24 - Time 12:58:28 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */
 
 /*
 * Created on 2022-08-24 ( 12:58:28 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */


package com.maan.eway.repository;

import java.math.BigDecimal;

import com.maan.eway.bean.RatingMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.maan.eway.bean.RatingMasterId;
/**
 * <h2>RatingMasterRepository</h2>
 *
 * createdAt : 2022-08-24 - Time 12:58:28
 * <p>
 * Description: "RatingMaster" Repository
 */
 
 
 
public interface RatingMasterRepository  extends JpaRepository<RatingMaster,RatingMasterId > , JpaSpecificationExecutor<RatingMaster> {

	

}