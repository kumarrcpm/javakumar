/*
 * Java domain class for entity "MsVehicleDetails" 
 * Created on 2022-10-19 ( Date ISO 2022-10-19 - Time 17:10:35 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */
 
 /*
 * Created on 2022-10-19 ( 17:10:35 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */


package com.maan.eway.repository;

import java.math.BigDecimal;
import java.util.List;

import com.maan.eway.bean.MsVehicleDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.maan.eway.bean.MsVehicleDetailsId;
/**
 * <h2>MsVehicleDetailsRepository</h2>
 *
 * createdAt : 2022-10-19 - Time 17:10:35
 * <p>
 * Description: "MsVehicleDetails" Repository
 */
 
 
 
public interface MsVehicleDetailsRepository  extends JpaRepository<MsVehicleDetails,MsVehicleDetailsId > , JpaSpecificationExecutor<MsVehicleDetails> {

	List<MsVehicleDetails> findByChassisNumber(String chassisNumber);

	MsVehicleDetails findByVdRefno(Long valueOf);

}
