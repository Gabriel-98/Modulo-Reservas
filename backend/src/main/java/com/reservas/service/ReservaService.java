package com.reservas.service;

import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.Vector;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.reservas.dto.HuespedDTO;
import com.reservas.dto.PeticionReservaDTO;
import com.reservas.dto.ReservaDTO;
import com.reservas.entity.Habitacion;
import com.reservas.entity.Huesped;
import com.reservas.entity.Reserva;
import com.reservas.entity.TipoHabitacion;
import com.reservas.repository.ReservaRepository;
import com.reservas.repository.TipoHabitacionRepository;
import com.reservas.repository.HabitacionRepository;
import com.reservas.repository.HuespedRepository;

@Service
public class ReservaService {
	
	@Autowired
	ReservaRepository reservaRepository;
	
	@Autowired
	HuespedRepository huespedRepository;
	
	@Autowired
	HabitacionRepository habitacionRepository;
	
	@Autowired
	TipoHabitacionRepository tipoHabitacionRepository;
	
	@Autowired
	HuespedService huespedService;
	
	@Autowired
	TipoHabitacionService tipoHabitacionService;
	
	@Autowired
	ModelMapper modelMapper;
	
	
	final int maxDias = 1000;
	Vector<Vector<Integer>> ocupado;
	
	
	
	
	public String getLocalDateTimeNow() {
		return LocalDateTime.now(Clock.systemUTC()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
	}
	
	public ReservaDTO reservaToReservaDTO(Reserva reserva) {
		ReservaDTO reservaDTO = modelMapper.map(reserva, ReservaDTO.class);
		reservaDTO.setCedula(reserva.getHuesped().getCedula());
		return reservaDTO;
	}
	
	public Long differenceInMilliseconds(LocalDateTime fecha1, LocalDateTime fecha2) {
		Timestamp f1, f2;
		f1 = Timestamp.valueOf(fecha1);
		f2 = Timestamp.valueOf(fecha2);
		return Math.abs(f1.getTime() - f2.getTime());
	}
		
	public void imprimirReservaDTO(ReservaDTO reservaDTO) {
		System.out.println("ReservaDTO");
	/*	System.out.println(reservaDTO);
		System.out.println(reservaDTO.toString());*/
		System.out.print(reservaDTO.getIdReserva() + " ");
		System.out.print(reservaDTO.getCedula() + " ");
		System.out.print(reservaDTO.getIdHabitacion() + " ");
		System.out.print(reservaDTO.getFechaLlegada() + " ");
		System.out.print(reservaDTO.getFechaSalida() + " ");
		System.out.print(reservaDTO.getCosto() + " ");
		System.out.print(reservaDTO.isCancelada() + " ");
		System.out.print(reservaDTO.getFechaCancelacion() + " ");
		System.out.print(reservaDTO.getFechaCreacion() + " ");
		System.out.println();
		System.out.println();
	}
	
	public void imprimirReserva(Reserva reserva) {
		/*System.out.println("Reserva");
		System.out.print(reserva.getIdReserva() + " ");
		System.out.print(reserva.getHuesped().getCedula() + " ");
		System.out.print(reserva.getIdHabitacion() + " ");
		System.out.print(reserva.getFechaLlegada() + " ");
		System.out.print(reserva.getFechaSalida() + " ");
		System.out.print(reserva.getCosto() + " ");
		System.out.print(reserva.isCancelada() + " ");
		System.out.print(reserva.getFechaCancelacion() + " ");
		System.out.print(reserva.getFechaCreacion() + " ");
		System.out.println();
		System.out.println();*/
	}
	
	// Servicios
	
	// (version ineficiente)
	public ReservaDTO reservar(PeticionReservaDTO peticionReservaDTO) throws Exception {
		System.out.println("reservar");
		// Pasar (PeticionReservaDTO) -> (HuespedDTO, ReservaDTO)
		ReservaDTO reservaDTO = new ReservaDTO();
		HuespedDTO huespedDTO = new HuespedDTO();
		huespedDTO.setCedula(peticionReservaDTO.getCedula());
		huespedDTO.setNombre(peticionReservaDTO.getNombre());
		huespedDTO.setApellidos(peticionReservaDTO.getApellidos());
		huespedDTO.setTelefono(peticionReservaDTO.getTelefono());
		huespedDTO.setEmail(peticionReservaDTO.getEmail());
		reservaDTO.setFechaLlegada(peticionReservaDTO.getFechaLlegada());
		reservaDTO.setFechaSalida(peticionReservaDTO.getFechaSalida());
		
		String idTipoHabitacion = peticionReservaDTO.getIdTipoHabitacion();
		
		if(!(tipoHabitacionService.encontrar(idTipoHabitacion)))
		throw new Exception("No existe ese tipo de habitacion");
		
		TipoHabitacion tipoHabitacion = tipoHabitacionRepository.findById(idTipoHabitacion).get();
		List<Habitacion> habitaciones = habitacionRepository.findAllByIdTipoHabitacion(tipoHabitacion);
		ListIterator<Habitacion> iterator = habitaciones.listIterator();
		Habitacion habitacion;

		boolean cond = false;
		while(true) {	
			if(iterator.hasNext()) {
				habitacion = iterator.next();
				List<Reserva> reservas = reservaRepository.findAllByIdHabitacion(habitacion);
				ListIterator<Reserva> iterator2 = reservas.listIterator();
					
				cond = true;
				while(true) {
					if(iterator2.hasNext()) {
						Reserva reserva = iterator2.next();
						if(((reserva.getFechaLlegada().compareTo(modelMapper.map(reservaDTO.getFechaLlegada(),LocalDate.class)) >= 0)
							&& (reserva.getFechaLlegada().compareTo(modelMapper.map(reservaDTO.getFechaSalida(), LocalDate.class)) < 0)))
						cond = false;
						if(((reserva.getFechaSalida().compareTo(modelMapper.map(reservaDTO.getFechaLlegada(),LocalDate.class)) > 0)
							&& (reserva.getFechaSalida().compareTo(modelMapper.map(reservaDTO.getFechaSalida(), LocalDate.class)) <= 0)))
						cond = false;
						if(!cond)
						break;
					}
					else
					break;
				}
				if(cond) 
				break;
			}
		}
			
		if(!cond)
		throw new Exception("No hay habitaciones disponibles");
			
		LocalDateTime localDateTime1 = LocalDate.parse(reservaDTO.getFechaLlegada()).atStartOfDay();
		LocalDateTime localDateTime2 = LocalDate.parse(reservaDTO.getFechaSalida()).atStartOfDay();
		long diferencia = Math.abs(Timestamp.valueOf(localDateTime1).getTime() - Timestamp.valueOf(localDateTime2).getTime());
		diferencia /= 86400;
		diferencia /= 1000;
		int dias = (int)diferencia;
		reservaDTO.setCosto(tipoHabitacion.getCostoBase() * dias);
		reservaDTO.setFechaCreacion(getLocalDateTimeNow());
		reservaDTO.setCancelada(false);
		reservaDTO.setIdHabitacion(habitacion.getIdHabitacion());
			
		huespedService.crear(huespedDTO);
					
		Reserva reserva = modelMapper.map(reservaDTO, Reserva.class);

		reserva.setHuesped(huespedRepository.findById(huespedDTO.getCedula()).get());
		reserva.setIdHabitacion(habitacion);

		Reserva reservaRespuesta = reservaRepository.save(reserva);
		ReservaDTO reservaRespuestaDTO = modelMapper.map(reservaRespuesta, ReservaDTO.class);
		reservaRespuestaDTO.setCedula(reservaRespuesta.getHuesped().getCedula());
					
		return reservaRespuestaDTO;
	}
	
	public List<ReservaDTO> listar(){
		List<ReservaDTO> reservasDTO = new ArrayList<ReservaDTO>();
		List<Reserva> reservas = reservaRepository.findAll();
		ListIterator<Reserva> iterator = reservas.listIterator();
		while(true){
			if(iterator.hasNext())
			reservasDTO.add(modelMapper.map(iterator.next(), ReservaDTO.class));
			else
			break;
		}
		return reservasDTO;
	}
	
	public List<ReservaDTO> listarPorHuesped(String cedula) throws Exception {
		Optional<Huesped> optionalHuesped = huespedRepository.findById(cedula);
		if(optionalHuesped.isEmpty())
		throw new Exception("No hay un huesped con la cedula " + cedula);
		
		HuespedDTO huespedDTO = modelMapper.map(optionalHuesped.get(), HuespedDTO.class);		
		List<ReservaDTO> reservasDTO = new ArrayList<ReservaDTO>();
		List<Reserva> reservas = reservaRepository.findAllByHuesped(modelMapper.map(huespedDTO, Huesped.class));
		ListIterator<Reserva> iterator = reservas.listIterator();
		while(true) {
			if(iterator.hasNext())
			reservasDTO.add(modelMapper.map(iterator.next(), ReservaDTO.class));
			else
			break;
		}
		return reservasDTO;
	}
	
/*	public ReservaDTO crear(ReservaDTO reservaDTO, String idTipoHabitacion) throws Exception{
		
	}*/
	
	/*public ReservaDTO crear(ReservaDTO reservaDTO){
		imprimirReservaDTO(reservaDTO);
		reservaDTO.setFechaCreacion(getLocalDateTimeNow());
		Reserva reserva = modelMapper.map(reservaDTO, Reserva.class);
		reserva.setHuesped(huespedRepository.findById(reservaDTO.getCedula()).get());
		Reserva reservaRespuesta = reservaRepository.save(reserva);
		ReservaDTO reservaRespuestaDTO = modelMapper.map(reservaRespuesta, ReservaDTO.class);
		reservaRespuestaDTO.setCedula(reservaRespuesta.getHuesped().getCedula());
		return reservaRespuestaDTO;
	}*/
	
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
	
	/*public ReservaDTO consultar(Integer id) {
		Reserva reserva = reservaRepository.findByIdReserva(id);
		return modelMapper.map(reserva, ReservaDTO.class);
	}*/
	
/*	public ReservaDTO modificar(Integer id, String fechaLlegada, String fechaSalida) {
		
		reserva
		
	}*/

}
