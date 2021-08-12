package com.cg.paymentapp.services;

import java.time.LocalDate;
import java.util.List;

import com.cg.paymentapp.beans.TransactionBean;

public interface TransactionService {

	
	public List<TransactionBean> viewAllTransactionForCustomer(String mobileNo);
	
	public List<TransactionBean> viewTransactionForCustomerByDate(LocalDate startDate,LocalDate endDate);
	
	public TransactionBean viewTheTransactionById(int txId);
	
	
}
