package com.reservas.service;
/*
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;*/
/*import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;*/
/*import org.springframework.stereotype.Service;

import com.reservas.entity.Huesped;
import com.reservas.repository.HuespedRepository;*/

//@Service
public class UsuarioService /*implements UserDetailsService */{
/*
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("username: " + username);
		List<GrantedAuthority> roles = new ArrayList<>();
		roles.add(new SimpleGrantedAuthority("ADMIN"));
		
		Usuario usuario = usuarioRepository.findById(username).get();
		UserDetails user = new User(usuario.getCedula(), usuario.getCodigo(), roles);
		
		return user;
	}
*/
}
