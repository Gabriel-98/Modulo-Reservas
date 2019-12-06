package com.reservas;

import java.util.List;
import java.util.ListIterator;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.reservas.dto.HabitacionDTO;
import com.reservas.dto.HuespedDTO;
import com.reservas.dto.TipoHabitacionDTO;
import com.reservas.service.HabitacionService;
import com.reservas.service.HuespedService;
import com.reservas.service.ReservaService;
import com.reservas.service.TipoHabitacionService;

@SpringBootTest
class ReservasApplicationTests {

	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	ReservaService reservaService;
	
	@Autowired
	TipoHabitacionService tipoHabitacionService;
	
	@Autowired
	HabitacionService habitacionService;
	
	@Autowired
	HuespedService huespedService;
	
	public void imprimirTipoHabitacionDTO(TipoHabitacionDTO tipoHabitacionDTO) {
		System.out.print(tipoHabitacionDTO.getIdTipoHabitacion() + " ");
		System.out.print(tipoHabitacionDTO.getDescripcion() + " ");
		System.out.print(tipoHabitacionDTO.getMaxOcupantes() + " ");
		System.out.print(tipoHabitacionDTO.getCostoBase() + " ");
		System.out.println();
		System.out.println();
	}
	
	public void imprimirHabitacionDTO(HabitacionDTO habitacionDTO) {
		System.out.print(habitacionDTO.getIdHabitacion() + " ");
		System.out.print(habitacionDTO.getIdTipoHabitacion() + " ");
		System.out.println();
		System.out.println();
	}
	
	public void imprimirHuespedDTO(HuespedDTO huespedDTO) {
		System.out.print(huespedDTO.getCedula() + " ");
		System.out.print(huespedDTO.getNombre() + " ");
		System.out.print(huespedDTO.getApellidos() + " ");
		System.out.print(huespedDTO.getEmail() + " ");
		System.out.print(huespedDTO.getTelefono() + " ");
		System.out.print(huespedDTO.getCodigo() + " ");
		System.out.print(huespedDTO.getFechaCreacion() + " ");
		System.out.println();
		System.out.println();
	}
	
	/***
	 Test TipoHabitacion
	 */
	
	public void buscarTipoHabitacion() {
		System.out.println("buscar tipo habitacion:");
		try {
			TipoHabitacionDTO tipoHabitacionDTO = tipoHabitacionService.buscar("basica 2");
			imprimirTipoHabitacionDTO(tipoHabitacionDTO);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void listarTiposHabitacion() {
		System.out.println("listar tipos de habitacion");
		List<TipoHabitacionDTO> tiposHabitacionDTO = tipoHabitacionService.listar();
		ListIterator<TipoHabitacionDTO> iterator = tiposHabitacionDTO.listIterator();
		while(true) {
			if(iterator.hasNext()) {
				TipoHabitacionDTO tipoHabitacionDTO = iterator.next();
				imprimirTipoHabitacionDTO(tipoHabitacionDTO);
			}
			else
			break;
		}
	}
	
	public void crearTipoHabitacion() {
		System.out.println("crear tipo habitacion:");
		TipoHabitacionDTO tipoHabitacionDTO = new TipoHabitacionDTO();
		tipoHabitacionDTO.setIdTipoHabitacion("basica");
		tipoHabitacionDTO.setDescripcion("...");
		tipoHabitacionDTO.setMaxOcupantes(4);
		tipoHabitacionDTO.setCostoBase(90000.00);
		try {
			TipoHabitacionDTO tipoHabitionRespuestaDTO = tipoHabitacionService.crear(tipoHabitacionDTO);
			imprimirTipoHabitacionDTO(tipoHabitionRespuestaDTO);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}		
	}
	
	public void modificarTipoHabitacion() {
		System.out.println("modificar tipo habitacion:");
		TipoHabitacionDTO tipoHabitacionDTO = new TipoHabitacionDTO();
		tipoHabitacionDTO.setIdTipoHabitacion("basica");
		tipoHabitacionDTO.setDescripcion("...");
		tipoHabitacionDTO.setMaxOcupantes(4);
		tipoHabitacionDTO.setCostoBase(90000.00);
		try {
			TipoHabitacionDTO tipoHabitionRespuestaDTO = tipoHabitacionService.modificar(tipoHabitacionDTO);
			imprimirTipoHabitacionDTO(tipoHabitionRespuestaDTO);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void eliminarTipoHabitacion() {
		System.out.println("eliminar tipo habitacion:");
		try {
			boolean respuesta = tipoHabitacionService.eliminar("basica");
			System.out.println(respuesta);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/***
	 * Test Huesped
	 */
	
	public void buscarHuesped() {
		System.out.println("buscar huesped:");
		try {
			HuespedDTO huespedDTO = huespedService.buscar("1054894989");
			imprimirHuespedDTO(huespedDTO);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void listarHuespedes() {
		System.out.println("listar huespedes");
		List<HuespedDTO> huespedesDTO = huespedService.listar();
		ListIterator<HuespedDTO> iterator = huespedesDTO.listIterator();
		while(true) {
			if(iterator.hasNext()) {
				HuespedDTO huespedDTO = iterator.next();
				imprimirHuespedDTO(huespedDTO);
			}
			else
			break;
		}
	}
	
	public void crearHuesped() {
		System.out.println("crear huesped:");
		HuespedDTO huespedDTO = new HuespedDTO();
		huespedDTO.setCedula("1054894989");
		huespedDTO.setNombre("nombre01");
		huespedDTO.setApellidos("apellido1");
		huespedDTO.setEmail("ggutierreztamayo@gmail.com");
		huespedDTO.setTelefono("35489847");
		try {
			HuespedDTO huespedRespuestaDTO = huespedService.crear(huespedDTO);
			imprimirHuespedDTO(huespedRespuestaDTO);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}		
	}
	
	public void modificarHuesped() {
		System.out.println("modificar huesped:");
		HuespedDTO huespedDTO = new HuespedDTO();
		huespedDTO.setCedula("1064154654");
		huespedDTO.setNombre("nombre01");
		huespedDTO.setApellidos("apellido1");
		huespedDTO.setEmail("correo1@gmail.com");
		huespedDTO.setTelefono("3462659");
		try {
			HuespedDTO huespedRespuestaDTO = huespedService.modificar(huespedDTO);
			imprimirHuespedDTO(huespedRespuestaDTO);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void eliminarHuesped() {
		System.out.println("eliminar huesped:");
		try {
			boolean respuesta = huespedService.eliminar("108464648");
			System.out.println(respuesta);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void cambiarCodigoHuesped() {
		System.out.println("cambiar codigo:");
		String cedula = "104546876614";
		try {
			huespedService.cambiarCodigo(cedula);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void validarLoginHuesped() {
		try {
			HuespedDTO huespedDTO = huespedService.validarLogin("105646468", "2MBZHWXY8R");
			imprimirHuespedDTO(huespedDTO);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/***
	 * Test Habitacion
	 */
	
	public void buscarHabitacion() {
		System.out.println("buscar habitacion:");
		try {
			HabitacionDTO habitacionDTO = habitacionService.buscar("102");
			imprimirHabitacionDTO(habitacionDTO);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void listarHabitaciones() {
		System.out.println("listar habitaciones");
		try {
			//List<HabitacionDTO> habitacionesDTO = habitacionService.listar();
			List<HabitacionDTO> habitacionesDTO = habitacionService.listarPorTipoHabitacion("basica");
			ListIterator<HabitacionDTO> iterator = habitacionesDTO.listIterator();
			while(true) {
				if(iterator.hasNext()) {
					HabitacionDTO habitacionDTO = iterator.next();
					imprimirHabitacionDTO(habitacionDTO);
				}
				else
				break;
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void crearHabitacion() {
		System.out.println("crear habitacion:");
		HabitacionDTO habitacionDTO = new HabitacionDTO();
		habitacionDTO.setIdHabitacion("102");
		habitacionDTO.setIdTipoHabitacion("estandar");
		try {
			HabitacionDTO habitacionRespuestaDTO = habitacionService.crear(habitacionDTO);
			imprimirHabitacionDTO(habitacionRespuestaDTO);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}		
	}
	
	public void modificarHabitacion() {
		System.out.println("modificar habitacion:");
		HabitacionDTO habitacionDTO = new HabitacionDTO();
		habitacionDTO.setIdHabitacion("103");
		habitacionDTO.setIdTipoHabitacion("basica");
		try {
			HabitacionDTO habitionRespuestaDTO = habitacionService.modificar(habitacionDTO);
			imprimirHabitacionDTO(habitionRespuestaDTO);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void eliminarHabitacion() {
		System.out.println("eliminar habitacion:");
		try {
			boolean respuesta = habitacionService.eliminar("100");
			System.out.println(respuesta);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	void crearUsuario() {
		modificarHabitacion();
	}
}
