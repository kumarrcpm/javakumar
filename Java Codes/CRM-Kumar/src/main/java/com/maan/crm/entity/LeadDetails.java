package com.maan.crm.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter 
@Setter
@NoArgsConstructor
@AllArgsConstructor

@IdClass(LeadDetailsId.class)
@Table(name="LEAD_DETAILS")
public class LeadDetails implements Serializable {
	 
	private static final long serialVersionUID = 1L;
	 
	    //--- ENTITY PRIMARY KEY 
	    @Id
	    @Column(name="LEAD_ID", nullable=false)
	    private int     leadId ;

	    @Id
	    @Column(name="CLIENT_ID", nullable=false)
	    private int     clientId ;

	    //--- ENTITY DATA FIELDS 
	    @Column(name="BUSINESSTYPE", length=100)
	    private String     businessType;
	    
	    @Column(name="BUSINESSTYPE_Id")
	    private int   businesstypeId ;


	    @Column(name="CLASS_DESC", length = 100)
	    private String classDesc ;


	    @Column(name="CLASS_ID")
	    private int classId ;


	    @Column(name="POLICYTYPE", length = 100)
	    private String 	policyType ;


	    @Column(name="POLICYTYPE_ID")
	    private int   policyTypeId ;

	    @Temporal(TemporalType.DATE)
	    @Column(name="LEAD_GEN_DATE", nullable=false)
	    private Date       leadGenDate ;

	    @Temporal(TemporalType.DATE)
	    @Column(name="DUE_DATE", nullable=false)
	    private Date       dueDate ;

	    @Column(name="BROKEN_POLICY", length = 100)
	    private String brokenPolicy ;

	    @Column(name="CLASSIFICATION", length = 100)
	    private String calssification ;

	    @Column(name="CLASSIFICATION_ID")
	    private int   classificationId ;

	    @Column(name="SOURCE", length = 100)
	    private String source ;

	    @Column(name="SOURCE_ID")
	    private int   sourceId ;

	    @Column(name="REFERREDBY", length = 100)
	    private String referredby ;

	    @Column(name="REFERREDBY_ID")
	    private int   referredbyId ;


	    @Column(name="OTHERTYPE", length = 100)
	    private String othertype ;

	    @Column(name="OTHERTYPE_ID")
	    private int   othertypeId ;

	    @Column(name="POS", length = 100)
	    private String pos ;

	    @Column(name="POS_ID")
	    private int   posId ;

	    @Column(name="REFERENCE_NAME", length = 100)
	    private String referenceName ;


	    @Column(name="ASSIGNTO_GROUP", length = 100)
	    private String assigntoGroup ;

	    @Column(name="ASSIGNTO_GROUP_ID")
	    private int   assigntoGroupId ;

	    @Column(name="ASSIGNTO_USER", length = 100)
	    private String assigntoUser ;

	    @Column(name="ASSIGNTO_USER_ID")
	    private int   assigntoUserId ;

	    @Column(name="REMARKS", length = 100)
	    private String remarks ;






}
