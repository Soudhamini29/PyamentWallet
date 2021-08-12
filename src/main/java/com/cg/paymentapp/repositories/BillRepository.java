package com.cg.paymentapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.paymentapp.beans.BillPayment;

public interface BillRepository extends JpaRepository<BillPayment,Integer>{

	public List<BillPayment> findByMobileNo(String mobileNo);
}
