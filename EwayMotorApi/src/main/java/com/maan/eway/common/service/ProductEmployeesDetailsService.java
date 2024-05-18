package com.maan.eway.common.service;

import java.util.List;

import com.maan.eway.common.req.ProductEmployeeDeleteReq;
import com.maan.eway.common.req.ProductEmployeeSaveReq;
import com.maan.eway.common.req.ProductEmployeesGetReq;
import com.maan.eway.common.res.ProductEmployeeGetRes;
import com.maan.eway.error.Error;
import com.maan.eway.res.SuccessRes;

public interface ProductEmployeesDetailsService {
	
	List<Error> validateProductEmployeesDetails(List<ProductEmployeeSaveReq> req);

	SuccessRes saveProductEmployeesDetails(List<ProductEmployeeSaveReq> req);

	List<ProductEmployeeGetRes> getallProductEmployeesDetails(ProductEmployeesGetReq req);

	SuccessRes deleteProductEmployeesDetails(ProductEmployeeDeleteReq req);

}
