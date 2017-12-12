package com.everson.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = { "com.everson.model" })
@EnableJpaRepositories(basePackages = { "com.everson.repository" })
@ComponentScan(basePackages = {"com.everson.controller"})
@ComponentScan(basePackages = {"com.everson.starter.config"})
public class GestaoComprasApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestaoComprasApplication.class, args);
	}
}
