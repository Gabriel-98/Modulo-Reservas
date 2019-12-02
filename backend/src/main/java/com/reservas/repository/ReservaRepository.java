package com.reservas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import com.reservas.entity.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva,Integer>{
//	List<Reserva> findByIdUsuario(Integer Usuario);
//	List<Reserva> findAllByFechaSalida();
}
