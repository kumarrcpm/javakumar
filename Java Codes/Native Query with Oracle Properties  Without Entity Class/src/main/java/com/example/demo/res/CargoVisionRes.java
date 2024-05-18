package com.example.demo.res;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CargoVisionRes {

	@JsonProperty("RequestReferenceNo")
	private String requestReferenceNo;
	
	@JsonProperty("ProductTypeId")
	private String productTypeId;
	
	@JsonProperty("PolicyType")
	private String policyType;
	
	@JsonProperty("QuoteType")
	private String quoteType;
	
	@JsonProperty("UserType")
	private String userType;
	
	@JsonProperty("VehicleType")
	private String vehicleType;
	
	@JsonProperty("VehTypeId")
	private String vehTypeId;
	
	@JsonProperty("LoginId")
	private String loginId;
	
	@JsonProperty("AdminLoginId")
	private String adminLoginId;
	
	@JsonProperty("EBrokerId")
	private String ebrokerId;
	
	@JsonProperty("AgencyCode")
	private String agencyCode;
	
	@JsonProperty("BrokerCode")
	private String brokerCode;
	
	@JsonProperty("SchemeCode")
	private String schemeCode;
	
	@JsonProperty("HavePromoCode")
	private String havePromoCode;
	
	@JsonProperty("PromoCode")
	private String promoCode;
	
	@JsonProperty("DivisionCode")
	private String divisionCode;
	
	@JsonProperty("CustomerCode")
	private String customerCode;
	
	@JsonProperty("SourceType")
	private String sourceType;
	
	@JsonProperty("PromoEmpCode")
	private String promoEmpCode;
	
	@JsonProperty("BdmCode")
	private String bdmCode;
	
	@JsonProperty("EntryDate")
	private String entryDate;
	
	@JsonProperty("NumberOfDays")
	private String numberOfDays;
	
	@JsonProperty("ImgRefno")
	private String imgRefNo;
	
	@JsonProperty("InterestionCompanyYn")
	private String interestionCompanyYn;
	
	@JsonProperty("PreviousCompanyId")
	private String prviousCompanyId;
	
	@JsonProperty("PreviousPolicyYn")
	private String previousPolicyYn;
	
	@JsonProperty("CivilId")
	private String civilId;
	
	@JsonProperty("DateOfBirth")
	private String dateOfBirth;
	
	@JsonProperty("Age")
	private String age;
	
	@JsonProperty("Gender")
	private String gender;
	
	@JsonProperty("GenderEn")
	private String genderEn;
	
	@JsonProperty("GenderAr")
	private String genderAr;
	
	@JsonProperty("Profession")
	private String profession;
	
	@JsonProperty("ProfessionEn")
	private String professionEn;
	
	@JsonProperty("ProfessionAr")
	private String professionAr;
	
	@JsonProperty("Region")
	private String region;
	
	@JsonProperty("RegionEn")
	private String regionEn;
	
	@JsonProperty("RegionAr")
	private String regionAr;
	
	@JsonProperty("LicenceTypeId")
	private String licenseTypeId;
	
	@JsonProperty("LicenceTypeIdDesc")
	private String licenseTypeIdDesc;
	
	@JsonProperty("LicenceValidPeriod")
	private String licenseValidPeriod;
	
	@JsonProperty("LicenceValidityDate")
	private String licenseValidityDate;
	
	@JsonProperty("VolumeOfCars")
	private String volumeOfCars;
	
	@JsonProperty("ClaimOccurence")
	private String claimOccurence;
	
	@JsonProperty("DriverPoints")
	private String driverPoints;
	
	@JsonProperty("Loyalty")
	private String loyalty;
	
	@JsonProperty("LicenceExpiryYn")
	private String licenseExpiryYn;
	
	@JsonProperty("CustomerReferenceNo")
	private String customerReferenceNo;
	
	@JsonProperty("VehicleEngineNo")
	private String vehicleEngineNo;
	
	@JsonProperty("ChassisNo")
	private String chassisNo;
	
	@JsonProperty("VehCivilId")
	private String vehCivilId;
	
	@JsonProperty("PlateNo")
	private String plateNo;
	
	@JsonProperty("PlateChar")
	private String plateChar;
	
	@JsonProperty("PlateCharEn")
	private String plateCharEn;
	
	@JsonProperty("PlateCharAr")
	private String plateCharAr;
	
	@JsonProperty("VehTonnage")
	private String vehTonnage;
	
	@JsonProperty("MakeId")
	private String makeId;
	
	@JsonProperty("MakeNameEn")
	private String makeNameEn;
	
	@JsonProperty("MakeNameAr")
	private String makeNameAr;
	
	@JsonProperty("ModelId")
	private String modelId;
	
	@JsonProperty("ModelNameEn")
	private String modelNameEn;

	@JsonProperty("ModelNameAr")
	private String modelNameAr;
	
	@JsonProperty("BodyId")
	private String bodyId;
	
	@JsonProperty("BodyTypeEn")
	private String bodyTypeEn;
	
	@JsonProperty("BodyTypeAr")
	private String bodyTypeAr;
	
	@JsonProperty("Trim")
	private String trim;
	
	@JsonProperty("TrimNameEn")
	private String trimNameEn;
	
	@JsonProperty("TrimNameAr")
	private String trimNameAr;
	
	@JsonProperty("VehicleColorId")
	private String vehicleColorId;
	
	@JsonProperty("VehicleColor")
	private String vehicleColor;
	
	@JsonProperty("SeatingCapacity")
	private String seatingCapacity;
	
	@JsonProperty("ManfactureCountryId")
	private String manufactureId;
	
	@JsonProperty("ManufactureYear")
	private String manufactureYear;
	
	@JsonProperty("VehicleRegistrationDate")
	private String vehicleRegistrationDate;
	
	@JsonProperty("VehicleAge")
	private String vehicleAge;
	
	@JsonProperty("ChassisClaim")
	private String chassisClaim;
	
	@JsonProperty("VehicleCondition")
	private String vehicleCondition;
	
	@JsonProperty("OdoMeter")
	private String odoMeter;
	
	@JsonProperty("ClaimAmt")
	private String claimAmt;
	
	@JsonProperty("ClaimBonus")
	private String claimBonus;
	
	@JsonProperty("GeoExtensionDescription")
	private String geoExtensionDescription;
	
	@JsonProperty("ImportYn")
	private String importYn;
	
	@JsonProperty("ImportCode")
	private String importCode;
	
	@JsonProperty("ImportCountry")
	private String importCountry;
	
	@JsonProperty("IsCommercialYn")
	private String isCommercialYn;
	
	@JsonProperty("VehicleUsageId")
	private String vehicleUsageId;
	
	@JsonProperty("GreyImport")
	private String greyImport;
	
	@JsonProperty("SalvageYn")
	private String salvageYn;
	
	@JsonProperty("NamedDriverCnt")
	private String namedDriverCnt;
	
	@JsonProperty("VehicleRenewalYn")
	private String vehicleRenewalYn;
	
	@JsonProperty("VehRenewalPolicyNo")
	private String vehRenewalPolicyNo;
	
	@JsonProperty("VehRenewalClaimAmount")
	private String vehRenewalClaimAmount;
	
	@JsonProperty("BreakInsuranceYn")
	private String breakInsuranceYn;
	
	@JsonProperty("VehicleReferenceNumber")
	private String vehicleReferenceNumber;
	
	@JsonProperty("McdReferenceNo")
	private String mcdReferenceNo;
	
	@JsonProperty("Suminsured")
	private String suminsured;
	
	@JsonProperty("CountryId")
	private String countryId;
	

	@JsonProperty("DriverAge")
	private String driverAge;
	

	@JsonProperty("B2cOnlineDiscount")
	private String b2cOnlineDiscount;


	@JsonProperty("DiscountYear")
	private String discountYear;

	
	@JsonProperty("NewCustomerYN")
	private String newCustomerYN;
	
	
	@JsonProperty("ROPClaimCount")
	private String rOPClaimCount;
	
	@JsonProperty("VehBodyTypeId")
	private String vehBodyTypeId;
	
	@JsonProperty("VehImportCountryId")
	private String vehImportCountryId;
	
	
	@JsonProperty("VehMakeId")
	private String vehMakeId;
	
	@JsonProperty("VehicleTypeId")
	private String vehicleTypeId;
	
	
	
	
}
