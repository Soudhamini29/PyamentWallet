package com.cg.paymentapp.services;

import com.cg.paymentapp.beans.Customer;

public interface UserService {
	
	public Customer validateLogin(String mobileNumber,String password);
	
	public Customer viewCustomerByMobileNo(String mobileNo);
		
	public Customer deleteCustomerByMobileNo(String mobileNo);
}
