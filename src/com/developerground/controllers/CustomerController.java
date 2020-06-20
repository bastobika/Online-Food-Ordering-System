package com.developerground.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import com.developerground.entities.Order;
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
	public String viewCart(@ModelAttribute("id")String customerID,@ModelAttribute("placedOrder")String placedOrder, Model model) {
		List<CartItem> cartItems = customerService.viewCart(customerID);
		model.addAttribute("cartItems",cartItems);
		int sum = 0;
		for (CartItem cartItem : cartItems) {
			sum += cartItem.getFoodItem().getPrice() * cartItem.getUnits();
		}
		model.addAttribute("orderTotal",sum);
		model.addAttribute("noCartItems", cartItems.isEmpty());
		model.addAttribute("placedOrder", placedOrder);
		return "viewUserCart";
	}
	
	@PostMapping("/placeOrder")
	public String placeOrder(@ModelAttribute("id")String customerID,Model model) {
		if( !customerService.placeOrder(customerID)) {
			model.addAttribute("placedOrder", "notPlaced");
			return "redirect:viewCart";
		}
		else {
			model.addAttribute("placedOrder", "placed");
			return "redirect:viewOrders";
		}	
	}
	
	@GetMapping("/viewOrders")
	public String viewOrders(@ModelAttribute("id")String customerID, @ModelAttribute("placedOrder")String placedOrder,Model model) {
			List<Order> orders = customerService.viewOrders(customerID);
			model.addAttribute("placedOrder", placedOrder);
			model.addAttribute("orders",orders);
			model.addAttribute("noOrders", orders.isEmpty());
			return "viewCustomerOrders";
	}	
	
	@PostMapping("/deleteCartItem")
	public String deleteCartItem(@RequestParam("CartItemID")String cartItemID) {
		customerService.deleteCartItem(cartItemID);
		return "redirect:viewCart";
	}
	
	@GetMapping("/customerDetails")
	public String updateInfo(@ModelAttribute("id")String customerID,@ModelAttribute("updateStatus")String updateStatus,Model model) {
		model.addAttribute("updateStatus", updateStatus);
		model.addAttribute("customer",customerService.getCustomer(customerID));
		return "viewCustomer";
	}
	
	@PostMapping("/updateCustomerInfo")
	public String updateCustomerInfo(@ModelAttribute("customer")Customer customer,Model model) {
		customerService.updateCustomerInfo(customer);
		model.addAttribute("updateStatus", "success");
		return "redirect:customerDetails";
	}
	
	@GetMapping("/deleteCustomer")
	public String deleteCaterer(@ModelAttribute("email")String email) {
		customerService.deleteCustomer(email);
		return "redirect:../common/welcome";
	}
	
	@PostMapping("/rateOrder")
	public String rateOrder(@ModelAttribute("orderID")String orderID,Model model) {
		model.addAttribute("order", customerService.getOrder(orderID));	
		return "ratingPage";
	}
	
	@PostMapping("/submitRating")
	public String rateFoodItem(HttpServletRequest request, Model model) {
		String[] foodItemRatings = request.getParameterValues("foodItemRating");
		String catererRating = request.getParameter("catererRating");
		String[] foodItemIDs = request.getParameterValues("foodItemID");
		String orderID = request.getParameter("orderID");
		customerService.submitRating(foodItemRatings,foodItemIDs,catererRating,orderID);
		model.addAttribute("ratingStatus", "success");
		return "customerHome";
	}
	
}
