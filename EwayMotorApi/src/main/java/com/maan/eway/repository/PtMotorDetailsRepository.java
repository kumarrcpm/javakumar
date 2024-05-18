/*
 * Java domain class for entity "AcExecutiveMaster" 
 * Created on 2022-11-11 ( Date ISO 2022-11-11 - Time 13:36:48 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */
 
 /*
 * Created on 2022-11-11 ( 13:36:48 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */


package com.maan.eway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.maan.eway.bean.PtMotorDetails;
import com.maan.eway.bean.PtMotorDetailsId;
/**
 * <h2>AcExecutiveMasterRepository</h2>
 *
 * createdAt : 2022-11-11 - Time 13:36:48
 * <p>
 * Description: "AcExecutiveMaster" Repository
 */
 
 
 
public interface PtMotorDetailsRepository  extends JpaRepository<PtMotorDetails,PtMotorDetailsId > , JpaSpecificationExecutor<PtMotorDetails> {

}
