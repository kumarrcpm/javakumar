/*
*  Copyright (c) 2019. All right reserved
* Created on 2021-10-12 ( Date ISO 2021-10-12 - Time 16:17:06 )
* Generated by Telosys Tools Generator ( version 3.3.0 )
*/
package com.maan.travel.serviceimpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maan.travel.req.PrintReqService;

/**
 * <h2>BankBranchMasterServiceimpl</h2>
 */
@Service
@Transactional
public class PrintReqServiceImpl implements PrintReqService {

	
	private Logger log = LogManager.getLogger(PrintReqServiceImpl.class);
	
	public String reqPrint(Object response) {
		ObjectMapper mapper = new ObjectMapper();
		String resp = "";
		try {
			// log.info(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(response));
			// resp = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(response);
			resp = mapper.writeValueAsString(response);
			log.info(resp);
		} catch (Exception e) {
			log.error(e);
		}
		return resp;
	}

}