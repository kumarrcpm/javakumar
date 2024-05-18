/*
 * Java domain class for entity "MotorVehicleInfo" 
 * Created on 2022-10-06 ( Date ISO 2022-10-06 - Time 15:40:39 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */
 
 /*
 * Created on 2022-10-06 ( 15:40:39 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */


package com.maan.eway.repository;

import java.math.BigDecimal;
import java.util.Date;

import com.maan.eway.bean.MotorVehicleInfo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.maan.eway.bean.MotorVehicleInfoId;
/**
 * <h2>MotorVehicleInfoRepository</h2>
 *
 * createdAt : 2022-10-06 - Time 15:40:39
 * <p>
 * Description: "MotorVehicleInfo" Repository
 */
 
 
 
public interface MotorVehicleInfoRepository  extends JpaRepository<MotorVehicleInfo,MotorVehicleInfoId > , JpaSpecificationExecutor<MotorVehicleInfo> {

	MotorVehicleInfo findByResRegNumberAndResChassisNumber(String regNo, String chassisNo);

	MotorVehicleInfo findByResRegNumber(String reqRegNumber);

	MotorVehicleInfo findByResChassisNumber(String reqChassisNumber);

	Page<MotorVehicleInfo> findByEntryDateBetween(Pageable paging, Date effDate, Date endDate);

	

}