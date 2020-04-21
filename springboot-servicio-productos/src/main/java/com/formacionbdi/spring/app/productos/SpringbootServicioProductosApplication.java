package com.formacionbdi.spring.app.productos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
//La anotación @EntityScan nos permite indicar a nuestro proyecto servicio-productos que la clase
//Productos se encuentra en otro proyecto y otro package para lo cual de esta forma podrá hacer uso de ella
//@EntityScan({"com.formacionbdi.springboot.app.commons.models.entity"})
public class SpringbootServicioProductosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServicioProductosApplication.class, args);
	}

}
