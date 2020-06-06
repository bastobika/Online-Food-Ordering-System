package com.developerground.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.developerground.daos.CustomerDao;
import com.developerground.entities.Customer;

@Component
public class CustomerService {
		
	@Autowired
	private CustomerDao customerDao;
	
	public String signUp(Customer customer) {
		return customerDao.signUp(customer);
	}
}
