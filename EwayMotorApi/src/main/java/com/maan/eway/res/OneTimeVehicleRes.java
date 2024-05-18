package com.maan.eway.res;

import com.maan.eway.bean.MsAssetDetails;
import com.maan.eway.bean.MsVehicleDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OneTimeVehicleRes {

	private String vdRefNo ;
	private String sectionId ;
	private String agencyCode  ;
	private String branchCode ;
	private String productId ;
	private String companyId ;
	private String vehicleId ;
	

	private MsVehicleDetails msVehicleDetails ;
}
