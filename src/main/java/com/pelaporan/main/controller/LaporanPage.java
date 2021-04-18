package com.pelaporan.main.controller;

import java.awt.Button;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.pelaporan.main.entity.Laporan;
import com.pelaporan.main.repository.LaporanRepo;
import com.pelaporan.main.service.ModelLaporan;
import com.pelaporan.main.utility.FileUtility;

@Controller
public class LaporanPage {


	@Autowired
	ModelLaporan modelLaporan;

	@Autowired
	LaporanRepo laporanRepo;
	
	 private final String UPLOAD_DIR = "./src/main/resources/static/uploads/";
	 
	 @GetMapping("/laporan/view")
		public String viewIndelaporan(Model model) {
			model.addAttribute("listlaporan",modelLaporan.getAllLaporan());
			model.addAttribute("active",3);
			return "view_laporan";
		}

	 

		@GetMapping("/laporan/add")
		public String viewAddLaporan(Model model) {
			model.addAttribute("laporan",new Laporan());
			model.addAttribute("active",4);

			return "add_laporan";
		}
		
		@PostMapping("/laporan/view")
		public String addlaporan(@RequestParam(value = "file")MultipartFile file,@ModelAttribute Laporan laporan, Model model) throws IOException { {
			   String fileName = StringUtils.cleanPath(file.getOriginalFilename());
			  
		         
		        String uploadDir = "user-photos/" ;
		
		        FileUtility.saveFile(uploadDir, fileName, file);
		 
	          laporan.setGambar("/"+uploadDir + fileName);
	           this.modelLaporan.addLaporan(laporan);

			model.addAttribute("listlaporan",modelLaporan.getAllLaporan());
			
			return "redirect:/laporan/view";
		  }
		}
				
		@GetMapping("laporan/approve/{id}")
		public String viewApprove(@PathVariable String id, Model model) {

			Laporan laporan = modelLaporan.getLaporanById(id);
			model.addAttribute("laporan", laporan);
	        laporan.setStatus("Approve");
	        laporanRepo.save(laporan);

	      
			return "view_laporan";
		}


		@GetMapping("laporan/reject/{id}")
		public String viewReject(@PathVariable String id, Model model) {
			
			Laporan laporan = modelLaporan.getLaporanById(id);
			// buat penampung data adminuser di halaman htmlnya
			model.addAttribute("laporan", laporan);
	        laporan.setStatus("Reject");
	        laporanRepo.save(laporan);
	        
			return "view_laporan";
		}

		@GetMapping("/pertanyaan/delete/{id}")
		public String deleteLaporan(@PathVariable String id, Model model) {
			
			this.modelLaporan.deleteLaporan(id);
			
			
			return "redirect:/laporan/view";
		}
		
		
}
