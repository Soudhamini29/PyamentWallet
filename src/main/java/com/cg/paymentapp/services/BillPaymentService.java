package com.cg.paymentapp.services;

import java.util.List;

import com.cg.paymentapp.beans.BillPayment;
import com.cg.paymentapp.beans.BillType;

public interface BillPaymentService {

	public BillPayment payTheBill(String mobileNo,BillType billType,double amount);
	
	public List<BillPayment> getTheBillPaymentOfCustomer(String mobileNo);
	
	
	
}
