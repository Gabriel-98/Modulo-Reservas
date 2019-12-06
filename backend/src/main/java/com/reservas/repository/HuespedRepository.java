package com.reservas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reservas.entity.Huesped;

public interface HuespedRepository extends JpaRepository<Huesped,String>{
	
}
