package com.reservas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="habitaciones")
public class Habitacion {
	
	@Id
	@Column(name="id_habitacion", nullable=false)
	private String idHabitacion;
	
	@ManyToOne
	@JoinColumn(name="id_tipo_habitacion", nullable=false)
	private TipoHabitacion idTipoHabitacion;
}
