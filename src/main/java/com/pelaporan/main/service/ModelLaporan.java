package com.pelaporan.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pelaporan.main.entity.Laporan;
import com.pelaporan.main.repository.LaporanRepo;

@Service
public class ModelLaporan  implements ModelLaporanInterface{

	@Autowired
	LaporanRepo laporanRepo;
	
	@Override
	public List<Laporan> getAllLaporan() {
		// TODO Auto-generated method stub
		return (List<Laporan>) this.laporanRepo.findAll();
	}


	@Override
	public Laporan addLaporan(Laporan laporan) {
		// TODO Auto-generated method stub
		
		return  this.laporanRepo.save(laporan);
	
	}

	@Override
	public Laporan getLaporanById(String id) {

		return this.laporanRepo.findById(Long.parseLong(id)).get();		
	}

	@Override
	public void deleteLaporan(String id) {

		this.laporanRepo.deleteById(Long.parseLong(id));
		
	}
	
	
}