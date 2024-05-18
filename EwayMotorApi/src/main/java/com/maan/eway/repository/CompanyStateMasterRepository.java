/*
 * Java domain class for entity "ReferalMaster" 
 * Created on 2022-08-24 ( Date ISO 2022-08-24 - Time 12:58:28 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */
 
 /*
 * Created on 2022-08-24 ( 12:58:28 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */


package com.maan.eway.repository;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.maan.eway.bean.CompanyStateMaster;
import com.maan.eway.bean.CompanyStateMasterId;
import com.maan.eway.bean.StateMaster;
import com.maan.eway.bean.StateMasterId;
/**
 * <h2>ReferalMasterRepository</h2>
 *
 * createdAt : 2022-08-24 - Time 12:58:28
 * <p>
 * Description: "ReferalMaster" Repository
 */
 
 
 
public interface CompanyStateMasterRepository  extends JpaRepository<CompanyStateMaster,CompanyStateMasterId > , JpaSpecificationExecutor<CompanyStateMaster> {




}
