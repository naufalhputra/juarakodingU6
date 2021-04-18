package com.pelaporan.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.pelaporan.main.entity.Pelapor;
import com.pelaporan.main.service.ModelPelapor;

@Controller
public class PelaporPage {


	@Autowired
	ModelPelapor modelPelapor;
	
	@GetMapping("/pelapor/view")
	public String viewIndexpelapor(Model model) {
		
		model.addAttribute("listPelapor",modelPelapor.getAllPelapor());
		model.addAttribute("active",2);
		
		return "view_pelapor";
	}


	@GetMapping("/pelapor/add")
	public String viewAddPelapor(Model model) {
		
		model.addAttribute("pelapor",new Pelapor());
		
		return "add_pelapor";
	}

	@PostMapping("/pelapor/view")
	  public String addPelapor(@ModelAttribute Pelapor pelapor, Model model) {
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String plainPassword = pelapor.getPassword();
		String encodedPassword = passwordEncoder.encode(plainPassword);
        pelapor.setPassword(encodedPassword);		
		
        this.modelPelapor.addPelapor(pelapor);
		model.addAttribute("listPelapor",modelPelapor.getAllPelapor());
		
		
		return "redirect:/pelapor/view";
	}
	
	@GetMapping("/pelapor/update/{id}")
	public String viewUpdatePelapor(@PathVariable String id, Model model) {
		
		Pelapor pelapor = modelPelapor.getPelapornById(id);
		model.addAttribute("Pelapor", pelapor);
		
		return "add_pelapor";
	}
	
	@GetMapping("/pelapor/delete/{id}")
	public String deletePelapor(@PathVariable String id, Model model) {
		
		this.modelPelapor.deletePelapor(id);
		model.addAttribute("listPelapor",modelPelapor.getAllPelapor());
		
		
		return "redirect:/pelapor/view";
	}

}
