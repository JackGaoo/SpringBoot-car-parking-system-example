package com.imust;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
@SpringBootApplication
@MapperScan("com.imust.mapper")
public class MyApp {
	public static void main(String[] args) {
		SpringApplication.run(MyApp.class, args);
	}
	
	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {

	   return (container -> {
	        ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/404.html");

	        container.addErrorPages( error404Page);
	   });
	}

}
