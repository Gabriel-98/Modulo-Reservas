package com.reservas.service;

import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import com.reservas.dto.ReservaDTO;
import com.reservas.entity.Reserva;
import com.reservas.repository.ReservaRepository;
import com.reservas.repository.UsuarioRepository;

@Service
public class ReservaService {
	
	@Autowired
	ReservaRepository reservaRepository;
	
	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	ModelMapper modelMapper;
	
	public String getLocalDateTimeNow() {
	//	String fecha = LocalDateTime.now(Clock.systemUTC()).format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
	//	System.out.println(fecha);
	//	return LocalDateTime.parse(fecha, DateTimeFormatter.ISO_LOCAL_DATE).toString();
			
	//	LocalDateTime ldt = LocalDateTime.now(Clock.systemUTC());
//		return ldt.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
//		return LocalDate(LocalDateTime.now().toString();
		return LocalDateTime.now(Clock.systemUTC()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
	//	return LocalDateTime.now(Clock.systemUTC()).format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);	
	}
	
	public ReservaDTO reservaToReservaDTO(Reserva reserva) {
		ReservaDTO reservaDTO = modelMapper.map(reserva, ReservaDTO.class);
		reservaDTO.setCedula(reserva.getUsuario().getCedula());
		return reservaDTO;
	}
	
	public Long differenceInMilliseconds(LocalDateTime fecha1, LocalDateTime fecha2) {
		Timestamp f1, f2;
		f1 = Timestamp.valueOf(fecha1);
		f2 = Timestamp.valueOf(fecha2);
		return f1.getTime() - f2.getTime();
	}
	
	public void imprimirReservaDTO(ReservaDTO reserva) {
		System.out.println("ReservaDTO");
	/*	System.out.println(reserva);
		System.out.println(reserva.toString());*/
		System.out.print(reserva.getIdReserva() + " ");
		System.out.print(reserva.getCedula() + " ");
		System.out.print(reserva.getIdHabitacion() + " ");
		System.out.print(reserva.getFechaLlegada() + " ");
		System.out.print(reserva.getFechaSalida() + " ");
		System.out.print(reserva.getCosto() + " ");
		System.out.print(reserva.isCancelada() + " ");
		System.out.print(reserva.getFechaCancelacion() + " ");
		System.out.print(reserva.getFechaCreacion() + " ");
		System.out.println();
		System.out.println();
	}
	
	public void imprimirReserva(Reserva reserva) {
		System.out.println("Reserva");
		System.out.print(reserva.getIdReserva() + " ");
		System.out.print(reserva.getUsuario().getCedula() + " ");
		System.out.print(reserva.getIdHabitacion() + " ");
		System.out.print(reserva.getFechaLlegada() + " ");
		System.out.print(reserva.getFechaSalida() + " ");
		System.out.print(reserva.getCosto() + " ");
		System.out.print(reserva.isCancelada() + " ");
		System.out.print(reserva.getFechaCancelacion() + " ");
		System.out.print(reserva.getFechaCreacion() + " ");
		System.out.println();
		System.out.println();
	}
	
	public ReservaDTO crear(ReservaDTO reservaDTO){
		imprimirReservaDTO(reservaDTO);
		reservaDTO.setFechaCreacion(getLocalDateTimeNow());
		Reserva reserva = modelMapper.map(reservaDTO, Reserva.class);
		reserva.setUsuario(usuarioRepository.findById(reservaDTO.getCedula()).get());
		Reserva reservaRespuesta = reservaRepository.save(reserva);
		ReservaDTO reservaRespuestaDTO = modelMapper.map(reservaRespuesta, ReservaDTO.class);
		reservaRespuestaDTO.setCedula(reservaRespuesta.getUsuario().getCedula());
		return reservaRespuestaDTO;
	}
	
	public ReservaDTO cancelar(int idReserva){
		Reserva reserva = reservaRepository.findById(idReserva).get();
		reserva.setCancelada(true);
		reserva.setFechaCancelacion(LocalDateTime.parse(getLocalDateTimeNow()));
		Reserva reservaRespuesta = reservaRepository.save(reserva);
		//ReservaDTO reservaRespuestaDTO = modelMapper.map(reservaRespuesta, ReservaDTO.class);
		//reservaRespuestaDTO.setCedula(reservaRespuesta.getUsuario().getCedula());
		ReservaDTO reservaRespuestaDTO = reservaToReservaDTO(reservaRespuesta);
		return reservaRespuestaDTO;
	}
	
/*	public ReservaDTO modificar(int idReserva, String fechaLlegada, String fechaSalida) {
		long milisecondsDifference = differenceInMilliseconds(LocalDateTime.parse(fechaLlegada), LocalDateTime.parse(fechaSalida));
	}*/
	
	public List<ReservaDTO> listar(){
		List<ReservaDTO> reservasDTO = new ArrayList<ReservaDTO>();
		List<Reserva> reservas = reservaRepository.findAll();
		imprimirReserva(reservas.get(0));
		ListIterator<Reserva> iterator = reservas.listIterator();
		while(true){
			reservasDTO.add(modelMapper.map(iterator.next(), ReservaDTO.class));
			if(!iterator.hasNext())
			break;
		}
		imprimirReservaDTO(reservasDTO.get(0));
		return reservasDTO;
	}
	
	/*public ReservaDTO consultar(Integer id) {
		Reserva reserva = reservaRepository.findByIdReserva(id);
		return modelMapper.map(reserva, ReservaDTO.class);
	}*/
	
/*	public ReservaDTO modificar(Integer id, String fechaLlegada, String fechaSalida) {
		
		reserva
		
	}*/

}
