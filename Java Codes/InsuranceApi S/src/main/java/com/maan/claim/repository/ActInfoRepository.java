package com.maan.claim.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.maan.claim.entity.ActInfo;
import com.maan.claim.entity.ActInfoId;

// add ActInfoId if one more primary key id is used in table
public interface ActInfoRepository  extends JpaRepository<ActInfo, ActInfoId> , JpaSpecificationExecutor<ActInfo>  {

	ActInfo findBySequencenumber(BigDecimal sequencenumber);
	
	List<ActInfo> OrderBySequencenumberDesc();

	Page<ActInfo> findByStatus(Pageable paging, String string);
	
	@Query(value="select count(*) from insurance_company_master bcm,login_master lm where bcm.INS_ID =?1 ?2 ?3 and BCM.INS_ID=LM.COMPANY_ID",nativeQuery=true)
	Long validateComanyId(String companyId);
	
	@Query(value="select count(*) from insurance_company_master bcm,login_master lm where bcm.INS_ID =?1 and BCM.INS_ID=LM.COMPANY_ID",nativeQuery=true)
	List<Map<String,Object>> getPortFolio(String companyId);
	
	/*// Existing Quote Without Pagination
	/*	@Query(value = " SELECT A.APPLICATION_NO,A.QUOTE_NO, A.CUSTOMER_ID, TO_CHAR(A.ENTRY_DATE, 'DD/MM/YYYY') QUOTATION_DATE, TO_CHAR (A.EFFECTIVE_DATE, 'DD/MM/YYYY') VALIDITY_DATE, NVL (B.COMPANY_NAME, B.FIRST_NAME) CUSTOMER_NAME, A. LOGIN_ID, B.COMPANY_NAME, A.EFFECTIVE_DATE, NVL (M.OPEN_COVER_NO, '0') AS OPEN_COVER_NO , round((NVL (round(m.PREMIUM,2)+nvl(m.stamp_duty,0), '0') + NVL (m. POLICY_FEE, '0') +trunc(NVL (m.CGST,'0'),2) +trunc(NVL (m.SGST,'0'),2) +trunc(NVL (m.IGST,'0'),2) +trunc(NVL (m.UTGST,'0'),2) +trunc(NVL (m. SERVICE_TAX,'0'),2) +trunc(NVL (m.EDU_CESS,0),2) +trunc(NVL (m.SH,0),2)+ trunc(NVL (m.KRISHI_KALYAN_CESS,0),2)+NVL(round(m.EXCESS_PREMIUM,2),0)), 0) PREMIUM, B.EMAIL FROM POSITION_MASTER A, PERSONAL_INFO B, MARINE_DATA M WHERE A.LOGIN_ID =?1 AND (A.FREIGHT_STATUS NOT IN ('F', 'B') OR A.FREIGHT_STATUS IS NULL) AND A.EFFECTIVE_DATE > = ( SELECT SYSDATE FROM DUAL) AND A.STATUS = 'Y' AND (A.REMARKS NOT IN ('Admin', 'Referal', 'NORMAL_EXCESS_PRICE')) AND M.APPLICATION_NO = A.APPLICATION_NO AND NVL (M.ADMIN_REFERRAL_STATUS, 'N') NOT IN ('Y') AND B.CUSTOMER_ID = A.CUSTOMER_ID and b.amend_id=( select max(amend_id) from PERSONAL_INFO p where p.CUSTOMER_ID=b.CUSTOMER_ID) AND A.PRODUCT_ID = ?2 AND A.APPLICATION_ID = NVL(?3,'1') AND NVL(A.OPEN_COVER_NO,'0') like NVL(?4 ||'%','0') and nvl(SALES_TURNOVER_TYPE,'N')=nvl(?5,'N') and nvl(CONSOLIDATE_POLICY_NO,'N') =nvl(?6,'N') ORDER BY QUOTE_NO desc " , nativeQuery = true)
		List<Map<String , Object>> getExistingQuoteDetails(String loginId , String productId , String applicationId , String openCoverNo , String saleType , String consolidatePolicyNo ); */
	
	// With Pagination
	// (i) Existing Quote 
	/*@Query(value = " SELECT * FROM   ( SELECT t.*, ROWNUM AS rn FROM   ( SELECT A.APPLICATION_NO,A.QUOTE_NO, A.CUSTOMER_ID, TO_CHAR(A.ENTRY_DATE, 'DD/MM/YYYY') QUOTATION_DATE, TO_CHAR (A.EFFECTIVE_DATE, 'DD/MM/YYYY') VALIDITY_DATE, NVL (B.COMPANY_NAME, B.FIRST_NAME) CUSTOMER_NAME, A. LOGIN_ID, B.COMPANY_NAME, A.EFFECTIVE_DATE, NVL (M.OPEN_COVER_NO, '0') AS OPEN_COVER_NO , round((NVL (round(m.PREMIUM,2)+nvl(m.stamp_duty,0), '0') + NVL (m. POLICY_FEE, '0') +trunc(NVL (m.CGST,'0'),2) +trunc(NVL (m.SGST,'0'),2) +trunc(NVL (m.IGST,'0'),2) +trunc(NVL (m.UTGST,'0'),2) +trunc(NVL (m. SERVICE_TAX,'0'),2) +trunc(NVL (m.EDU_CESS,0),2) +trunc(NVL (m.SH,0),2)+ trunc(NVL (m.KRISHI_KALYAN_CESS,0),2)+NVL(round(m.EXCESS_PREMIUM,2),0)), 0) PREMIUM, B.EMAIL FROM POSITION_MASTER A, PERSONAL_INFO B, MARINE_DATA M WHERE A.LOGIN_ID =?1 AND (A.FREIGHT_STATUS NOT IN ('F', 'B') OR A.FREIGHT_STATUS IS NULL) AND A.EFFECTIVE_DATE > = ( SELECT SYSDATE FROM DUAL) AND A.STATUS = 'Y' AND (A.REMARKS NOT IN ('Admin', 'Referal', 'NORMAL_EXCESS_PRICE')) AND M.APPLICATION_NO = A.APPLICATION_NO AND NVL (M.ADMIN_REFERRAL_STATUS, 'N') NOT IN ('Y') AND B.CUSTOMER_ID = A.CUSTOMER_ID and b.amend_id=( select max(amend_id) from PERSONAL_INFO p where p.CUSTOMER_ID=b.CUSTOMER_ID) AND A.PRODUCT_ID = ?2 AND A.APPLICATION_ID = NVL(?3,'1') AND NVL(A.OPEN_COVER_NO,'0') like NVL(?4 ||'%','0') and nvl(SALES_TURNOVER_TYPE,'N')=nvl(?5,'N') and nvl(CONSOLIDATE_POLICY_NO,'N') =nvl(?6,'N') ORDER BY QUOTE_NO desc ) t ) WHERE  rn BETWEEN ?7 AND ?8 " , nativeQuery = true)
	List<Map<String , Object>> getExistingQuoteDetails(String loginId , String productId , String applicationId , String openCoverNo , String saleType , String consolidatePolicyNo , int start ,int end );
*/
}	