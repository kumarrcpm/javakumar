/*
*  Copyright (c) 2019. All right reserved
* Created on 2022-10-06 ( Date ISO 2022-10-06 - Time 15:40:39 )
* Generated by Telosys Tools Generator ( version 3.3.0 )
*/
package com.maan.eway.service;
import java.util.List;

import com.maan.eway.bean.MotorVehicleInfo;
import com.maan.eway.error.Error;
import com.maan.eway.req.MotorTiraMsgReq;

import com.maan.eway.req.TiraMsg;

import com.maan.eway.req.MotorVehicleInfoGetAllReq;
import com.maan.eway.req.MotorVehicleInfoGetReq;
import com.maan.eway.req.MotorVehicleInfoSaveReq;
import com.maan.eway.res.MotorSaveRes;
import com.maan.eway.res.MotorTiraMsgRes;
import com.maan.eway.res.MotorVehicleInfoRes;
import com.maan.eway.res.SuccessRes;
/**
* <h2>MotorVehicleInfoServiceimpl</h2>
*/
public interface RegulatoryInfoService  {

SuccessRes saveMotorInfo(TiraMsg req, MotorTiraMsgRes res);

SuccessRes saveMotorInfo(MotorTiraMsgReq req, MotorTiraMsgRes res);

MotorVehicleInfoRes getVehicleInfo(MotorVehicleInfoGetReq req);

List<MotorVehicleInfoRes> getallVehicleInfo(MotorVehicleInfoGetAllReq req);

MotorSaveRes saveVehicleInfo(MotorVehicleInfoSaveReq req);

List<Error> validateVehicleInfo(MotorVehicleInfoSaveReq req);

}