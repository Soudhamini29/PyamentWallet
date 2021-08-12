package com.cg.paymentapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.paymentapp.beans.BankAccount;


public interface AccountRepository extends JpaRepository<BankAccount, Integer> {

	
	
	
	
}
