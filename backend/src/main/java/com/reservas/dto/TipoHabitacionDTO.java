package com.reservas.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TipoHabitacionDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String idTipoHabitacion;
	private String descripcion;
	private int maxOcupantes;
	private double costoBase;
}
