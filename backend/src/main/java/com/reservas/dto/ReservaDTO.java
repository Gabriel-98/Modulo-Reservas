package com.reservas.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReservaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idReserva;
	private String cedula;
	private String idHabitacion;
	private String fechaLlegada;
	private String fechaSalida;
	private double costo;
	private boolean cancelada;
	private String fechaCancelacion;
	private String fechaCreacion;
}