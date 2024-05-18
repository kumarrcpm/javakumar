package com.maan.eway.repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.maan.eway.bean.MotorColorMaster;
import com.maan.eway.bean.MotorColorMasterId;

public interface MotorColorMasterRepository
		extends JpaRepository<MotorColorMaster, MotorColorMasterId>,
		JpaSpecificationExecutor<MotorColorMaster> {


}
