package com.maan.eway.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.maan.eway.bean.EserviceBuildingDetails;
import com.maan.eway.bean.EserviceCommonDetails;
import com.maan.eway.bean.EserviceCustomerDetails;
import com.maan.eway.bean.EserviceMotorDetails;
import com.maan.eway.bean.EserviceTravelDetails;
import com.maan.eway.bean.EserviceTravelGroupDetails;
import com.maan.eway.bean.MsCommonDetails;
import com.maan.eway.bean.MsCustomerDetails;
import com.maan.eway.bean.MsVehicleDetails;
import com.maan.eway.bean.SeqOnetimetable;
import com.maan.eway.config.onetime.Thread_OneTime;
import com.maan.eway.config.thread.MyTaskList;
import com.maan.eway.repository.EServiceBuildingDetailsRepository;
import com.maan.eway.repository.EServiceMotorDetailsRepository;
import com.maan.eway.repository.EServiceSectionDetailsRepository;
import com.maan.eway.repository.EserviceCommonDetailsRepository;
import com.maan.eway.repository.EserviceCustomerDetailsRepository;
import com.maan.eway.repository.EserviceTravelDetailsRepository;
import com.maan.eway.repository.EserviceTravelGroupDetailsRepository;
import com.maan.eway.repository.MsAssetDetailsRepository;
import com.maan.eway.repository.MsCommonDetailsRepository;
import com.maan.eway.repository.MsCustomerDetailsRepository;
import com.maan.eway.repository.MsHumanDetailsRepository;
import com.maan.eway.repository.MsVehicleDetailsRepository;
import com.maan.eway.repository.SeqOnetimetableRepository;
import com.maan.eway.req.OneTimeTableReq;
import com.maan.eway.res.MsCommonDetailsRes;
import com.maan.eway.res.MsCustomerDetailsRes;
import com.maan.eway.res.MsDetailsRes;
import com.maan.eway.res.MsVehicleDetailsRes;
import com.maan.eway.res.OneTimeTableRes;
import com.maan.eway.res.OneTimeVehicleRes;
import com.maan.eway.service.OneTimeService;

@Service
@Transactional
public class OneTimeServiceImpl implements OneTimeService {

	//@Lazy
	@Autowired
	private OneTimeService otSer;
	
	private ForkJoinPool forkjoin = new ForkJoinPool(2);
	
	@Autowired
	private EserviceCustomerDetailsRepository eserviceCustomerRepo ;
	
	@Autowired
	private MsCustomerDetailsRepository msCustomerRepo ;
	
	@Autowired
	private EServiceMotorDetailsRepository eserviceMotorRepo ;
	
	@Autowired
	private MsVehicleDetailsRepository msVehicleRepo ;
	
	@Autowired
	private MsCommonDetailsRepository msCommonRepo ;
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private EserviceTravelDetailsRepository eserTravelRepo ;
	@Autowired
	private MsHumanDetailsRepository msHumanRepo ;
	@Autowired
	private EserviceTravelGroupDetailsRepository eserGroupRepo ;
	@Autowired
	private EServiceBuildingDetailsRepository eserBuildRepo ;
	

	@Autowired
	private MsAssetDetailsRepository msAssetRepo ;
	
	@Autowired
	private EserviceCommonDetailsRepository eserCommonRepo ;
	
	@Autowired
	private SeqOnetimetableRepository oneNoRepo ;
	
	@Value(value = "${motor.productId}")
	private String motorProductId;
	
	@Value(value = "${travel.productId}")
	private String travelProductId;
	
	@Value(value="${building.productId}")
	private String buildingProductId;
	
	@Value(value="${personalaccident.productId}")
	private String personalaccidentProductId;
	
	@Value(value = "${employeesliability.productId}")
	private String employeesLiabilityProductId;
	
	@Value(value = "${workmencompensation.productId}")
	private String workmenCompensationProductId;
	
	@Value(value = "${sme.productId}")
	private String smeproductId;
	
	@Value(value = "${burglary.productId}")
	private String burglaryproductId;
	
	private Logger log = LogManager.getLogger(OneTimeTableServiceImpl.class);
	
	private EserviceMotorDetails motorDatas=null ;
	private EserviceTravelDetails travelData=null ;
	private EserviceCustomerDetails custData = null ;
	List<EserviceTravelGroupDetails> groupDatas = null;
	private EserviceBuildingDetails buildingData=null ;
	private List<EserviceCommonDetails> esercommonDatas =null ;
	
	@Autowired
	private EServiceSectionDetailsRepository eserSecRepo ;

	
	@Transactional
	@Override
	public List<OneTimeTableRes> call_OT_Insert(OneTimeTableReq req) {
		List<OneTimeTableRes> resList = new ArrayList<OneTimeTableRes>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddhhmmssSS");
		DozerBeanMapper dozerMapper = new DozerBeanMapper();
		try {
			String custRefNo = "" ;
			List<Callable<Object>> queue = new ArrayList<Callable<Object>>();

			MyTaskList taskList = new MyTaskList(queue);

			// Product Id Based Insert
			if(  req.getProductId().equals(Integer.valueOf(motorProductId))) {
				
				if( req.getMotorDetails() != null  ) {
					motorDatas=req.getMotorDetails()  ;
				} else {
					motorDatas=eserviceMotorRepo.findByRequestReferenceNoAndRiskId(req.getRequestReferenceNo() , Integer.valueOf(req.getVehicleId())); 
				}
				custRefNo = motorDatas.getCustomerReferenceNo() ;
				Thread_OneTime msVehicle = new Thread_OneTime("MSVehicle", req, otSer, em,custData, msVehicleRepo, eserviceMotorRepo, msCustomerRepo, eserviceCustomerRepo,motorDatas,
						eserTravelRepo,msHumanRepo,travelData,groupDatas,eserGroupRepo,eserBuildRepo,msAssetRepo,buildingData,eserSecRepo,oneNoRepo, esercommonDatas ,eserCommonRepo);
				queue.add(msVehicle);
				
			} else if (req.getProductId().equals(Integer.valueOf(travelProductId) ) ) {
				
				travelData = eserTravelRepo.findByRequestReferenceNoAndRiskId(req.getRequestReferenceNo(),req.getId());
				Thread_OneTime msTravel = new Thread_OneTime("MSTravel", req, otSer, em,custData, msVehicleRepo, eserviceMotorRepo, msCustomerRepo, eserviceCustomerRepo,motorDatas,eserTravelRepo,msHumanRepo
							,travelData,groupDatas,eserGroupRepo,eserBuildRepo,msAssetRepo,buildingData,eserSecRepo,oneNoRepo,esercommonDatas ,eserCommonRepo);
					queue.add(msTravel);	
					custRefNo = travelData.getCustomerReferenceNo() ;
				
				
			}
			
			else if (req.getProductId().equals(Integer.valueOf(buildingProductId) ) || req.getProductId().equals(Integer.valueOf(smeproductId) ) || 
					 req.getProductId().equals(Integer.valueOf(burglaryproductId) ) ) {
				
				buildingData = eserBuildRepo.findByRequestReferenceNoAndRiskId(req.getRequestReferenceNo(),req.getVehicleId());
				esercommonDatas = eserCommonRepo.findByRequestReferenceNo(req.getRequestReferenceNo());
				
				Thread_OneTime msTravel = new Thread_OneTime("MSAsset", req, otSer, em,custData, msVehicleRepo, eserviceMotorRepo, msCustomerRepo, eserviceCustomerRepo,motorDatas,eserTravelRepo,msHumanRepo
							,travelData,groupDatas,eserGroupRepo,eserBuildRepo,msAssetRepo,buildingData,eserSecRepo,oneNoRepo,esercommonDatas ,eserCommonRepo);
					queue.add(msTravel);	
					custRefNo = buildingData.getCustomerReferenceNo() ;
				
				
			}
			else  {
				esercommonDatas = new ArrayList<>();
				esercommonDatas.add(eserCommonRepo.findByRequestReferenceNoAndRiskId(req.getRequestReferenceNo(),req.getVehicleId()));
				
				Thread_OneTime msPersonalAcc = new Thread_OneTime("MsHuman", req, otSer, em,custData, msVehicleRepo, eserviceMotorRepo, msCustomerRepo, eserviceCustomerRepo,motorDatas,eserTravelRepo,msHumanRepo
							,travelData,groupDatas,eserGroupRepo,eserBuildRepo,msAssetRepo,buildingData,eserSecRepo,oneNoRepo,esercommonDatas ,eserCommonRepo);
					queue.add(msPersonalAcc);	
					custRefNo = esercommonDatas.get(0).getCustomerReferenceNo() ;
			}
			
			custData = eserviceCustomerRepo.findByCustomerReferenceNo(custRefNo);
			
			Thread_OneTime msCustomer = new Thread_OneTime("MSCustomer", req, otSer, em,custData, msVehicleRepo, eserviceMotorRepo, msCustomerRepo, eserviceCustomerRepo,motorDatas,eserTravelRepo,msHumanRepo
					,travelData,groupDatas,eserGroupRepo,eserBuildRepo,msAssetRepo,buildingData,eserSecRepo,oneNoRepo,esercommonDatas ,eserCommonRepo);
			queue.add(msCustomer);

			ConcurrentLinkedQueue<Future<Object>> invoke = (ConcurrentLinkedQueue<Future<Object>>) forkjoin
					.invoke(taskList);

			int success = 0;

			List<OneTimeVehicleRes> oneTimeResList = new ArrayList<OneTimeVehicleRes>();
			
			String cdRefno = "";
			String msCust=null;
			String msVehDet = null;

			for (Future<Object> callable : invoke) {

				log.info(callable.getClass() + "," + callable.isDone());

				if (callable.isDone()) {
					Map<String, Object> map = (Map<String, Object>) callable.get();

					for (Entry<String, Object> future : map.entrySet()) {
						if ("MSVehicle".equalsIgnoreCase(future.getKey())) {

							oneTimeResList = (List<OneTimeVehicleRes>) future.getValue();

						} else if ("MSCustomer".equalsIgnoreCase(future.getKey())) {

							//cdRefno = (String) future.getValue();
							cdRefno = (String) future.getValue();

						} else if ("MSTravel".equalsIgnoreCase(future.getKey())) {

							//cdRefno = (String) future.getValue();
							oneTimeResList = (List<OneTimeVehicleRes>) future.getValue();

						}
						else if ("MSAsset".equalsIgnoreCase(future.getKey())) {

							//cdRefno = (String) future.getValue();
							oneTimeResList = (List<OneTimeVehicleRes>) future.getValue();

						}
						else if ("MsHuman".equalsIgnoreCase(future.getKey())) {

							//cdRefno = (String) future.getValue();
							oneTimeResList = (List<OneTimeVehicleRes>) future.getValue();

						}
					}

					success++;
				}
			}
			/*	resList.add(vdRefNo);
			resList.add(sectionId);
			resList.add(agencyCode);
			resList.add(branchCode);
			resList.add(productId);
			resList.add(companyId); */
			
			for (OneTimeVehicleRes oneTimeRes : oneTimeResList) {
				OneTimeTableRes response = new OneTimeTableRes();
				
				String vdRefno = oneTimeRes.getVdRefNo() ;
				String sectionId = oneTimeRes.getSectionId() ;
				String agencyCode = oneTimeRes.getAgencyCode() ;
				String branchCode = oneTimeRes.getBranchCode() ;
				String productId = oneTimeRes.getProductId() ;
				String companyId = oneTimeRes.getCompanyId() ;
				
				String msRefNo = "" ;
				String complete = (queue.size() == success) ? "yes" : "No";
				log.info("call_OTInsert--> complete: " + complete);
				
				// Save Common Details
				MsCommonDetails findData = msCommonRepo.findByCdRefnoAndVdRefnoAndRequestreferencenoAndAgencyCodeAndBranchCodeAndInsuranceIdAndProductIdAndSectionIdAndStatus(Long.valueOf(cdRefno) ,Long.valueOf(vdRefno) , req.getRequestReferenceNo(),req.getAgencyCode(),req.getBranchCode(),companyId,Integer.valueOf(productId),Integer.valueOf(sectionId),"Y") ;
				if( findData !=null) {
					msRefNo = String.valueOf(findData.getMsRefno());
				} else {
					 
				///	Random rand = new Random();
		        //     int random=rand.nextInt(90)+10; 
					msRefNo = genOneTimeTableRefNo();//sdf.format(new Date()) + random ; ; 
					MsCommonDetails saveData = new MsCommonDetails();
					saveData.setAgencyCode(agencyCode);
					saveData.setBranchCode(branchCode);
					saveData.setInsuranceId(companyId);
					saveData.setProductId(Integer.valueOf(productId)) ;
					saveData.setRequestreferenceno(req.getRequestReferenceNo());
					saveData.setCdRefno(Long.valueOf(cdRefno));
					saveData.setEntryDate(new Date());
					saveData.setVdRefno(Long.valueOf(vdRefno));
					saveData.setMsRefno(Long.valueOf(msRefNo));
					saveData.setStatus("Y");
					saveData.setSectionId(Integer.valueOf(sectionId));
					msCommonRepo.saveAndFlush(saveData);
				}
				//Response 
				response.setCdRefNo(cdRefno);
				response.setVdRefNo(vdRefno);
				response.setMsRefNo(msRefNo);
				response.setRequestReferenceNo(req.getRequestReferenceNo());
				response.setVehicleId(oneTimeRes.getVehicleId()==null?"" : oneTimeRes.getVehicleId());
				response.setProductId(productId);
				response.setSectionId(sectionId);
				response.setProductId(productId);
				response.setCompanyId(companyId);
				resList.add(response);
			}
			
			
			
			return resList;
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Exception is --> " +  e.getMessage());
			return null;	
		}
		
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
	public MsDetailsRes msDetails (Long msrefno) {
	MsDetailsRes res = new MsDetailsRes();
	DozerBeanMapper mapper = new DozerBeanMapper();
	try {
	MsCommonDetails data = msCommonRepo.findByMsRefno(msrefno);
	MsCustomerDetails cusdetails =  msCustomerRepo.findByCdRefno(Long.valueOf(data.getCdRefno()));
	MsVehicleDetails  msvehdetails = msVehicleRepo.findByVdRefno(Long.valueOf(data.getVdRefno()));
	res.setMsCommonDetails(mapper.map(data,MsCommonDetailsRes.class));
	res.setMsCustomerDetails(mapper.map(cusdetails,MsCustomerDetailsRes.class));
	res.setMsVehicleDetails(mapper.map(msvehdetails, MsVehicleDetailsRes.class));	
	
	}
	catch (Exception e) {
	 	e.printStackTrace();
		log.error("Exception is ---> " + e.getMessage());
		return null ;
 }

 return res;
}
	
	
}