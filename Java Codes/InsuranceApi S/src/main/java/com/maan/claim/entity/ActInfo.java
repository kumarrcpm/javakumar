package com.maan.claim.entity;

import javax.persistence.Table;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@IdClass(ActInfoId.class)// if one primary key column IdClass is not use
@Entity
@Table( name ="ACT_INFO")
public class ActInfo implements Serializable {
	 
	private static final long serialVersionUID = 1L;

	//--- ENTITY PRIMARY KEY 
    @Id
    @Column(name="SEQUENCENUMBER", nullable=false)
    private BigDecimal sequencenumber ;

    @Id
    @Column(name="VEHICLEID", nullable=false)
    private BigDecimal vehicleid ;

    //--- ENTITY DATA FIELDS 
    @Column(name="ACTARABIC", length=200)
    private String     actarabic ;

    @Column(name="ACTENGLISH", length=100)
    private String     actenglish ;

    @Column(name="AMENDID")
    private BigDecimal amendid ;

    @Temporal(TemporalType.DATE)
    @Column(name="ENTRYDATE")
    private Date       entrydate ;

    @Column(name="STATUS", length=1)
    private String     status ;

    @Column(name="REMARKS", length=500)
    private String     remarks ;

    @Column(name="CASENUMBER", length=50)
    private String     casenumber ;


    @Temporal(TemporalType.DATE)
    @Column(name="EFFECTIVE_DATE")
    private Date       effectiveDate ;
    //--- ENTITY LINKS ( RELATIONSHIP )
}
