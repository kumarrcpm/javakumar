package com.maan.claim.service;

import java.util.List;

import com.maan.claim.req.ActEditReq;
import com.maan.claim.req.ActGridReq;
import com.maan.claim.req.ActSaveReq;
import com.maan.claim.res.ActInfoRes;
import com.maan.claim.res.SuccessRes;
import com.maan.claim.error.Error;

public interface ActInfoService {

	List<ActInfoRes> getActDetails();

	ActInfoRes getActInfo(String id);

	ActInfoRes getActDetailsById(ActEditReq req);

	SuccessRes saveActDetails(ActSaveReq req);

	List<Error> validateActDetailsReq(ActSaveReq req);

	List<Error> validateListOfActDetailsReq(List<ActSaveReq> req);

	SuccessRes saveListOfActDetails(List<ActSaveReq> req);

	ActInfoRes getActDetailsByIdWithList(ActEditReq req);

	SuccessRes saveActDetailsWithAccidentList(ActSaveReq req);

	List<Error> validateActDetailsWithAccidentList(ActSaveReq req);

	List<ActInfoRes> getActDetails2(ActGridReq req);

}         
