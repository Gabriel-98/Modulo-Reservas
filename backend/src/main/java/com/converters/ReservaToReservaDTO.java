package com.converters;

import org.modelmapper.AbstractConverter;

import com.reservas.dto.ReservaDTO;
import com.reservas.entity.Reserva;

public class ReservaToReservaDTO extends AbstractConverter<Reserva,ReservaDTO>{
	
	@Override
	protected ReservaDTO convert(Reserva source) {
		ReservaDTO destination = new ReservaDTO();
		destination.setIdReserva(source.getIdReserva());
		destination.setCedula(source.getUsuario().getCedula());
		destination.setIdHabitacion(source.getIdHabitacion());
		destination.setFechaLlegada(source.getFechaLlegada().toString());
		destination.setFechaSalida(source.getFechaSalida().toString());
		destination.setCosto(source.getCosto());
		destination.setCancelada(source.isCancelada());
		destination.setFechaCancelacion(source.getFechaCancelacion().toString());
		return destination;
	}

}
