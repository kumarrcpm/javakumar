package com.maan.claim.req;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ActSaveReq {

    @JsonProperty("Sequencenumber")
    private String sequencenumber ;

    @JsonProperty("Vehicleid")
    private String vehicleid ;
 
    @JsonProperty("Actarabic")
    private String     actarabic ;

    @JsonProperty("Actenglish")
    private String     actenglish ;

 /*   @JsonProperty("Amendid")
    private String amendid ;*/

  /*  @Temporal(TemporalType.DATE)
    @JsonProperty("ENTRYDATE")
    private String       entrydate ; */
    @JsonProperty("EffectiveDate")
    private String       effectiveDate ;

   /* @JsonProperty("Status")
    private String     status ; */
    
    @JsonProperty("Remarks")
    private String     remarks ;

    @JsonProperty("Casenumber")
    private String     casenumber ;
    
    @JsonProperty("AccidentList")
    private List<AccidentInfoSaveReq>     accidenttList ;

}
