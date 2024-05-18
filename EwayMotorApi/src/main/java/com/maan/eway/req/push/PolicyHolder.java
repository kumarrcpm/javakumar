package com.maan.eway.req.push;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;
@Data
//@XmlRootElement(name="PolicyHolder")
@ToString
@Jacksonized
@XmlAccessorType(XmlAccessType.FIELD)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PolicyHolder {

	@JsonProperty("CountryCode")
	@XmlElement(name = "CountryCode")
    String countryCode;
	
	@JsonProperty("District")
	@XmlElement(name = "District")
	String district;
	
	@JsonProperty("EmailAddress")
	@XmlElement(name = "EmailAddress")
	String emailAddress;
	
	@JsonProperty("Gender")
	@XmlElement(name = "Gender")
	String gender;
	
	@JsonProperty("IsMulti")
	@XmlElement(name = "IsMulti")
	String isMulti;
	
	@JsonProperty("PolicyHolderBirthDate")
	@XmlElement(name = "PolicyHolderBirthDate")
	String policyHolderBirthDate;
	
	@JsonProperty("PolicyHolderFax")
	@XmlElement(name = "PolicyHolderFax")
	String policyHolderFax;
	
	@JsonProperty("PolicyHolderIdNumber")
	@XmlElement(name = "PolicyHolderIdNumber")
	String policyHolderIdNumber;
	
	@JsonProperty("PolicyHolderIdType")
	@XmlElement(name = "PolicyHolderIdType")
	String policyHolderIdType;
	
	@JsonProperty("PolicyHolderName")
	@XmlElement(name = "PolicyHolderName")
	String policyHolderName;
	
	@JsonProperty("PolicyHolderPhoneNumber")
	@XmlElement(name = "PolicyHolderPhoneNumber")
	String policyHolderPhoneNumber;
	
	@JsonProperty("PolicyHolderType")
    @XmlElement(name = "PolicyHolderType")
	String policyHolderType;
	
	@JsonProperty("PostalAddress")
	@XmlElement(name = "PostalAddress")
	String postalAddress;
	
	@JsonProperty("Region")
	@XmlElement(name = "Region")
	String region;
	
	@JsonProperty("Street")
	@XmlElement(name = "Street")
	String street;
   
  
}