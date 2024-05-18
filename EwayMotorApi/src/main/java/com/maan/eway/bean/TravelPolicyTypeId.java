package com.maan.eway.bean;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TravelPolicyTypeId implements Serializable {

	private static final long serialVersionUID=1L;

	private Integer policyTypeId;
	private Integer planTypeId;
	private Integer coverId;
	private Integer subCoverId;


}
