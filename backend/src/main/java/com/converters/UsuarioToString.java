package com.converters;

import org.modelmapper.AbstractConverter;

import com.reservas.entity.Usuario;

public class UsuarioToString extends AbstractConverter<Usuario,String>{

	@Override
	protected String convert(Usuario source) {
		return source.getCedula();
	}

}
