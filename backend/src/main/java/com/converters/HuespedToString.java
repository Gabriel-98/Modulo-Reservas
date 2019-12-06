package com.converters;

import org.modelmapper.AbstractConverter;

import com.reservas.entity.Huesped;

public class HuespedToString extends AbstractConverter<Huesped,String>{

	@Override
	protected String convert(Huesped source) {
		return source.getCedula();
	}

}
