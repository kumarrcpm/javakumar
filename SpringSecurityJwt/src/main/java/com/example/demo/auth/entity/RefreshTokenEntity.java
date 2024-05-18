package com.example.demo.auth.entity;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="REFRESH_TOKEN_DETAILS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefreshTokenEntity {

	
	@Id
	@Column(name="ID", nullable=false)
    private int id;

	@Column(name="USER_NAME", length=20)
    private String userName;

	@Column(name="REFRESH_VALUE", length=100)
	private String refreshValue;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="EXPIRY_DATE")
	private Date expiryDate;
	
	
	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRefreshValue() {
		return refreshValue;
	}

	public void setRefreshValue(String refreshValue) {
		this.refreshValue = refreshValue;
	}


}
