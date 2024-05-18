package com.maan.eway.batch.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
//@IdClass(EwayEmplyeeDetailRawId.class)
@Table(name = "EWAY_EMPLOYEE_DETAILS_RAW")
public class EwayEmplyeeDetailRaw {
	

	@Id
	@Column(name ="ROWNUM")
	private Integer rowNum;

	@Column(name ="NATIONALITY_ID")
	private String nationalityId;
		
	
	@Column(name ="REQUEST_REFERENCE_NO")
	private String requestReferenceNo;
	

	@Column(name ="RISK_ID")
	private Integer riskId;

	@Column(name ="QUOTE_NO")
	private String quoteNo;
	

	@Column(name ="PRODUCT_ID")
	private Integer productId;
	

	@Column(name ="COMPANY_ID")
	private Integer companyId;
	
	
	@Column(name ="CREATED_BY")
	private String createdBy;
	
	@Column(name ="EMPLOYEE_NAME")
	private String employeeName;
	
	@Column(name ="DATE_OF_JOINING")
	private String dateOfJoining;
	
	@Column(name ="DATE_OF_JOIN_MONTH")
	private String dateOfJoiningMonth;
	
	@Column(name ="OCCUPATION_ID")
	private String occupationId;
	
	@Column(name ="OCCUPATION_DESC")
	private String occupatonDesc;
	
	@Column(name ="SALARY")
	private String salary;
	
	@Column(name ="SNO")
	private Integer sno;
	
	@Column(name ="DATE_OF_BIRTH")
	private String dateOfBirth;
	
	@Column(name ="ERROR_DESC")
	private String errorDesc;
	
	@Column(name ="STATUS")
	private String status;
	
	@Column(name ="TYPEID")
	private Integer typeid;
	


}

