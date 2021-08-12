package com.cg.paymentapp.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.BatchSize;
import org.springframework.lang.NonNull;

@Entity
public class BankAccount {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int accountNo;
	
	private String ifscCode;
	
	private String bankName;
	
	private double balance;
	

	
	public BankAccount() {
		// TODO Auto-generated constructor stub
	}


	public BankAccount(int accountNo, String ifscCode, String bankName, double balance) {
		super();
		this.accountNo = accountNo;
		this.ifscCode = ifscCode;
		this.bankName = bankName;
		this.balance = balance;
	}



	public int getAccountNo() {
		return accountNo;
	}


	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}


	public String getIfscCode() {
		return ifscCode;
	}


	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}


	public String getBankName() {
		return bankName;
	}


	public void setBankName(String bankName) {
		this.bankName = bankName;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}

}
