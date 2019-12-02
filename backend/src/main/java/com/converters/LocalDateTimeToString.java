package com.converters;

import org.modelmapper.AbstractConverter;
import java.time.LocalDateTime;

public class LocalDateTimeToString extends AbstractConverter<LocalDateTime,String> {
	
	@Override
	protected String convert(LocalDateTime source){
		if(source == null)
		return null;
		return source.toString();
	}
}
