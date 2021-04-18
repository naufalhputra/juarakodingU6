package com.pelaporan.main.repository;


import org.springframework.data.repository.CrudRepository;

import com.pelaporan.main.entity.Pelapor;

public interface PelaporRepo extends CrudRepository<Pelapor, Long> {
	public Pelapor findByEmail(String email);
	public Pelapor findByIdPelapor(Long id);

}
