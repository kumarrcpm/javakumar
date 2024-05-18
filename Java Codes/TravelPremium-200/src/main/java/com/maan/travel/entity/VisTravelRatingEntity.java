package com.maan.travel.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Entity
@DynamicInsert
@DynamicUpdate
@Builder
@NoArgsConstructor
@Table(name="VIS_TRAVEL_RATING")
public class VisTravelRatingEntity {
	
	@Id
	@Column(name="SNO")
	private BigDecimal sno ;

	
	@Column(name="TYPE_ID", length=5)
	private String     typeId ;
		
	@Column(name="TYPE_DESC", length=50)
	private String     typeDesc ;
	
	@Column(name="COVER_ID")
	private BigDecimal coverId ;
	
	@Column(name="COVER_DESC", length=50)
	private String     coverDesc ;
	
	@Column(name="SCHEME_ID")
	private BigDecimal schemeId ;
	
	@Column(name="SCHEME_DESC", length=30)
	private String     schemeDesc ;
	
	@Column(name="TRAVEL_START_DATE")
	private BigDecimal travelStartDate ;
	
	
	@Column(name="TRAVEL_END_DATE")
	private BigDecimal travelEndDate ;
	
	
	@Column(name="AGE_FROM")
	private BigDecimal ageFrom ;
	
	@Column(name="AGE_TO")
	private BigDecimal ageTo ;
	
	@Column(name="RATING")
	private BigDecimal rating ;
	
	@Column(name="VAT")
	private BigDecimal vat ;
	
	@Column(name="TOTAL_RATE")
	private BigDecimal totalRate ;
	
	@Column(name="AGENCY_CODE", length=25)
	private String agencyCode ;
	
	@Column(name="VAT2")
	private BigDecimal vat2 ;
	
	@Column(name="TOTAL_VAT")
	private BigDecimal totalVat ;
	
	@Column(name="AMEND_ID")
	private BigDecimal amendId ;
	
	@Temporal(TemporalType.DATE)
	@Column(name="EFFECTIVE_DATE", nullable=false)
	private Date       effectiveDate ;
	
	
	@Column(name="REMARKS", length=300)
	private String     remarks ;
	
	
	@Column(name="STATUS", length=2)
	private String     status ;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name="ENTRY_DATE", nullable=false)
	private Date       entryDate ;
	
	
	
	@Column(name="TRIP_ID")
	private BigDecimal tripId ;
	
	@Column(name="AGEBAND_ID")
	private BigDecimal agebandId ;
	
	

	
}
