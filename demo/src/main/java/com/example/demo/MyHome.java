package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component
public class MyHome {
	
	public MyHome()
	{
		System.out.println("I am Object");
	}
	@Autowired
	@Qualifier("Eb")
	private EbOffice eb;
	
	public EbOffice getEb() {
		return eb;
	}
	public void setEb(EbOffice eb) {
		this.eb = eb;
	}
	public void getSupply()
	{
	System.out.println("New Home Power Supply Connection");	
	eb.giveSupply();
	}
	private String streetname;
	private int doorNo;
	public String getStreetname() {
		return streetname;
	}
	public void setStreetname(String streetname) {
		this.streetname = streetname;
	}
	public int getDoorNo() {
		return doorNo;
	}
	public void setDoorNo(int doorNo) {
		this.doorNo = doorNo;
	}
	
}
