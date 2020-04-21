package com.formacionbdi.spring.app.item;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

	@Bean("clienteRest")
	@LoadBalanced //Le indicamos al cliente RestTemplate que solicite la instancia más adecuada para consumir el recurso del microservicio
	public RestTemplate registrarRestTemplate() {
		return new RestTemplate();
	} 
}
