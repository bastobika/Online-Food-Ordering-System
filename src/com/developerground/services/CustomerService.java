package com.developerground.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.developerground.daos.CustomerDao;
import com.developerground.entities.CartItem;
import com.developerground.entities.Customer;

@Component
public class CustomerService {
		
	@Autowired
	private CustomerDao customerDao;
	
	public String signUp(Customer customer) {
		return customerDao.signUp(customer);
	}

	public List<Object[]> viewFood(String preference, String customerID) {
		return customerDao.viewFood(preference,customerID);
	}

	public void addToCart(String foodID, String customerID, String units) {
		customerDao.addToCart(Integer.parseInt(foodID),Integer.parseInt(customerID),Integer.parseInt(units));
	}

	public List<CartItem> viewCart(String customerID) {
		return customerDao.viewCart(Integer.parseInt(customerID));
	}
}
