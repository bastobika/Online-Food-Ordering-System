package com.developerground.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.developerground.entities.Caterer;
import com.developerground.entities.FoodItem;
import com.developerground.services.CatererService;

@Controller
@RequestMapping("/caterer")
public class CatererController {
	
		@Autowired
		private CatererService catererService;
		
		@PostMapping("/signUp")
		public String signUp(@ModelAttribute("caterer")Caterer caterer, Model model) {

			String status = catererService.signUp(caterer);
			model.addAttribute("status", status);
			if( status.equalsIgnoreCase("duplicateEntry")) {
				return "catererSignUp";
			}
			return "welcome";
		}
		
		@GetMapping("/addFood")
		public String addFood(Model model) {
			model.addAttribute("foodItem", new FoodItem());
			return "addFoodItem";
		}
		
		@PostMapping("/addFoodItem")
		public String addFoodItem(@ModelAttribute("foodItem")FoodItem foodItem, @RequestParam("email")String email, Model model) {
			System.out.println(email);
			String additionStatus = catererService.addFoodItem(foodItem,email);
			model.addAttribute("additionStatus", additionStatus);
			if (additionStatus.equalsIgnoreCase("success")) {
				return "viewFoodItems";
			}
			return "addFood";
		}
		
		@PostMapping("viewFoodItems")
		public String viewFoodItems(Model model) {
			List<FoodItem> foodItems = catererService.viewFoodItems();
			model.addAttribute("foodItems", foodItems);
			model.addAttribute("noFoodItems",foodItems.isEmpty());
			return "viewFoodItems";
		}
}
