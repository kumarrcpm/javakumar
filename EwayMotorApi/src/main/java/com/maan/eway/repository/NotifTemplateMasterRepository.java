/*
 * Java domain class for entity "NotifTemplateMaster" 
 * Created on 2022-09-30 ( Date ISO 2022-09-30 - Time 18:45:40 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */
 
 /*
 * Created on 2022-09-30 ( 18:45:40 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */


package com.maan.eway.repository;

import java.math.BigDecimal;

import com.maan.eway.bean.NotifTemplateMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.maan.eway.bean.NotifTemplateMasterId;
/**
 * <h2>NotifTemplateMasterRepository</h2>
 *
 * createdAt : 2022-09-30 - Time 18:45:40
 * <p>
 * Description: "NotifTemplateMaster" Repository
 */
 
 
 
public interface NotifTemplateMasterRepository  extends JpaRepository<NotifTemplateMaster,NotifTemplateMasterId > , JpaSpecificationExecutor<NotifTemplateMaster> {

}
