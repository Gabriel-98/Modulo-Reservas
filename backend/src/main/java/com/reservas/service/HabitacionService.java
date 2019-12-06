package com.reservas.service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reservas.dto.HabitacionDTO;
import com.reservas.dto.TipoHabitacionDTO;
import com.reservas.entity.Habitacion;
import com.reservas.entity.TipoHabitacion;
import com.reservas.repository.HabitacionRepository;

@Service
public class HabitacionService {
	
	@Autowired
	HabitacionRepository habitacionRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	TipoHabitacionService tipoHabitacionService;
	
	// Servicios
	
	public boolean encontrar(String idHabitacion) throws Exception {
		Optional<Habitacion> optionalHabitacion = habitacionRepository.findById(idHabitacion);
		return optionalHabitacion.isPresent();
	}
	
	public HabitacionDTO buscar(String idHabitacion) throws Exception {
		Optional<Habitacion> optionalHabitacion = habitacionRepository.findById(idHabitacion);
		if(optionalHabitacion.isPresent())
		return modelMapper.map(optionalHabitacion.get(), HabitacionDTO.class);
		throw new Exception("La habitacion " + idHabitacion + " no existe");
	}
	
	public List<HabitacionDTO> listar() {
		List<HabitacionDTO> habitacionesDTO = new ArrayList<HabitacionDTO>();
		List<Habitacion> habitaciones = habitacionRepository.findAll();
		ListIterator<Habitacion> iterator = habitaciones.listIterator();
		while(true) {
			if(iterator.hasNext()) 
			habitacionesDTO.add(modelMapper.map(iterator.next(), HabitacionDTO.class));
			else
			break;
		}
		return habitacionesDTO;
	}
	
	public List<HabitacionDTO> listarPorTipoHabitacion(String idTipoHabitacion) throws Exception{
		List<HabitacionDTO> habitacionesDTO = new ArrayList<HabitacionDTO>();
		if(tipoHabitacionService.encontrar(idTipoHabitacion)) {
			try {
				TipoHabitacionDTO tipoHabitacionDTO = tipoHabitacionService.buscar(idTipoHabitacion);
				TipoHabitacion tipoHabitacion = modelMapper.map(tipoHabitacionDTO, TipoHabitacion.class);
				List<Habitacion> habitaciones = habitacionRepository.findAllByIdTipoHabitacion(tipoHabitacion);
				ListIterator<Habitacion> iterator = habitaciones.listIterator();
				while(true) {
					if(iterator.hasNext()) 
					habitacionesDTO.add(modelMapper.map(iterator.next(), HabitacionDTO.class));
					else
					break;
				}
			}
			catch(Exception e) {}	
			return habitacionesDTO;
		}
		else
		throw new Exception("No existe el tipo de habitacion " + idTipoHabitacion);
	}
	
	public HabitacionDTO crear(HabitacionDTO habitacionDTO) throws Exception {
		Optional<Habitacion> optionalHabitacion = habitacionRepository.findById(habitacionDTO.getIdHabitacion());
		if(optionalHabitacion.isPresent())
		throw new Exception("La habitacion " + habitacionDTO.getIdHabitacion() + " ya existe");
		
		Habitacion habitacion = modelMapper.map(habitacionDTO, Habitacion.class);
		if(tipoHabitacionService.encontrar(habitacionDTO.getIdTipoHabitacion())) {
			Habitacion habitacionRespuesta = habitacionRepository.save(habitacion);
			return modelMapper.map(habitacionRespuesta, HabitacionDTO.class);
		}
		throw new Exception("No hay un tipo de habitacion " + habitacionDTO.getIdTipoHabitacion());
	}
	
	public boolean eliminar(String idHabitacion) throws Exception {
		Optional<Habitacion> optionalHabitacion = habitacionRepository.findById(idHabitacion);
		if(optionalHabitacion.isEmpty())
		throw new Exception("La habitacion " + idHabitacion + " no ha sido creada");
		
		habitacionRepository.deleteById(idHabitacion);;
		return true;
	}
	
	public HabitacionDTO modificar(HabitacionDTO habitacionDTO) throws Exception {
		Optional<Habitacion> optionalHabitacion = habitacionRepository.findById(habitacionDTO.getIdHabitacion());
		if(optionalHabitacion.isEmpty())
		throw new Exception("La habitacion " + habitacionDTO.getIdHabitacion() + " no ha sido creada");
		
		Habitacion habitacion = modelMapper.map(habitacionDTO, Habitacion.class);
		if(tipoHabitacionService.encontrar(habitacionDTO.getIdTipoHabitacion())) {
			Habitacion habitacionRespuesta = habitacionRepository.save(habitacion);
			return modelMapper.map(habitacionRespuesta, HabitacionDTO.class);
		}
		throw new Exception("No hay un tipo de habitacion " + habitacionDTO.getIdTipoHabitacion());
	}
}
