package com.developerground.controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.developerground.entities.CartItem;
import com.developerground.entities.Customer;
import com.developerground.entities.FoodItem;
import com.developerground.services.CustomerService;

@Controller
@RequestMapping("/customer")
@SessionAttributes({"name","email","preference","id"})
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/signUp")
	public String signUp(@ModelAttribute("customer")Customer customer, Model model) {

		String status = customerService.signUp(customer);
		model.addAttribute("customerStatus", status);
		if( status.equalsIgnoreCase("duplicateEntry")) {
			return "customerSignUp";
		}
		return "redirect:../common/welcome";
	}
	
	@GetMapping("/orderFood")
	public String orderPage( @ModelAttribute("preference")String preference,@ModelAttribute("id")String customerID, @ModelAttribute("addToCartFlag")String addToCartFlag, Model model) {
		
		List<Object[]> foodItems = customerService.viewFood(preference,customerID);
		model.addAttribute("foodItems", foodItems);
		model.addAttribute("noFoodItems", foodItems.isEmpty());
		model.addAttribute("addToCartFlag", addToCartFlag);
		return "viewFoodForOrder";
	}
	
	@PostMapping("/addToCart")
	public String addToCart(@ModelAttribute("id")String customerID, @RequestParam("units")String units,@RequestParam("foodID")String foodID,Model model) {

		customerService.addToCart(foodID,customerID,units);
		model.addAttribute("addToCartFlag","added");
		return "redirect:orderFood";
	}
	
	@GetMapping("/viewCart")
	public String viewCart(@ModelAttribute("id")String customerID,Model model) {
		List<CartItem> cartItems = customerService.viewCart(customerID);
		model.addAttribute("cartItems",cartItems);
		model.addAttribute("noCartItems", cartItems.isEmpty());
		return "viewCart";
	}
	
	@PostMapping("/placeOrder")
	public String placeOrder(@ModelAttribute("id")String customerID,Model model) {
		return "viewOrders";
	}
	
}
