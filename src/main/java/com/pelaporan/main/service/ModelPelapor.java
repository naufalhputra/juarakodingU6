package com.pelaporan.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pelaporan.main.entity.Pelapor;
import com.pelaporan.main.repository.PelaporRepo;


@Service
public class ModelPelapor implements ModelPelaporInterface{
	
	@Autowired
	PelaporRepo pelaporRepo;

	@Override
	public List<Pelapor> getAllPelapor() {
		// TODO Auto-generated method stub
		return (List<Pelapor>) this.pelaporRepo.findAll();
	}
	
	@Override
	public Pelapor addPelapor(Pelapor pelapor) {
		// TODO Auto-generated method stub
		
		return  this.pelaporRepo.save(pelapor);
	
	}

	@Override
	public Pelapor getPelapornById(String id) {
		// TODO Auto-generated method stub
		
		return this.pelaporRepo.findById(Long.parseLong(id)).get();
		
		
	}
	
	@Override
	public void deletePelapor(String id) {
		// TODO Auto-generated method stub
		this.pelaporRepo.deleteById(Long.parseLong(id));
		
	}


}
