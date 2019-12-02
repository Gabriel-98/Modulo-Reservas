package com.reservas;

//import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.reservas.dto.ReservaDTO;
import com.reservas.entity.Reserva;
import com.reservas.service.ReservaService;

//import com.reservas.entity.Usuario;
//import com.reservas.repository.UsuarioRepository;

@SpringBootTest
class ReservasApplicationTests {

//	@Autowired
//	private UsuarioRepository usuarioRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	ReservaService reservaService;
	
	@Test
	void crearUsuario() {

	}

}
