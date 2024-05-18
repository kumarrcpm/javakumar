/* 
*  Copyright (c) 2019. All right reserved
 * Created on 2023-01-12 ( Date ISO 2023-01-12 - Time 16:01:18 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */

/*
 * Created on 2023-01-12 ( 16:01:18 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */


package com.maan.eway.bean;


import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.Table;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

import java.util.Date;
import javax.persistence.*;




/**
* Domain class for entity "LoginMaster"
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
@IdClass(LoginMasterId.class)
@Table(name="eway_login_master")


public class LoginMaster implements Serializable {
 
private static final long serialVersionUID = 1L;
 
    //--- ENTITY PRIMARY KEY 
    @Id
    @Column(name="LOGIN_ID", nullable=false, length=50)
    private String     loginId ;

    @Id
    @Column(name="USER_TYPE", nullable=false, length=20)
    private String     userType ;

    @Id
    @Column(name="SUB_USER_TYPE", nullable=false, length=20)
    private String     subUserType ;

    //--- ENTITY DATA FIELDS 
    @Column(name="PASSWORD", length=50)
    private String     password ;

    @Column(name="COMPANY_ID", length=20)
    private String     companyId ;

    @Column(name="ATTACHED_BRANCHES", nullable=false, length=300)
    private String     attachedBranches ;

    @Column(name="ATTACHED_REGIONS", length=300)
    private String     attachedRegions ;

    @Column(name="ATTACHED_COMPANIES", length=300)
    private String     attachedCompanies ;

    @Column(name="AGENCY_CODE", nullable=false, length=10)
    private String     agencyCode ;

    @Column(name="BANK_CODE", length=20)
    private String     bankCode ;

    @Column(name="BROKER_COMPANY_YN", length=1)
    private String     brokerCompanyYn ;

    @Column(name="OA_CODE", length=10)
    private String     oaCode ;

    @Column(name="LPASS1", length=50)
    private String     lpass1 ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="LPASS_DATE")
    private Date       lpassDate ;

    @Column(name="LPASS2", length=50)
    private String     lpass2 ;

    @Column(name="LPASS3", length=50)
    private String     lpass3 ;

    @Column(name="CREATED_BY", length=20)
    private String     createdBy ;

    @Column(name="MENU_IDS", length=500)
    private String     menuIds ;

    @Column(name="STATUS", nullable=false, length=1)
    private String     status ;

    @Column(name="UPDATED_BY", length=20)
    private String     updatedBy ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="UPDATED_DATE")
    private Date       updatedDate ;

    @Column(name="LPASS4", length=20)
    private String     lpass4 ;

    @Column(name="LPASS5", length=20)
    private String     lpass5 ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="EFFECTIVE_DATE_START")
    private Date       effectiveDateStart ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="ENTRY_DATE")
    private Date       entryDate ;

    @Column(name="PWD_COUNT", length=10)
    private String     pwdCount ;


    //--- ENTITY LINKS ( RELATIONSHIP )


}


