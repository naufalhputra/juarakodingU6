package com.pelaporan.main.service;

import java.util.List;

import com.pelaporan.main.entity.Pelapor;

public interface ModelPelaporInterface {
	
	public List<Pelapor> getAllPelapor();

	public Pelapor addPelapor(Pelapor pelapor);
	public Pelapor getPelapornById(String id);
	public void deletePelapor(String id);


}
