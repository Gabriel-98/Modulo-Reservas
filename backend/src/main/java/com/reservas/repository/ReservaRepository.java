package com.reservas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reservas.entity.Habitacion;
import com.reservas.entity.Huesped;
import com.reservas.entity.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva,Integer>{
	
	List<Reserva> findAllByHuesped(Huesped huesped);
	
	List<Reserva> findAllByIdHabitacion(Habitacion habitacion);
}
