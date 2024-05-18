package com.maan.eway.common.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Tuple;
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
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maan.eway.bean.CountryMaster;
import com.maan.eway.bean.HomePositionMaster;
import com.maan.eway.bean.ListItemValue;
import com.maan.eway.bean.ProductGroupMaster;
import com.maan.eway.bean.StateMaster;
import com.maan.eway.bean.TravelPassengerDetails;
import com.maan.eway.bean.TravelPassengerHistory;
import com.maan.eway.common.req.TravelPassDetailsGetAllReq;
import com.maan.eway.common.req.TravelPassDetailsGetReq;
import com.maan.eway.common.req.TravelPassDetailsSaveReq;
import com.maan.eway.common.req.TravelPassValidateReq;
import com.maan.eway.common.res.TravelPassDetailsRes;
import com.maan.eway.common.res.TravelPassHistoryRes;
import com.maan.eway.common.service.TravelPassengerDetailsService;
import com.maan.eway.error.Error;
import com.maan.eway.repository.HomePositionMasterRepository;
import com.maan.eway.repository.ListItemValueRepository;
import com.maan.eway.repository.TravelPassengerDetailsRepository;
import com.maan.eway.repository.TravelPassengerHistoryRepository;
import com.maan.eway.res.SuccessRes;
import com.maan.eway.res.TravelIndividualPassRes;
import com.maan.eway.res.TravelPassCommonRes;


@Service
@Transactional
public class TravelPassengerDetailsServiceImpl  implements TravelPassengerDetailsService{
	
	@Autowired
	private TravelPassengerDetailsRepository repo;
	
	@Autowired
	private TravelPassengerHistoryRepository historyRepo;
	
	
	private Logger log=LogManager.getLogger(TravelPassengerDetailsServiceImpl.class);

	@Autowired
	private ListItemValueRepository listRepo;
	
	@Autowired
	private HomePositionMasterRepository homeRepo;
	
	@PersistenceContext
	private EntityManager em;

	
	@Override
	public List<Error> validatepassdetails(TravelPassDetailsSaveReq req) {
		List<Error> errors = new ArrayList<Error>();
		try {
				if (StringUtils.isBlank(req.getQuoteNo())) {
					errors.add(new Error("01", "Quote No", "Please Enter Quote No "));
				} else if (req.getQuoteNo().length() > 20) {
					errors.add(new Error("01", "Quote No", "Please Enter Quote No within 20 Characters "));
				}
				if (StringUtils.isBlank(req.getPassengerId())) {
					errors.add(new Error("02", "PassengerId", "Please Select PassengerId "));
				}else if (req.getPassengerId().length() > 20) {
					errors.add(new Error("03", "PassengerId", "Please Enter PassengerId within 20 Characters "));
				}
//				if (StringUtils.isBlank(req.getNameTitleId())) {
//					errors.add(new Error("04", "NameTitleId", "Please Select NameTitleId "));
//				}
				if (StringUtils.isBlank(req.getPassengerFirstName())) {
					errors.add(new Error("05", "PassengerFirstName", "Please Enter PassengerFirstName "));
				} else if (req.getPassengerFirstName().length() > 120) {
					errors.add(new Error("05", "PassengerFirstName", "Please Enter PassengerFirstName within 120 Characters "));
				}
			
				if (StringUtils.isBlank(req.getPassengerLastName())) {
					errors.add(new Error("06", "PassengerLastName", "Please Enter PassengerLastName "));
				} else if (req.getPassengerLastName().length() > 120) {
					errors.add(new Error("06", "PassengerLastName", "Please Enter PassengerLastName within 120 Characters "));
				}
				Calendar cal = new GregorianCalendar();
				Date today = new Date();
				
				if (req.getDob()==null) {
					errors.add(new Error("07", "Dob", "Please Enter Dob "));
				} else if ((req.getDob().after(today))) {
					errors.add(new Error("07", "Dob", "Please Enter Dob as Past Date "));
				} 
				
				if (StringUtils.isBlank(req.getGenderId())) {
					errors.add(new Error("08", "GenderId", "Please Select GenderId "));
				}
//				if (StringUtils.isBlank(req.getAge())) {
//					errors.add(new Error("09", "Age", "Please Enter Age "));
//				}
				
//				if (StringUtils.isBlank(req.getStateCode())) {
//					errors.add(new Error("09", "State", "Please Select State In Row No : "+ row));
//				}
				if (StringUtils.isBlank(req.getRelationId())) {
					errors.add(new Error("10", "Relation Id", "Please Select Relation "));
				}
				if (StringUtils.isBlank(req.getNationality())) {
					errors.add(new Error("11", "Nationality", "Please Enter Nationality "));
				}
				if (StringUtils.isBlank(req.getPassportNo())) {
					errors.add(new Error("12", "PassportNo", "Please Enter PassportNo "));
				} else if (req.getPassportNo().length() > 20) {
					errors.add(new Error("12", "PassportNo", "Please Enter PassportNo within 20 Characters "));
				}
//				if (StringUtils.isBlank(req.getAddress1())) {
//					errors.add(new Error("13", "Address1", "Please Enter Address1 In Row No : "));
//				} else if (req.getAddress1().length() > 500) {
//					errors.add(new Error("13", "Address1", "Please Enter Address1 within 500 Characters "));
//				}
//				if (StringUtils.isBlank(req.getAddress2())) {
//					errors.add(new Error("14", "Address2", "Please Enter Address2 In Row No : "));
//				} else if (req.getAddress2().length() > 500) {
//					errors.add(new Error("14", "Address2", "Please Enter Address2 within 500 Characters "));
//				}
			
			
		} catch(Exception e) {
			e.printStackTrace();
			log.info("Exception is ---> " + e.getMessage());
			errors.add(new Error("01","Common Error",e.getMessage() ));
		}
		return errors;
	}

	@Override
	public SuccessRes savepassdetails(TravelPassDetailsSaveReq req) {
		SuccessRes res = new SuccessRes();
		try {
			
			String quoteNo = req.getQuoteNo() ;
			List<TravelPassengerDetails> passDetails = repo.findByQuoteNoOrderByPassengerIdAsc(quoteNo);
			String insuranceId = passDetails.get(0).getCompanyId() ;
			String branchCode = passDetails.get(0).getBranchCode() ;	
			List<ListItemValue> genders  = getListItem(insuranceId , branchCode , "GENDER");
			List<ListItemValue> relations  = getListItem(insuranceId , branchCode , "RELATION_TYPE");
	//		List<ListItemValue> nametitles  = getListItem(insuranceId , branchCode , "TITLE");
			
			
				String gender = genders.stream().filter(o -> o.getItemCode().equalsIgnoreCase(req.getGenderId()  )).collect(Collectors.toList()).get(0).getItemValue();
				String relation = relations.stream().filter(o -> o.getItemCode().equalsIgnoreCase(req.getRelationId()  )).collect(Collectors.toList()).get(0).getItemValue();
			//	String nametitle = nametitles.stream().filter(o -> o.getItemCode().equalsIgnoreCase(req.getNameTitleId()  )).collect(Collectors.toList()).get(0).getItemValue();
						
				TravelPassengerDetails updateData = passDetails.stream().filter( o -> o.getPassengerId().equals(Integer.valueOf(req.getPassengerId())) ).collect(Collectors.toList()).get(0);
				
				updateData.setPassengerFirstName(req.getPassengerFirstName());
				updateData.setPassengerLastName(req.getPassengerLastName());
				updateData.setPassengerName(req.getPassengerFirstName() + " " + req.getPassengerLastName() );
				updateData.setDob(req.getDob());
				updateData.setGenderId(req.getGenderId());
				updateData.setGenderDesc(gender );
				updateData.setAge(Integer.valueOf(req.getAge()));
				updateData.setRelationId(Integer.valueOf(req.getRelationId()));
				updateData.setRelationDesc(relation);;
				//updateData.setNameTitleId(Integer.valueOf(req.getNameTitleId()));
				//updateData.setNameTitleDesc(nametitle);
				updateData.setNationality(req.getNationality());
				updateData.setPassportNo(req.getPassportNo());
				updateData.setCivilId(req.getCivilId());
				//updateData.setAddress1(req.getAddress1());
				//updateData.setAddress2(req.getAddress2());
				//updateData.setPobox(req.getPobox());
				updateData.setUpdatedBy(req.getCreatedBy());
				updateData.setUpdatedDate(new Date());
				List<Tuple> countryName = getCountryName(req.getNationality());
				
				if(countryName!=null && countryName.size()>0  ) {
					updateData.setNationalityDesc(countryName.get(0).get("countryName") == null ? "" : countryName.get(0).get("countryName").toString());
				}
				
				res.setSuccessId(updateData.getPassengerId().toString());
				res.setResponse("Updated Successfully");
				repo.saveAndFlush(updateData);
			
			
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
			log.info("Log Details"+e.getMessage());
			return null;
		}
		return res;
	}

	public List<Tuple> getCountryName(String countryId) {
		List<Tuple> list = new ArrayList<Tuple>();
		try {
			Date today = new Date();
			Calendar cal = new GregorianCalendar();
			cal.setTime(today);
			cal.set(Calendar.HOUR_OF_DAY, 23);
			cal.set(Calendar.MINUTE, 1);
			today = cal.getTime();
			cal.set(Calendar.HOUR_OF_DAY, 1);
			cal.set(Calendar.MINUTE, 1);
			Date todayEnd = cal.getTime();
			// Find Latest Record
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Tuple> query = cb.createQuery(Tuple.class);

			Root<CountryMaster> c = query.from(CountryMaster.class);
			
			// State Effective Date Max Filter
			Subquery<Long> effectiveDate1 = query.subquery(Long.class);
			Root<CountryMaster> ocpm1 = effectiveDate1.from(CountryMaster.class);
			effectiveDate1.select(cb.max(ocpm1.get("effectiveDateStart")));
			Predicate seff2 = cb.equal(ocpm1.get("countryId"), c.get("countryId"));
			Predicate seff4 = cb.lessThanOrEqualTo(ocpm1.get("effectiveDateStart"), today);
			effectiveDate1.where( seff2, seff4);

			// State Name Max Filter
			// State Effective Date Max Filter
			Subquery<Long> effectiveDate2 = query.subquery(Long.class);
			Root<StateMaster> ocpm2 = effectiveDate2.from(StateMaster.class);
			effectiveDate2.select(cb.max(ocpm2.get("effectiveDateEnd")));
			Predicate seff6 = cb.equal(ocpm2.get("countryId"), c.get("countryId"));
			Predicate seff7 = cb.greaterThanOrEqualTo(ocpm2.get("effectiveDateEnd"), todayEnd);
			effectiveDate2.where( seff6, seff7);

			// Select
			query.multiselect( c.get("countryName").alias("countryName") );
			
			Predicate s2 = cb.equal(c.get("countryId"), countryId);
			Predicate s3 = cb.equal(c.get("status"), "Y");
			Predicate s4 = cb.equal(c.get("effectiveDateStart"), effectiveDate1);
			Predicate s5 = cb.equal(c.get("effectiveDateEnd"), effectiveDate2);
			query.where( s2, s3, s4,s5);
			
			// Get Result
			TypedQuery<Tuple> result = em.createQuery(query);
			list = result.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
			return null;
		}
		return list;
	}
	
	public synchronized List<ListItemValue> getListItem(String insuranceId , String branchCode , String itemType) {
		List<ListItemValue> list = new ArrayList<ListItemValue>();
		try {
			Date today = new Date();
			Calendar cal = new GregorianCalendar();
			cal.setTime(today);
			today = cal.getTime();
			Date todayEnd = cal.getTime();
			
			// Criteria
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<ListItemValue> query=  cb.createQuery(ListItemValue.class);
			// Find All
			Root<ListItemValue> c = query.from(ListItemValue.class);
			
			//Select
			query.select(c);
			// Order By
			List<Order> orderList = new ArrayList<Order>();
			orderList.add(cb.asc(c.get("branchCode")));
			
			
			// Effective Date Start Max Filter
			Subquery<Long> effectiveDate = query.subquery(Long.class);
			Root<ListItemValue> ocpm1 = effectiveDate.from(ListItemValue.class);
			effectiveDate.select(cb.max(ocpm1.get("effectiveDateStart")));
			Predicate a1 = cb.equal(c.get("itemId"),ocpm1.get("itemId"));
			Predicate a2 = cb.lessThanOrEqualTo(ocpm1.get("effectiveDateStart"), today);
			effectiveDate.where(a1,a2);
			// Effective Date End Max Filter
			Subquery<Long> effectiveDate2 = query.subquery(Long.class);
			Root<ListItemValue> ocpm2 = effectiveDate2.from(ListItemValue.class);
			effectiveDate2.select(cb.max(ocpm2.get("effectiveDateEnd")));
			Predicate a3 = cb.equal(c.get("itemId"),ocpm2.get("itemId"));
			Predicate a4 = cb.greaterThanOrEqualTo(ocpm2.get("effectiveDateEnd"), todayEnd);
			effectiveDate2.where(a3,a4);
						
			// Where
			Predicate n1 = cb.equal(c.get("status"),"Y");
			Predicate n2 = cb.equal(c.get("effectiveDateStart"),effectiveDate);
			Predicate n3 = cb.equal(c.get("effectiveDateEnd"),effectiveDate2);	
			Predicate n4 = cb.equal(c.get("companyId"), insuranceId);
			Predicate n5 = cb.equal(c.get("companyId"), "99999");
			Predicate n6 = cb.equal(c.get("branchCode"), branchCode);
			Predicate n7 = cb.equal(c.get("branchCode"), "99999");
			Predicate n8 = cb.or(n4,n5);
			Predicate n9 = cb.or(n6,n7);
			Predicate n10 = cb.equal(c.get("itemType"),itemType);
			query.where(n1,n2,n3,n8,n9,n10).orderBy(orderList);
			// Get Result
			TypedQuery<ListItemValue> result = em.createQuery(query);
			list = result.getResultList();
			
			list = list.stream().filter(distinctByKey(o -> Arrays.asList(o.getItemCode()))).collect(Collectors.toList());
			list.sort(Comparator.comparing(ListItemValue :: getItemValue));
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Exception is ---> " + e.getMessage());
			return null;
		}
		return list ;
	}
	
	private static <T> java.util.function.Predicate<T> distinctByKey(java.util.function.Function<? super T, ?> keyExtractor) {
	    Map<Object, Boolean> seen = new ConcurrentHashMap<>();
	    return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	}
	
	@Override
	public TravelPassDetailsRes getpassdetails(TravelPassDetailsGetReq req) {
	TravelPassDetailsRes res = new TravelPassDetailsRes();
	DozerBeanMapper mapper = new DozerBeanMapper();
	try {

		TravelPassengerDetails data = repo.findByQuoteNoAndPassengerId(req.getQuoteNo(),Integer.valueOf( req.getPassengerId())); 
		if(data!=null) {
			res =mapper.map(data, TravelPassDetailsRes.class);
		}
	}
	catch(Exception e) {
		e.printStackTrace();
		log.info("Log Details"+e.getMessage());
		return null;
	}
	return res;
	}

	@Override
	public SuccessRes deletepassdetails(TravelPassDetailsGetReq req) {
		SuccessRes res = new SuccessRes();
	try {

			TravelPassengerDetails data = repo.findByQuoteNoAndPassengerId(req.getQuoteNo(),Integer.valueOf(req.getPassengerId())); 
			if(data!=null) {
				repo.delete(data);
				res.setResponse("Deleted Successfully");
				res.setSuccessId(req.getPassengerId());
				}
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info("Log Details"+e.getMessage());
			return null;
		}
		return res;
		}

	@Override
	public List<TravelPassDetailsRes> getallpassdetails(TravelPassDetailsGetAllReq req) {
		List<TravelPassDetailsRes> resList = new ArrayList<TravelPassDetailsRes>();
		DozerBeanMapper mapper = new DozerBeanMapper();
		try {
			List<TravelPassengerDetails> datas = repo.findByQuoteNoOrderByPassengerIdAsc(req.getQuoteNo());
			
			List<TravelPassengerDetails> adultList = datas.stream().filter( o -> o.getGroupId().equals(2) ).collect(Collectors.toList());
			for(TravelPassengerDetails data : adultList) {
				TravelPassDetailsRes res = new TravelPassDetailsRes();
				res = mapper.map(data, TravelPassDetailsRes.class);
				resList.add(res);
			}
			List<TravelPassengerDetails> otherList =  datas.stream().filter( o -> ! o.getGroupId().equals(2) ).collect(Collectors.toList());
			for(TravelPassengerDetails data : otherList) {
				TravelPassDetailsRes res = new TravelPassDetailsRes();
				res = mapper.map(data, TravelPassDetailsRes.class);
				resList.add(res);
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info("Log Details"+e.getMessage());
			return null;
		}
		return resList;
	}

	@Override
	public List<Error> validatepassListDetails(TravelPassValidateReq quoteReq) {
		List<Error> errors = new ArrayList<Error>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			List<TravelPassengerDetails> passDetails = repo.findByQuoteNoOrderByPassengerIdAsc(quoteReq.getQuoteNo());
			List<ProductGroupMaster>  groupMaster =  getProductGroupMasterDropdown(passDetails.get(0).getCompanyId() , passDetails.get(0).getBranchCode() , passDetails.get(0).getProductId() );
			
			
			// Indivudal Validation
			for (TravelPassengerDetails pass :  passDetails ) {
				// Group Master
				ProductGroupMaster filterGroupMaster =  groupMaster.stream().filter( o -> o.getGroupId().equals(pass.getGroupId())    ).collect(Collectors.toList()).get(0);
				Long fromAge = Long.valueOf(filterGroupMaster.getGroupFrom()) ;
			    Long toAge = Long.valueOf(filterGroupMaster.getGroupTo()) ;
			    String bandDesc = filterGroupMaster.getBandDesc();
			    
				// Age Band Validation
				String date =  sdf.format(pass.getDob()) ; 
				Date birthDate = sdf.parse(date);
			    Long ageInMillis = System.currentTimeMillis() - birthDate.getTime();
			    Long years = ageInMillis /(365 * 24*60*60*1000l);
			    Long leftover = ageInMillis %(365 * 24*60*60*1000l);
			    Long days = leftover/(24*60*60*1000l);
			    System.out.println(years);
			    System.out.println(days);
				
				if(filterGroupMaster.getGroupId().equals(1) ) {
					// Age 3 - 18 Restrict
					 if( 90 > days && years > toAge    ) {
						 errors.add(new Error("01", "Dob", "Date Of Birth Should be " + bandDesc +" Years Allowed in Passenger No : " +  pass.getPassengerId() )); 
					 }
				 
				} else {
					// Other Age Restrict	
					 if( fromAge > years && years < toAge ) {
						 errors.add(new Error("01", "Dob", "Date Of Birth Should be  " + bandDesc + "  Years Only Allowed in Passenger No : " +  pass.getPassengerId() )); 
					 }
				} 
				
			}
				
			// Group Validation
			Map<Integer , List<TravelPassengerDetails>> groupById = 	passDetails.stream().collect( Collectors.groupingBy(TravelPassengerDetails :: getGroupId));
			for ( Integer id :  groupById.keySet()) {
				List<TravelPassengerDetails> groupDatas = groupById.get(id);
				ProductGroupMaster filterGroupMaster =  groupMaster.stream().filter( o -> o.getGroupId().equals(groupDatas.get(0).getGroupId())    ).collect(Collectors.toList()).get(0);
				String bandDesc = filterGroupMaster.getBandDesc();
				if(groupDatas.size() !=  groupDatas.get(0).getGroupCount()) {
					errors.add(new Error("01", "Group Count", "Group Count :" + groupDatas.get(0).getGroupCount() +  " Only Allowed In "+ bandDesc + " Age Group Band"  ));
				}
				
			}
					
					
			
		} catch(Exception e) {
			e.printStackTrace();
			log.info("Exception is ---> " + e.getMessage());
			errors.add(new Error("01","Common Error",e.getMessage() ));
		}
		return errors;
	}

	public List<ProductGroupMaster> getProductGroupMasterDropdown(String insId , String branchCode , Integer productId) {
		List<ProductGroupMaster> list = new ArrayList<ProductGroupMaster>();
		
		try {
			Date today = new Date();
			Calendar cal = new GregorianCalendar();
			cal.setTime(today);
			today = cal.getTime();
			Date todayEnd = cal.getTime();
			
			// Criteria
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<ProductGroupMaster> query = cb.createQuery(ProductGroupMaster.class);
			
			// Find All
			Root<ProductGroupMaster> c = query.from(ProductGroupMaster.class);
			// Select
			query.select(c);
			// Order By
			List<Order> orderList = new ArrayList<Order>();
			orderList.add(cb.asc(c.get("branchCode")));

			// Effective Date Start Max Filter
			Subquery<Long> effectiveDate = query.subquery(Long.class);
			Root<ProductGroupMaster> ocpm1 = effectiveDate.from(ProductGroupMaster.class);
			effectiveDate.select(cb.max(ocpm1.get("effectiveDateStart")));
			Predicate a1 = cb.equal(c.get("groupId"), ocpm1.get("groupId"));
			Predicate a2 = cb.lessThanOrEqualTo(ocpm1.get("effectiveDateStart"), today);
			Predicate a3 = cb.equal(c.get("companyId"), ocpm1.get("companyId"));
			Predicate a4 = cb.equal(c.get("branchCode"), ocpm1.get("branchCode"));
			Predicate a5 = cb.equal(c.get("productId"), ocpm1.get("productId"));
			effectiveDate.where(a1, a2, a3, a4, a5);
			// Effective Date End Max Filter
			Subquery<Long> effectiveDate2 = query.subquery(Long.class);
			Root<ProductGroupMaster> ocpm2 = effectiveDate2.from(ProductGroupMaster.class);
			effectiveDate2.select(cb.max(ocpm2.get("effectiveDateEnd")));
			Predicate a6 = cb.equal(c.get("groupId"), ocpm2.get("groupId"));
			Predicate a7 = cb.greaterThanOrEqualTo(ocpm2.get("effectiveDateEnd"), todayEnd);
			Predicate a8 = cb.equal(c.get("companyId"), ocpm2.get("companyId"));
			Predicate a9 = cb.equal(c.get("branchCode"), ocpm2.get("branchCode"));
			Predicate a10 = cb.equal(c.get("productId"), ocpm2.get("productId"));

			effectiveDate2.where(a6, a7, a8, a9, a10);
			// Where
			Predicate n1 = cb.equal(c.get("status"), "Y");
			Predicate n2 = cb.equal(c.get("effectiveDateStart"), effectiveDate);
			Predicate n3 = cb.equal(c.get("effectiveDateEnd"), effectiveDate2);
			Predicate n4 = cb.equal(c.get("productId"),productId);
			Predicate n8 = cb.equal(c.get("companyId"), insId);
			Predicate n5 = cb.equal(c.get("branchCode"), branchCode);
			Predicate n6 = cb.equal(c.get("branchCode"), "99999");
			Predicate n7 = cb.or(n5, n6);
			query.where(n1, n2, n3, n4, n7, n8).orderBy(orderList);
			// Get Result
			TypedQuery<ProductGroupMaster> result = em.createQuery(query);
			list = result.getResultList();
			list = list.stream().filter(distinctByKey(o -> Arrays.asList(o.getGroupId()))).collect(Collectors.toList());
			list.sort(Comparator.comparing(ProductGroupMaster::getGroupDesc));
			
		}
			catch(Exception e) {
				e.printStackTrace();
				log.info("Exception is --->"+e.getMessage());
				return null;
				}
			return list;
		}
	
	@Override
	public TravelPassCommonRes getpassdetails(TravelPassValidateReq req) {
		TravelPassCommonRes travelRes = new TravelPassCommonRes();
		DozerBeanMapper dozerMapper = new DozerBeanMapper(); 
		try {
			List<TravelPassengerDetails> passList = repo.findByQuoteNoOrderByPassengerIdAsc(req.getQuoteNo()) ;
			dozerMapper.map(passList.get(0), travelRes ) ;
			
			List<TravelIndividualPassRes> travelPassList = new ArrayList<TravelIndividualPassRes>();
			
			for (TravelPassengerDetails pass :  passList ) {
				TravelIndividualPassRes  traPass = new TravelIndividualPassRes();
				dozerMapper.map(pass, traPass ) ;
				travelPassList.add(traPass);
			}
			
			// Total Premium
			HomePositionMaster homeData = homeRepo.findByQuoteNo(req.getQuoteNo());  
			travelRes.setActualPremiumFc(homeData.getPremiumFc()==null?"":homeData.getPremiumFc().toString());
			travelRes.setActualPremiumLc(homeData.getPremiumLc()==null?"":homeData.getPremiumLc().toString());
			travelRes.setOverallPremiumFc(homeData.getOverallPremiumFc()==null?"":homeData.getOverallPremiumFc().toString());
			travelRes.setOverallPremiumLc(homeData.getOverallPremiumLc()==null?"":homeData.getOverallPremiumLc().toString());
			
		} catch(Exception e) {
			e.printStackTrace();
			log.info("Exception is --->"+e.getMessage());
			return null;
		}
			return travelRes;
	}

	@Override
	public List<TravelPassHistoryRes> getallpasshistorydetails(TravelPassDetailsGetAllReq req) {
		List<TravelPassHistoryRes> resList = new ArrayList<TravelPassHistoryRes>();
		DozerBeanMapper mapper = new DozerBeanMapper();
		try {
			List<TravelPassengerHistory> datas = historyRepo.findByQuoteNoOrderByPassengerIdAsc(req.getQuoteNo());
			
			List<TravelPassengerHistory> adultList = datas.stream().filter( o -> o.getGroupId().equals(2) ).collect(Collectors.toList());
			for(TravelPassengerHistory data : adultList) {
				TravelPassHistoryRes res = new TravelPassHistoryRes();
				res = mapper.map(data, TravelPassHistoryRes.class);
				resList.add(res);
			}
			
			List<TravelPassengerHistory> otherList =  datas.stream().filter( o -> ! o.getGroupId().equals(2) ).collect(Collectors.toList());
			for(TravelPassengerHistory data : otherList) {
				TravelPassHistoryRes res = new TravelPassHistoryRes();
				res = mapper.map(data, TravelPassHistoryRes.class);
				resList.add(res);
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
