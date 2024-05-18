/*
 * Created on 2022-11-16 ( 16:19:16 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */
package com.maan.eway.bean;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;



/**
 * Composite primary key for entity "UwQuestionsDetailsArch" ( stored in table "uw_questions_details_arch" )
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
public class UwQuestionsDetailsArchId implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY KEY ATTRIBUTES 
    private String     archId ;
    
    private String     companyId ;
    
    private Integer    productId ;
    
    private String     requestReferenceNo ;
    
    private Integer    vehicleId ;
    
    private Integer    uwQuestionId ;
    
     
}
