package com.cg.paymentapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.paymentapp.beans.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, Integer>{

	
	
}
