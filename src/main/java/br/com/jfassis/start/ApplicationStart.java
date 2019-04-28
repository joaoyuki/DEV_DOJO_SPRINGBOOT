package br.com.jfassis.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

//Classe responsável por iniciar o spring boot
@EnableAutoConfiguration
@ComponentScan(basePackages = "br.com.jfassis.endpoint")
public class ApplicationStart {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationStart.class, args);
	}
	
}
