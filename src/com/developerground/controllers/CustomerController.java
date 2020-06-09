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

import com.developerground.entities.Customer;
import com.developerground.entities.FoodItem;
import com.developerground.services.CustomerService;

@Controller
@RequestMapping("/customer")
@SessionAttributes({"name","email","preference","cart"})
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
	public String orderPage( @ModelAttribute("preference")String preference,@ModelAttribute("cart")HashMap<FoodItem,Integer> cart,Model model) {
		
		System.out.println(cart.getClass());
		List<Object[]> foodItems = customerService.viewFood(preference);
		for(int j=0;j<foodItems.size();j++) {
			Object temp = foodItems.get(j)[1];
			if (cart.containsKey(temp)) {
				foodItems.remove(temp);
		}
		}
		model.addAttribute("foodItems", foodItems);
		model.addAttribute("noFoodItems", foodItems.isEmpty());
		return "viewFoodForOrder";
	}
	
	@PostMapping("/addToCart")
	public String addToCart( @ModelAttribute("cart")HashMap<FoodItem,Integer> cart,@RequestParam("units")String units,@RequestParam("foodItem")FoodItem foodItem) {

		cart.put(foodItem, Integer.parseInt(units));
		return "redirect:orderFood";
	}
	
}
