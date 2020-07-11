package com.developerground.controllers;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.developerground.entities.Caterer;
import com.developerground.entities.Customer;
import com.developerground.services.CommonService;

@Controller
@RequestMapping("/common")
@SessionAttributes({"name","email","preference","id"})
public class CommonController {
	
		@Autowired
		private CommonService commonService;

		@RequestMapping("/signUpOptions")
		public String signUpOptions() {
			return "options";
		}
		
		@RequestMapping("/signUp")
		public String signUp(@RequestParam("userType")String userType,Model model,@ModelAttribute("status")String status) {
			model.addAttribute("status", status);
			if( userType.equalsIgnoreCase("Caterer") ) {
				model.addAttribute("caterer", new Caterer());
				return "catererSignUp";
			}
			model.addAttribute("customer", new Customer());
			return "customerSignUp";
		}
		
		@GetMapping("/welcome")
		public String Welcome(@ModelAttribute("status")String customerStatus, @ModelAttribute("status")String catererStatus, Model model) {
			model.addAttribute("status", customerStatus);
			model.addAttribute("status", catererStatus);
			return "welcome";
		}
		
		@PostMapping("/authenticate")
		public String authenticate(@RequestParam("email")String email , @RequestParam("password")String password,Model model) {
			Map<String,String> map = commonService.authenticate(email, password);
			String loginFlag = map.get("loginFlag");
			model.addAttribute("loginFlag", loginFlag);
			model.addAttribute("email", email);
			if ( loginFlag.equalsIgnoreCase("success")) {
				model.addAttribute("name", map.get("name"));
				model.addAttribute("id", map.get("id"));
				if(map.get("userType").equalsIgnoreCase("Caterer")) {
					String status = map.get("status");
					model.addAttribute("status", status);
					if (status.equalsIgnoreCase("Pending") || status.equalsIgnoreCase("Denied")) {
						return "welcome";
					}
					return "catererHome";
				}else if(map.get("userType").equalsIgnoreCase("Customer")) {
					model.addAttribute("preference", map.get("preference"));
					return "customerHome";
				}
			} 
			return "welcome";
		}
		
		@GetMapping("/logout")
		public String logout(HttpSession session, SessionStatus status) {
			/*Mark the current handler's session processing as complete, allowing for cleanup of 
			  session attributes.*/
			status.setComplete();
			/* Invalidates this session then unbinds any objects bound to it. */
			session.invalidate();
			return "welcome";
		}
		
}
