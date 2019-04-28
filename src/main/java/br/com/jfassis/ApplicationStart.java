package br.com.jfassis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//Classe responsável por iniciar o spring boot
@EnableAutoConfiguration
@ComponentScan
@Configuration// Diz para usar as classes do Java para configurar o projeto, e não usar XML
public class ApplicationStart {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationStart.class, args);
	}
	
}
