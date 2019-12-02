package com.reservas;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import com.converters.StringToLocalDate;
import com.converters.StringToLocalDateTime;
import com.converters.UsuarioToString;
import com.reservas.dto.ReservaDTO;
import com.reservas.entity.Reserva;
import com.reservas.entity.Usuario;
import com.converters.LocalDateToString;
import com.converters.LocalDateTimeToString;
import com.converters.ModelMapperManager;
import com.converters.ReservaToReservaDTO;

@Configuration
public class Configuracion {

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		ModelMapperManager modelMapperManager = new ModelMapperManager();
		
		// add converter (String -> LocalDate)
		modelMapperManager.addConverterToModelMapper(String.class, LocalDate.class, new StringToLocalDate(), modelMapper);
		
		// add converter (LocalDate -> String)
		modelMapperManager.addConverterToModelMapper(LocalDate.class, String.class, new LocalDateToString(), modelMapper);
		
		// add converter (String -> LocalDateTime)
		modelMapperManager.addConverterToModelMapper(String.class, LocalDateTime.class, new StringToLocalDateTime(), modelMapper);
		
		// add converter (LocalDateTime -> String)
		modelMapperManager.addConverterToModelMapper(LocalDateTime.class, String.class, new LocalDateTimeToString(), modelMapper);
		
		// add converter (Usuario -> String)
		//modelMapperManager.addConverterToModelMapper(Usuario.class, String.class, new UsuarioToString(), modelMapper);
		
		//modelMapperManager.addConverterToModelMapper(Reserva.class, ReservaDTO.class, new ReservaToReservaDTO(), modelMapper);
		
		return modelMapper;
	}
	
}
