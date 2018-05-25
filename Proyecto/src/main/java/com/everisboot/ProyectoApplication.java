package com.everisboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication(scanBasePackages={"com.everisboot"})
public class ProyectoApplication implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
	}	
}
