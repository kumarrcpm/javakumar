package com.maan.eway.tira.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.maan.eway.bean.MotorVehicleInfo;
import com.maan.eway.bean.PersonalInfo;
import com.maan.eway.bean.PolicyCoverData;
import com.maan.eway.req.push.CoverNoteAddon;
import com.maan.eway.req.push.CoverNoteAddons;
import com.maan.eway.req.push.CoverNoteDtl;
import com.maan.eway.req.push.CoverNoteHdr;
import com.maan.eway.req.push.DiscountOffered;
import com.maan.eway.req.push.MotorCoverNoteRefReq;
import com.maan.eway.req.push.MotorDtl;
import com.maan.eway.req.push.PolicyHolder;
import com.maan.eway.req.push.PolicyHolders;
import com.maan.eway.req.push.RiskCovered;
import com.maan.eway.req.push.RisksCovered;
import com.maan.eway.req.push.TaxCharged;
import com.maan.eway.req.push.TiraMsgVehiclePush;
import com.maan.eway.tira.bean.MaansarovarToTira;
import com.maan.eway.tira.util.AddonFromData;
import com.maan.eway.tira.util.CoverFromData;
import com.maan.eway.tira.util.DiscountFromData;
import com.maan.eway.tira.util.LoadingFromData;
import com.maan.eway.tira.util.TaxFromData;

@Service
public class ConvertTiraRequest {

	
	public TiraMsgVehiclePush convert(MaansarovarToTira m) {
		SimpleDateFormat format=new SimpleDateFormat("YYYY-MM-DD'T'HH:mm:SS"); 
		CoverNoteDtl cn=new CoverNoteDtl();
		cn.setCommisionPaid(m.getPolicy().getCommission().toEngineeringString());
		cn.setCoverNoteNumber(m.getPolicy().getQuoteNo().toString());
		cn.setPrevCoverNoteReferenceNumber(m.getPolicy().getOriginalPolicyNo());
		cn.setSalePointCode(null);
		cn.setCoverNoteStartDate(format.format(m.getPolicy().getInceptionDate()));
		cn.setCoverNoteEndDate(format.format(m.getPolicy().getExpiryDate()));
		cn.setCoverNoteDesc("Cover Note for "+m.getPolicy().getPolicyNo());
		cn.setOperativeClause(m.getProduct().getProductDesc());
		cn.setPaymentMode(m.getLtPayment().getItemCode());  
		cn.setCurrencyCode(m.getPolicy().getCurrency());
		cn.setExchangeRate(m.getPolicy().getExchangeRate().toString());
		cn.setTotalPremiumExcludingTax(new BigDecimal(m.getPolicy().getPremiumFc()).toPlainString());
		cn.setTotalPremiumIncludingTax(new BigDecimal(m.getPolicy().getOverallPremiumFc()).toPlainString());
		 
		cn.setCommisionRate(m.getPolicy().getCommissionPercentage().toEngineeringString());
		cn.setOfficerName((m.getPolicy().getApplicationId().equals("1") || m.getPolicy().getApplicationId().equals("01")) ?m.getBroker().getUserName():m.getUw().getCompanyName());
		
		cn.setOfficerTitle((m.getPolicy().getApplicationId().equals("1") || m.getPolicy().getApplicationId().equals("01"))?"Broker":"Underwriter");
		cn.setProductCode(m.getSection().getRegulatoryCode());//m.getProduct().getRegulatoryCode()
		cn.setEndorsementType(null);
		cn.setEndorsementReason(null);
		cn.setEndorsementPremiumEarned(null);
		
		 
		riskData(m, cn);
		
		CoverNoteHdr hdr=CoverNoteHdr.builder()
				.callBackUrl("http://192.168.1.39:8085/dispatch/api/covernote/non-life/motor/v2/request")
				.companyCode("ICC105")
				.coverNoteType(StringUtils.isNotBlank(m.getPolicy().getEndtTypeId())?"3":(StringUtils.isNotBlank(m.getPolicy().getOriginalPolicyNo())?"2":"1"))
				.insurerCompanyCode("ICC110")
				.requestId("EWAY"+Calendar.getInstance().getTimeInMillis())
				.systemCode("LSYS_EWAYINSURANCE_001")
				.tranCompanyCode("ICC110")
				.build();
		
		MotorCoverNoteRefReq mt=new MotorCoverNoteRefReq();		
		mt.setCoverNoteDtlBean(cn);
		mt.setCoverNoteHdrBean(hdr);
		TiraMsgVehiclePush p=new TiraMsgVehiclePush();
		p.setMotorCoverNoteRefReq(mt);
		 return p;
		
	}
	// predicate to filter the duplicates by the given key extractor.
		public  <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
			Map<Object, Boolean> uniqueMap = new ConcurrentHashMap<>();
			return t -> uniqueMap.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
		}
	public void riskData(MaansarovarToTira m, CoverNoteDtl coverDtl) {

		 try {
			 
			   
			  List<PolicyCoverData> distinctsVehicle = m.getCovers().stream()
					   .filter(distinctByKey(cust -> cust.getVehicleId()))
						.collect(Collectors.toList());
			   
				
					for(PolicyCoverData v  :distinctsVehicle) {
						List<PolicyCoverData> distinctsCovers = m.getCovers().stream()
								.filter(p-> p.getVehicleId().equals(v.getVehicleId()) &&  p.getCoverageType().equals("B") )
								.filter(distinctByKey(cust -> cust.getCoverId() ))
								.collect(Collectors.toList());
						List<PolicyCoverData> totalcovers = m.getCovers().stream()
									.filter(p-> p.getVehicleId().equals(v.getVehicleId()))									
									.collect(Collectors.toList());
						
						for (PolicyCoverData distintc : distinctsCovers) {
						//	List<Cover> totalcovers=new ArrayList<Cover>();
							List<PolicyCoverData> covers =totalcovers.stream()
									.filter(p-> p.getCoverId().equals(distintc.getCoverId()) )									
									.collect(Collectors.toList());
							
							DiscountFromData discountUtil=new DiscountFromData();
							List<DiscountOffered> discounts = covers.stream().map(discountUtil).filter(d->d!=null).collect(Collectors.toList());
							LoadingFromData loadingtuils=new LoadingFromData();
							List<DiscountOffered> loadings = covers.stream().map(loadingtuils).filter(d->d!=null).collect(Collectors.toList());
							TaxFromData taxesutils=new TaxFromData();							
							 List<TaxCharged> taxes = covers.stream().map(taxesutils).filter(d->d!=null).collect(Collectors.toList());
							 
							CoverFromData splitsub=new CoverFromData("B",discounts,loadings,taxes);
							List<RiskCovered> risks= covers.stream().map(splitsub).filter(d->d!=null).collect(Collectors.toList());   
							 
							coverDtl.setRisksCoveredBean(RisksCovered.builder().riskCoveredBeanList(risks).build());
							 
						}	
						
						  distinctsCovers = m.getCovers().stream()
								.filter(p-> p.getVehicleId().equals(v.getVehicleId()) && p.getCoverageType().equalsIgnoreCase("O"))
								.filter(distinctByKey(cust -> cust.getCoverId() ))
								.collect(Collectors.toList());
						
						  List<CoverNoteAddon> addonsall=new ArrayList<CoverNoteAddon>();
						for (PolicyCoverData distintc : distinctsCovers) {
							List<PolicyCoverData> covers =totalcovers.stream()
									.filter(p-> p.getCoverId().equals(distintc.getCoverId()) )									
									.collect(Collectors.toList());
							
							 TaxFromData taxesutils=new TaxFromData();							
							 List<TaxCharged> taxes = covers.stream().map(taxesutils).filter(d->d!=null).collect(Collectors.toList());
							 
							AddonFromData addutil=new AddonFromData(taxes);
							List<CoverNoteAddon> addons = covers.stream().map(addutil).filter(d->d!=null).collect(Collectors.toList());  
							addonsall.addAll(addons);
							
						}
						//addon reference
						AtomicInteger a=new AtomicInteger(1);
						addonsall.stream().forEach(i-> i.setAddonReference(String.valueOf(a.getAndIncrement())));
						coverDtl.setCoverNoteAddonsBean(CoverNoteAddons.builder().coverNoteAddonBeanList(addonsall).build());
						
					}
				
				PersonalInfo c = m.getCustomerInfo();
				SimpleDateFormat format=new SimpleDateFormat("YYYY-MM-DD");
			    String postaladdress=	(StringUtils.isNotBlank(c.getAddress1())?c.getAddress1():"")+(StringUtils.isNotBlank(c.getAddress2())?c.getAddress2():"");
			    
				PolicyHolder p=PolicyHolder.builder()
							.countryCode(c.getNationality())
							.district(c.getStateName())
							.emailAddress(c.getEmail1())
							.gender(c.getGender())
							.policyHolderBirthDate(format.format(c.getDobOrRegDate()))
							.policyHolderFax(c.getFax())
							.policyHolderIdNumber(c.getIdNumber())
							.policyHolderName(c.getClientName())
							.policyHolderPhoneNumber(c.getMobileNo1())
							.policyHolderType(c.getIdType())
							.postalAddress(postaladdress)
							.region(c.getRegionCode())
							.street(c.getStreet())							
							.build();
				List<PolicyHolder> policyHolders=new ArrayList<PolicyHolder>();
				policyHolders.add(p);
				coverDtl.setPolicyHoldersBean(PolicyHolders.builder().policyHolderBeanList(policyHolders).build());
				
				MotorVehicleInfo v = m.getVehicleInfo();
				MotorDtl mdl=MotorDtl.builder()
							.axleDistance(v.getResAxleDistance().toString())
							.bodyType(v.getResBodyType())
							.chassisNumber(v.getResChassisNumber())
							.color(v.getResColor())
							.engineCapacity(v.getResEngineCapacity())
							.fuelUsed(v.getResFuelUsed())
							.grossWeight(v.getResGrossWeight().toString())
							.make(v.getResMake())
							.model(v.getResModel())
							.modelNumber(null)
							.motorCategory(v.getResMotorCategory().toString())
							.motorType(null)
							.motorUsage(v.getResMotorUsage())
							.numberOfAxles(v.getResNumberOfAxles().toString())
							.ownerAddress(c.getAddress1())
							.ownerCategory(v.getResOwnerCategory())
							.ownerName(v.getResOwnerName())
							.registrationNumber(v.getResRegNumber())
							.sittingCapacity(v.getResSittingCapacity().toString())
							.tareWeight(v.getResTareWeight().toString())
							.yearOfManufacture(v.getResYearOfManufacture().toString())
							.build();
						 
				coverDtl.setMotorDtlBean(mdl);
				//return coverDtl;
		 }catch (Exception e) {
			 e.printStackTrace();
		}
		 
		 //return null
	} 
}
