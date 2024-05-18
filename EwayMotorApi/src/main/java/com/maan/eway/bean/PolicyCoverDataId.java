/*
 * Created on 2023-01-12 ( 16:01:43 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */
package com.maan.eway.bean;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;



/**
 * Composite primary key for entity "PolicyCoverData" ( stored in table "policy_cover_data" )
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
public class PolicyCoverDataId implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY KEY ATTRIBUTES 
    private String     quoteNo ;
    
    private String     requestReferenceNo ;
    
    private Integer    vehicleId ;
    
    private Integer    productId ;
    
    private Integer    sectionId ;
    
    private Integer    coverId ;
    
    private String     subCoverYn ;
    
    private Integer    subCoverId ;
    
    private Integer    discLoadId ;
    
    private Integer    taxId ;
    
    private Integer    discountCoverId;
    
    private BigDecimal     endtCount ; 
}
