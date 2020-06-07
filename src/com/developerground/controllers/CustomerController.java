package com.developerground.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.developerground.entities.Caterer;
import com.developerground.entities.Customer;
import com.developerground.services.CatererService;
import com.developerground.services.CustomerService;

@Controller
@RequestMapping("/customer")
@SessionAttributes({"name","email","preference"})
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
	public String orderPage( @ModelAttribute("preference")String preference,Model model) {

		List<Object> foodItems = customerService.orderFood(preference);
		model.addAttribute("foodItems", foodItems);
		model.addAttribute("noFoodItems", foodItems.isEmpty());
		return "viewCaterers";
	}
}
