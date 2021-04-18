package com.pelaporan.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.pelaporan.main.entity.Admin;
import com.pelaporan.main.service.ModelAdmin;


@Controller
public class AdminPage {

	@Autowired
	ModelAdmin modelAdmin;
	
	@GetMapping("/admin/view")
	public String viewIndexAdminUser(Model model) {
		
		model.addAttribute("listAdmin",modelAdmin.getAllAdmin());
		model.addAttribute("active",1);
		
		return "view_admin";
	}
	
	
	@GetMapping("/admin/add")
	public String viewAddAdmin(Model model) {
		
		// buat penampung data adminuser di halaman htmlnya
		model.addAttribute("admin",new Admin());
		
		return "add_admin";
	}

	@PostMapping("/admin/view")
	  public String addAdminUser(@ModelAttribute Admin admin, Model model) {
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String plainPassword = admin.getPassword();
		String encodedPassword = passwordEncoder.encode(plainPassword);
        admin.setPassword(encodedPassword);		
		this.modelAdmin.addAdmin(admin);
		model.addAttribute("listAdmin",modelAdmin.getAllAdmin());
		
		
		return "redirect:/admin/view";
	}
	
	@GetMapping("/admin/update/{id}")
	public String viewUpdateAdmin(@PathVariable String id, Model model) {
		
		Admin admin = modelAdmin.getAdminById(id);
		// buat penampung data adminuser di halaman htmlnya
		model.addAttribute("admin",admin);
		
		return "add_admin";
	}
	
	@GetMapping("/admin/delete/{id}")
	public String deleteAdmin(@PathVariable String id, Model model) {
		
		this.modelAdmin.deleteAdmin(id);
		model.addAttribute("listAdmin",modelAdmin.getAllAdmin());
		
		
		return "redirect:/admin/view";
	}

}
