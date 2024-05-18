package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
private String name;
@Id
private long mobileNo;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public long getMobileNo() {
	return mobileNo;
}
public void setMobileNo(long mobileNo) {
	this.mobileNo = mobileNo;
}

}
