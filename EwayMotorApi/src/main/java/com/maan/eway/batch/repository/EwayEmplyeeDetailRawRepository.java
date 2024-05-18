package com.maan.eway.batch.repository;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.maan.eway.batch.entity.EwayEmplyeeDetailRaw;

@Repository
public interface EwayEmplyeeDetailRawRepository extends JpaRepository<EwayEmplyeeDetailRaw, Integer> {

	List<EwayEmplyeeDetailRaw> findByRequestReferenceNo(String requestReferenceNo);

	List<EwayEmplyeeDetailRaw> findByCompanyIdAndProductIdAndRequestReferenceNo(Integer companyId, Integer productId,
			String requestRefNo);

	List<EwayEmplyeeDetailRaw> findByCompanyIdAndProductIdAndQuoteNoAndRiskIdAndRequestReferenceNo(Integer companyId,Integer productId,
			String quoteNo,Integer riskId,String requestReferenceNo);
	
	@Modifying
	@Transactional
	@Query(value="UPDATE eway_employee_details_raw raw SET Occupation_id =( SELECT occupation_id FROM Eway_Occupation_master WHERE STATUS = 'Y' AND Product_id = raw.Product_id AND Company_id = raw.Company_id AND TRIM( UPPER(occupation_name))= TRIM( UPPER(raw.occupation_desc) ) AND SYSDATE() BETWEEN effective_date_start AND effective_date_end AND amend_id =( SELECT MAX(amend_id) FROM Eway_Occupation_master WHERE STATUS = 'Y' AND SYSDATE() BETWEEN effective_date_start AND effective_date_end AND Product_id = raw.Product_id AND TRIM( UPPER(occupation_name) )= TRIM( UPPER(raw.occupation_desc) ) AND Company_id = raw.Company_id ) ), error_desc = CONCAT( error_desc, CASE WHEN TRIM( UPPER(raw.occupation_desc) ) NOT IN ( SELECT TRIM( UPPER(occupation_name) ) FROM Eway_Occupation_master WHERE STATUS = 'Y' AND Product_id = raw.Product_id AND Company_id = raw.Company_id AND SYSDATE() BETWEEN effective_date_start AND effective_date_end ) THEN '~Occupation id is not found' END ) , STATUS= CASE WHEN error_desc IS NOT NULL OR error_desc!='' THEN 'E' ELSE 'Y' END WHERE raw.company_id=?1 AND raw.product_id =?2 AND raw.risk_id=?3 AND raw.request_reference_no =?4 AND raw.quote_no =?5 and raw.status='Y'",nativeQuery=true)
	Integer updateOccupationId(Integer companyId,Integer productId,Integer riskId,String refNo,String quoteNo);

	
	@Modifying
	@Transactional
	@Query(value="UPDATE eway_employee_details_raw RAW SET STATUS='E',error_desc=CONCAT(IFNULL(ERROR_DESC,''),'~nationality_id duplicates are found') WHERE nationality_id IN( SELECT nationality_id FROM( SELECT nationality_id FROM eway_employee_details_raw WHERE REQUEST_REFERENCE_NO=?1 AND QUOTE_NO=?2 AND COMPANY_ID=?3 AND PRODUCT_ID=?4 AND RISK_ID=?5 and status='Y' GROUP BY nationality_id HAVING COUNT(*)>1) AS TEMP) AND REQUEST_REFERENCE_NO=?1 AND QUOTE_NO=?2 AND COMPANY_ID=?3 AND PRODUCT_ID=?4 AND RISK_ID=?5 and status='Y'",nativeQuery=true)
	Integer updateDuplicateNationalityId(String refNo,String quoteNo,Integer companyId,Integer productId,Integer riskId);

	List<EwayEmplyeeDetailRaw> findByCompanyIdAndProductIdAndRequestReferenceNoAndQuoteNoAndRiskIdAndStatusIgnoreCase(
			Integer companyId, Integer productId, String requestRefNo, String quoteNo, Integer riskId, String status);

	@Modifying
	@Transactional
	@Query(value="UPDATE eway_employee_details_raw SET STATUS='E', ERROR_DESC=CONCAT(ERROR_DESC,'~SUMINSURED IS GREATER THAN EXPECTED') WHERE(SELECT SALARY FROM ( SELECT SUM(SALARY) AS SALARY FROM eway_employee_details_raw WHERE QUOTE_NO=?1 AND REQUEST_REFERENCE_NO=?2 AND COMPANY_ID=?3 AND RISK_ID=?4 AND PRODUCT_ID=?5 GROUP BY QUOTE_NO)X)>(SELECT SUM(SUM_INSURED) FROM Common_Data_Details WHERE Quote_no=?1 GROUP BY Quote_no) AND QUOTE_NO=?1 AND REQUEST_REFERENCE_NO=?2 AND COMPANY_ID=?3 AND RISK_ID=?4 AND PRODUCT_ID=?5 and status='Y'",nativeQuery=true)
	Integer checkSuminsuredValidation(String quoteNO, String refNo, String compnayId, String riskId, String productId);

	EwayEmplyeeDetailRaw findByCompanyIdAndProductIdAndQuoteNoAndRiskIdAndRequestReferenceNoAndNationalityIdAndStatusIgnoreCase(
			Integer companyId, Integer productId, String quoteNo, Integer riskId, String requestRefNo,String refNo, String status);

	@Query("select p.sumInsured from CommonDataDetails p where p.quoteNo=:quoteNo")
	BigDecimal getToalPremium(@Param("quoteNo") String quoteNo);
	
	@Modifying
	@Transactional
	@Query(value="UPDATE eway_employee_details_raw SET STATUS=( CASE WHEN DATE_OF_JOINING >= (SELECT YEAR(CURDATE())) THEN 'E' WHEN STR_TO_DATE(DATE_OF_BIRTH,'%d/%m/%Y') >=DATE_SUB(CURDATE(),INTERVAL 18 YEAR) THEN 'E' ELSE 'Y' END), ERROR_DESC=( CASE WHEN DATE_OF_JOINING >= (SELECT YEAR(CURDATE())) THEN '~Date Of Joining should be equal currentYear or pastYear' WHEN STR_TO_DATE(DATE_OF_BIRTH,'%d/%m/%Y') >=DATE_SUB(CURDATE(),INTERVAL 18 YEAR) THEN '~Date of birth should be equal 18 years or greaterthan 18 years' END ) WHERE QUOTE_NO=?1 AND REQUEST_REFERENCE_NO=?2 AND COMPANY_ID=?3 AND RISK_ID=?4 AND PRODUCT_ID=?5 and STATUS ='Y'",nativeQuery=true)
	Integer checkDateOfjoiningAndDateOfBirth(String quoteNo,String refNo,String companyId,String riskId,String productId);
}
