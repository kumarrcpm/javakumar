package com.example.demo.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefreshTokenReq {

	private String refreshValue;

	public String getRefreshValue() {
		return refreshValue;
	}

	public void setRefreshValue(String refreshValue) {
		this.refreshValue = refreshValue;
	}
}
