/*
 * Created on 2022-09-02 ( 18:14:54 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */
package com.maan.eway.bean;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


import java.util.Date;

/**
 * Composite primary key for entity "SectionMaster" ( stored in table "section_master" )
 *
 * @author Telosys
 *
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UWQuestionsMasterId implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY KEY ATTRIBUTES 
    
    private String     companyId ;

    private Integer  productId;

    private Integer     amendId ;

    private Integer  uwQuestionId;
    
    private String branchCode;
	
    
    
     
}
