package com.converters;

import java.time.LocalDate;
import org.modelmapper.AbstractConverter;

public class StringToLocalDate extends AbstractConverter<String, LocalDate>{
		
	@Override
	protected LocalDate convert(String source){
		try {
			LocalDate destination = LocalDate.parse(source);
			return destination;
		}
		catch(Exception e) {
			return null;
		}
	}
}