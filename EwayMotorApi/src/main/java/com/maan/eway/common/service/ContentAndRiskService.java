package com.maan.eway.common.service;

import java.util.List;

import com.maan.eway.common.req.ContentAndRiskSaveReq;
import com.maan.eway.common.req.ContentRiskGetAllReq;
import com.maan.eway.common.req.ContentRiskGetReq;
import com.maan.eway.common.res.ContentRiskGetRes;
import com.maan.eway.common.res.ContentRiskGetallRes;
import com.maan.eway.error.Error;
import com.maan.eway.res.SuccessRes;

public interface ContentAndRiskService {

	List<Error> validatecontentrisk(ContentAndRiskSaveReq req);

	SuccessRes savecontentrisk(ContentAndRiskSaveReq req);

	ContentRiskGetRes getcontentrisk(ContentRiskGetReq req);

	ContentRiskGetallRes getallcontentrisk(ContentRiskGetAllReq req);

	
}
