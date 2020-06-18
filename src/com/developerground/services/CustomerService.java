package com.developerground.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.developerground.daos.CustomerDao;
import com.developerground.entities.CartItem;
import com.developerground.entities.Customer;
import com.developerground.entities.Order;

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

	public boolean placeOrder(String customerID) {
		List<CartItem> cartItems = viewCart(customerID);
		int firstCatererID = cartItems.get(0).getFoodItem().getCaterer().getID();
		for(CartItem cartItem : cartItems) {
			if(cartItem.getFoodItem().getCaterer().getID() != firstCatererID)
				return false;
		}
		return customerDao.placeOrder(cartItems);
	}

	public List<Order> viewOrders(String customerID) {
		return customerDao.viewOrders(customerID);
	}

	public void deleteCartItem(String cartItemID) {
		customerDao.deleteCartItem(Integer.parseInt(cartItemID));
	}

	public void deleteCustomer(String email) {
		customerDao.deleteCustomer(email);
	}

	public void updateCustomerInfo(Customer customer) {
		customerDao.updateCustomerInfo(customer);
	}

	public Object getCustomer(String customerID) {
		return customerDao.getCustomer(Integer.parseInt(customerID));
	}
}
