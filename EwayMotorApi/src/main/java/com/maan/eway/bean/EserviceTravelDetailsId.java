/*
 * Created on 2022-11-30 ( 17:06:34 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */
package com.maan.eway.bean;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;



/**
 * Composite primary key for entity "EserviceTravelDetails" ( stored in table "eservice_travel_details" )
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
public class EserviceTravelDetailsId implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY KEY ATTRIBUTES 
    private String     requestReferenceNo ;
    
    private String     customerReferenceNo ;
    
    private Integer    riskId ;
    
    private String     companyId ;
    
    private String     branchCode ;
    
     
}