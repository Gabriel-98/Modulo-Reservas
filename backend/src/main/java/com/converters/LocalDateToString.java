package com.converters;

import org.modelmapper.AbstractConverter;
import java.time.LocalDate;

public class LocalDateToString extends AbstractConverter<LocalDate,String>{

	@Override
	protected String convert(LocalDate source){
		if(source == null)
		return null;
		return source.toString();
	}
}
