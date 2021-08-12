package com.cg.paymentapp.beans;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Wallet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int walletId;
	
	private BigDecimal balance;
	
	
	public Wallet() {
		// TODO Auto-generated constructor stub
	}


	public int getWalletId() {
		return walletId;
	}


	public void setWalletId(int walletId) {
		this.walletId = walletId;
	}


	public BigDecimal getBalance() {
		return balance;
	}


	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}


	public Wallet(int walletId, BigDecimal balance) {
		super();
		this.walletId = walletId;
		this.balance = balance;
	}



	@Override
	public String toString() {
	return " balance= "+balance;
	}
	
	
	
	
	
}
