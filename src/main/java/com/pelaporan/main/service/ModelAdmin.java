package com.pelaporan.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pelaporan.main.entity.Admin;
import com.pelaporan.main.repository.AdminRepo;


@Service
public class ModelAdmin  implements ModelAdminInterface{
	
	@Autowired
	AdminRepo adminRepo;

	public List<Admin> getAllAdmin() {
		// TODO Auto-generated method stub
		return (List<Admin>) this.adminRepo.findAll();
	}
	

	@Override
	public Admin addAdmin(Admin admin) {
		// TODO Auto-generated method stub
		
		return  this.adminRepo.save(admin);
	
	}

	@Override
	public Admin getAdminById(String id) {
		// TODO Auto-generated method stub
		
		return this.adminRepo.findById(Long.parseLong(id)).get();
		
		
	}

	@Override
	public void deleteAdmin(String id) {
		// TODO Auto-generated method stub
		this.adminRepo.deleteById(Long.parseLong(id));
		
	}



}