package com.pelaporan.main.repository;

import org.springframework.data.repository.CrudRepository;

import com.pelaporan.main.entity.Admin;


public interface AdminRepo extends CrudRepository<Admin, Long> {
	public Admin findByUsername(String username);
}
