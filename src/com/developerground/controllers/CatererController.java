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
import org.springframework.web.bind.annotation.SessionAttributes;

import com.developerground.entities.Caterer;
import com.developerground.entities.FoodItem;
import com.developerground.services.CatererService;

@Controller
@RequestMapping("/caterer")
@SessionAttributes({"name","email","id"})
public class CatererController {
	
		@Autowired
		private CatererService catererService;
		
		@PostMapping("/signUp")
		public String signUp(@ModelAttribute("caterer")Caterer caterer, Model model) {

			String status = catererService.signUp(caterer);
			model.addAttribute("catererStatus", status);
			if( status.equalsIgnoreCase("duplicateEntry")) {
				return "catererSignUp";
			}
			return "redirect:../common/welcome";
		}
		
		@GetMapping("/addFood")
		public String addFood(Model model) {
			model.addAttribute("foodItem", new FoodItem());
			return "addFoodItem";
		}
		
		@PostMapping("/addFoodItem")
		public String addFoodItem(@ModelAttribute("foodItem")FoodItem foodItem, @ModelAttribute("email")String email, Model model) {
			String additionStatus = catererService.addFoodItem(foodItem,email);
			model.addAttribute("additionStatus", additionStatus);
			if (additionStatus.equalsIgnoreCase("success")) {
				return "redirect:viewFoodItems";
			}
			return "addFood";
		}
		
		@GetMapping("/viewFoodItems")
		public String viewFoodItems(@ModelAttribute("id")String catererID,Model model) {
			List<FoodItem> foodItems = catererService.viewFoodItems(catererID);
			model.addAttribute("foodItems", foodItems);
			model.addAttribute("noFoodItems",foodItems.isEmpty());
			return "viewFoodItems";
		}
}
