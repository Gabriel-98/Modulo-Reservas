package com.converters;

import java.time.LocalDate;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;

public class ModelMapperManager {
	
	public void addConverterToModelMapper(Class<?> sourceType, Class<?> destinationType, Converter<?,?> converter, ModelMapper modelMapper) {
		modelMapper.createTypeMap(sourceType, destinationType);
		modelMapper.addConverter(converter);
		modelMapper.getTypeMap(String.class, LocalDate.class).setPropertyConverter(converter);
	}
}
