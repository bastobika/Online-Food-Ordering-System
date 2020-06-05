package com.developerground.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.developerground.entities.Caterer;
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
			return "login";
		}
}
