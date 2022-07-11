package com.mycompany.conference;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//@EnableWebMvc
//@ComponentScan(basePackages ={"com.mycompany.controller", "com.mycompany.example"}, excludeFilters = {@Filter(EnableWebMvc.class),
//@Filter(Controller.class)})
@SpringBootApplication
public class ConferenceApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ConferenceApplication.class, args);
	}

}
