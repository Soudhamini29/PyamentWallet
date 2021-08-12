package com.cg;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import com.cg.paymentapp.beans.Customer;
import com.cg.paymentapp.repositories.UserRepository;
import com.cg.paymentapp.services.UserServiceImpl;

@ExtendWith(SpringExtension.class)
public class TestUserService {
	
	@InjectMocks
	private UserServiceImpl userServiceImpl;
	
	@Mock
	private UserRepository userRepo;
	
	@Test
	public void deleteCustomerByMobileNo() {
		Customer c=new Customer();
	    c.setMobileNo("9704169622");
		
	     Mockito.when(userRepo.findByMobileNo("9704169622")).thenReturn(Optional.of(c).get());
		 assertEquals(1,userServiceImpl.deleteCustomerByMobileNo("9704169622").getMobileNo());
		
	}


	

}
