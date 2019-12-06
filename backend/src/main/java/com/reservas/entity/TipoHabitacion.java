package com.reservas.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="tipos_habitacion")
public class TipoHabitacion {
	
	@Id
	@Column(name="id_tipo_habitacion", nullable=false)
	private String idTipoHabitacion;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="max_ocupantes", nullable=false)
	private int maxOcupantes;
	
	@Column(name="costo_base", nullable=false)
	private double costoBase;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="idTipoHabitacion")
	private List<Habitacion> habitaciones;
}
