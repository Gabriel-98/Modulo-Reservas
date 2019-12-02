package com.reservas.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
//import javax.persistence.Entity;
import java.io.Serializable;


//import javax.persistence.Entity;

//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//@SuppressWarnings("unused")

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReservaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idReserva;
	private String cedula;
	private int idHabitacion;
	private String fechaLlegada;
	private String fechaSalida;
	private double costo;
	private boolean cancelada;
	private String fechaCancelacion;
	private String fechaCreacion;
/*	private String nombre;
	private String apellidos;
	private String email;
	private String telefono;
	private String codigo;*/
}
