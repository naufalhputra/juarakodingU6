package com.pelaporan.main.service;

import java.util.List;

import com.pelaporan.main.entity.Laporan;


public interface ModelLaporanInterface {


	public List<Laporan> getAllLaporan();
	
	
	public Laporan addLaporan(Laporan laporan);
	public Laporan getLaporanById(String id);	
	public void deleteLaporan(String id);
	

}
