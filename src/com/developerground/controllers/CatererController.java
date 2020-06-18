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
import com.developerground.entities.Order;
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
		
		@PostMapping("/updateFood")
		public String updateFood(@RequestParam("foodItemID")String foodItemID,Model model) 
		{
			FoodItem foodItem = catererService.updateFood(foodItemID);
			model.addAttribute("foodItem", foodItem);
			return "updateFoodItem";
		}
		
		@PostMapping("/updateFoodItem")
		public String updateFoodItem(@ModelAttribute("foodItem")FoodItem foodItem, @ModelAttribute("email")String email, Model model) {
			String updateStatus = catererService.updateFoodItem(foodItem,email);
			model.addAttribute("updateStatus", updateStatus);
			return "redirect:viewFoodItems";
		}
		
		@PostMapping("/deleteFood")
		public String deleteFood(@RequestParam("foodItemID")String foodItemID,Model model) 
		{
			catererService.deleteFood(foodItemID);
			model.addAttribute("deleteStatus", "success");
			return "redirect:viewFoodItems";
		}
		
		@GetMapping("/viewFoodItems")
		public String viewFoodItems(@ModelAttribute("id")String catererID,Model model) {
			List<FoodItem> foodItems = catererService.viewFoodItems(catererID);
			model.addAttribute("foodItems", foodItems);
			model.addAttribute("noFoodItems",foodItems.isEmpty());
			return "viewFoodItem";
		}
		
		@GetMapping("/catererDetails")
		public String updateInfo(@ModelAttribute("id")String catererID,@ModelAttribute("updateStatus")String updateStatus,Model model) {
			model.addAttribute("updateStatus", updateStatus);
			model.addAttribute("caterer",catererService.getCaterer(catererID));
			return "viewCaterer";
		}
		
		@PostMapping("/updateCatererInfo")
		public String updateCatererInfo(@ModelAttribute("caterer")Caterer caterer,Model model) {
			catererService.updateCatererInfo(caterer);
			model.addAttribute("updateStatus", "success");
			return "redirect:catererDetails";
		}
		
		@GetMapping("/deleteCaterer")
		public String deleteCaterer(@ModelAttribute("email")String email) {
			catererService.deleteCaterer(email);
			return "redirect:../common/welcome";
		}
		
		@GetMapping("/viewOrders")
		public String viewOrders(@ModelAttribute("id")String customerID, @ModelAttribute("orderUpdated")String orderUpdated,Model model) {
				List<Order> orders = catererService.viewOrders(customerID);
				model.addAttribute("orders",orders);
				model.addAttribute("noOrders", orders.isEmpty());
				model.addAttribute("orderUpdated",orderUpdated);
				return "viewCatererOrders";
		}	
		
		@PostMapping("/updateStatus")
		public String updateOrderStatus(@RequestParam("orderID")String orderID,Model model){
			catererService.updateOrderStatus(orderID);
			model.addAttribute("orderUpdated","updated");
			return "redirect:viewOrders";
		}
		
}
