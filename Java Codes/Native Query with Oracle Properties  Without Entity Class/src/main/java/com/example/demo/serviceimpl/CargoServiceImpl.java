package com.example.demo.serviceimpl;




import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.springframework.stereotype.Service;

import com.example.demo.req.CargoReq;
import com.example.demo.res.CargoVisionRes;
import com.example.demo.service.CargoService;


@Service 
public class CargoServiceImpl implements CargoService{

	@PersistenceContext
	private EntityManager em;
	
	private static Properties properties ;
	 
	private void setProperties() {
		if(properties==null) {
			try {
	        	InputStream  inputStream = getClass().getClassLoader().getResourceAsStream("oracle.properties");
	        	if (inputStream != null) {
	        		properties=new Properties();
	        		properties.load(inputStream);
				}
	        	
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
			
		 
		}
	}
	
	
	@Override
	public CargoVisionRes getCargo(CargoReq req) {
		CargoVisionRes r = new CargoVisionRes();

		try {
			setProperties();
			Object query = properties.get("MCDREFERENCENO_DETAILS");
			
			Query nativequery = em.createNativeQuery(query.toString() );		
			nativequery.setParameter(1, req.getMcdReferenceNo() );		
			nativequery.unwrap(NativeQueryImpl.class).setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
			List<Map<Object,Object>> list = nativequery.getResultList();	
			Map<Object,Object> d = list.get(0);
			if (d !=null ) {
				
				r.setAdminLoginId(d.get("ADMIN_LOGINID")==null ?"" : d.get("ADMIN_LOGINID").toString());
				r.setAge(d.get("CD_AGE")==null?"": d.get("CD_AGE").toString());     
				r.setBdmCode(d.get("BDMCODE")==null?"": d.get("BDMCODE").toString());
				r.setBodyTypeAr(d.get("VD_BODYTYPE_AR")==null ?"": d.get("VD_BODYTYPE_AR").toString());
				r.setBodyTypeEn(d.get("VD_BODYTYPE_EN")==null ?"": d.get("VD_BODYTYPE_EN").toString());
				r.setBreakInsuranceYn(d.get("VD_BREAKININSURANCE_YN")==null ?"": d.get("VD_BREAKININSURANCE_YN").toString());
				r.setBrokerCode(d.get("BROKERCODE")==null ?"":d.get("BROKERCODE").toString());
				r.setChassisClaim(d.get("VD_CHASSIS_CLAIM")==null ?"": d.get("VD_CHASSIS_CLAIM").toString());
				r.setChassisNo(d.get("VD_CHASSISNO")==null ?"" : d.get("VD_CHASSISNO").toString());
				r.setCivilId(d.get("CD_CIVILID")==null ?"": d.get("CD_CIVILID").toString());
				r.setClaimBonus(d.get("VD_CLAIMBONUS")==null?"":d.get("VD_CLAIMBONUS").toString());
				r.setCustomerCode(d.get("CUSTOMERCODE")==null?"":d.get("CUSTOMERCODE").toString());
				r.setCustomerReferenceNo(d.get("CD_REFERENCENO")==null?"":d.get("CD_REFERENCENO").toString());
				r.setDateOfBirth(d.get("CD_DOBG")==null?"":d.get("CD_DOBG").toString());
				r.setDriverPoints(d.get("")==null?"":d.get("").toString());
				r.setEbrokerId(d.get("EBROKERID")==null?"":d.get("EBROKERID").toString());
				r.setEntryDate(d.get("ENTRYDATE")==null?"":d.get("ENTRYDATE").toString());
				r.setGender(d.get("CD_GENDER")==null?"":d.get("CD_GENDER").toString());
				r.setGenderAr(d.get("CD_GENDER_AR")==null?"":d.get("CD_GENDER_AR").toString());
				r.setGenderEn(d.get("CD_GENDER_EN")==null?"":d.get("CD_GENDER_EN").toString());
				r.setGeoExtensionDescription(d.get("VD_GEOEXTENSION_DESC")==null?"":d.get("VD_GEOEXTENSION_DESC").toString());
				r.setGreyImport(d.get("VD_GREYIMPORT_YN")==null?"":d.get("VD_GREYIMPORT_YN").toString());
				r.setHavePromoCode(d.get("HAVEPROMOCODE")==null?"":d.get("HAVEPROMOCODE").toString());
				r.setImgRefNo(d.get("IMGREFNO")==null?"":d.get("IMGREFNO").toString());
				r.setImportCode(d.get("VD_IMPORT_CODE")==null?"":d.get("VD_IMPORT_CODE").toString());
				r.setImportCountry(d.get("VD_IMPORT_COUNTRY")==null?"":d.get("VD_IMPORT_COUNTRY").toString());
				r.setImportYn(d.get("VD_IMPORT_YN")==null?"":d.get("VD_IMPORT_YN").toString());
				r.setInterestionCompanyYn(d.get("INTERESTEDIN_COMPYN")==null?"":d.get("INTERESTEDIN_COMPYN").toString());
				r.setIsCommercialYn(d.get("VD_ISCOMMERICAL_YN")==null?"":d.get("VD_ISCOMMERICAL_YN").toString());
				r.setLicenseExpiryYn(d.get("CD_LICENCEEXPIREDYN")==null?"":d.get("CD_LICENCEEXPIREDYN").toString());
				r.setLicenseTypeId(d.get("CD_LICENCETYPE_ID")==null?"":d.get("CD_LICENCETYPE_ID").toString());
				r.setLicenseTypeIdDesc(d.get("CD_LICENCETYPE_DESC")==null?"":d.get("CD_LICENCETYPE_DESC").toString());
				r.setLicenseValidityDate(d.get("CD_LICENCE_VALIDITYDATE")==null?"":d.get("CD_LICENCE_VALIDITYDATE").toString());
				r.setLicenseValidPeriod(d.get("CD_LICENCE_VALIDPERIOD")==null?"":d.get("CD_LICENCE_VALIDPERIOD").toString());
				r.setLoginId(d.get("LOGINID")==null?"":d.get("LOGINID").toString());
				r.setLoyalty(d.get("CD_LOYALTY")==null?"":d.get("CD_LOYALTY").toString());
				r.setMakeNameAr(d.get("VD_MAKENAME_AR")==null?"":d.get("VD_MAKENAME_AR").toString());
				r.setMakeNameEn(d.get("VD_MAKENAME_EN")==null?"":d.get("VD_MAKENAME_EN").toString());
				r.setManufactureId(d.get("")==null?"":d.get("").toString());
				r.setManufactureYear(d.get("VD_MANFYEAR")==null?"":d.get("VD_MANFYEAR").toString());
				r.setModelNameAr(d.get("VD_MODELNAME_AR")==null?"":d.get("VD_MODELNAME_AR").toString());
				r.setModelNameEn(d.get("VD_MODELNAME_EN")==null?"":d.get("VD_MODELNAME_EN").toString());
				r.setNumberOfDays(d.get("NOOFDAYS")==null?"":d.get("NOOFDAYS").toString());
				r.setOdoMeter(d.get("VD_ODOMETER")==null?"":d.get("VD_ODOMETER").toString());
				r.setPlateChar(d.get("VD_PLATECHAR")==null?"":d.get("VD_PLATECHAR").toString());
				r.setPlateCharAr(d.get("  VD_PLATECHAR_AR")==null?"":d.get("  VD_PLATECHAR_AR").toString());
				r.setPlateCharEn(d.get("VD_PLATECHAR_EN")==null?"":d.get("VD_PLATECHAR_EN").toString());
				r.setPlateNo(d.get("VD_PLATENO")==null?"":d.get("VD_PLATENO").toString());
				r.setPreviousPolicyYn(d.get("PREVTPLPOLICYYN")==null?"":d.get("PREVTPLPOLICYYN").toString());
				r.setProfession(d.get("CD_PROFESSION")==null?"":d.get("CD_PROFESSION").toString());
				r.setProfessionAr(d.get("CD_PROFESSION_AR")==null?"":d.get("CD_PROFESSION_AR").toString());
				r.setProfessionEn(d.get("CD_PROFESSION_EN")==null?"":d.get("CD_PROFESSION_EN").toString());
				r.setPromoEmpCode(d.get("PROMOEMPCODE")==null?"":d.get("PROMOEMPCODE").toString());
				r.setPrviousCompanyId(d.get("PREVCOMPANYID")==null?"":d.get("PREVCOMPANYID").toString());
				r.setQuoteType(d.get("QUOTETYPE")==null?"":d.get("QUOTETYPE").toString());
				r.setRegionAr(d.get("CD_REGION_AR")==null?"":d.get("CD_REGION_AR").toString());
				r.setRegionEn(d.get("CD_REGION_EN")==null?"":d.get("CD_REGION_EN").toString());
				r.setRequestReferenceNo(d.get("REQUESTREFERENCENO")==null?"":d.get("REQUESTREFERENCENO").toString());
				r.setSalvageYn(d.get("VD_SALVAGEYN")==null?"":d.get("VD_SALVAGEYN").toString());
				r.setSchemeCode(d.get("SCHEMECODE")==null?"":d.get("SCHEMECODE").toString());
				r.setSeatingCapacity(d.get("VD_SEATINGCAPACITY")==null?"":d.get("VD_SEATINGCAPACITY").toString());
				r.setSourceType(d.get("SOURCETYPE")==null?"":d.get("SOURCETYPE").toString());
				r.setTrim(d.get("VD_TRIM")==null?"":d.get("VD_TRIM").toString());
				r.setTrimNameAr(d.get("VD_TRIMNAME_AR")==null?"":d.get("VD_TRIMNAME_AR").toString());
				r.setTrimNameEn(d.get("VD_TRIMNAME_EN")==null?"":d.get("VD_TRIMNAME_EN").toString());
				r.setUserType(d.get("USERTYPE")==null?"":d.get("USERTYPE").toString());
				r.setVehCivilId(d.get("VD_CIVILID")==null?"":d.get("VD_CIVILID").toString());
				r.setVehicleColor(d.get("VD_VEHCOLOR")==null?"":d.get("VD_VEHCOLOR").toString());
				r.setVehicleColorId(d.get("VD_VEHCOLORID")==null?"":d.get("VD_VEHCOLORID").toString());
				r.setVehicleCondition(d.get("VD_VEHCONDITION")==null?"":d.get("VD_VEHCONDITION").toString());
				r.setVehicleEngineNo(d.get("VD_ENGINENO")==null?"":d.get("VD_ENGINENO").toString());
				r.setVehicleReferenceNumber(d.get("VD_REFERENCENO")==null?"":d.get("VD_REFERENCENO").toString());
				r.setVehicleRegistrationDate(d.get("VD_VEHREGN_DATE")==null?"":d.get("VD_VEHREGN_DATE").toString());
				r.setVehRenewalClaimAmount(d.get("VD_RENEWAL_CLAIMAMT")==null?"":d.get("VD_RENEWAL_CLAIMAMT").toString());
				r.setVehRenewalPolicyNo(d.get("VD_RENEWAL_POLICYNO")==null?"":d.get("VD_RENEWAL_POLICYNO").toString());
				r.setVehTonnage(d.get("VD_TONNAGE")==null?"":d.get("VD_TONNAGE").toString());
				r.setVolumeOfCars(d.get("CD_VOLUMEOFCARS")==null?"":d.get("CD_VOLUMEOFCARS").toString());

				
				log.info("PremiumClac Requestframe Response==>"); 
				
			}
			
			
		}catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		
		return res;
	}

}
