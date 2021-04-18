package com.pelaporan.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomePage {
	
	
	
	@GetMapping("/index/view")
	public String viewHomePage(Model model) {
		
		model.addAttribute("active",0);

		return "index";
		
	}
	
	@GetMapping("/login")
	public String loginPage(Model model) {
		

		return "login";
		
	}
	
}
