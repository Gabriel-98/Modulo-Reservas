package com.reservas.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PeticionReservaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String idTipoHabitacion;
	private String fechaLlegada;
	private String fechaSalida;
	private String cedula;
	private String nombre;
	private String apellidos;
	private String email;
	private String telefono;
}
