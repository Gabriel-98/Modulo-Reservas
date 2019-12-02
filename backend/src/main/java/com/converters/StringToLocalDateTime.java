package com.converters;

import java.time.LocalDateTime;
import org.modelmapper.AbstractConverter;

public class StringToLocalDateTime extends AbstractConverter<String, LocalDateTime>{

	@Override
	protected LocalDateTime convert(String source){
		try {
			LocalDateTime destination = LocalDateTime.parse(source);
			return destination;
		}
		catch(Exception e) {
			return null;
		}
	}
}
