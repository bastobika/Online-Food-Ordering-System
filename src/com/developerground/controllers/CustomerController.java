package com.developerground.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.developerground.entities.Customer;
import com.developerground.services.CustomerService;

@Controller
@RequestMapping("/customer")
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
}
