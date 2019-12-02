package com.reservas.service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reservas.dto.UsuarioDTO;
import com.reservas.entity.Usuario;
import com.reservas.repository.UsuarioRepository;

@Service
public class HuespedService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	List<UsuarioDTO> listar(){
		List<UsuarioDTO> usuariosDTO = new ArrayList<UsuarioDTO>();
		List<Usuario> usuarios = usuarioRepository.findAll();
		ListIterator<Usuario> iterator = usuarios.listIterator();
		while(true){
			usuariosDTO.add(modelMapper.map(iterator.next(), UsuarioDTO.class));
			if(!iterator.hasNext())
			break;
		}
		return usuariosDTO;
	}
	
	UsuarioDTO add(UsuarioDTO usuarioDTO) {
		Usuario usuario = modelMapper.map(usuarioDTO,Usuario.class);
		Usuario respuesta = usuarioRepository.save(usuario);
		return modelMapper.map(respuesta, UsuarioDTO.class);
	}
}
