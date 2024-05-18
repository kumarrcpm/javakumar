package com.maan.eway.common.service.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maan.eway.bean.CommonDataDetails;
import com.maan.eway.bean.CompanyProductMaster;
import com.maan.eway.bean.ProductEmployeeDetails;
import com.maan.eway.common.req.ProductEmployeeDeleteReq;
import com.maan.eway.common.req.ProductEmployeeSaveReq;
import com.maan.eway.common.req.ProductEmployeesGetReq;
import com.maan.eway.common.res.ProductEmployeeGetRes;
import com.maan.eway.common.service.ProductEmployeesDetailsService;
import com.maan.eway.error.Error;
import com.maan.eway.repository.CommonDataDetailsRepository;
import com.maan.eway.repository.ProductEmployeesDetailsRepository;
import com.maan.eway.res.SuccessRes;

@Service
@Transactional
public class ProductEmployeesDetailsDetailsServiceImpl implements ProductEmployeesDetailsService {

	@Autowired 
	private CommonDataDetailsRepository commonRepo;
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private ProductEmployeesDetailsRepository productRepo;


	private Logger log = LogManager.getLogger(ProductEmployeesDetailsDetailsServiceImpl.class);
 
	@Override
	public List<Error> validateProductEmployeesDetails(List<ProductEmployeeSaveReq> reqList) {
		List<Error> error = new ArrayList<Error>();

		try {
			List<String> nationalityIds = new ArrayList<String>();
			
			Long row = 0L ;
			BigDecimal sumInsured = BigDecimal.ZERO ;
			String quoteNo = "" ;
			CommonDataDetails commonData = new CommonDataDetails();
			
			if(reqList!=null && reqList.size()> 0 && StringUtils.isNotBlank(reqList.get(0).getQuoteNo() )  ) {
				commonData = commonRepo.findByQuoteNo(reqList.get(0).getQuoteNo() );
				quoteNo = reqList.get(0).getQuoteNo() ;
			}  else {
				error.add(new Error("01", "QuoteNo", "Please Enter Atleat one Employee Details "));
			}
			Long reqempId  = StringUtils.isBlank( reqList.get(0).getEmployeeId() ) ? null : Long.valueOf( reqList.get(0).getEmployeeId())  ;
			
			
			for(ProductEmployeeSaveReq req : reqList) {
				row = row +1;
				if (StringUtils.isBlank(req.getQuoteNo())) {
					error.add(new Error("01", "QuoteNo", "Please Select QuoteNo in Row : " + row));
				}
				
				if (StringUtils.isBlank(req.getCreatedBy())) {
					error.add(new Error("01", "CreatedBy", "Please Select CreatedBy in Row : " + row));
				}
				
				if (StringUtils.isBlank(req.getNationalityId())) {
					error.add(new Error("01", "NationalityId", "Please Select NationalityId in Row : " + row));
					
				} else {
					List<String> filterIds = nationalityIds.stream().filter( o -> o.equalsIgnoreCase(req.getNationalityId()) ).collect(Collectors.toList());
					if(filterIds.size() >0  ) {
						error.add(new Error("01", "NationalityId", "Duplicate NationalityId in Row : " + row));
					} else {
						nationalityIds.add(req.getNationalityId());
					}
					
				}
				
				if (StringUtils.isBlank(req.getRequestReferenceNo())) {
					error.add(new Error("01", "RequestReferenceNo", "Please Select RequestReferenceNo in Row : " + row));
				}
				
				if (StringUtils.isBlank(req.getRequestReferenceNo())) {
					error.add(new Error("01", "RequestReferenceNo", "Please Select RequestReferenceNo in Row : " + row));
				}
				
				if (StringUtils.isBlank(req.getRiskId())) {
					error.add(new Error("01", "RiskId", "Please Select RiskId in Row : " + row));
				}
				
				// Date Of Birth Validation
				Calendar cal = Calendar.getInstance();
				Date today = new Date();
				cal.setTime(today);
				cal.add(Calendar.DAY_OF_MONTH, -1);
				cal.set(Calendar.HOUR_OF_DAY, 23);
				cal.set(Calendar.MINUTE, 50);
				today = cal.getTime();
				
				if (req.getDateOfBirth() == null) {
					error.add(new Error("38", "DateOfBirth", "Please Select Date Of Birth in Row : " + row));

				} else if (req.getDateOfBirth().after(today)) {
					error.add(new Error("38", "DateOfBirth", "Please Select Date Of Birth as Past Date in Row : " + row));

				} else {
					LocalDate localDate1 = req.getDateOfBirth().toInstant().atZone(ZoneId.systemDefault())
							.toLocalDate();
					LocalDate localDate2 = today.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

					Integer years = Period.between(localDate1, localDate2).getYears();
					if (years > 100) {
						error.add(new Error("38", "DateOfBirth", "Date Of Birth Not Accepted More than 100 Years in Row : " + row));

					} else if (years < 18) {
						error.add(new Error("38", "DateOfBirth", "Date Of Birth Not Accepted Less than 18 Years For Induvidual in Row : " + row));

					}

				}
//				if (StringUtils.isBlank(req.getDateOfJoiningMonth())) {
//					error.add(new Error("50", "DateOfJoiningMonth", "Please Enter Date Of Joining Month in Row : " + row));
//					
//				}
//				
				// Date Of Joining
				int year = Calendar.getInstance().get(Calendar.YEAR);

				if (StringUtils.isBlank(req.getDateOfJoiningYear())) {
					error.add(new Error("33", "DateOfJoiningYear", "Please Enter Date Of Joining Year in Row : " + row));
					
				} else if (StringUtils.isNotBlank(req.getDateOfJoiningYear())) {
					Integer year1 = Integer.valueOf(req.getDateOfJoiningYear());
					Integer diff = year - year1;
					 if ((StringUtils.isNotBlank(req.getDateOfJoiningYear())	&& !req.getDateOfJoiningYear().matches("[0-9]+")) || req.getDateOfJoiningYear().length() > 4) {
						error.add(new Error("33", "DateOfJoiningYear", "Please Enter Date Of Joining Format in YYYY in Row : " + row));
					} else if ((StringUtils.isNotBlank(req.getDateOfJoiningYear()) && !req.getDateOfJoiningYear().matches("[0-9]+")) || req.getDateOfJoiningYear().length() < 4) {
						error.add(new Error("33", "DateOfJoiningYear","Please Enter Date Of Joining Format in YYYY  in Row : " + row));
					}
					else if (StringUtils.isNotBlank(req.getDateOfJoiningYear())){
						if(year1>year) {
							error.add(new Error("33", "DateOfJoiningYear","Please Enter Date Of Joining as Past Year  in Row : " + row));
						}
						else if(diff>50) {
							error.add(new Error("33", "DateOfJoiningYear","Please Enter Date Of Joining within 50 years  in Row : " + row));
						}
					}
				}
				
				if (StringUtils.isBlank(req.getEmployeeName()) ) {
					error.add(new Error("03", "Employee Name ", "Please Enter Employee Name In Row No : " + row));
				} else if ((StringUtils.isNotBlank(req.getEmployeeName()))&&!req.getEmployeeName().matches("[A-Z a-z]+")) {
					error.add(new Error("04", "Employee Name ", "Please Enter Valid Employee Name  In Row No:" + row ));
				}
				
				// Drop Downs
				if(  reqempId ==null  ) {
					if (StringUtils.isBlank(req.getSalary())) {
						error.add(new Error("08", "Salary", "Please Enter Employee Salary In Row No : " + row));
					} else if (!req.getSalary().matches("[0-9.]+")  || Double.valueOf(req.getSalary()) <=0 ) {
						error.add(new Error("09", "Salary", "Please Enter Valid Number In Employee Salary  In Row No : " + row));
					} else {
						sumInsured = sumInsured.add(new BigDecimal(req.getSalary()));
					}
				}
				
			}
			
			if(StringUtils.isNotBlank(quoteNo)  ) {
				if(commonData.getSumInsured()!=null && sumInsured.compareTo(commonData.getSumInsured()) > 0  ) {
					error.add(new Error("03", "SumInsured", "Employees Total Salary Greater Than Actual SumInsured" ));
				}
				
			}
		
	} catch (Exception e) {

		log.error(e);
		e.printStackTrace();
		error.add(new Error("03", "Common Error", e.getMessage()));
	}
	return error;
}

	
	@Override
	@Transactional
	public SuccessRes saveProductEmployeesDetails(List<ProductEmployeeSaveReq> reqList) {
		// TODO Auto-generated method stub
		SuccessRes res = new SuccessRes();
		
		try {
			String quoteNo = reqList.get(0).getQuoteNo() ;
			Integer riskId = Integer.valueOf(reqList.get(0).getRiskId()) ;
			Integer productId = Integer.valueOf(reqList.get(0).getProductId()) ;
			String refNo = reqList.get(0).getRequestReferenceNo() ;
			String companyId = reqList.get(0).getInsuranceId() ;
			Date entryDate = new Date();
			String createdBy = reqList.get(0).getCreatedBy() ;
			String productName =   getCompanyProductMasterDropdown(companyId , productId.toString() );
			Long reqempId  = StringUtils.isBlank( reqList.get(0).getEmployeeId() ) ? null : Long.valueOf( reqList.get(0).getEmployeeId())  ;
			
			List<ProductEmployeeDetails> saveList = new ArrayList<ProductEmployeeDetails>();
			// Drop Downs
			if(  reqempId ==null  ) {
				Long count = productRepo.countByQuoteNoAndRiskId(quoteNo , riskId  );
				if (count > 0 ) {
					productRepo.deleteByQuoteNoAndRiskId(quoteNo, riskId);
				} 
			}
			
			Long empId = 0L ;
			// Map List
			for (ProductEmployeeSaveReq req : reqList ) {
				if(  reqempId !=null  ) {
					empId = Long.valueOf(req.getEmployeeId()) ;
				} else {
					empId = empId + 1L ;
				}
				
				ProductEmployeeDetails saveRes = new ProductEmployeeDetails();
				saveRes.setDateOfBirth( req.getDateOfBirth());
				saveRes.setDateOfJoiningYear(Integer.valueOf(req.getDateOfJoiningYear()) );
				saveRes.setDateOfJoiningMonth(req.getDateOfJoiningMonth());			
				saveRes.setCompanyId(companyId);
				saveRes.setCreatedBy(createdBy);
				saveRes.setEmployeeId(empId);
				saveRes.setEmployeeName(req.getEmployeeName());
				saveRes.setEntryDate(entryDate);
				saveRes.setOccupationId(req.getOccupationId());
				saveRes.setOccupationDesc(req.getOccupationDesc());
				saveRes.setProductId(productId);
				saveRes.setQuoteNo(quoteNo);
				saveRes.setRequestReferenceNo(refNo);
				saveRes.setRiskId(riskId);
				saveRes.setStatus("Y");
				saveRes.setSalary(new BigDecimal(req.getSalary()));
				saveRes.setNationalityId(req.getNationalityId());
				saveRes.setProductDesc(productName);
				
				saveList.add(saveRes);
				
			}
			
			// Save All
			productRepo.saveAllAndFlush(saveList);
			res.setResponse("Saved Successfully");
			res.setSuccessId(riskId.toString() );;
				
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Log Details" + e.getMessage());
			return null;
		}
	
		return res;
	}

	@Override
	public List<ProductEmployeeGetRes> getallProductEmployeesDetails(ProductEmployeesGetReq req) {
		// TODO Auto-generated method stub
		List<ProductEmployeeGetRes> resList = new ArrayList<ProductEmployeeGetRes>();
		try {
			List<ProductEmployeeDetails> datas = productRepo.findByQuoteNoAndRiskIdOrderByEmployeeIdAsc(req.getQuoteNo() , Integer.valueOf(req.getRiskId()));

			
			datas.forEach( data ->  {
				ProductEmployeeGetRes res = new ProductEmployeeGetRes();
				res.setDateOfBirth( data.getDateOfBirth());
				res.setDateOfJoiningYear(data.getDateOfJoiningYear().toString());
				res.setDateOfJoiningMonth(data.getDateOfJoiningMonth());
				res.setCreatedBy(data.getCreatedBy());
				res.setEmployeeId(data.getEmployeeId().toString());
				res.setEmployeeName(data.getEmployeeName());
				res.setEntryDate(data.getEntryDate());
				res.setOccupationDesc(data.getOccupationDesc());
				res.setOccupationId(data.getOccupationId());
				res.setQuoteNo(data.getQuoteNo());
				res.setRequestReferenceNo(data.getRequestReferenceNo());
				res.setRiskId(data.getRiskId().toString());
				res.setSalary(data.getSalary().toPlainString());
				res.setProductId(data.getProductId().toString());
				res.setProductDesc(data.getProductDesc());
				res.setNationalityId(data.getNationalityId());
				res.setInsuranceId(data.getCompanyId());
				
				resList.add(res);
			} ) ;
			
				
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info("Log Details"+e.getMessage());
			return null;
		}
		return resList;
	}

	@Override
	public SuccessRes deleteProductEmployeesDetails(ProductEmployeeDeleteReq req) {
		SuccessRes res = new SuccessRes();
		try {
			
			Long count = productRepo.countByQuoteNoAndRiskIdAndEmployeeId(req.getQuoteNo() ,Integer.valueOf(req.getRiskId()) , Long.valueOf(req.getEmployeeId()));
			if(count > 0 ) {
				productRepo.deleteByQuoteNoAndRiskIdAndEmployeeId(req.getQuoteNo() ,Integer.valueOf(req.getRiskId()) , Long.valueOf(req.getEmployeeId()));
			}
			res.setResponse("Deleted Successfully") ;
			res.setSuccessId(req.getQuoteNo()) ;;
				
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info("Log Details"+e.getMessage());
			return null;
		}
		return res;
	}

	
	public String getCompanyProductMasterDropdown(String companyId , String productId) {
		String productName = "";
		try {
			Date today = new Date();
			Calendar cal = new GregorianCalendar();
			cal.setTime(today);
			cal.set(Calendar.HOUR_OF_DAY, 23);;
			cal.set(Calendar.MINUTE, 1);
			today = cal.getTime();
			cal.set(Calendar.HOUR_OF_DAY, 1);
			cal.set(Calendar.MINUTE, 1);
			Date todayEnd = cal.getTime();
			
			// Criteria
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<CompanyProductMaster> query=  cb.createQuery(CompanyProductMaster.class);
			List<CompanyProductMaster> list = new ArrayList<CompanyProductMaster>();
			// Find All
			Root<CompanyProductMaster> c = query.from(CompanyProductMaster.class);
			//Select
			query.select(c);
			// Order By
			List<Order> orderList = new ArrayList<Order>();
			orderList.add(cb.asc(c.get("productName")));
			
			// Effective Date Start Max Filter
			Subquery<Long> effectiveDate = query.subquery(Long.class);
			Root<CompanyProductMaster> ocpm1 = effectiveDate.from(CompanyProductMaster.class);
			effectiveDate.select(cb.max(ocpm1.get("effectiveDateStart")));
			Predicate a1 = cb.equal(c.get("productId"),ocpm1.get("productId"));
			Predicate a2 = cb.equal(c.get("companyId"),ocpm1.get("companyId"));
			Predicate a3 = cb.lessThanOrEqualTo(ocpm1.get("effectiveDateStart"), today);
			effectiveDate.where(a1,a2,a3);
			// Effective Date End Max Filter
			Subquery<Long> effectiveDate2 = query.subquery(Long.class);
			Root<CompanyProductMaster> ocpm2 = effectiveDate2.from(CompanyProductMaster.class);
			effectiveDate2.select(cb.max(ocpm2.get("effectiveDateEnd")));
			Predicate a4 = cb.equal(c.get("productId"),ocpm2.get("productId"));
			Predicate a5 = cb.equal(c.get("companyId"),ocpm2.get("companyId"));
			Predicate a6 = cb.greaterThanOrEqualTo(ocpm2.get("effectiveDateEnd"), todayEnd);
			effectiveDate2.where(a4,a5,a6);
			
			// Where
			Predicate n1 = cb.equal(c.get("status"),"Y");
			Predicate n2 = cb.equal(c.get("effectiveDateStart"),effectiveDate);
			Predicate n3 = cb.equal(c.get("effectiveDateEnd"),effectiveDate2);	
			Predicate n4 = cb.equal(c.get("companyId"),companyId);
			Predicate n5 = cb.equal(c.get("productId"),productId);
			query.where(n1,n2,n3,n4,n5).orderBy(orderList);
			// Get Result
			TypedQuery<CompanyProductMaster> result = em.createQuery(query);
			list = result.getResultList();
			productName  = list.size()> 0 ? list.get(0).getProductName() : "";	
		}
			catch(Exception e) {
				e.printStackTrace();
				log.info("Exception is --->"+e.getMessage());
				return null;
				}
			return productName;
		}
}
