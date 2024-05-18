package com.maan.eway.config.onetime;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;
import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dozer.DozerBeanMapper;

import com.maan.eway.bean.CurrencyMaster;
import com.maan.eway.bean.EserviceBuildingDetails;
import com.maan.eway.bean.EserviceCommonDetails;
import com.maan.eway.bean.EserviceCustomerDetails;
import com.maan.eway.bean.EserviceMotorDetails;
import com.maan.eway.bean.EserviceTravelDetails;
import com.maan.eway.bean.EserviceTravelGroupDetails;
import com.maan.eway.bean.ListItemValue;
import com.maan.eway.bean.MsAssetDetails;
import com.maan.eway.bean.MsCustomerDetails;
import com.maan.eway.bean.MsHumanDetails;
import com.maan.eway.bean.MsVehicleDetails;
import com.maan.eway.bean.SectionCoverMaster;
import com.maan.eway.bean.SeqOnetimetable;
import com.maan.eway.common.req.TravelGroupInsertReq;
import com.maan.eway.common.res.BuildingSectionRes;
import com.maan.eway.repository.EServiceBuildingDetailsRepository;
import com.maan.eway.repository.EServiceMotorDetailsRepository;
import com.maan.eway.repository.EServiceSectionDetailsRepository;
import com.maan.eway.repository.EserviceCommonDetailsRepository;
import com.maan.eway.repository.EserviceCustomerDetailsRepository;
import com.maan.eway.repository.EserviceTravelDetailsRepository;
import com.maan.eway.repository.EserviceTravelGroupDetailsRepository;
import com.maan.eway.repository.MsAssetDetailsRepository;
import com.maan.eway.repository.MsCustomerDetailsRepository;
import com.maan.eway.repository.MsHumanDetailsRepository;
import com.maan.eway.repository.MsVehicleDetailsRepository;
import com.maan.eway.repository.SeqOnetimetableRepository;
import com.maan.eway.req.OneTimeTableReq;
import com.maan.eway.res.OneTimeVehicleRes;
import com.maan.eway.service.OneTimeService;

public class Thread_OneTime implements Callable<Object> {

	private String type;

	private OneTimeTableReq request;
	
	private SeqOnetimetableRepository oneNoRepo ;

	private OneTimeService otSer;
	private EntityManager em;
	private MsVehicleDetailsRepository msVehicleRepo ;
	
	
	
	private EServiceMotorDetailsRepository eserviceMotorRepo;
	private MsCustomerDetailsRepository msCustomerRepo;
	private EserviceCustomerDetailsRepository eserviceCustomerRepo;
	private EserviceTravelGroupDetailsRepository groupRepo ;
	private Logger log = LogManager.getLogger(getClass());

	private EserviceMotorDetails motorDatas ;
	
	private EserviceTravelDetailsRepository eserTravelRepo ;
	private MsHumanDetailsRepository msHumanRepo ;
	private EserviceTravelDetails travelData ;
	private EserviceCustomerDetails custData ;
	private  List<EserviceTravelGroupDetails> groupDatas;
	private EServiceBuildingDetailsRepository eserBuildRepo;
	private MsAssetDetailsRepository msAssetRepo;
	private EserviceBuildingDetails eserBuild;
	private EServiceSectionDetailsRepository eserSecRepo ; 
	private List<EserviceCommonDetails> esercommonDatas ;
	private EserviceCommonDetailsRepository eserCommonRepo ;
	private MsAssetDetails msAsset;
	
	public Thread_OneTime(String type, OneTimeTableReq request, OneTimeService otSer, EntityManager em,EserviceCustomerDetails custData ,  MsVehicleDetailsRepository msVehicleRepo, 
			EServiceMotorDetailsRepository eserviceMotorRepo, MsCustomerDetailsRepository msCustomerRepo, EserviceCustomerDetailsRepository eserviceCustomerRepo
			,EserviceMotorDetails motorDatas ,EserviceTravelDetailsRepository eserTravelRepo,MsHumanDetailsRepository msHumanRepo
			, EserviceTravelDetails travelData , List<EserviceTravelGroupDetails> groupDatas,EserviceTravelGroupDetailsRepository groupRepo,
			EServiceBuildingDetailsRepository eserBuildRepo,MsAssetDetailsRepository msAssetRepo,EserviceBuildingDetails eserBuild ,  EServiceSectionDetailsRepository eserSecRepo
			, SeqOnetimetableRepository oneNoRepo , List<EserviceCommonDetails> esercommonDatas  , EserviceCommonDetailsRepository eserCommonRepo  ) {
		
		this.type = type;
		this.request = request;
		this.otSer = otSer;
		this.em=em;
		this.custData= custData ;
		this.eserviceMotorRepo=eserviceMotorRepo;
		this.msCustomerRepo=msCustomerRepo;
		this.msVehicleRepo=msVehicleRepo;
		this.eserviceMotorRepo=eserviceMotorRepo;
		this.eserviceCustomerRepo=eserviceCustomerRepo; 
		this.motorDatas=motorDatas;
		this.eserTravelRepo=eserTravelRepo;
		this.msHumanRepo=msHumanRepo;
		this.travelData = travelData ;
		this.groupDatas = groupDatas ;
		this.groupRepo = groupRepo;
		this.eserBuildRepo = eserBuildRepo;
		this.msAssetRepo = msAssetRepo;
		this.eserBuild = eserBuild;
		this.eserSecRepo = eserSecRepo ;
		this.oneNoRepo = oneNoRepo ;
		this.esercommonDatas = esercommonDatas ;
		this.eserCommonRepo = eserCommonRepo ;
	}

	@Override
	public Map<String, Object> call() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		try {

			type = StringUtils.isBlank(type) ? "" : type;

			log.info("Thread_OneTime--> type: " + type);

			if (type.equalsIgnoreCase("MSVehicle")) {

				map.put("MSVehicle", call_MSVehicle(request));

			} else if (type.equalsIgnoreCase("MSCustomer")) {

				map.put("MSCustomer", call_MSCustomer(request));

			} else if (type.equalsIgnoreCase("MSTravel")) {

				map.put("MSTravel", call_MSTravel(request));

			}
			else if (type.equalsIgnoreCase("MSAsset")) {

				map.put("MSAsset", call_MSAsset(request));

			}
			else if (type.equalsIgnoreCase("MSHuman")) {

				map.put("MSHuman", call_MSHuman(request));

			}


		} catch (Exception e) {
			log.error(e);
		}
		return map;
	}
	
	
	
	@Transactional
	private synchronized  List<OneTimeVehicleRes> call_MSVehicle(OneTimeTableReq request) {
		List<OneTimeVehicleRes> resList = new ArrayList<OneTimeVehicleRes>();
		OneTimeVehicleRes res = new  OneTimeVehicleRes();
		List<MsVehicleDetails> list = new ArrayList<MsVehicleDetails>();

		String vdRefNo = "" ;
		String sectionId = "" ;
		String agencyCode = "" ;
		String branchCode = "" ;
		String productId = "" ;
		String companyId = "" ;
	//	SimpleDateFormat sdf = new SimpleDateFormat("yyMMddhhmmssSS");
		String decimalDigits = currencyDecimalFormat(motorDatas.getCompanyId() , motorDatas.getCurrency() ).toString();
		String stringFormat = "%0"+decimalDigits+"d" ;
		String decimalLength = decimalDigits.equals("0") ?"" : String.format(stringFormat ,0L)  ;
		String pattern = StringUtils.isBlank(decimalLength) ?  "#####0" :   "#####0." + decimalLength;
		DecimalFormat df = new DecimalFormat(pattern);
		
		
		DozerBeanMapper dozerMapper = new DozerBeanMapper();
		try {
			
			// Wind Screen SumInsured
			BigDecimal windSumInsured = BigDecimal.ZERO ;
			if(  motorDatas.getWindScreenSumInsured()!=null && motorDatas.getWindScreenSumInsured().compareTo(BigDecimal.ZERO)>0 ) {
				String itemType = "WINDSCREEN_SUMINSURED" ;
				List<ListItemValue> getList  = getListItem(motorDatas.getCompanyId() , motorDatas.getBranchCode() , itemType);
				List<ListItemValue> privateVehicle = getList.stream().filter( o -> o.getItemCode().equalsIgnoreCase("1") ).collect(Collectors.toList());
				List<ListItemValue> otherVehicle = getList.stream().filter( o ->  o.getItemCode().equalsIgnoreCase("2") ).collect(Collectors.toList());
				
				windSumInsured = motorDatas.getWindScreenSumInsured().multiply(motorDatas.getExchangeRate()) ; 
				BigDecimal privateVehicleValue = privateVehicle.size() > 0 ? new BigDecimal (privateVehicle.get(0).getItemValue()) :  BigDecimal.ZERO  ;
				BigDecimal otherVehicleValue =  otherVehicle.size() > 0 ? new BigDecimal (otherVehicle.get(0).getItemValue()) :  BigDecimal.ZERO  ;
				
				if(motorDatas.getSectionId().equalsIgnoreCase("10") && windSumInsured.compareTo(privateVehicleValue) > 0  ) {
					windSumInsured = windSumInsured.subtract(privateVehicleValue) ;
				}  else if(motorDatas.getSectionId().equalsIgnoreCase("10") && windSumInsured.compareTo(privateVehicleValue) <= 0  ) {
					
					windSumInsured = new BigDecimal("-1") ;
					
				} else if(windSumInsured.compareTo(otherVehicleValue) > 0 ) {
					
					windSumInsured = windSumInsured.subtract(otherVehicleValue) ;
					
				}  else if(windSumInsured.compareTo(otherVehicleValue ) <= 0) {
					
					windSumInsured = new BigDecimal("-1") ; 
				}
			}
			
			// Accessories SumInsured
			BigDecimal accSumInsured =  BigDecimal.ZERO  ;
			if( motorDatas.getAcccessoriesSumInsured()!=null &&   motorDatas.getAcccessoriesSumInsured().compareTo(BigDecimal.ZERO)>0 ) {
				String itemType = "ACCESSORIES_SUMINSURED" ;
				List<ListItemValue> getList  = getListItem(motorDatas.getCompanyId() , motorDatas.getBranchCode() , itemType);
				List<ListItemValue> privateVehicle = getList.stream().filter( o -> o.getItemCode().equalsIgnoreCase("1") ).collect(Collectors.toList());
				List<ListItemValue> otherVehicle = getList.stream().filter( o ->  o.getItemCode().equalsIgnoreCase("2") ).collect(Collectors.toList());
				
				accSumInsured = motorDatas.getAcccessoriesSumInsured().multiply(motorDatas.getExchangeRate())  ; 
				BigDecimal privateVehicleValue = privateVehicle.size() > 0 ? new BigDecimal(privateVehicle.get(0).getItemValue()) : BigDecimal.ZERO  ;
				BigDecimal otherVehicleValue = otherVehicle.size() > 0 ? new BigDecimal(otherVehicle.get(0).getItemValue()) : BigDecimal.ZERO ;
				
				if(motorDatas.getSectionId().equalsIgnoreCase("10") && accSumInsured.compareTo(privateVehicleValue)>0  ) {
					accSumInsured = accSumInsured.subtract(privateVehicleValue) ;
					
				} else if(motorDatas.getSectionId().equalsIgnoreCase("10") && accSumInsured.compareTo(privateVehicleValue) <= 0  ) {
					accSumInsured = new BigDecimal("-1") ;
					
				} else if(accSumInsured.compareTo(otherVehicleValue ) > 0) {
					accSumInsured = accSumInsured.subtract(otherVehicleValue) ;
					
				} else if(accSumInsured.compareTo(otherVehicleValue ) <= 0) {
					accSumInsured = new BigDecimal("-1") ; 
				} 
			}
			
			
			boolean newEntry = false ;
			sectionId = motorDatas.getSectionId() ;
			branchCode = motorDatas.getBranchCode();
			agencyCode =  motorDatas.getAgencyCode();
			productId =  motorDatas.getProductId();
			companyId =  motorDatas.getCompanyId();
			BigDecimal grossWeight = new BigDecimal(df.format(motorDatas.getGrossWeight().divide(new BigDecimal(1000))));

			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<MsVehicleDetails> query = cb.createQuery(MsVehicleDetails.class);

			// Find All
			Root<MsVehicleDetails> b = query.from(MsVehicleDetails.class);

			// Select
			query.select(b);
			Predicate n1 = (cb.like(cb.lower(b.get("vehicleId")), motorDatas.getRiskId().toString().toLowerCase()));		
			Predicate n2 = (cb.like(cb.lower(b.get("accidentYn")), motorDatas.getAccident().toLowerCase()));
			Predicate n3 = (cb.like(cb.lower(b.get("windScreenCoverRequeired")), motorDatas.getWindScreenCoverRequired().toLowerCase()));
			Predicate n4 = (cb.like(cb.lower(b.get("insuranceType")), motorDatas.getInsuranceType().toLowerCase()));
			Predicate n5 = (cb.like(cb.lower(b.get("insuranceClass")), motorDatas.getInsuranceClass().toLowerCase()));
			Predicate n6 = (cb.like(cb.lower(b.get("ownerCategory")), motorDatas.getOwnerCategory().toLowerCase()));
			Predicate n7 = (cb.like(cb.lower(b.get("chassisNumber")), motorDatas.getChassisNumber().toLowerCase()));
			Predicate n8 = (cb.like(cb.lower(b.get("vehicleMake")), motorDatas.getVehicleMake().toLowerCase()));
			Predicate n9 = (cb.like(cb.lower(b.get("vehcileModel")), motorDatas.getVehcileModel().toLowerCase()));
			Predicate n10 = (cb.like(cb.lower(b.get("vehicleBodyType")), motorDatas.getVehicleType().toLowerCase()));				
			Predicate n11 = cb.equal(b.get("vehicleWeight"), grossWeight);
			Predicate n12 = cb.equal(b.get("manufactureYear"), motorDatas.getManufactureYear());
			Predicate n13 = cb.equal(b.get("manufactureAge"), motorDatas.getManufactureAge());
			Predicate n14= cb.equal(b.get("registrationAge"), motorDatas.getRegistrationAge());
			Predicate n15 = cb.equal(b.get("registrationYear"), motorDatas.getRegistrationYear());
			Predicate n16 = cb.equal(b.get("seatingCapacity"), motorDatas.getSeatingCapacity());
			Predicate n17 = cb.equal(b.get("periodOfInsurance"), motorDatas.getPeriodOfInsurance());
			Predicate n18 = cb.equal(b.get("windScreenSumInsured"), windSumInsured);
			Predicate n19 = cb.equal(b.get("acccessoriesSumInsured"), accSumInsured);
			Predicate n20 = cb.equal(b.get("sumInsured"), motorDatas.getSumInsured());
			Predicate n21 = cb.equal(b.get("ncdyears"), motorDatas.getNcdYears()==null?0:motorDatas.getNcdYears());
			Predicate n22 = (cb.like(cb.lower(b.get("ncdYn")), motorDatas.getNcdYn().toLowerCase()));
			Predicate n23 = cb.equal(b.get("noOfClaims"), motorDatas.getNoOfClaims()==null?0:motorDatas.getNoOfClaims());
			Predicate n24 = cb.equal(b.get("currency"), motorDatas.getCurrency());
			Predicate n25 = cb.equal(b.get("exchangeRate"), motorDatas.getExchangeRate());
			Predicate n26 = (cb.like(cb.lower(b.get("fleetOwnerYn")), motorDatas.getFleetOwnerYn()==null ?null : motorDatas.getFleetOwnerYn().toLowerCase()));
			Predicate n27 = cb.equal(b.get("noOfVehicles"), motorDatas.getNoOfVehicles());
			Predicate n28 = cb.equal(b.get("noOfCompehensives"), motorDatas.getNoOfCompehensives());
			Predicate n29 = cb.equal(b.get("claimRatio"), motorDatas.getClaimRatio());
			Predicate n30 =(motorDatas.getTppdIncreaeLimit()!=null ?(cb.equal(b.get("tpdIncreaseLimit"), motorDatas.getTppdIncreaeLimit())):cb.isNull(b.get("tpdIncreaseLimit")));
			Predicate n31 = (cb.like(cb.lower(b.get("motorUsage")), motorDatas.getMotorUsage().toLowerCase()));
			Predicate n32 = (cb.like(cb.lower(b.get("status")), "Y".toLowerCase()));
			Predicate n33 = (cb.like(cb.lower(b.get("fuelType")), motorDatas.getFuelType().toLowerCase()));
			Predicate n34 = (cb.like(cb.lower(b.get("chassisNumber")), motorDatas.getChassisNumber().toLowerCase()));
			Predicate n35 = (cb.like(cb.lower(b.get("gpsyn")), motorDatas.getGpsTrackingInstalled().toLowerCase()));
			Predicate n36 = (cb.like(cb.lower(b.get("requestReferenceNo")), motorDatas.getRequestReferenceNo().toString().toLowerCase()));	
			Predicate n37 = cb.equal(b.get("cityLimit"), motorDatas.getCityLimit());
			Predicate n38 = (cb.equal(b.get("havepromocode"), motorDatas.getHavepromocode()));
			Predicate n39 = (cb.equal(b.get("promocode"), motorDatas.getPromocode()));
			Predicate n40 = (cb.equal(b.get("endtTypeId"),motorDatas.getEndorsementType()==null?0 :motorDatas.getEndorsementType() ));
			Predicate n41 = (cb.equal(b.get("endtCategoryId"),motorDatas.getIsFinaceYn()==null?"N" :motorDatas.getIsFinaceYn() ));

			query.where(n1,n2,n3,n4,n5,n6,n7,n8,n9,n10,
					n11,n12,n13,n14,n15,n16,n17,n18,n19,n20,
					n21,n22,n23,n24,n25,n26,n27,n28,n29,n30,
					n31,n32,n33,n34,n35, n36,n37,n38,n39 , n40,n41
					);
			// Get Result
			TypedQuery<MsVehicleDetails> result = em.createQuery(query);
			list = result.getResultList();		


			if (list==null || list.size() <= 0 ) {
				newEntry = true ;

			} else {
				vdRefNo = String.valueOf(list.get(0).getVdRefno());
				res.setMsVehicleDetails(list.get(0));
			}
			if(newEntry==true  ) {
			//	Random rand = new Random();
	         // int random=rand.nextInt(90)+10;
				vdRefNo = genOneTimeTableRefNo() ;  // sdf.format(new Date()) + random ;

				MsVehicleDetails saveVehicle = new MsVehicleDetails();
				dozerMapper.map(motorDatas, saveVehicle);
				saveVehicle.setVehicleId(motorDatas.getRiskId().toString());
				saveVehicle.setVdRefno(Long.valueOf(vdRefNo) );
				saveVehicle.setEntryDate(new Date());
				saveVehicle.setAccidentYn(StringUtils.isBlank(motorDatas.getAccident())?"N":motorDatas.getAccident());
				saveVehicle.setStatus("Y");
				saveVehicle.setNcdyears(motorDatas.getNcdYears());
				saveVehicle.setInsuranceClass(motorDatas.getInsuranceClass());
				saveVehicle.setNcdYn(motorDatas.getNcdYn());
				saveVehicle.setNoOfClaims(motorDatas.getNoOfClaims()==null?0 :motorDatas.getNoOfClaims());
				saveVehicle.setNoOfCompehensives(motorDatas.getNoOfCompehensives()==null?0 :motorDatas.getNoOfCompehensives());
				saveVehicle.setNoOfVehicles(motorDatas.getNoOfVehicles()==null?0 :motorDatas.getNoOfVehicles());
				saveVehicle.setNcdyears(motorDatas.getNcdYears()==null?0 :motorDatas.getNcdYears());
				saveVehicle.setOwnerCategory(motorDatas.getOwnerCategory()==null?"0":motorDatas.getOwnerCategory());
				saveVehicle.setRegistrationYear(motorDatas.getRegistrationYear());
				saveVehicle.setVehicleBodyType(motorDatas.getVehicleType());
				saveVehicle.setTpdIncreaseLimit(motorDatas.getTppdIncreaeLimit());
				saveVehicle.setWindScreenCoverRequeired(motorDatas.getWindScreenCoverRequired());
				saveVehicle.setMotorUsage(motorDatas.getMotorUsage());
				saveVehicle.setGpsyn(motorDatas.getGpsTrackingInstalled());
				saveVehicle.setGroupCount(1);
				saveVehicle.setCityLimit(StringUtils.isBlank(motorDatas.getCityLimit())?"0": motorDatas.getCityLimit());
				saveVehicle.setWindScreenSumInsured(windSumInsured);
				saveVehicle.setAcccessoriesSumInsured(accSumInsured);
				saveVehicle.setHavepromocode(motorDatas.getHavepromocode());
				saveVehicle.setPromocode(motorDatas.getPromocode());
				saveVehicle.setEndtTypeId(motorDatas.getEndorsementType()==null?0 :motorDatas.getEndorsementType() ) ;
				saveVehicle.setEndtCategoryId(motorDatas.getIsFinaceYn()==null?"N" :motorDatas.getIsFinaceYn() );
				//Double grossWeight =  Double.valueOf(df.format(motorDatas.getGrossWeight()))/ 1000;

				saveVehicle.setVehicleWeight(grossWeight);
				msVehicleRepo.saveAndFlush(saveVehicle);
				res.setMsVehicleDetails(saveVehicle);

			}
			res.setVdRefNo(vdRefNo);
			res.setSectionId(sectionId);
			res.setAgencyCode(agencyCode);
			res.setBranchCode(branchCode);
			res.setProductId(productId);
			res.setCompanyId(companyId);
			res.setVehicleId(motorDatas.getRiskId().toString());
			resList.add(res);
		}catch (Exception e) {
			e.printStackTrace();
			log.error("Exception is ---> " + e.getMessage());
			return null ;
		}

		return resList;
	}
	
	public Integer currencyDecimalFormat(String insuranceId  ,String currencyId ) {
		Integer decimalFormat = 0 ;
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
			
			// Criteria
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<CurrencyMaster> query = cb.createQuery(CurrencyMaster.class);
			List<CurrencyMaster> list = new ArrayList<CurrencyMaster>();
			
			// Find All
			Root<CurrencyMaster>    c = query.from(CurrencyMaster.class);		
			
			// Select
			query.select(c);
			
		
			// Order By
			List<Order> orderList = new ArrayList<Order>();
			orderList.add(cb.asc(c.get("currencyName")));
			
			// Effective Date Max Filter
			Subquery<Long> effectiveDate = query.subquery(Long.class);
			Root<CurrencyMaster> ocpm1 = effectiveDate.from(CurrencyMaster.class);
			effectiveDate.select(cb.max(ocpm1.get("effectiveDateStart")));
			Predicate a11 = cb.equal(c.get("currencyId"),ocpm1.get("currencyId") );
			Predicate a12 = cb.lessThanOrEqualTo(ocpm1.get("effectiveDateStart"), today);
			Predicate a18 = cb.equal(c.get("status"),ocpm1.get("status") );
			Predicate a22 = cb.equal(c.get("companyId"), ocpm1.get("companyId"));
			
			effectiveDate.where(a11,a12,a18,a22);
			
			// Effective Date Max Filter
			Subquery<Long> effectiveDate2 = query.subquery(Long.class);
			Root<CurrencyMaster> ocpm2 = effectiveDate2.from(CurrencyMaster.class);
			effectiveDate2.select(cb.max(ocpm2.get("effectiveDateEnd")));
			Predicate a13 = cb.equal(c.get("currencyId"),ocpm2.get("currencyId") );
			Predicate a14 = cb.greaterThanOrEqualTo(ocpm2.get("effectiveDateEnd"), todayEnd);
			Predicate a19 = cb.equal(c.get("status"),ocpm2.get("status") );
			Predicate a23 = cb.equal(c.get("companyId"), ocpm2.get("companyId"));
			
			effectiveDate2.where(a13,a14,a19,a23);
			
		    // Where	
			Predicate n1 = cb.equal(c.get("status"), "Y");
			Predicate n2 = cb.equal(c.get("effectiveDateStart"), effectiveDate);
			Predicate n3 = cb.equal(c.get("effectiveDateEnd"), effectiveDate2);
			Predicate n4 = cb.equal(c.get("companyId"),insuranceId);
			Predicate n5 = cb.equal(c.get("companyId"),"99999");
			Predicate n6 = cb.or(n4,n5);
			Predicate n7 = cb.equal(c.get("currencyId"),currencyId);
			query.where(n1,n2,n3,n6,n7).orderBy(orderList);
			
			// Get Result
			TypedQuery<CurrencyMaster> result = em.createQuery(query);			
			list =  result.getResultList(); 
			
			decimalFormat = list.size() > 0 ? (list.get(0).getDecimalDigit()==null?0 :list.get(0).getDecimalDigit()) :0; 		
			
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Exception is ---> " + e.getMessage());
			return null;
		}
		return decimalFormat;
	}
	
	public synchronized List<ListItemValue> getListItem(String insId , String branchCode , String itemType) {
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
			Predicate n4 = cb.equal(c.get("companyId"), insId);
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
	
	
	@Transactional
	private synchronized List<OneTimeVehicleRes> call_MSTravel(OneTimeTableReq request) {
		List<OneTimeVehicleRes> resList = new ArrayList<OneTimeVehicleRes>();
		OneTimeVehicleRes res = new  OneTimeVehicleRes();
		List<MsHumanDetails> list = new ArrayList<MsHumanDetails>();

		String vdRefNo = "" ;
		String sectionId = "" ;
		String agencyCode = "" ;
		String branchCode = "" ;
		String productId = "" ;
		String companyId = "" ;
	//	SimpleDateFormat sdf = new SimpleDateFormat("yyMMddhhmmssSS");
		String pattern = "#####0.00";
		DecimalFormat df = new DecimalFormat(pattern);
		DozerBeanMapper dozerMapper = new DozerBeanMapper();
		try {
			
			boolean newEntry = true ;
			sectionId = travelData.getSectionId() ;
			branchCode = travelData.getBranchCode();
			agencyCode =  travelData.getBrokerCode();
			productId =  travelData.getProductId();
			companyId =  travelData.getCompanyId();
		//	Double grossWeight = Double.valueOf(df.format(motorDatas.getGrossWeight()/ 1000));


//			CriteriaBuilder cb = em.getCriteriaBuilder();
//			CriteriaQuery<MsHumanDetails> query = cb.createQuery(MsHumanDetails.class);
//
//			// Find All
//			Root<MsHumanDetails> b = query.from(MsHumanDetails.class);
//
//			// Select
//			query.select(b);
//			Predicate n7 = cb.equal(cb.lower(b.get("createdBy")), travelData.getCreatedBy().toString().toLowerCase());
//			Predicate n8 = cb.equal(cb.lower(b.get("covidCoverYn")), travelData.getCovidCoverYn().toString().toLowerCase());
//			Predicate n9 = cb.equal(cb.lower(b.get("currency")), travelData.getCurrency().toString().toLowerCase());
//			Predicate n10 = cb.equal(cb.lower(b.get("destinationCountry")), travelData.getDestinationCountry().toString().toLowerCase());
//			Predicate n11 = cb.equal(b.get("exchangeRate"), travelData.getExchangeRate());
//			Predicate n12 = cb.equal(cb.lower(b.get("havepromocode")), travelData.getHavepromocode().toString().toLowerCase());
//			Predicate n13 = cb.equal(b.get("planTypeId"), travelData.getPlanTypeId());
//			Predicate n14 = cb.equal(cb.lower(b.get("promocode")), travelData.getPromocode().toString().toLowerCase());
//			Predicate n15 = cb.equal(cb.lower(b.get("sourceCountry")), travelData.getSourceCountry().toString().toLowerCase());
//			Predicate n16 = cb.equal(cb.lower(b.get("sportsCoverYn")), travelData.getSportsCoverYn().toString().toLowerCase());
//			Predicate n17 = cb.equal(cb.lower(b.get("terrorismCoverYn")), travelData.getTerrorismCoverYn().toString().toLowerCase());
//			Predicate n18 = cb.equal(b.get("totalPassengers"), travelData.getTotalPassengers());
//			Predicate n19 = cb.equal(b.get("travelCoverDuration"), travelData.getTravelCoverDuration());
//			Predicate n20 = cb.equal(b.get("travelCoverId"), travelData.getTravelCoverId());
//			Predicate n21 = cb.equal(b.get("travelId"), travelData.getTravelId());
//			Predicate n22 = cb.equal(b.get("requestReferenceNo"), travelData.getRequestReferenceNo());
//			Predicate n23 = cb.equal(b.get("groupId"), groupData.getGroupId());
//			Predicate n24 = cb.equal(b.get("groupCount"), groupData.getGrouppMembers());
//			
//			query.where(n7,n8,n9,n10,n11,n12,n13,n14,n15,n16,n17,n18,n19,n20,n21,n22,n23,n24) ;			
//			// Get Result
//			TypedQuery<MsHumanDetails> result = em.createQuery(query);
//			list = result.getResultList();		
//
//
//			if (list==null || list.size() <= 0 ) {
//				newEntry = true ;
//
//			} else {
//				vdRefNo = String.valueOf(list.get(0).getVdRefno());
//				
//			}
			if(newEntry==true  ) {
			//	Random rand = new Random();
	        //  int random=rand.nextInt(90)+10;
				vdRefNo = genOneTimeTableRefNo() ; //sdf.format(new Date()) + random ;
				SectionCoverMaster covageageLimit=getCoverageLimit(request);
//				if(travelData.getPlanTypeId() == 3 ) {
//					MsHumanDetails saveHuman = new MsHumanDetails();
//					dozerMapper.map(travelData, saveHuman);
//					saveHuman.setHumanId(Integer.valueOf(3));
//					saveHuman.setVdRefno(Long.valueOf(vdRefNo) );
//					saveHuman.setEntryDate(new Date());
//					saveHuman.setGroupId(Integer.valueOf(3));
//					saveHuman.setSumInsured(covageageLimit.getCoverageLimit());
//					//saveHuman.setSumInsured(BigDecimal.ONE);
//					saveHuman.setGroupCount(1);
//					saveHuman.setPeriodOfInsurance(travelData.getTravelCoverDuration().toString());
//					saveHuman.setExchangeRate(BigDecimal.ONE);
//					saveHuman.setCurrency("USD");
//					saveHuman.setEndtTypeId(travelData.getEndorsementType()==null?0 :travelData.getEndorsementType() ) ;
//					saveHuman.setEndtCategoryId(travelData.getIsFinaceYn()==null?"N" :travelData.getIsFinaceYn() );
//
//
//					msHumanRepo.saveAndFlush(saveHuman);
//				} else {
					for(TravelGroupInsertReq data   : request.getGroupDetails() ) {
						MsHumanDetails saveHuman = new MsHumanDetails();
						dozerMapper.map(travelData, saveHuman);
						saveHuman.setHumanId(Integer.valueOf(data.getGroupId()));
						saveHuman.setVdRefno(Long.valueOf(vdRefNo) );
						saveHuman.setEntryDate(new Date());
						saveHuman.setGroupId(Integer.valueOf(data.getGroupId()));
						saveHuman.setSumInsured(covageageLimit.getCoverageLimit());
						//saveHuman.setSumInsured(BigDecimal.ONE);
						saveHuman.setGroupCount(Integer.valueOf(data.getGroupMembers()));
						saveHuman.setPeriodOfInsurance(travelData.getTravelCoverDuration().toString());
						saveHuman.setExchangeRate(BigDecimal.ONE);
						saveHuman.setCurrency("USD");
						saveHuman.setEndtTypeId(travelData.getEndorsementType()==null?0 :travelData.getEndorsementType() ) ;
						saveHuman.setEndtCategoryId(travelData.getIsFinaceYn()==null?"N" :travelData.getIsFinaceYn() );


						msHumanRepo.saveAndFlush(saveHuman);
					}	
		//		}
				
		
			}
			res.setVdRefNo(vdRefNo);
			res.setSectionId(sectionId);
			res.setAgencyCode(agencyCode);
			res.setBranchCode(branchCode);
			res.setProductId(productId);
			res.setCompanyId(companyId);
			resList.add(res);
		}catch (Exception e) {
			e.printStackTrace();
			log.error("Exception is ---> " + e.getMessage());
			return null ;
		}

		return resList;
	}
	
	@Transactional
	private synchronized List<OneTimeVehicleRes> call_MSHuman(OneTimeTableReq request) {
		List<OneTimeVehicleRes> resList = new ArrayList<OneTimeVehicleRes>();
		OneTimeVehicleRes res = new  OneTimeVehicleRes();
		List<MsHumanDetails> list = new ArrayList<MsHumanDetails>();

		String vdRefNo = "" ;
		String sectionId = "" ;
		String agencyCode = "" ;
		String branchCode = "" ;
		String productId = "" ;
		String companyId = "" ;
		DozerBeanMapper dozerMapper = new DozerBeanMapper();
		
		try {
			EserviceCommonDetails commonData = esercommonDatas.get(0) ;
			boolean newEntry = false ;
			sectionId = commonData.getSectionId() ;
			branchCode = commonData.getBranchCode();
			agencyCode =  commonData.getBrokerCode();
			productId =  commonData.getProductId();
			companyId =  commonData.getCompanyId();
			
			
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<MsHumanDetails> query = cb.createQuery(MsHumanDetails.class);

			// Find All
			Root<MsHumanDetails> b = query.from(MsHumanDetails.class);

			// Select
			query.select(b);
			Predicate n1 = (cb.like(cb.lower(b.get("requestReferenceNo")), commonData.getRequestReferenceNo().toString().toLowerCase()));		
			Predicate n4 = (cb.like(cb.lower(b.get("createdBy")), commonData.getCreatedBy().toString().toLowerCase()));		
			Predicate n5 = (cb.equal(b.get("humanId"), commonData.getRiskId()));		
			Predicate n8 = (cb.like(cb.lower(b.get("status")), commonData.getStatus().toString().toLowerCase()));		
			Predicate n9 = (cb.equal(b.get("periodOfInsurance"), commonData.getPolicyPeriod()));		
			Predicate n10 = (cb.like(cb.lower(b.get("currency")), commonData.getCurrency().toString().toLowerCase()));		
			Predicate n11 = (cb.equal(b.get("exchangeRate"), commonData.getExchangeRate()));		
			Predicate n12 = (cb.equal(b.get("sumInsured"), commonData.getSumInsured()));		
			Predicate n13 = (cb.equal(b.get("categoryId"), commonData.getCategoryId()));		
			Predicate n14 = cb.equal(cb.lower(b.get("havepromocode")), commonData.getHavepromocode().toString().toLowerCase());
			Predicate n15 = cb.equal(cb.lower(b.get("promocode")), commonData.getPromocode()==null?"" : commonData.getPromocode().toString().toLowerCase());
			Predicate n16 = cb.equal(cb.lower(b.get("groupId")), 1);
			Predicate n17 = cb.equal(cb.lower(b.get("groupCount")), 1);
			Predicate n40 = (cb.equal(b.get("endtTypeId"),commonData.getEndorsementType()==null?0 :commonData.getEndorsementType() ));
			Predicate n41 = (cb.equal(b.get("endtCategoryId"),commonData.getIsFinaceYn()==null?"N" :commonData.getIsFinaceYn() ));
			Predicate n42 = (cb.equal(b.get("natureOfBusinessId"),commonData.getNatureOfBusinessId()) );
			Predicate n43 = (cb.equal(b.get("totalNoOfEmployees"),commonData.getTotalNoOfEmployees()));
			Predicate n44 = (cb.equal(b.get("totalExcludedEmployees"),commonData.getTotalExcludedEmployees()));
			Predicate n45 = (cb.equal(b.get("totalRejoinedEmployees"),commonData.getTotalRejoinedEmployees()));
			Predicate n46 = (cb.equal(b.get("accountOutstandingEmployees"),commonData.getAccountOutstandingEmployees()));
			Predicate n47 = (cb.equal(b.get("accountAuditentType"),commonData.getAccountAuditentType()));
			
			query.where(n1,n4,n5,n8,n9,n10,n11,n12,n13,n14,n15 ,n16,n17,n40,n41,n42,n43,n44,n45,n46,n47 );					
			// Get Result
			TypedQuery<MsHumanDetails> result = em.createQuery(query);
			list = result.getResultList();		


			if (list==null || list.size() <= 0 ) {
				newEntry = true ;

			} else {
				vdRefNo = String.format("%05d",list.get(0).getVdRefno());
			}
		
			if(newEntry==true  ) {
				vdRefNo = genOneTimeTableRefNo() ; 
				MsHumanDetails saveHuman = new MsHumanDetails();
				dozerMapper.map(commonData, saveHuman);
				saveHuman.setHumanId(Integer.valueOf(commonData.getRiskId()));
				saveHuman.setVdRefno(Long.valueOf(vdRefNo) );
				saveHuman.setEntryDate(new Date());
				saveHuman.setGroupId(Integer.valueOf(1));
				saveHuman.setSumInsured(commonData.getSumInsured());
				saveHuman.setGroupCount(1);
				saveHuman.setPeriodOfInsurance(commonData.getPolicyPeriod().toString());
				saveHuman.setCategoryId(commonData.getCategoryId());
				saveHuman.setEndtTypeId(commonData.getEndorsementType()==null?0 :commonData.getEndorsementType() ) ;
				saveHuman.setEndtCategoryId(commonData.getIsFinaceYn()==null?"N" :commonData.getIsFinaceYn() );
				saveHuman.setNatureOfBusinessId(commonData.getNatureOfBusinessId());
				saveHuman.setTotalNoOfEmployees(commonData.getTotalNoOfEmployees());
				saveHuman.setTotalExcludedEmployees(commonData.getTotalExcludedEmployees());
				saveHuman.setTotalRejoinedEmployees(commonData.getTotalRejoinedEmployees());
				saveHuman.setAccountOutstandingEmployees(commonData.getAccountOutstandingEmployees());
				saveHuman.setAccountAuditentType(commonData.getAccountAuditentType());
				
				msHumanRepo.saveAndFlush(saveHuman);
				
			}
			res.setVdRefNo(vdRefNo);
			res.setSectionId(sectionId);
			res.setAgencyCode(agencyCode);
			res.setBranchCode(branchCode);
			res.setProductId(productId);
			res.setCompanyId(companyId);
			resList.add(res);
			
		}catch (Exception e) {
			e.printStackTrace();
			log.error("Exception is ---> " + e.getMessage());
			return null ;
		}

		return resList;
	}
	
	private synchronized List<OneTimeVehicleRes> call_MSAsset(OneTimeTableReq request) {
		List<OneTimeVehicleRes> resList = new  ArrayList<OneTimeVehicleRes>();
	
		String vdRefNo = "" ;
		String sectionId = "" ;
		String agencyCode = "" ;
		String branchCode = "" ;
		String productId = "" ;
		String companyId = "" ;
		String riskId = "" ;
		
		// SimpleDateFormat sdf = new SimpleDateFormat("yyMMddhhmmssSS");
		String pattern = "#####0.00";
		DecimalFormat df = new DecimalFormat(pattern);
		DozerBeanMapper dozerMapper = new DozerBeanMapper();
		try {
			
			
			boolean newEntry = true ;
			
			branchCode = eserBuild.getBranchCode();
			agencyCode =  eserBuild.getBrokerCode();
			productId =  eserBuild.getProductId().toString();
			companyId =  eserBuild.getCompanyId();

		for ( BuildingSectionRes sec :    request.getSectionList()  ) {
			OneTimeVehicleRes res = new  OneTimeVehicleRes();
			
			if ( sec.getMotorYn().equalsIgnoreCase("H") ) {
				
				List<MsHumanDetails> list = new ArrayList<MsHumanDetails>();
				EserviceCommonDetails commonData = esercommonDatas.get(0) ;
			    newEntry = false ;
				sectionId = commonData.getSectionId() ;
				branchCode = commonData.getBranchCode();
				agencyCode =  commonData.getBrokerCode();
				productId =  commonData.getProductId();
				companyId =  commonData.getCompanyId();
				riskId 	   = commonData.getRiskId().toString();
				
				CriteriaBuilder cb = em.getCriteriaBuilder();
				CriteriaQuery<MsHumanDetails> query = cb.createQuery(MsHumanDetails.class);

				// Find All
				Root<MsHumanDetails> b = query.from(MsHumanDetails.class);
				List<Predicate> predicate = new ArrayList<Predicate>();
				
				// Select
				query.select(b);
				predicate.add(cb.like(cb.lower(b.get("requestReferenceNo")), commonData.getRequestReferenceNo().toString().toLowerCase()));		
				predicate.add(cb.like(cb.lower(b.get("createdBy")), commonData.getCreatedBy().toString().toLowerCase()));		
				predicate.add(cb.equal(b.get("humanId"), commonData.getRiskId()));		
				predicate.add(cb.like(cb.lower(b.get("status")), commonData.getStatus().toString().toLowerCase()));		
				predicate.add(cb.equal(b.get("periodOfInsurance"), commonData.getPolicyPeriod()));		
				predicate.add(cb.like(cb.lower(b.get("currency")), commonData.getCurrency().toString().toLowerCase()));		
				predicate.add(cb.equal(b.get("exchangeRate"), commonData.getExchangeRate()));		
				predicate.add(cb.equal(b.get("sumInsured"), commonData.getSumInsured()));		
				predicate.add(cb.equal(b.get("categoryId"), commonData.getCategoryId()));		
				predicate.add(cb.equal(cb.lower(b.get("havepromocode")), commonData.getHavepromocode().toString().toLowerCase()));
				predicate.add(cb.equal(cb.lower(b.get("promocode")), commonData.getPromocode()==null?"" : commonData.getPromocode().toString().toLowerCase()));
				predicate.add(cb.equal(cb.lower(b.get("groupId")), 1));
				predicate.add(cb.equal(cb.lower(b.get("groupCount")), 1));
				predicate.add(cb.equal(b.get("endtTypeId"),commonData.getEndorsementType()==null?0 :commonData.getEndorsementType() ));
				predicate.add(cb.equal(b.get("endtCategoryId"),commonData.getIsFinaceYn()==null?"N" :commonData.getIsFinaceYn() ));
				predicate.add(cb.equal(b.get("natureOfBusinessId"),commonData.getNatureOfBusinessId()) );
				predicate.add(cb.equal(b.get("totalNoOfEmployees"),commonData.getTotalNoOfEmployees()));
				predicate.add(cb.equal(b.get("totalExcludedEmployees"),commonData.getTotalExcludedEmployees()));
				predicate.add(cb.equal(b.get("totalRejoinedEmployees"),commonData.getTotalRejoinedEmployees()));
				predicate.add(cb.equal(b.get("accountOutstandingEmployees"),commonData.getAccountOutstandingEmployees()));
				predicate.add(cb.equal(b.get("accountAuditentType"),commonData.getAccountAuditentType()));
				//predicate.add(cb.equal(b.get("industryName"),commonData.getIndustryName()));
				predicate.add(cb.equal(b.get("liabilitySi"),commonData.getLiabilitySi()));
				predicate.add(cb.equal(b.get("fidEmpCount"),commonData.getFidEmpCount()));
				predicate.add(cb.equal(b.get("fidEmpSi"),commonData.getFidEmpSi()));
				predicate.add(cb.equal(b.get("empLiabilitySi"),commonData.getEmpLiabilitySi()));
				predicate.add(cb.equal(b.get("personalLiabilityOccupation"),commonData.getPersonalLiabilityOccupation()));
				predicate.add(cb.equal(b.get("personalLiabilitySi"),commonData.getPersonalLiabilitySi()));
				predicate.add(cb.equal(b.get("personalLiabilityCategory"),commonData.getPersonalLiabilityCategory()));
				
				query.where(predicate.toArray(new Predicate[0]));					
				// Get Result
				TypedQuery<MsHumanDetails> result = em.createQuery(query);
				list = result.getResultList();		


				if (list==null || list.size() <= 0 ) {
					newEntry = true ;

				} else {
					vdRefNo = String.format("%05d",list.get(0).getVdRefno());
					riskId  = String.valueOf(list.get(0).getHumanId());
				}
			
				if(newEntry==true  ) {
					vdRefNo = genOneTimeTableRefNo() ; 
					riskId  = String.valueOf(commonData.getRiskId());
					
					MsHumanDetails saveHuman = new MsHumanDetails();
					dozerMapper.map(commonData, saveHuman);
					saveHuman.setHumanId(Integer.valueOf(commonData.getRiskId()));
					saveHuman.setVdRefno(Long.valueOf(vdRefNo) );
					saveHuman.setEntryDate(new Date());
					saveHuman.setGroupId(Integer.valueOf(1));
					saveHuman.setSumInsured(commonData.getSumInsured());
					saveHuman.setGroupCount(1);
					saveHuman.setPeriodOfInsurance(commonData.getPolicyPeriod().toString());
					saveHuman.setCategoryId(commonData.getCategoryId());
					saveHuman.setEndtTypeId(commonData.getEndorsementType()==null?0 :commonData.getEndorsementType() ) ;
					saveHuman.setEndtCategoryId(commonData.getIsFinaceYn()==null?"N" :commonData.getIsFinaceYn() );
					saveHuman.setNatureOfBusinessId(commonData.getNatureOfBusinessId());
					saveHuman.setTotalNoOfEmployees(commonData.getTotalNoOfEmployees());
					saveHuman.setTotalExcludedEmployees(commonData.getTotalExcludedEmployees());
					saveHuman.setTotalRejoinedEmployees(commonData.getTotalRejoinedEmployees());
					saveHuman.setAccountOutstandingEmployees(commonData.getAccountOutstandingEmployees());
					saveHuman.setAccountAuditentType(commonData.getAccountAuditentType());
					saveHuman.setEndtTypeId(commonData.getEndorsementType()==null?0 :commonData.getEndorsementType() ) ;
					saveHuman.setEndtCategoryId(commonData.getIsFinaceYn()==null?"N" :commonData.getIsFinaceYn() );
					
					msHumanRepo.saveAndFlush(saveHuman);
					sectionId = sec.getSectionId() ;
				}
				
				
				
			} else {
				
				CriteriaBuilder cb = em.getCriteriaBuilder();
		
				CriteriaQuery<MsAssetDetails> query = cb.createQuery(MsAssetDetails.class);

				// Find All
				List<MsAssetDetails> list = new ArrayList<MsAssetDetails>();
				Root<MsAssetDetails> b = query.from(MsAssetDetails.class);
				List<Predicate> predicate = new ArrayList<Predicate>();
				// Select
				query.select(b);
				predicate.add(cb.like(cb.lower(b.get("requestReferenceNo")), eserBuild.getRequestReferenceNo().toString().toLowerCase()));		
				predicate.add(cb.like(b.get("branchCode"), eserBuild.getBranchCode().toString()));		
				predicate.add(cb.equal(b.get("buildingAge"), eserBuild.getBuildingAge()));		
				predicate.add(cb.equal(b.get("buildingFloors"), eserBuild.getBuildingFloors()));		
				predicate.add(cb.equal(b.get("buildingSuminsured"),eserBuild.getBuildingSuminsured() ==null?0: eserBuild.getBuildingSuminsured()));		
				predicate.add(cb.like(b.get("companyId"), eserBuild.getCompanyId().toString()));		
				predicate.add(cb.like(cb.lower(b.get("createdBy")), eserBuild.getCreatedBy().toString().toLowerCase()));		
				predicate.add(cb.equal(b.get("locationId"), eserBuild.getRiskId()));		
				predicate.add(cb.equal(b.get("productId"), eserBuild.getProductId()));		
				predicate.add(cb.equal(b.get("sectionId"), sec.getSectionId()));		
				predicate.add(cb.like(cb.lower(b.get("status")), eserBuild.getStatus().toString().toLowerCase()));		
				predicate.add(cb.equal(b.get("periodOfInsurance"), eserBuild.getPolicyPeriord()));		
				predicate.add(cb.like(cb.lower(b.get("currency")), eserBuild.getCurrency().toString().toLowerCase()));		
				predicate.add(cb.equal(b.get("exchangeRate"), eserBuild.getExchangeRate()));		
				predicate.add(cb.like(b.get("buildingPurposeId"), eserBuild.getBuildingPurposeId()));		
				predicate.add(cb.like(b.get("buildingUsageId"), eserBuild.getBuildingUsageId()));		
				predicate.add(cb.equal(b.get("allriskSuminsured"), eserBuild.getAllriskSuminsured()));		
				predicate.add(cb.equal(b.get("personalIntSuminsured"), eserBuild.getPersonalIntSuminsured()));		
				predicate.add(cb.equal(b.get("contentSuminsured"), eserBuild.getContentSuminsured()));		
				predicate.add(cb.equal(b.get("categoryId"), eserBuild.getCategoryId()));				
				predicate.add(cb.equal(b.get("paDeathSuminsured"), eserBuild.getPaDeathSuminsured()));	
				predicate.add(cb.equal(b.get("paPermanentdisablementSuminsured"), eserBuild.getPaPermanentdisablementSuminsured()));
				predicate.add(cb.equal(b.get("paTotaldisabilitySumInsured"), eserBuild.getPaTotaldisabilitySumInsured()));
				predicate.add(cb.equal(b.get("PaMedicalSuminsured"), eserBuild.getPaMedicalSuminsured()));
				predicate.add(cb.equal(b.get("workmenCompSuminsured"), eserBuild.getWorkmenCompSuminsured()));
				predicate.add(cb.equal(b.get("endtTypeId"),eserBuild.getEndorsementType()==null?0 :eserBuild.getEndorsementType() ));
				predicate.add(cb.equal(b.get("endtCategoryId"),eserBuild.getIsFinaceYn()==null?"N" :eserBuild.getIsFinaceYn() ));
				predicate.add(cb.equal(b.get("cashInHandDirectors"),eserBuild.getCashInHandDirectors()));
				predicate.add(cb.equal(b.get("cashInHandEmployees"),eserBuild.getCashInHandEmployees()));
				predicate.add(cb.equal(b.get("cashInPremises"),eserBuild.getCashInPremises()));
				predicate.add(cb.equal(b.get("cashInSafe"),eserBuild.getCashInSafe()));
				predicate.add(cb.equal(b.get("cashInTransit"),eserBuild.getCashInTransit()));
				predicate.add(cb.equal(b.get("cashValueablesSi"),eserBuild.getCashValueablesSi()));
				predicate.add(cb.equal(b.get("revenueFromStamps"),eserBuild.getRevenueFromStamps()));
				predicate.add(cb.equal(b.get("moneyInLocker"),eserBuild.getMoneyInLocker()));
				predicate.add(cb.equal(b.get("moneyInPremises"),eserBuild.getMoneyInPremises()));
				predicate.add(cb.equal(b.get("moneyInSafeBusiness"),eserBuild.getMoneyInSafeBusiness()));
				predicate.add(cb.equal(b.get("moneyOutSafeBusiness"),eserBuild.getMoneyOutSafeBusiness()));
				predicate.add(cb.equal(b.get("moneyInPremises"),eserBuild.getMoneyInPremises()));
				predicate.add(cb.equal(b.get("moneyAnnualcarrySuminsured"),eserBuild.getMoneyAnnualcarrySuminsured()));
				predicate.add(cb.equal(b.get("fidelityAnyoccuSuminsured"), eserBuild.getFidelityAnyoccuSuminsured()));		
				predicate.add(cb.equal(b.get("fidelityAnnualSuminsured"), eserBuild.getFidelityAnnualSuminsured()));		
				predicate.add(cb.equal(b.get("tpliabilityAnyoccuSuminsured"), eserBuild.getTpliabilityAnyoccuSuminsured()));		
				predicate.add(cb.equal(b.get("empliabilityAnnualSuminsured"), eserBuild.getEmpliabilityAnnualSuminsured()));		
				predicate.add(cb.equal(b.get("empliabilityExcessSuminsured"), eserBuild.getEmpliabilityExcessSuminsured()));		
				predicate.add(cb.equal(b.get("goodsSinglecarrySuminsured"), eserBuild.getGoodsSinglecarrySuminsured()));		
				predicate.add(cb.equal(b.get("goodsTurnoverSuminsured"), eserBuild.getGoodsTurnoverSuminsured()));		
				predicate.add(cb.equal(b.get("industryId"), eserBuild.getIndustryId()));		
				predicate.add(cb.equal(b.get("workmenCompSuminsured"), eserBuild.getWorkmenCompSuminsured()));
				predicate.add(cb.equal(b.get("endtTypeId"),eserBuild.getEndorsementType()==null?0 :eserBuild.getEndorsementType() ));
				predicate.add(cb.equal(b.get("endtCategoryId"),eserBuild.getIsFinaceYn()==null?"N" :eserBuild.getIsFinaceYn() ));
				predicate.add(cb.equal(b.get("natureOfTradeId"),eserBuild.getNatureOfTradeId()) );
				predicate.add(cb.equal(b.get("insuranceForId"),eserBuild.getInsuranceForId() ));
				predicate.add(cb.equal(b.get("internalWallType"),eserBuild.getInternalWallType() ));
				predicate.add(cb.equal(b.get("ceilingType"),eserBuild.getCeilingType() ));
				predicate.add(cb.equal(b.get("stockInTradeSi"),eserBuild.getStockInTradeSi() ));
				predicate.add(cb.equal(b.get("goodsSi"),eserBuild.getGoodsSi() ));
				predicate.add(cb.equal(b.get("applianceSi"),eserBuild.getApplianceSi() ));
				predicate.add(cb.equal(b.get("cashValueablesSi"),eserBuild.getCashValueablesSi() ));
				predicate.add(cb.equal(b.get("occupiedYear"),eserBuild.getOccupiedYear() ));
				predicate.add(cb.equal(b.get("showWindow"),eserBuild.getShowWindow() ));
				predicate.add(cb.equal(b.get("frontDoors"),eserBuild.getFrontDoors() ));
				predicate.add(cb.equal(b.get("backDoors"),eserBuild.getBackDoors() ));
				predicate.add(cb.equal(b.get("windowsMaterialId"),eserBuild.getWindowsMaterialId() ));
				predicate.add(cb.equal(b.get("nightLeftDoor"),eserBuild.getNightLeftDoor() ));
				predicate.add(cb.equal(b.get("buildingOccupied"),eserBuild.getBuildingOccupied() ));
				predicate.add(cb.equal(b.get("watchmanGuardHours"),eserBuild.getWatchmanGuardHours() ));
				predicate.add(cb.equal(b.get("accessibleWindows"),eserBuild.getAccessibleWindows() ));
				predicate.add(cb.equal(b.get("trapDoors"),eserBuild.getTrapDoors() ));
				predicate.add(cb.equal(b.get("buildingAge"),eserBuild.getBuildingAge() ));
				predicate.add(cb.equal(b.get("industryId"),eserBuild.getIndustryId() ));
				predicate.add(cb.equal(b.get("cashInHandDirectors"),eserBuild.getCashInHandDirectors() ));
				predicate.add(cb.equal(b.get("cashInTransit"),eserBuild.getCashInTransit() ));
				predicate.add(cb.equal(b.get("cashInHandEmployees"),eserBuild.getCashInHandEmployees() ));
				predicate.add(cb.equal(b.get("cashInSafe"),eserBuild.getCashInSafe() ));
				predicate.add(cb.equal(b.get("cashInPremises"),eserBuild.getCashInPremises() ));
				predicate.add(cb.equal(b.get("revenueFromStamps"),eserBuild.getRevenueFromStamps() ));
				predicate.add(cb.equal(b.get("moneyInSafeBusiness"),eserBuild.getMoneyInSafeBusiness() ));
				predicate.add(cb.equal(b.get("moneyOutSafeBusiness"),eserBuild.getMoneyOutSafeBusiness() ));
				predicate.add(cb.equal(b.get("moneyInPremises"),eserBuild.getMoneyInPremises() ));
				predicate.add(cb.equal(b.get("moneyInLocker"),eserBuild.getMoneyInLocker() ));
				predicate.add(cb.equal(b.get("machineEquipSi"),eserBuild.getMachineEquipSi() ));
				predicate.add(cb.equal(b.get("plateGlassSi"),eserBuild.getPlateGlassSi() ));
				predicate.add(cb.equal(b.get("firstLossPercent"),eserBuild.getFirstLossPercent() ));
				predicate.add(cb.equal(b.get("accDamageSi"),eserBuild.getAccDamageSi() ));
				predicate.add(cb.equal(b.get("burglarySi"),eserBuild.getBurglarySi() ));
				predicate.add(cb.equal(b.get("powerPlantSi"),eserBuild.getPowerPlantSi() ));
				predicate.add(cb.equal(b.get("machineEquipSi"),eserBuild.getMachineEquipSi() ));
				predicate.add(cb.equal(b.get("elecMachinesSi"),eserBuild.getElecMachinesSi() ));
				predicate.add(cb.equal(b.get("equipmentSi"),eserBuild.getEquipmentSi() ));
				predicate.add(cb.equal(b.get("generalMachineSi"),eserBuild.getGeneralMachineSi() ));
				predicate.add(cb.equal(b.get("manuUnitsSi"),eserBuild.getManuUnitsSi() ));
				predicate.add(cb.equal(b.get("boilerPlantsSi"),eserBuild.getBoilerPlantsSi() ));
				
			      
				query.where(predicate.toArray(new Predicate[0]));	
				
				// Get Result
				TypedQuery<MsAssetDetails> result = em.createQuery(query);
				list = result.getResultList();	
				
				if (list==null || list.size() <= 0 ) {
					newEntry = true ;

				} else {
					vdRefNo = String.valueOf(list.get(0).getVdRefno());
					riskId  = String.valueOf(list.get(0).getLocationId());

				}
				
				if(newEntry==true  ) {
				//	Random rand = new Random();
		         //    int random=rand.nextInt(90)+10;
					vdRefNo = genOneTimeTableRefNo() ; // sdf.format(new Date()) + random ;
					riskId 	   = eserBuild.getRiskId().toString();
					
					MsAssetDetails saveAsset = new MsAssetDetails();
					dozerMapper.map(eserBuild, saveAsset);
					saveAsset.setVdRefno(Long.valueOf(vdRefNo));	
					saveAsset.setLocationId(eserBuild.getRiskId());
					saveAsset.setEntryDate(new Date());
					saveAsset.setStatus("Y");
					saveAsset.setGroupCount(1);
					saveAsset.setBuildingAge(eserBuild.getBuildingAge());
					saveAsset.setPeriodOfInsurance(String.valueOf(eserBuild.getPolicyPeriord()));
					saveAsset.setExchangeRate(eserBuild.getExchangeRate());
					saveAsset.setCurrency(eserBuild.getCurrency());
					saveAsset.setBuildingFloors(eserBuild.getBuildingFloors());
					saveAsset.setRequestReferenceNo(eserBuild.getRequestReferenceNo());
					saveAsset.setContentSuminsured(eserBuild.getContentSuminsured()==null?null: eserBuild.getContentSuminsured());
					saveAsset.setAllriskSuminsured(eserBuild.getAllriskSuminsured()==null?null: eserBuild.getAllriskSuminsured());
					saveAsset.setBuildingSuminsured(eserBuild.getBuildingSuminsured()==null?null: eserBuild.getBuildingSuminsured());
					saveAsset.setPaDeathSuminsured(eserBuild.getPaDeathSuminsured()==null?null: eserBuild.getPaDeathSuminsured());
					saveAsset.setPaPermanentdisablementSuminsured(eserBuild.getPaPermanentdisablementSuminsured()==null?null: eserBuild.getPaPermanentdisablementSuminsured());
					saveAsset.setPaTotaldisabilitySumInsured(eserBuild.getPaTotaldisabilitySumInsured()==null?null: eserBuild.getPaTotaldisabilitySumInsured());
					saveAsset.setPaMedicalSuminsured(eserBuild.getPaMedicalSuminsured()==null?null: eserBuild.getPaMedicalSuminsured());
					saveAsset.setPersonalIntSuminsured(eserBuild.getPersonalIntSuminsured()==null?null:  eserBuild.getPersonalIntSuminsured());
					saveAsset.setSectionId(Integer.valueOf(sec.getSectionId()));
					saveAsset.setCategoryId(eserBuild.getCategoryId());
					saveAsset.setOccupationType(eserBuild.getOccupationType());
					saveAsset.setWorkmenCompSuminsured(eserBuild.getWorkmenCompSuminsured()==null?null:eserBuild.getWorkmenCompSuminsured());
					saveAsset.setCashInHandDirectors(eserBuild.getCashInHandDirectors());
					saveAsset.setCashInHandEmployees(eserBuild.getCashInHandEmployees());
					saveAsset.setCashInPremises(eserBuild.getCashInPremises());
					saveAsset.setCashInSafe(eserBuild.getCashInSafe());
					saveAsset.setCashInTransit(eserBuild.getCashInTransit());
					saveAsset.setCashValueablesSi(eserBuild.getCashValueablesSi());
					saveAsset.setRevenueFromStamps(eserBuild.getRevenueFromStamps());
					saveAsset.setMoneyInLocker(eserBuild.getMoneyInLocker());
					saveAsset.setMoneyInPremises(eserBuild.getMoneyInPremises());
					saveAsset.setMoneyInSafeBusiness(eserBuild.getMoneyInSafeBusiness());
					saveAsset.setMoneyOutSafeBusiness(eserBuild.getMoneyOutSafeBusiness());
					saveAsset.setMoneyInPremises(eserBuild.getMoneyInPremises());
					saveAsset.setMoneyAnnualcarrySuminsured(eserBuild.getMoneyAnnualcarrySuminsured());
					saveAsset.setMoneySinglecarrySuminsured(eserBuild.getMoneySinglecarrySuminsured());
					saveAsset.setElecEquipSuminsured(eserBuild.getElecEquipSuminsured()==null?null:  eserBuild.getElecEquipSuminsured());
					saveAsset.setMoneySinglecarrySuminsured(eserBuild.getMoneySinglecarrySuminsured()==null?null:  eserBuild.getMoneySinglecarrySuminsured());
					saveAsset.setMoneyInsafeSuminsured(eserBuild.getMoneyInsafeSuminsured()==null?null:  eserBuild.getMoneyInsafeSuminsured());;
					saveAsset.setMoneyAnnualcarrySuminsured(eserBuild.getMoneyAnnualcarrySuminsured()==null?null:  eserBuild.getMoneyAnnualcarrySuminsured());
					saveAsset.setFidelityAnyoccuSuminsured(eserBuild.getFidelityAnyoccuSuminsured()==null?null:  eserBuild.getFidelityAnyoccuSuminsured());
					saveAsset.setFidelityAnnualSuminsured(eserBuild.getFidelityAnnualSuminsured()==null?null:  eserBuild.getFidelityAnnualSuminsured());
					saveAsset.setTpliabilityAnyoccuSuminsured(eserBuild.getTpliabilityAnyoccuSuminsured()==null?null:  eserBuild.getTpliabilityAnyoccuSuminsured());
					saveAsset.setEmpliabilityAnnualSuminsured(eserBuild.getEmpliabilityAnnualSuminsured()==null?null:  eserBuild.getEmpliabilityAnnualSuminsured());;
					saveAsset.setEmpliabilityExcessSuminsured(eserBuild.getEmpliabilityExcessSuminsured()==null?null:  eserBuild.getEmpliabilityExcessSuminsured());
					saveAsset.setGoodsSinglecarrySuminsured(eserBuild.getGoodsSinglecarrySuminsured()==null?null:  eserBuild.getGoodsSinglecarrySuminsured());
					saveAsset.setGoodsTurnoverSuminsured(eserBuild.getGoodsTurnoverSuminsured()==null?null:  eserBuild.getGoodsTurnoverSuminsured());
					saveAsset.setIndustryId(eserBuild.getIndustryId()==null?0:eserBuild.getIndustryId());
					saveAsset.setWorkmenCompSuminsured(eserBuild.getWorkmenCompSuminsured()==null?null:eserBuild.getWorkmenCompSuminsured());
					saveAsset.setEndtTypeId(eserBuild.getEndorsementType()==null?0 :eserBuild.getEndorsementType() ) ;
					saveAsset.setEndtCategoryId(eserBuild.getIsFinaceYn()==null?"N" :eserBuild.getIsFinaceYn() );
					saveAsset.setNatureOfTradeId(eserBuild.getNatureOfTradeId());
					saveAsset.setInsuranceForId(eserBuild.getInsuranceForId() );
					saveAsset.setInternalWallType(eserBuild.getInternalWallType() );
					saveAsset.setCeilingType(eserBuild.getCeilingType() );
					saveAsset.setStockInTradeSi(eserBuild.getStockInTradeSi() );
					saveAsset.setGoodsSi(eserBuild.getGoodsSi() );
					saveAsset.setApplianceSi(eserBuild.getApplianceSi() );
					saveAsset.setCashValueablesSi(eserBuild.getCashValueablesSi() );
					saveAsset.setOccupiedYear(eserBuild.getOccupiedYear() );
					saveAsset.setShowWindow(eserBuild.getShowWindow() );
					saveAsset.setFrontDoors(eserBuild.getFrontDoors() );
					saveAsset.setBackDoors(eserBuild.getBackDoors() );
					saveAsset.setWindowsMaterialId(eserBuild.getWindowsMaterialId() );
					saveAsset.setNightLeftDoor(eserBuild.getNightLeftDoor() );
					saveAsset.setBuildingOccupied(eserBuild.getBuildingOccupied() );
					saveAsset.setWatchmanGuardHours(eserBuild.getWatchmanGuardHours() );
					saveAsset.setAccessibleWindows(eserBuild.getAccessibleWindows() );
					saveAsset.setTrapDoors(eserBuild.getTrapDoors() );
					saveAsset.setBuildingAge(eserBuild.getBuildingAge() );
					saveAsset.setIndustryId(eserBuild.getIndustryId() );
					
					
					msAssetRepo.saveAndFlush(saveAsset);
					sectionId = sec.getSectionId() ;
					
				}
			}
			
			res.setVdRefNo(vdRefNo);
			res.setSectionId(sectionId);
			res.setAgencyCode(agencyCode);
			res.setBranchCode(branchCode);
			res.setProductId(productId);
			res.setCompanyId(companyId);
			res.setVehicleId(riskId);
			resList.add(res);
		}
	
		
		}catch (Exception e) {
			e.printStackTrace();
			log.error("Exception is ---> " + e.getMessage());
			return null ;
		}

		return resList;
	}
	


	
	
	
	
	
	@Transactional
	public synchronized String call_MSCustomer(OneTimeTableReq request) {
		String cdRefNo = "" ;
		DozerBeanMapper dozerMapper = new DozerBeanMapper(); 
		// SimpleDateFormat sdf = new SimpleDateFormat("yyMMddhhmmssSS");
		try {
			List<MsCustomerDetails> list = new ArrayList<MsCustomerDetails>();
			
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<MsCustomerDetails> query = cb.createQuery(MsCustomerDetails.class);
			// Find All
			Root<MsCustomerDetails> b = query.from(MsCustomerDetails.class);
			// Select
			query.select(b);

			Predicate n1 = cb.equal(cb.lower(b.get("policyHolderTypeid")),custData.getPolicyHolderTypeid().toLowerCase());
			Predicate n2 = cb.equal(cb.lower(b.get("policyHolderType")),custData.getPolicyHolderType().toLowerCase());
			Predicate n3 = cb.equal(b.get("age"),custData.getAge());
			Predicate n4 = cb.equal(cb.lower(b.get("gender")),custData.getGender().toLowerCase());
			Predicate n5 = cb.equal(cb.lower(b.get("occupation")),custData.getOccupation().toLowerCase());
			Predicate n7 = cb.equal(cb.lower(b.get("regionCode")),custData.getRegionCode().toLowerCase());
		//	Predicate n8 = cb.equal(b.get("cityCode"),custData.getCityCode());
			Predicate n9 = cb.equal(b.get("taxExemptedId"),custData.getTaxExemptedId());
			Predicate n10 = cb.equal(cb.lower(b.get("status")),custData.getStatus().toLowerCase());
			Predicate n11 = cb.equal(cb.lower(b.get("idNumber")),custData.getIdNumber().toLowerCase());

			query.where(n1,n2,n3,n4,n5,n7,n9,n10,n11);					

			TypedQuery<MsCustomerDetails> result = em.createQuery(query);
			list =  result.getResultList(); 
			if (list!=null && list.size() > 0  ) {
				cdRefNo =String.format("%05d", list.get(0).getCdRefno()) ;
			} else {
			//	Random rand = new Random();
	         // int random=rand.nextInt(90)+10;
				cdRefNo =  genOneTimeTableRefNo() ;  //sdf.format(new Date()) + random ;				
				MsCustomerDetails saveNewEntry  = new  MsCustomerDetails(); 
				dozerMapper.map(custData, saveNewEntry);
				saveNewEntry.setCdRefno(Long.valueOf(cdRefNo) );
				saveNewEntry.setEntryDate(new Date());
				msCustomerRepo.save(saveNewEntry);
			}

		}catch (Exception e) {
			e.printStackTrace();
			log.error("Exception is ---> " + e.getMessage());
			return null ;
		}

		return cdRefNo;
	}

	 public synchronized String genOneTimeTableRefNo() {
	       try {
	    	   SeqOnetimetable entity;
	            entity = oneNoRepo.save(new SeqOnetimetable());          
	            return String.format("%05d",entity.getReferenceNo()) ;
	        } catch (Exception e) {
				e.printStackTrace();
				log.info( "Exception is ---> " + e.getMessage());
	            return null;
	        }
	       
	 }
	 
	 public SectionCoverMaster getCoverageLimit(OneTimeTableReq req) {
		 SectionCoverMaster res = new SectionCoverMaster();
			DozerBeanMapper dozerMapper = new  DozerBeanMapper();
		
			try {
				Date today  = new Date();
				Calendar cal = new GregorianCalendar(); 
				cal.setTime(today);
				cal.set(Calendar.HOUR_OF_DAY, 23);
				cal.set(Calendar.MINUTE, 1);
				today   = cal.getTime();
				
				// Criteria
				CriteriaBuilder cb = em.getCriteriaBuilder();
				CriteriaQuery<SectionCoverMaster> query = cb.createQuery(SectionCoverMaster.class);
				List<SectionCoverMaster> list = new ArrayList<SectionCoverMaster>();
				
				// Find All
				Root<SectionCoverMaster>    c = query.from(SectionCoverMaster.class);		
				
				// Select
				query.select(c);
				
				// Amend ID Max Filter
				Subquery<Long> amendId = query.subquery(Long.class);
				Root<SectionCoverMaster> ocpm1 = amendId.from(SectionCoverMaster.class);
				amendId.select(cb.max(ocpm1.get("amendId")));
				javax.persistence.criteria.Predicate a1 = cb.equal(c.get("sectionId"),ocpm1.get("sectionId") );
				javax.persistence.criteria.Predicate a2 = cb.equal(c.get("productId"),ocpm1.get("productId") ) ;
				javax.persistence.criteria.Predicate a3 = cb.equal(c.get("companyId"),ocpm1.get("companyId") ) ;
				Predicate a4 = cb.equal(c.get("coverId"),ocpm1.get("coverId") ) ;
				Predicate a5 = cb.equal(c.get("subCoverId"),ocpm1.get("subCoverId") ) ;
				//javax.persistence.criteria.Predicate a4 = cb.lessThanOrEqualTo(c.get("effectiveDateStart"),today ) ;
				//Predicate a5 = cb.equal(ocpm1.get("branchCode"),c.get("branchCode"));
				amendId.where(a1,a2,a3,a4,a5);
				
				
				
				// Order By
				List<Order> orderList = new ArrayList<Order>();
				orderList.add(cb.desc(c.get("effectiveDateStart")));
				
			    // Where	
			
				javax.persistence.criteria.Predicate n1 = cb.equal(c.get("amendId"), amendId);		
				javax.persistence.criteria.Predicate n2 = cb.equal(c.get("sectionId"),req.getSectionId()) ;
				javax.persistence.criteria.Predicate n3 = cb.equal(c.get("productId"),req.getProductId()) ;
				javax.persistence.criteria.Predicate n4 = cb.equal(c.get("companyId"),req.getInsuranceId()) ;
				javax.persistence.criteria.Predicate n5 = cb.equal(c.get("coverId"),"5") ;
				Predicate n6 = cb.equal(c.get("subCoverId"),"0") ;
				query.where(n1 ,n2,n3,n4,n5,n6).orderBy(orderList);
				
				// Get Result
				TypedQuery<SectionCoverMaster> result = em.createQuery(query);			
				list =  result.getResultList();  
				list = list.stream().filter(distinctByKey(o -> Arrays.asList(o.getCoverId()))).collect(Collectors.toList());
				res =  list.size()>0 ? list.get(0) : null ;
//				list.sort(Comparator.comparing(SectionCoverMaster :: getSectionName ));
//				
//				res = dozerMapper.map(list.get(0) , ProductSectionMasterRes.class);
//				res.setSectionId(list.get(0).getSectionId().toString());
//				res.setEntryDate(list.get(0).getEntryDate());
//				res.setEffectiveDateStart(list.get(0).getEffectiveDateStart());
			
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Exception is ---> " + e.getMessage());
				return null;
			}
			return res;
		}

}
