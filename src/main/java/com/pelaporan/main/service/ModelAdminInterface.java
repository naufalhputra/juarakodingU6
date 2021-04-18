package com.pelaporan.main.service;

import java.util.List;

import com.pelaporan.main.entity.Admin;


public interface ModelAdminInterface {
	
	public List<Admin> getAllAdmin();

	public Admin addAdmin(Admin admin);
	public Admin getAdminById(String id);
	public void deleteAdmin(String id);


}
