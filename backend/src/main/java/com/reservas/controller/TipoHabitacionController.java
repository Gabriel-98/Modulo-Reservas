package com.reservas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reservas.dto.TipoHabitacionDTO;
import com.reservas.service.TipoHabitacionService;

@CrossOrigin(origins="http://localhost:4200", maxAge=3600)
@RestController
@RequestMapping("/tipos_habitaciones")
public class TipoHabitacionController {

	@Autowired
	TipoHabitacionService tipoHabitacionService;
	
	@GetMapping
	public List<TipoHabitacionDTO> listar(){
		System.out.println("/tiposhabitacion/listar");
		List<TipoHabitacionDTO> tiposHabitacionDTO = tipoHabitacionService.listar();
		return tiposHabitacionDTO;
	}
	
	@PostMapping
	public ResponseEntity<?> crear(@RequestBody TipoHabitacionDTO huespedDTO){
		System.out.println("/tiposhabitacion/crear");
		try {
			TipoHabitacionDTO tipoHabitacionRespuestaDTO = tipoHabitacionService.crear(huespedDTO);
			return ResponseEntity.ok(tipoHabitacionRespuestaDTO);
		}
		catch(Exception e){
			return ResponseEntity.ok(e.getMessage());
		}
	}
	
	@PutMapping()
	public ResponseEntity<?> modificar(@RequestBody TipoHabitacionDTO tipoHabitacionDTO){
		try {
			TipoHabitacionDTO ans = tipoHabitacionService.modificar(tipoHabitacionDTO);
			return ResponseEntity.ok(ans);
		}
		catch(Exception e){
			return ResponseEntity.ok(e.getMessage());
		}
	}
	
	@DeleteMapping(value = "/eliminar/{id}")
	public ResponseEntity<?> eliminar(@PathVariable("id") String id){
		System.out.println("eliminar/" + id);
		try {
			boolean ans = tipoHabitacionService.eliminar(id);
			return ResponseEntity.ok(ans);
		}
		catch(Exception e) {
			return ResponseEntity.ok(e.getMessage());
		}
	}
}
