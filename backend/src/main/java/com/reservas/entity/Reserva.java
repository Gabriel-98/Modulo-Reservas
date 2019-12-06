package com.reservas.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="reservas")
public class Reserva {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="id_reserva", nullable=false, updatable=false)
	private Integer idReserva;
	
	@ManyToOne
	@JoinColumn(name="cedula", nullable=false, referencedColumnName="cedula")
	private Huesped huesped;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_habitacion", referencedColumnName="id_habitacion")
	private Habitacion idHabitacion;
	
	@Column(name="fecha_llegada", nullable=false)
	@JsonFormat(pattern="yyyy/MM/dd")
	private LocalDate fechaLlegada;
	
	@Column(name="fecha_salida", nullable=false)
	@JsonFormat(pattern="yyyy/MM/dd")
	private LocalDate fechaSalida;
	
	@Column(name="costo", nullable=false)
	private double costo;
	
	@Column(name="cancelada", nullable=false)
	private boolean cancelada;
	
	@Column(name="fecha_cancelacion")
	@JsonFormat(pattern="yyyy/MM/dd'T'HH:mm:ss")
	private LocalDateTime fechaCancelacion;
	
	@Column(name="fecha_creacion", nullable=false)
	@JsonFormat(pattern="yyyy/MM/dd'T'HH:mm:ss")
	private LocalDateTime fechaCreacion;
}
