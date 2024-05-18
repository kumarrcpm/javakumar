/* 
*  Copyright (c) 2019. All right reserved
 * Created on 2022-11-18 ( Date ISO 2022-11-18 - Time 11:38:59 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */

/*
 * Created on 2022-11-18 ( 11:38:59 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */


package com.maan.eway.bean;


import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import java.util.Date;
import javax.persistence.*;




/**
* Domain class for entity "MsAssetDetails"
*
* @author Telosys Tools Generator
*
*/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@DynamicInsert
@DynamicUpdate
@Builder
@IdClass(MsAssetDetailsId.class)
@Table(name="ms_asset_details")


public class MsAssetDetails implements Serializable {
 
private static final long serialVersionUID = 1L;
 
    //--- ENTITY PRIMARY KEY 
    @Id
    @Column(name="VD_REFNO", nullable=false)
    private Long       vdRefno ;

    @Id
    @Column(name="REQUEST_REFERENCE_NO", nullable=false, length=20)
    private String     requestReferenceNo ;
    
    
    @Id
    @Column(name="LOCATION_ID", nullable=false)
    private Integer    locationId ;

    @Id
    @Column(name="PRODUCT_ID", nullable=false)
    private Integer    productId ;

    @Id
    @Column(name="SECTION_ID", nullable=false)
    private Integer    sectionId ;

    @Id
    @Column(name="COMPANY_ID", nullable=false, length=20)
    private String     companyId ;

    @Id
    @Column(name="BRANCH_CODE", nullable=false, length=20)
    private String     branchCode ;
    
    @Id
    @Column(name="ENDT_TYPE_ID")
    private Integer    endtTypeId ;
    
    @Id
    @Column(name="ENDT_CATEGORY_ID")
    private String    endtCategoryId ;

    //--- ENTITY DATA FIELDS 
    @Column(name="BUILDING_AGE")
    private Integer    buildingAge ;

    @Column(name="BUILDING_FLOORS")
    private Integer    buildingFloors ;

    @Column(name="BUILDING_USAGE_ID", length=100)
    private String     buildingUsageId;
 
    @Column(name="BUILDING_SUMINSURED")
    private BigDecimal buildingSuminsured ;
    
    @Column(name="ALLRISK_SUMINSURED")
    private BigDecimal     allriskSuminsured ;
    
    @Column(name="PA_DEATH_SUMINSURED")
    private BigDecimal    paDeathSuminsured ;
    

    @Column(name="PA_PERMANENTDISABLEMENT_SUMINSURED")
    private BigDecimal    paPermanentdisablementSuminsured ;
    
    @Column(name="PA_TOTALDISABILITY_SUMINSURED")
    private BigDecimal    paTotaldisabilitySumInsured ;
    
    @Column(name="PA_MEDICAL_SUMINSURED")
    private BigDecimal    PaMedicalSuminsured ;

    @Column(name="PERSONAL_INT_SUMINSURED")
    private BigDecimal    personalIntSuminsured ;
    
    @Column(name="CONTENT_SUMINSURED")
    private BigDecimal     contentSuminsured ;
    
    @Column(name="WORKMEN_COMP_SUMINSURED")
    private BigDecimal     workmenCompSuminsured;

    @Column(name="Period_of_Insurance", nullable=false, length=10)
    private String     periodOfInsurance ;
    
    
    @Column(name="CURRENCY", length=20)
    private String  currency;
    
    
    @Column(name="EXCHANGE_RATE")
    private BigDecimal exchangeRate;
    
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="ENTRY_DATE")
    private Date       entryDate ;

    @Column(name="CREATED_BY", length=100)
    private String     createdBy ;

    @Column(name="BUILDING_PURPOSE_ID", length=100)
    private String     buildingPurposeId;

    
    @Column(name="STATUS", length=2)
    private String     status ;

    @Column(name="GROUP_COUNT")
    private Integer groupCount;
    
    @Column(name="HAVEPROMOCODE", length=20)
    private String     havepromocode;

    @Column(name="PROMOCODE", length=100)
    private String     promocode;
    
    @Column(name="INBUILD_CONSTRUCT_TYPE", length=20)
    private String     inbuildConstructType;

    @Column(name="OCCUPATION_TYPE", length=20)
    private String     occupationType;

    @Column(name="CATEGORY_ID", length=20)
    private String     categoryId;

    @Column(name="ELEC_EQUIP_SUMINSURED")
    private BigDecimal elecEquipSuminsured;

    @Column(name="MONEY_SINGLECARRY_SUMINSURED")
    private BigDecimal moneySinglecarrySuminsured;

    @Column(name="MONEY_ANNUALCARRY_SUMINSURED")
    private BigDecimal moneyAnnualcarrySuminsured;

    @Column(name="MONEY_INSAFE_SUMINSURED")
    private BigDecimal moneyInsafeSuminsured;

    @Column(name="FIDELITY_ANYOCCU_SUMINSURED")
    private BigDecimal fidelityAnyoccuSuminsured;

    @Column(name="FIDELITY_ANNUAL_SUMINSURED")
    private BigDecimal fidelityAnnualSuminsured;

    @Column(name="TPLIABILITY_ANYOCCU_SUMINSURED")
    private BigDecimal tpliabilityAnyoccuSuminsured;

    @Column(name="EMPLIABILITY_ANNUAL_SUMINSURED")
    private BigDecimal empliabilityAnnualSuminsured;


    @Column(name="EMPLIABILITY_EXCESS_SUMINSURED")
    private BigDecimal empliabilityExcessSuminsured;

    @Column(name="GOODS_SINGLECARRY_SUMINSURED")
    private BigDecimal goodsSinglecarrySuminsured;

    @Column(name="GOODS_TURNOVER_SUMINSURED")
    private BigDecimal goodsTurnoverSuminsured;

    @Column(name="INDUSTRY_ID")
    private Integer  industryId ;



    @Column(name="NATURE_OF_TRADE_ID")
    private Integer natureOfTradeId;
    
    @Column(name="INSURANCE_FOR_ID")
    private String insuranceForId ;
    
    @Column(name="INTERNAL_WALL_TYPE")
    private Integer internalWallType;
    
    @Column(name="CEILING_TYPE")
    private Integer ceilingType;
    
    @Column(name="STOCK_IN_TRADE_SI")
    private BigDecimal stockInTradeSi ;
    
    @Column(name="GOODS_SI")
    private BigDecimal goodsSi;
    
    @Column(name="FURNITURE_SI")
    private BigDecimal furnitureSi;
    
    @Column(name="APPLIANCE_SI")
    private BigDecimal applianceSi;
    
    @Column(name="CASH_VALUEABLES_SI")
    private BigDecimal cashValueablesSi;
    
    @Column(name="OCCUPIED_YEAR")
    private Integer occupiedYear;
    
    @Column(name="SHOW_WINDOWS")
    private Integer showWindow;
    
    @Column(name="FRONT_DOORS")
    private Integer frontDoors;
    
    @Column(name="BACK_DOORS")
    private Integer backDoors;
    
    @Column(name="WINDOWS_MATERIAL_ID")
    private Integer windowsMaterialId;
    
    @Column(name="DOORS_MATERIAL_ID")
    private Integer doorsMaterialId; 
    
    @Column(name="NIGHT_LEFT_DOOR")
    private Integer nightLeftDoor; 
    
    @Column(name="BUILDING_OCCUPIED")
    private Integer buildingOccupied; 
    
    @Column(name="WATCHMAN_GUARD_HOURS")
    private Integer watchmanGuardHours;
    
    @Column(name="ACCESSIBLE_WINDOWS")
    private Integer accessibleWindows;
    
    @Column(name="TRAP_DOORS")
    private Integer trapDoors;
    
    @Column(name="CASH_IN_HAND_DIRECTORS")
    private BigDecimal cashInHandDirectors;
    
    @Column(name="CASH_IN_TRANSIT")
    private BigDecimal cashInTransit;
    
    @Column(name="CASH_IN_HAND_EMPLOYEES")
    private BigDecimal cashInHandEmployees;
    
    @Column(name="CASH_IN_SAFE")
    private BigDecimal cashInSafe;
    
    @Column(name="CASH_IN_PREMISES")
    private BigDecimal cashInPremises;
    
    @Column(name="REVENUE_FROM_STAMPS")
    private BigDecimal revenueFromStamps;
    
    @Column(name="MONEY_IN_SAFE_BUSINESS")
    private BigDecimal moneyInSafeBusiness;
    
    @Column(name="MONEY_OUT_SAFE_BUSINESS")
    private BigDecimal moneyOutSafeBusiness;
    
    @Column(name="MONEY_IN_PREMISES")
    private BigDecimal moneyInPremises;
    
    @Column(name="MONEY_IN_LOCKER")
    private BigDecimal moneyInLocker;

    @Column(name="MACHINE_EQUIP_SI")
    private BigDecimal machineEquipSi ;

    @Column(name="PLATE_GLASS_SI")
    private BigDecimal plateGlassSi ;
    
    @Column(name="ACC_DAMAGE_SI")
    private BigDecimal accDamageSi ;
    
    @Column(name="FIRST_LOSS_PERCENT")
    private Long firstLossPercent ;
    
    @Column(name="BURGLARY_SI")
    private BigDecimal burglarySi ;
    
    @Column(name="POWER_PLANT_SI")
    private BigDecimal powerPlantSi ;
    
    @Column(name="ELEC_MACHINES_SI")
    private BigDecimal elecMachinesSi ;
    
    @Column(name="EQUIPMENT_SI")
    private BigDecimal equipmentSi ;
    
    @Column(name="GENERAL_MACHINE_SI")
    private BigDecimal generalMachineSi ;
    
    @Column(name="MANU_UNITS_SI")
    private BigDecimal manuUnitsSi ;
    
    @Column(name="BOILER_PLANTS_SI")
    private BigDecimal boilerPlantsSi ;
    
}



