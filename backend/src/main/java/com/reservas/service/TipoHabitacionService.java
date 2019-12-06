package com.reservas.service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reservas.dto.TipoHabitacionDTO;
import com.reservas.entity.TipoHabitacion;
import com.reservas.repository.TipoHabitacionRepository;

@Service
public class TipoHabitacionService {

	@Autowired
	TipoHabitacionRepository tipoHabitacionRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	public boolean encontrar(String idTipoHabitacion) {
		Optional<TipoHabitacion> optionalTipoHabitacion = tipoHabitacionRepository.findById(idTipoHabitacion);
		return optionalTipoHabitacion.isPresent();
	}
	
	public TipoHabitacionDTO buscar(String idTipoHabitacion) throws Exception {
		Optional<TipoHabitacion> optionalTipoHabitacion = tipoHabitacionRepository.findById(idTipoHabitacion);
		if(optionalTipoHabitacion.isPresent())
		return modelMapper.map(optionalTipoHabitacion.get(), TipoHabitacionDTO.class);
		throw new Exception("El tipo de habitacion " + idTipoHabitacion + " no ha sido creado");
	}
	
	public List<TipoHabitacionDTO> listar() {
		List<TipoHabitacionDTO> tiposHabitacionDTO = new ArrayList<TipoHabitacionDTO>();
		List<TipoHabitacion> tiposHabitacion = tipoHabitacionRepository.findAll();
		ListIterator<TipoHabitacion> iterator = tiposHabitacion.listIterator();
		while(true) {
			if(iterator.hasNext()) 
			tiposHabitacionDTO.add(modelMapper.map(iterator.next(), TipoHabitacionDTO.class));
			else
			break;
		}
		return tiposHabitacionDTO;
	}
	
	public TipoHabitacionDTO crear(TipoHabitacionDTO tipoHabitacionDTO) throws Exception {
		Optional<TipoHabitacion> optionalTipoHabitacion = tipoHabitacionRepository.findById(tipoHabitacionDTO.getIdTipoHabitacion());
		if(optionalTipoHabitacion.isPresent())
		throw new Exception("El tipo de habitacion " + tipoHabitacionDTO.getIdTipoHabitacion() + " ya existe");
		
		TipoHabitacion tipoHabitacion = modelMapper.map(tipoHabitacionDTO,TipoHabitacion.class);
		TipoHabitacion tipoHabitacionRespuesta = tipoHabitacionRepository.save(tipoHabitacion);
		return modelMapper.map(tipoHabitacionRespuesta, TipoHabitacionDTO.class);
	}
	
	public boolean eliminar(String idTipoHabitacion) throws Exception {
		Optional<TipoHabitacion> optionalTipoHabitacion = tipoHabitacionRepository.findById(idTipoHabitacion);
		if(optionalTipoHabitacion.isEmpty())
		throw new Exception("El tipo de habitacion " + idTipoHabitacion + " no ha sido creado");
		
		tipoHabitacionRepository.deleteById(idTipoHabitacion);;
		return true;
	}
	
	public TipoHabitacionDTO modificar(TipoHabitacionDTO tipoHabitacionDTO) throws Exception {
		Optional<TipoHabitacion> optionalTipoHabitacion = tipoHabitacionRepository.findById(tipoHabitacionDTO.getIdTipoHabitacion());
		if(optionalTipoHabitacion.isEmpty())
		throw new Exception("El tipo de habitacion " + tipoHabitacionDTO.getIdTipoHabitacion() + " no ha sido creado");
		
		TipoHabitacion tipoHabitacion = modelMapper.map(tipoHabitacionDTO,TipoHabitacion.class);
		TipoHabitacion tipoHabitacionRespuesta = tipoHabitacionRepository.save(tipoHabitacion);
		return modelMapper.map(tipoHabitacionRespuesta, TipoHabitacionDTO.class);
	}
}
