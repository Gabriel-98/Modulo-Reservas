package com.reservas.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UsuarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String cedula;
	private String nombre;
	private String apellidos;
	private String email;
	private String telefono;
	private String codigo;
}
