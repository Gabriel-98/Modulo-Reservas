package com.reservas.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Column;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;

@Data
@Entity
@Table(name="huespedes")
public class Huesped implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cedula", nullable=false, updatable=false)
	private String cedula;
	
	@Column(name="nombre", nullable=false)
	private String nombre;
	
	@Column(name="apellidos", nullable=false)
	private String apellidos;
	
	@Column(name="email", nullable=false)
	private String email;
	
	@Column(name="telefono", nullable=false)
	private String telefono;
	
	@Column(name="codigo", nullable=false)
	private String codigo;
	
	@Column(name="fecha_creacion", nullable=false)
	private String fechaCreacion;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "huesped")
	private List<Reserva> reservas;
	
}
