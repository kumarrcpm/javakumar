/*
 * Java domain class for entity "ProductMaster" 
 * Created on 2022-08-24 ( Date ISO 2022-08-24 - Time 12:58:28 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */
 
 /*
 * Created on 2022-08-24 ( 12:58:28 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */


package com.maan.eway.repository;

import java.math.BigDecimal;
import java.util.List;

import com.maan.eway.bean.CurrencyMaster;
import com.maan.eway.bean.CurrencyMasterId;
import com.maan.eway.bean.OccupationMaster;
import com.maan.eway.bean.OccupationMasterId;
import com.maan.eway.bean.ProductMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.maan.eway.bean.ProductMasterId;
/**
 * <h2>ProductMasterRepository</h2>
 *
 * createdAt : 2022-08-24 - Time 12:58:28
 * <p>
 * Description: "ProductMaster" Repository
 */
 
 
 
public interface OccupationMasterRepository  extends JpaRepository<OccupationMaster,OccupationMasterId > , JpaSpecificationExecutor<OccupationMaster> {

	OccupationMaster findByOccupationId(String occupation);

	List<OccupationMaster> findByOccupationId(Integer valueOf);



}
