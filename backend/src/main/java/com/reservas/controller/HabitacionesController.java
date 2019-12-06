package com.reservas.controller;

import java.util.List;
import java.util.ListIterator;

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

import com.reservas.dto.HabitacionDTO;
import com.reservas.service.HabitacionService;

@CrossOrigin(origins="http://localhost:4200", maxAge=3600)
@RestController
@RequestMapping("/habitaciones")
public class HabitacionesController {

	@Autowired
	HabitacionService habitacionService;
	
	@GetMapping
	public List<HabitacionDTO> listar(){
		System.out.println("/habitaciones/listar");
		List<HabitacionDTO> habitacionesDTO = habitacionService.listar();
		System.out.println(habitacionesDTO.size());
		
		ListIterator<HabitacionDTO> iterator = habitacionesDTO.listIterator();
		while(true) {
			if(iterator.hasNext()) {
				HabitacionDTO habitacionDTO = iterator.next();
				System.out.println(habitacionDTO.getIdHabitacion() + " " + habitacionDTO.getIdTipoHabitacion());
			}
			else
			break;
		}
		
		return habitacionesDTO;
	}
	
	@PostMapping
	public ResponseEntity<?> crear(@RequestBody HabitacionDTO huespedDTO){
		System.out.println("/habitaciones/crear");
		try {
			HabitacionDTO habitacionRespuestaDTO = habitacionService.crear(huespedDTO);
			return ResponseEntity.ok(habitacionRespuestaDTO);
		}
		catch(Exception e){
			return ResponseEntity.ok(e.getMessage());
		}
	}
	
	@PutMapping()
	public ResponseEntity<?> modificar(@RequestBody HabitacionDTO habitacionDTO){
		try {
			HabitacionDTO ans = habitacionService.modificar(habitacionDTO);
			return ResponseEntity.ok(ans);
		}
		catch(Exception e){
			return ResponseEntity.ok(e.getMessage());
		}
	}
	
	@DeleteMapping("eliminar/{id}")
	public ResponseEntity<?> eliminar(@PathVariable("id") String id){
		try {
			boolean ans = habitacionService.eliminar(id);
			return ResponseEntity.ok(ans);
		}
		catch(Exception e) {
			return ResponseEntity.ok(e.getMessage());
		}
	}
}
