package com.reservas.service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.Random;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.reservas.dto.HuespedDTO;
import com.reservas.entity.Huesped;
import com.reservas.repository.HuespedRepository;
import com.time.Time;

@Service
public class HuespedService {
	
	@Autowired
	HuespedRepository huespedRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	private JavaMailSender mailSender;
	
	public void sendEmail(String destinatario, String asunto, String contenido) {
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(destinatario);
		email.setSubject(asunto);
		email.setText(contenido);
		mailSender.send(email);
	}
	
	public void enviarCodigo(HuespedDTO destinatario) {
		String email = destinatario.getEmail();
		String asunto = "Codigo de reservas";
		String contenido = "Su clave para consultar/cancelar reservas es el siguiente: " + destinatario.getCodigo();
		sendEmail(email, asunto, contenido);
	}
	
	public String generarCodigo() {
		Random random = new Random();
		String codigo = "";
		for(int i=0; i<10; i++){
			char letra;
			int r = random.nextInt(36);
			if(r < 10)
			letra = (char)('0' + r);
			else 
			letra = (char)('A' + r - 10);
			
			codigo += letra;
		}
		return codigo;
	}
	
	// Servicios
	
	public HuespedDTO buscar(String cedula) throws Exception {
		Optional<Huesped> optionalHuesped = huespedRepository.findById(cedula);
		if(optionalHuesped.isPresent())
		return modelMapper.map(optionalHuesped.get(), HuespedDTO.class);
		throw new Exception("El huesped con cedula " + cedula + " no ha sido creado");
	}
	
	public List<HuespedDTO> listar(){
		List<HuespedDTO> huespedesDTO = new ArrayList<HuespedDTO>();
		List<Huesped> huespedes = huespedRepository.findAll();
		ListIterator<Huesped> iterator = huespedes.listIterator();
		while(true){
			if(iterator.hasNext())
			huespedesDTO.add(modelMapper.map(iterator.next(), HuespedDTO.class));
			else
			break;
		}
		return huespedesDTO;
	}
	
	public HuespedDTO crear(HuespedDTO huespedDTO) throws Exception {
		boolean esNuevoHuesped = true;
		Optional<Huesped> optionalHuesped = huespedRepository.findById(huespedDTO.getCedula());
		if(optionalHuesped.isPresent()) {
			esNuevoHuesped = false;
			HuespedDTO huesped2DTO = modelMapper.map(optionalHuesped.get(), HuespedDTO.class);
			huespedDTO.setCodigo(huesped2DTO.getCodigo());
			huespedDTO.setFechaCreacion(huesped2DTO.getFechaCreacion());
			if(!(huespedDTO.equals(huesped2DTO)))
			throw new Exception("Los datos ingresados del huesped con cedula " + huespedDTO.getCedula() + " no coinciden con los anteriormente ingresados");
		}
		if(esNuevoHuesped) {
			huespedDTO.setCodigo(generarCodigo());
			huespedDTO.setFechaCreacion(Time.getLocalDateTimeNow());
		}
		Huesped huesped = modelMapper.map(huespedDTO, Huesped.class);
		Huesped huespedRespuesta = huespedRepository.save(huesped);	
		HuespedDTO huespedRespuestaDTO = modelMapper.map(huespedRespuesta, HuespedDTO.class);
		
		if(esNuevoHuesped)
		enviarCodigo(huespedRespuestaDTO);
				
		return huespedRespuestaDTO;
	}
	
	public HuespedDTO modificar(HuespedDTO huespedDTO) throws Exception {
		Optional<Huesped> optionalHuesped = huespedRepository.findById(huespedDTO.getCedula());
		if(optionalHuesped.isEmpty())
		throw new Exception("El huesped con cedula " + huespedDTO.getCedula() + " no ha sido creado");
		
		HuespedDTO huesped2DTO = modelMapper.map(optionalHuesped.get(), HuespedDTO.class);
		huespedDTO.setFechaCreacion(huesped2DTO.getFechaCreacion());
		huespedDTO.setCodigo(huesped2DTO.getCodigo());
		boolean cambioCamposBloqueados = false;
		if(!(huespedDTO.getNombre().equals(huesped2DTO.getNombre())))
		cambioCamposBloqueados = true;
		if(!(huespedDTO.getApellidos().equals(huesped2DTO.getApellidos())))
		cambioCamposBloqueados = true;
			
		if(cambioCamposBloqueados)
		throw new Exception("Esta intentando modificar datos no permitidos");

		Huesped huesped = modelMapper.map(huespedDTO, Huesped.class);
		Huesped huespedRespuesta = huespedRepository.save(huesped);
		return modelMapper.map(huespedRespuesta, HuespedDTO.class);
	}
	
	public boolean eliminar(String cedula) throws Exception {
		Optional<Huesped> optionalHuesped = huespedRepository.findById(cedula);
		if(optionalHuesped.isEmpty())
		throw new Exception("No hay huesped con cedula " + cedula);
		
		huespedRepository.deleteById(cedula);;
		return true;
	}
		
	public HuespedDTO cambiarCodigo(String cedula) throws Exception {
		Optional<Huesped> optionalHuesped = huespedRepository.findById(cedula);
		if(optionalHuesped.isEmpty())
		throw new Exception("El huesped con cedula " + cedula + " no ha sido creado");
		
		Huesped huesped = optionalHuesped.get();
		huesped.setCodigo(generarCodigo());
		Huesped huespedRespuesta = huespedRepository.save(huesped);
		HuespedDTO huespedRespuestaDTO = modelMapper.map(huespedRespuesta, HuespedDTO.class);
		enviarCodigo(huespedRespuestaDTO);
		return huespedRespuestaDTO;
	}
	
	public HuespedDTO validarLogin(String cedula, String codigo) throws Exception {
		Optional<Huesped> optionalHuesped = huespedRepository.findById(cedula);
		if(optionalHuesped.isEmpty())
		throw new Exception("No existe un huesped con esa cedula");
		
		Huesped huesped = optionalHuesped.get();
		if(huesped.getCodigo().equals(codigo))
		return modelMapper.map(huesped, HuespedDTO.class);
		throw new Exception("No coincide el codigo ingresado");
	}
}
