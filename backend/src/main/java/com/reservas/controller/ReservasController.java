package com.reservas.controller;

//import java.util.List;
import org.springframework.web.bind.annotation.RestController;

import com.reservas.dto.ReservaDTO;
import com.reservas.entity.Reserva;
import com.reservas.repository.ReservaRepository;
import com.reservas.service.ReservaService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.modelmapper.ModelMapper;
import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins="http://localhost:4200", maxAge=3600)
@RestController
@RequestMapping("/reservas")
public class ReservasController {

	/*@Autowired
	private ReservaRepository repo;
	
	@Autowired
	ModelMapper mapper;*/
	
	@Autowired
	ReservaService reservaService;
	
	public ReservasController() {
		System.out.println("inicia controlador 1");
	}
	
	
	
	@GetMapping()
	private List<ReservaDTO> listarReservas() {
		System.out.println("reservas");
		List<ReservaDTO> reservas = reservaService.listar();
		for(int i=0; i<reservas.size(); i++) {
		//	imprimirReserva(reservas.get(i));
		}
		return reservas;
		//return repo.findAll();
	}
	
/*	@PostMapping
	private void reservar(@RequestBody ReservaDTO reserva) {
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
	public ResponseEntity<?> reservar(@RequestBody ReservaDTO reserva){
		ReservaDTO ans = reservaService.crear(reserva);
		return ResponseEntity.ok(ans);
	}	

	@PutMapping("{idReserva}")
	public ResponseEntity<?> cancelar(@PathVariable Integer idReserva){
		ReservaDTO ans = reservaService.cancelar(idReserva);
		return ResponseEntity.ok(ans);
	}
}
