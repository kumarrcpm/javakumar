/*
*  Copyright (c) 2019. All right reserved
* Created on 2022-11-30 ( Date ISO 2022-11-30 - Time 17:06:34 )
* Generated by Telosys Tools Generator ( version 3.3.0 )
*/
package com.maan.eway.common.service;
import com.maan.eway.bean.EserviceTravelDetails;
import com.maan.eway.common.req.EserviceSaveRes;
import com.maan.eway.common.req.EserviceTravelDeleteReq;
import com.maan.eway.common.req.EserviceTravelGetAllReq;
import com.maan.eway.common.req.EserviceTravelGetReq;
import com.maan.eway.common.req.EserviceTravelSaveReq;
import com.maan.eway.common.res.EserviceTravelGetRes;
import com.maan.eway.common.res.SuccessRes;
import com.maan.eway.error.Error;

import java.util.List;
/**
* <h2>EserviceTravelDetailsServiceimpl</h2>
*/
public interface EserviceTravelDetailsService  {

EserviceTravelDetails create(EserviceTravelDetails d);
EserviceTravelDetails update(EserviceTravelDetails d);
//EserviceTravelDetails getOne(long id) ;
 List<EserviceTravelDetails> getAll();
long getTotal();
//boolean delete(long id);
List<Error> validateTravelDetails(EserviceTravelSaveReq req);
EserviceSaveRes saveTravelDetails(EserviceTravelSaveReq req);
EserviceTravelGetRes getTravelDetails(EserviceTravelGetReq req);
SuccessRes deleteTravelDetails(EserviceTravelDeleteReq req);
List<EserviceTravelGetRes> getallTravelDetails(EserviceTravelGetAllReq req);

}
