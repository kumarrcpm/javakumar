package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

	
	private String username;
	@Id
	private int doorNo;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getDoorNo() {
		return doorNo;
	}
	public void setDoorNo(int doorNo) {
		this.doorNo = doorNo;
	}
}
