package com.developerground.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.developerground.entities.Caterer;

@Controller
@RequestMapping("/common")
public class CommonController {

		@RequestMapping("/signUpOptions")
		public String signUpOptions() {
			return "signUpOptions";
		}
		
		@PostMapping("/signUp")
		public String signUp(@RequestParam("userType")String userType,Model model) {
			
			if( userType.equalsIgnoreCase("Caterer") ) {
				model.addAttribute("caterer", new Caterer());
				return "catererSignUp";
			}
			return "customerSignUp";
		}
}
