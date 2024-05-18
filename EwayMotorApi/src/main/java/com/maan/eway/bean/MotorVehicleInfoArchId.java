/*
 * Created on 2022-10-06 ( 15:40:39 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */
package com.maan.eway.bean;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;



/**
 * Composite primary key for entity "MotorVehicleInfo" ( stored in table "motor_vehicle_info" )
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
public class MotorVehicleInfoArchId implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY KEY ATTRIBUTES 
    private String     reqRegNumber ;
    
    private String     reqChassisNumber ;
    
    private String     archId ;

    
     
}
