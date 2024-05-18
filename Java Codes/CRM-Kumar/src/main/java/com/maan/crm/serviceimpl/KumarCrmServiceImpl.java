package com.maan.crm.serviceimpl;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.maan.crm.error.Error;
import com.maan.crm.repository.KumarCrmRepository;
import com.maan.crm.req.CrmLeadSaveReq;
import com.maan.crm.res.CrmLeadSuccessRes;
import com.maan.crm.service.KumarCrmService;
@Service
@Transactional
public class KumarCrmServiceImpl implements KumarCrmService{
	@Autowired
	private KumarCrmRepository repository;
	@Autowired
	private KumarCrmService entityService;

	Gson json = new Gson();

	private Logger log = LogManager.getLogger(KumarCrmServiceImpl.class);
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	String pattern = "#####0";
	DecimalFormat decimalFormat = new DecimalFormat(pattern);


	
	// Validation 
	@Override
	public List<Error> validateCrmCityMaster(CrmLeadSaveReq req) {
		List<Error> errors = new ArrayList<Error>();
		try {
			if (StringUtils.isNotBlank(req.getLeadId())) {
				if (!StringUtils.isNumeric(req.getLeadId())) {
					errors.add(new Error("01", "Lead Id", "Please Enter Valid Lead Id "));
				}
			}
			if (req.getClientId() == null || StringUtils.isBlank(req.getClientId())) {
				errors.add(new Error("02", "Client Id", "Please Enter Client Id"));
			}
			if (req.getBusinessType() == null || StringUtils.isBlank(req.getBusinessType())) {
				errors.add(new Error("03", "Business Type", "Please Enter Business Type"));
			}else if (req.getBusinessType().length() > 100) {
				errors.add(new Error("03", "Business Type", "Please Enter Business Type within 100 Characters"));
			}
			if (req.getBusinessTypeId() == null || StringUtils.isBlank(req.getBusinessTypeId())) {
				errors.add(new Error("04", "Business Type Id", "Please Enter Business Type Id"));
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Exception is --->" + e.getMessage());
			return errors;
		}
		return errors;
	}
	
	/// Save
	@Override
	public CrmLeadSuccessRes saveCrmCityMaster(CrmLeadSaveReq req) {
		// TODO Auto-generated method stub
		return null;
	}

}
