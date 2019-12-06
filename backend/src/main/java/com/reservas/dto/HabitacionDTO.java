package com.reservas.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class HabitacionDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String idHabitacion;
	private String idTipoHabitacion;
}
