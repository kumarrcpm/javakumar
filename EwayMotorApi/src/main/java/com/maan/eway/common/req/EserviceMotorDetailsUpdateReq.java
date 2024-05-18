/*
 * Java domain class for entity "EserviceMotorDetails" 
 * Created on 2022-10-17 ( Date ISO 2022-10-17 - Time 11:50:07 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */
package com.maan.eway.common.req;

import java.io.Serializable;

import lombok.*;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

 
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EserviceMotorDetailsUpdateReq implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("Requestreferenceno")
    private String   requestReferenceNo ;
	@JsonProperty("Idnumber")
    private String     idNumber     ;
	@JsonProperty("VehicleId")
    private Integer     vehicleId     ;
	private String     accident     ;
	@JsonProperty("Gpstrackinginstalled")
    private String     gpsTrackingInstalled ;
	@JsonProperty("Windscreencoverrequired")
    private String     windScreenCoverRequired ;
	@JsonProperty("Insurancetype")
    private String     insuranceType ;
	@JsonProperty("MotorCategory")
    private String     motorCategory ;
	@JsonProperty("Motorusage")
    private String     motorUsage   ;
	@JsonProperty("Registrationnumber")
    private String     registrationNumber ;
	@JsonProperty("Chassisnumber")
    private String     chassisNumber ;
	@JsonProperty("Vehiclemake")
    private String     vehicleMake  ;
	@JsonProperty("VehiclemakeDesc")
    private String     vehicleMakeDesc  ;
	@JsonProperty("Vehcilemodel")
    private String     vehcileModel ;
	@JsonProperty("VehcilemodelDesc")
    private String     vehcileModelDesc ;
	@JsonProperty("VehicleType")
    private String     vehicleType  ;
	@JsonProperty("VehicleTypeDesc")
    private String     vehicleTypeDesc  ;
	@JsonProperty("ModelNumber")
    private String     modelNumber  ;
	@JsonProperty("EngineNumber")
    private String     engineNumber ;
	@JsonProperty("FuelType")
    private String     fuelType     ;
	@JsonProperty("FuelTypeDesc")
    private String     fuelTypeDesc     ;
	@JsonProperty("ManufactureYear")
    private Integer   manufactureYear ;
	@JsonProperty("RegistrationYear")
    private Integer   registrationYear ;
	@JsonProperty("SeatingCapacity")
    private Integer    seatingCapacity ;
	@JsonProperty("CubicCapacity")
    private Double     cubicCapacity ;
	@JsonProperty("Color")
    private String     color        ;
	@JsonProperty("ColorDesc")
    private String     colorDesc ;
	@JsonProperty("Grossweight")
    private Double     grossWeight  ;
	@JsonProperty("Tareweight")
    private Double     tareWeight   ;
	@JsonProperty("Actualpremium")
    private Double     actualPremium ;
	@JsonProperty("CoverNoteNo")
    private String     covernoteNo  ;
	@JsonProperty("Stickerno")
    private String     stickerNo    ;
    private String     periodOfInsurance ;
	@JsonProperty("WindScreenSumInsured")
    private Double     windScreenSumInsured ;
	@JsonProperty("AcccessoriesSumInsured")
    private Double     acccessoriesSumInsured ;
	@JsonProperty("AccessoriesInformation")
    private String     accessoriesInformation ;
	@JsonProperty("NumberOfAxels")
    private Integer    numberOfAxels ;
	@JsonProperty("AxelDistance")
    private Double     axelDistance ;
	@JsonProperty("SumInsured")
    private Double     sumInsured   ;
	@JsonProperty("OverRidePercentage")
    private Double    overridePercentage   ;
	@JsonProperty("TppdFreeLimit")
    private Double     tppdFreeLimit ;
	@JsonProperty("TppdIncreaeLimit")
    private Double     tppdIncreaeLimit ;
	@JsonProperty("Ncd")
    private Double     ncd          ;
	@JsonProperty("InsurerSettlement")
    private Double     insurerSettlement ;
	@JsonProperty("PolicyType")
    private String     policyType   ;
	@JsonProperty("PolicyTypeDesc")
    private String     policyTypeDesc   ;	
	@JsonProperty("RadioOrCasseteplayer")
    private Double     radioorcasseteplayer ;
	@JsonProperty("RoofRack")
    private Double     roofRack     ;
	@JsonProperty("SpotFogLamp")   
	private Double     spotFogLamp  ;
	@JsonProperty("TrailerDetails")
    private String     trailerDetails ;
	@JsonProperty("Drivenby")
    private String     drivenBy     ;
	@JsonProperty("DrivenByDesc")
    private String     drivenByDesc     ;
	@JsonProperty("VehicleInterestedCompany")
    private String     vehicleInterestedCompany ;
	@JsonProperty("InterestedCompanyDetails")
    private String     interestedCompanyDetails ;
	@JsonProperty("OtherVehicle")
    private String     otherVehicle ;
	@JsonProperty("OtherVehicleDetails")
    private String     otherVehicleDetails ;
	@JsonProperty("OtherInsurance")
    private String     otherInsurance ;
	@JsonProperty("OtherInsuranceDetails")
    private String     otherInsuranceDetails ;
	@JsonProperty("HoldInsurancePolicy")
    private String     holdInsurancePolicy ;
	@JsonProperty("NoOfClaims")
    private Integer    noOfClaims   ;
	@JsonProperty("AdditionalCircumstances")
    private String     additionalCircumstances ;

	  
}