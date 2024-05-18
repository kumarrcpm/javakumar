package com.maan.eway.common.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maan.eway.bean.TravelPolicyType;
import com.maan.eway.common.req.TravelPolicyTypeGetReq;
import com.maan.eway.common.res.TravelPolicyTypeCoverRes;
import com.maan.eway.common.res.TravelPolicyTypeRes;
import com.maan.eway.common.res.TravelPolicyTypeSubCoverRes;
import com.maan.eway.common.service.TravelPolicyTypeService;
import com.maan.eway.repository.ListItemValueRepository;
import com.maan.eway.repository.TravelPolicyTypeRepository;


@Service
@Transactional
public class TravelPolicyTypeServiceImpl  implements TravelPolicyTypeService{
	
	@Autowired
	private TravelPolicyTypeRepository repo;

	private Logger log=LogManager.getLogger(TravelPolicyTypeServiceImpl.class);

	@Autowired
	private ListItemValueRepository listRepo;

	@Override
	public List<TravelPolicyTypeRes> getTravelPolicyType(TravelPolicyTypeGetReq req) {
		List<TravelPolicyTypeRes> resList = new ArrayList<TravelPolicyTypeRes>();
		DozerBeanMapper dozermapper = new DozerBeanMapper();
		try {
			TravelPolicyTypeRes res = new TravelPolicyTypeRes();
			List<TravelPolicyType> datas =  repo.findByPolicyTypeIdAndPlanTypeId(Integer.valueOf(req.getPolicyTypeId()),Integer.valueOf( req.getPlanTypeId()));
			List<TravelPolicyTypeCoverRes> coverList = new ArrayList<TravelPolicyTypeCoverRes>();
			TravelPolicyTypeCoverRes coverRes = new TravelPolicyTypeCoverRes();
		
			if(datas.size()>0) {
			for(TravelPolicyType data : datas) {
			if(data.getCoverId().toString().equalsIgnoreCase("0")) {
				coverRes = dozermapper.map(data,TravelPolicyTypeCoverRes.class );
				coverRes.setCoverId(data.getSubCoverId().toString());
				coverRes.setCoverDesc(data.getSubCoverDesc());
				List<TravelPolicyType> covers = repo.findByPolicyTypeIdAndPlanTypeIdAndCoverId(Integer.valueOf(req.getPolicyTypeId()), Integer.valueOf(req.getPlanTypeId()),Integer.valueOf(data.getSubCoverId()));
				List<TravelPolicyTypeSubCoverRes> subCoverList = new ArrayList<TravelPolicyTypeSubCoverRes>();				
				for(TravelPolicyType cover : covers) {
				TravelPolicyTypeSubCoverRes subCoverRes = new TravelPolicyTypeSubCoverRes();		
				subCoverRes = dozermapper.map(cover,TravelPolicyTypeSubCoverRes.class);
				subCoverList.add(subCoverRes);
				}
				coverRes.setTravelSubCover(subCoverList);
				coverList.add(coverRes);
				res.setTravelCover(coverList);

			}
			}
			
			res.setPlanTypeId(datas.get(0).getPlanTypeId().toString());
			res.setPlanTypeDesc(datas.get(0).getPlanTypeDesc());
			res.setPolicyTypeId(datas.get(0).getPolicyTypeId().toString());
			res.setPolicyTypeDesc(datas.get(0).getPolicyTypeDesc());			
			resList.add(res);
			}
			
			if(datas.size()<0){
				res.setPlanTypeDesc(null);
				res.setPlanTypeId(null);
				res.setPolicyTypeDesc(null);
				res.setPolicyTypeId(null);
				res.setTravelCover(null);
				resList.add(res);;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info("Log Details"+e.getMessage());
			return null;
		}
		return resList;
	}

	

}
