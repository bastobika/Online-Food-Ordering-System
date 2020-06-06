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

import com.developerground.entities.Admin;
import com.developerground.entities.Caterer;
import com.developerground.services.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
		
	@Autowired
	private AdminService adminService;
	
	@RequestMapping("/login")
	public String adminLogin(Model model) {
		model.addAttribute("admin", new Admin());
		model.addAttribute("loginFlag","unchecked");
		return "adminLogin";
	}
	
	@PostMapping("/authenticate")
	public String authentication(@ModelAttribute("admin")Admin admin,Model model) {
		String loginFlag = "false";
		if(adminService.authenticate(admin.getName(),admin.getPassword())) {
			loginFlag = "true";
			return "adminHome";
		}
		model.addAttribute("loginFlag",loginFlag);
		return "adminLogin";
	}
	
	@GetMapping("/requests")
	public String getRequests(Model model) {
		List<Caterer> catererRequests = adminService.getRequests();
		model.addAttribute("catererRequests", catererRequests);
		model.addAttribute("noRequests",catererRequests.isEmpty());
		return "adminHome";
	}
	
	@GetMapping("/updateStatus")
	public String updateStatus(@RequestParam("catererID")String catererID,@RequestParam("status")String status) {
		adminService.updateStatus(Integer.parseInt(catererID),status);
		return "redirect:requests";       //redirects to requests GetMapping, that is it automatically calls getRequests
	}
}
