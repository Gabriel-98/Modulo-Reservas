package com.reservas.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reservas.dto.HuespedDTO;
import com.reservas.dto.ReservaDTO;
import com.reservas.service.HuespedService;

@CrossOrigin(origins="http://localhost:4200", maxAge=3600)
@RestController
@RequestMapping("/huespedes")
public class HuespedController {
	
	@Autowired
	private HuespedService huespedService;
	
	@GetMapping
	public List<HuespedDTO> listar(){
		System.out.println("reservas");
		List<HuespedDTO> huespedesDTO = huespedService.listar();
		return huespedesDTO;
	}
	
	
	@GetMapping("/{cedula}/{codigo}")
	public boolean validar(@PathVariable("cedula") String cedula, @PathVariable("codigo") String codigo){
		System.out.println("consultar");
		try {
			HuespedDTO huespedDTO = huespedService.validarLogin(cedula, codigo);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	
	@PostMapping
	public ResponseEntity<?> crear(@RequestBody HuespedDTO huespedDTO){
		System.out.println("nuevo usuario");
		try {
			HuespedDTO huespedRespuestaDTO = huespedService.crear(huespedDTO);
			return ResponseEntity.ok(huespedRespuestaDTO);
		}
		catch(Exception e){
			return ResponseEntity.ok(e.getMessage());
		}
	}
}
