package com.reservas.controller;

import org.springframework.web.bind.annotation.RestController;

import com.reservas.dto.PeticionReservaDTO;
import com.reservas.dto.ReservaDTO;
import com.reservas.service.ReservaService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins="http://localhost:4200", maxAge=3600)
@RestController
@RequestMapping("/reservas")
public class ReservasController {
	
	@Autowired
	ReservaService reservaService;
	
	public ReservasController() {
		System.out.println("inicia controlador");
	}
	
	@GetMapping
	public List<ReservaDTO> listar() {
		System.out.println("reservas");
		List<ReservaDTO> reservasDTO = reservaService.listar();
		return reservasDTO;
		//return repo.findAll();
	}
	
	@GetMapping("/{id}")
	public List<ReservaDTO> listarPorHuesped(@PathVariable("id") String cedula){
		System.out.println("reservas por huesped");
		try {
			List<ReservaDTO> reservasDTO = reservaService.listarPorHuesped(cedula);
			System.out.println("size: " + reservasDTO.size());
			return reservasDTO;
		}
		catch(Exception e) {
			return new ArrayList<ReservaDTO>();
		}
	}
	
/*	@PostMapping
	public void reservar(@RequestBody ReservaDTO reserva) {
		System.out.println("registro");
		System.out.println(repo);
		imprimirReserva(reserva);
		Reserva reserva2 = mapper.map(reserva, Reserva.class);
	//	reserva2.setFechaLlegada(LocalDate.parse(reserva.getFechaLlegada()));
//		LocalDate date = LocalDate.parse("1998-10-18");
//		System.out.println(date);
		System.out.println(reserva2.getIdReserva() + " " + reserva2.getIdHabitacion() + " " + reserva2.getFechaLlegada());
	//	reserva.setIdReserva(1);

		repo.save(reserva2);
	}*/
	
	@PostMapping
	public ResponseEntity<?> reservar(@RequestBody PeticionReservaDTO peticionReservaDTO){
		try {
			ReservaDTO ans = reservaService.reservar(peticionReservaDTO);
			return ResponseEntity.ok(ans);
		}
		catch(Exception e) {
			return ResponseEntity.ok(e.getMessage());
		}
	}

	@PutMapping("/{idReserva}")
	public ResponseEntity<?> cancelar(@PathVariable Integer idReserva){
		ReservaDTO ans = reservaService.cancelar(idReserva);
		return ResponseEntity.ok(ans);
	}
}
