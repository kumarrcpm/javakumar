package com.maan.eway.req.push;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

@Data
//@XmlRootElement(name="SubjectMatter")
@ToString
@Jacksonized
@XmlAccessorType(XmlAccessType.FIELD)
@AllArgsConstructor
@NoArgsConstructor
public class SubjectMatter {
 
	@JsonProperty("SubjectMatterDesc")
	@XmlElement(name = "SubjectMatterDesc")
    private String subjectMatterDesc;
	@JsonProperty("SubjectMatterReference")
	@XmlElement(name = "SubjectMatterReference")
    private String subjectMatterReference;
 	 
}