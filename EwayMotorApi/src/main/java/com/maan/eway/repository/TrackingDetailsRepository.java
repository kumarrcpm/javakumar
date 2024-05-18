/*
 * Java domain class for entity "TrackingDetails" 
 * Created on 2021-10-09 ( Date ISO 2021-10-09 - Time 15:04:43 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */
 
 /*
 * Created on 2021-10-09 ( 15:04:43 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */


package com.maan.eway.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.maan.eway.bean.TrackingDetails;
import com.maan.eway.bean.TrackingDetailsId;

 
 
public interface TrackingDetailsRepository  extends JpaRepository<TrackingDetails,TrackingDetailsId > , JpaSpecificationExecutor<TrackingDetails> {

	List<TrackingDetails> OrderByEntryDateDesc();

}
