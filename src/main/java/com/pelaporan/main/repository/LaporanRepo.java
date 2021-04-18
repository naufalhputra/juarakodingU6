package com.pelaporan.main.repository;

import org.springframework.data.repository.CrudRepository;

import com.pelaporan.main.entity.Laporan;

public interface LaporanRepo extends CrudRepository<Laporan, Long>{
	}
