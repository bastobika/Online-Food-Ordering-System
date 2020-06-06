package com.developerground.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.developerground.entities.Caterer;
import com.developerground.entities.Customer;
import com.developerground.services.CommonService;

@Controller
@RequestMapping("/common")
public class CommonController {
	
		@Autowired
		private CommonService commonService;

		@RequestMapping("/signUpOptions")
		public String signUpOptions() {
			return "options";
		}
		
		@PostMapping("/signUp")
		public String signUp(@RequestParam("userType")String userType,Model model) {
			if( userType.equalsIgnoreCase("Caterer") ) {
				model.addAttribute("caterer", new Caterer());
				return "catererSignUp";
			}
			model.addAttribute("customer", new Customer());
			return "customerSignUp";
		}
		
		@GetMapping("/welcome")
		public String Welcome(@ModelAttribute("customerStatus")String status,Model model) {
			model.addAttribute("customerStatus", status);
			return "welcome";
		}
		
		@PostMapping("/authenticate")
		public String authenticate(@RequestParam("email")String email , @RequestParam("password")String password,Model model) {
			Map<String,String> map = commonService.authenticate(email, password);
			String loginFlag = map.get("loginFlag");
			model.addAttribute("loginFlag", loginFlag);
			model.addAttribute("email", email);
			if ( loginFlag.equalsIgnoreCase("success")) {
				if(map.get("userType").equalsIgnoreCase("Caterer")) {
					String status = map.get("status");
					model.addAttribute("status", status);			
					model.addAttribute("catererName", map.get("name"));
					if (status.equalsIgnoreCase("Pending") || status.equalsIgnoreCase("Denied")) {
						return "welcome";
					}
					return "catererHome";
				}else if(map.get("userType").equalsIgnoreCase("Customer")) {
					model.addAttribute("customerName", map.get("name"));
					return "customerHome";
				}
			} 
			return "welcome";
		}
}
