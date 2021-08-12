package com.cg.paymentapp.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.paymentapp.beans.Customer;
import com.cg.paymentapp.exceptions.CustomerNotFoundException;
import com.cg.paymentapp.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepo;
	Logger logger=LoggerFactory.getLogger(UserServiceImpl.class);
	
	
	@Override
	public Customer validateLogin(String mobileNumber, String password) {
		
		logger.info("validateLogin method of UserServiceImpl");
		Customer customer= userRepo.validateLogin(mobileNumber, password);
		
		if(customer != null)
			return customer;
		else
			throw new CustomerNotFoundException("Invalid Mobile number or password");
		
		
		
	}


	@Override
	public Customer viewCustomerByMobileNo(String mobileNo) {
		
		Customer customer= userRepo.findByMobileNo(mobileNo);
		logger.info("viewCustomerByMobileNo method of UserServiceImpl");
		
		if(customer == null)
			throw new CustomerNotFoundException("Customer not found with given Mobile Number");
		else
			return customer;
		
		
	}


	@Override
	public Customer deleteCustomerByMobileNo(String mobileNo) {
		
 		Customer customer = userRepo.findByMobileNo(mobileNo);
		
 		if(customer == null)
 			throw new CustomerNotFoundException("Customer Not found with mobile No :"+mobileNo);
		
 		userRepo.delete(customer);
 		
 		
 		return customer;
 		
 		
	}

}
