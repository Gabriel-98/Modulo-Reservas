package com.reservas;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import com.converters.StringToLocalDate;
import com.converters.StringToLocalDateTime;
import com.converters.LocalDateToString;
import com.converters.LocalDateTimeToString;
import com.converters.ModelMapperManager;

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
				
		//modelMapperManager.addConverterToModelMapper(Reserva.class, ReservaDTO.class, new ReservaToReservaDTO(), modelMapper);
		
		return modelMapper;
	}
	
}
