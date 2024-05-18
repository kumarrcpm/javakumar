package com.maan.eway.common.service;

import java.util.List;

import com.maan.eway.common.req.BuildingDetailsGetAllReq;
import com.maan.eway.common.req.BuildingDetailsGetReq;
import com.maan.eway.common.req.BuildingDetailsSaveReq;
import com.maan.eway.common.res.BuildingDetailsGetRes;
import com.maan.eway.error.Error;
import com.maan.eway.res.SuccessRes;

public interface BuildingDetailsService {

	List<Error> validatebuildingDetails(List<BuildingDetailsSaveReq> req);

	SuccessRes savebuildingDetails(List<BuildingDetailsSaveReq> req);

	List<BuildingDetailsGetRes> getallbuildingDetails(BuildingDetailsGetAllReq req);

	BuildingDetailsGetRes getbuildingDetails(BuildingDetailsGetReq req);

	SuccessRes deleteBuildingDetails(BuildingDetailsGetReq req);

}
