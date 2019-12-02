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
@Table(name="usuarios")
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cedula")
	private String cedula;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellidos")
	private String apellidos;
	
	@Column(name="email")
	private String email;
	
	@Column(name="telefono")
	private String telefono;
	
	@Column(name="codigo", nullable=false)
	private String codigo;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
	private List<Reserva> reservas;
	
}
