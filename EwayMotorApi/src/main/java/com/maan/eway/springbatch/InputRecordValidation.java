package com.maan.eway.springbatch;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.maan.eway.batch.entity.EwayEmplyeeDetailRaw;
import com.maan.eway.batch.repository.EwayEmplyeeDetailRawRepository;
import com.maan.eway.batch.res.UpdateRecordReq;
import com.maan.eway.error.Error;

@Component
public class InputRecordValidation {
	
	@Autowired
	private EwayEmplyeeDetailRawRepository empRepo;
	
	
	public List<Error> validateEmployee(UpdateRecordReq req){
		List<Error> list = new ArrayList<Error>();
		try {
			if(StringUtils.isBlank(req.getDateOfBirth())) {
				list.add(new Error("1","DateOfBirth","Please enter dateOfBirth"));
			}if(StringUtils.isBlank(req.getDateOfJoiningYear())) {
				list.add(new Error("1","DateOfJoiningYear","Please enter DateOfJoiningYear"));
			}if(StringUtils.isBlank(req.getDateOfJoiningMonth())) {
				list.add(new Error("1","DateOfJoiningMonth","Please enter DateOfJoiningMonth"));
			}
			if(StringUtils.isBlank(req.getEmployeeName())) {
				list.add(new Error("1","EmployeeName","Please enter EmployeeName"));
			}if(StringUtils.isBlank(req.getNationalityId())) {
				list.add(new Error("1","NationalityId","Please enter NationalityId"));
			}if(StringUtils.isBlank(req.getOccupationDesc())) {
				list.add(new Error("1","OccupationDesc","Please enter OccupationDesc"));
			}if(StringUtils.isBlank(req.getOccupationId())) {
				list.add(new Error("1","OccupationId","Please enter OccupationId"));
			}if(StringUtils.isBlank(req.getSalary())) {
				list.add(new Error("1","Salary","Please enter Salary"));
			}
			EwayEmplyeeDetailRaw emp =empRepo.findByCompanyIdAndProductIdAndQuoteNoAndRiskIdAndRequestReferenceNoAndNationalityIdAndStatusIgnoreCase(Integer.valueOf(req.getCompanyId()),
					Integer.valueOf(req.getProductId()),req.getQuoteNo(),Integer.valueOf(req.getRiskId()),req.getRequestRefNo(),req.getNationalityId(),"Y");
			if(emp!=null) {
				list.add(new Error("1","NationalityId","NationalityId already exists"));
			}
			
			List<EwayEmplyeeDetailRaw> empList =empRepo.findByCompanyIdAndProductIdAndQuoteNoAndRiskIdAndRequestReferenceNo(Integer.valueOf(req.getCompanyId()),
					Integer.valueOf(req.getProductId()),req.getQuoteNo(),Integer.valueOf(req.getRiskId()),req.getRequestRefNo());
			
			Double upoadedSumInsured =empList.stream()
					.filter(e ->e.getRowNum()!=Integer.valueOf(req.getRowNum()))
					.collect(Collectors.summingDouble(e ->Double.valueOf(e.getSalary())));
			
			Double totalUploadSumIn =upoadedSumInsured + Double.valueOf(req.getSalary());
			
			Double totalSumInsured =empRepo.getToalPremium(req.getQuoteNo()).doubleValue();
			
			
			if(Double.compare(totalUploadSumIn, totalSumInsured)>0) {
				list.add(new Error("1","Suminured","Suminured limit has exceeded ..Please change your employee salary limit lesser than actual suminured "+totalSumInsured+""));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list ;
	}
	
	

}
