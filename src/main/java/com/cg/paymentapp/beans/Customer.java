package com.cg.paymentapp.beans;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;





@Entity
public class Customer {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;
	
	//@NotBlank
	private String name;
	
	//@Size(min=10,max=10,message="Mobile Number should be of 10 digits")
	//@Pattern(regexp="[0-9]",message = "It should have only digits")
	private String mobileNo;
	
	//@Size(min=5,max=8)
	private String password;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Wallet wallet;


	public Customer() {
		
	}


	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	
	  public Wallet getWallet() { return wallet; }
	  
	  
	  public void setWallet(Wallet wallet) { this.wallet = wallet; }
	 
	
	
}
