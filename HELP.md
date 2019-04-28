# Curso de Spring boot do Dev Dojo

## Spring Boot Essentials 01: Setup do projeto

- Na classe principal, usamos a anotação **@EnableAutoConfiguration**, que diz para o spring que ele deve usar as dependências no POM, para configurar o projeto automaticamente.

```
@EnableAutoConfiguration
public class ApplicationStart {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationStart.class, args);
	}
	
}

```
- Para criarmos um endpoint, usamos a anotação **RestController**

```
@RestController
public class StudentEndpoint {

}
```

- - Para que o spring encontre a nossa classe com os endpoints, precisamos especificar isso na nossa classe principal com a anotação **@ComponentScan(basePackages = "br.com.jfassis.endpoint")**

```
@EnableAutoConfiguration
@ComponentScan(basePackages = "br.com.jfassis.endpoint")
public class ApplicationStart {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationStart.class, args);
	}
	
}
```
