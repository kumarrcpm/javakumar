package com.maan.crm.service;

import java.util.List;

import com.maan.crm.req.CrmLeadSaveReq;
import com.maan.crm.res.CrmLeadSuccessRes;
import com.maan.crm.error.Error;

public interface KumarCrmService {

	List<Error> validateCrmCityMaster(CrmLeadSaveReq req);

	CrmLeadSuccessRes saveCrmCityMaster(CrmLeadSaveReq req);

}
