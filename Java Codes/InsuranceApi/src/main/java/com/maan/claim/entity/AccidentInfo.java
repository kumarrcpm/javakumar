package com.maan.claim.entity;

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
//@IdClass(ActInfoId.class)// if one primary key column IdClass is not use
@Entity
@Table( name ="ACCIDENT_INFO")
public class AccidentInfo implements Serializable {
	 
	private static final long serialVersionUID = 1L;

	//--- ENTITY PRIMARY KEY 
    @Id
    @Column(name="CASENUMBER", nullable=false)
    private BigDecimal casenumber ;
    
    //--- ENTITY DATA FIELDS 
    @Column(name="SURVEYORNAME", length=200)
    private String     surveyorname ;

    @Temporal(TemporalType.DATE)
    @Column(name="CALLDATE")
    private Date       calldate ;
    
    @Column(name="CALLTIME", length=100)
    private String     calltime ;

    @Column(name="LANDMARK", length=200)
    private String landmark ;

    @Column(name="LOCATION", length=200)
    private String     location ;

    @Column(name="LOCATIONCOORDINATES", length=500)
    private String     locationcoordinates ;

    @Column(name="CITYID", length=200)
    private String     cityid ;
    
    @Column(name="CITY", length=500)
    private String     city ;

    @Column(name="ACCIDENTDESCRIPTION", length=500)
    private String     accidentdescription ;

    @Column(name="AMENDID", length=500)
    private BigDecimal     amendid ;
    
    @Temporal(TemporalType.DATE)
    @Column(name="ENTRYDATE")
    private Date     entrydate ;
    
    @Column(name="STATUS", length=500)
    private String     status ;

    @Column(name="REMARKS", length=500)
    private String  remark ;

    //--- ENTITY LINKS ( RELATIONSHIP )
}
