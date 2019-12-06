package com.reservas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;

import com.reservas.entity.Habitacion;
import com.reservas.entity.TipoHabitacion;


public interface HabitacionRepository extends JpaRepository<Habitacion, String> {

	//@Query(value="SELECT x FROM Habitacion x WHERE x.id_habitacion = idTipoHabitacion")
	List<Habitacion> findAllByIdTipoHabitacion(TipoHabitacion idTipoHabitacion);
}
