package com.formacionbdi.springboot.app.oauth.services;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.formacionbdi.springboot.app.commons.usuarios.models.entity.Usuario;
import com.formacionbdi.springboot.app.oauth.clients.UsuarioFeignClient;

//La clase UserDetailsService es de Spring Secutriy
@Service
public class UsuarioService implements UserDetailsService{

	private Logger log = org.slf4j.LoggerFactory.getLogger(UsuarioService.class);
	
	@Autowired
	private UsuarioFeignClient client;
	
	//Este método de Spring Security permite autenticar el usuario por el username independientemente
	//si estamos usando JPA, JDBC o microservicio con un cliente Feign
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario = client.findByUsername(username);
		
		if (usuario == null) {
			log.error("Error en el login, no existe el usuario '" + username + "' ");
			throw new UsernameNotFoundException("Error en el login, no existe el usuario '" + username + "' ");
		}
		
		//Para obtener los authorities (roles) de la relación ManyToMany usamos un List del tipo GrantedAuthority de Spring Security
		//Para obtener ese tipo de List usamos el método stream
		//con collect terminamos de convertir el flujo al tipo GrantedAuthority
		List<GrantedAuthority> authorities = usuario.getRoles()
				.stream()
				.map(role -> new SimpleGrantedAuthority(role.getNombre()))
				.peek(authority -> log.info("Role: " + authority.getAuthority()))
				.collect(Collectors.toList());
		
		log.info("Usuario autenticado: " + username);
		
		//Los true a continuación representan los parámetros de User: accountNonExpired, credentialsNonExpired y accountNonLocked
		//authorities son los roles
		return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(), true,
				true, true, authorities);
			
	}
}
