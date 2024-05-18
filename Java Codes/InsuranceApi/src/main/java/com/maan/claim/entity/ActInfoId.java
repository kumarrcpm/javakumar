package com.maan.claim.entity;



import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ActInfoId implements  Serializable {

    private static final long serialVersionUID = 1L;
    
    private BigDecimal sequencenumber ;
    
    private BigDecimal vehicleid ;


}
