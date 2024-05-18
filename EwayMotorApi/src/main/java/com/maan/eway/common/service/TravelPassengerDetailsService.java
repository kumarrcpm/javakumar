package com.maan.eway.common.service;

import java.util.List;

import com.maan.eway.common.req.TravelPassDetailsGetAllReq;
import com.maan.eway.common.req.TravelPassDetailsGetReq;
import com.maan.eway.common.req.TravelPassDetailsSaveReq;
import com.maan.eway.common.req.TravelPassValidateReq;
import com.maan.eway.common.res.TravelPassDetailsRes;
import com.maan.eway.common.res.TravelPassHistoryRes;
import com.maan.eway.error.Error;
import com.maan.eway.res.SuccessRes;
import com.maan.eway.res.TravelPassCommonRes;

public interface TravelPassengerDetailsService {

	List<Error> validatepassdetails(TravelPassDetailsSaveReq req);

	SuccessRes savepassdetails(TravelPassDetailsSaveReq req);

	TravelPassDetailsRes getpassdetails(TravelPassDetailsGetReq req);

	SuccessRes deletepassdetails(TravelPassDetailsGetReq req);

	List<TravelPassDetailsRes> getallpassdetails(TravelPassDetailsGetAllReq req);

	List<Error> validatepassListDetails(TravelPassValidateReq req);

	TravelPassCommonRes getpassdetails(TravelPassValidateReq req);

	List<TravelPassHistoryRes> getallpasshistorydetails(TravelPassDetailsGetAllReq req);

}
