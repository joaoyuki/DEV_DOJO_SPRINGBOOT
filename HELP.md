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
## Spring Boot Essentials 02 - @Component, @Autowired e @SpringBootApplication

- O Spring indica que deixemos a nossa classe principal, no pacote raiz, assim não é necessário que toda vez especificar os pacotes aonde estão nossos códigos

- No Spring, temos vários tipos de anoções para indicar componentes:
- - @Component
- - Todas as anotações abaixo vem de **@Component**
- - - Marca a classe para ser lida pelo **@ComponentScan**
- - @Repository
- - - Usada com DAO's
- - @Service
- - - Usada na camada de serviço

## Spring Boot Essentials 03 - Configurando hot swap

- Adicionamos a dependência do devtools para fazer o hot swap

```
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<optional>true</optional>
		</dependency>
```

## Spring Boot Essentials 05 - Padrões REST e POST pt 01

- O Spring possui uma classe para usarmos quando formos retornar alguma informação de um controller **ResponseEntity**

```
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> listAll() {
		return new ResponseEntity<>(Student.studentList, HttpStatus.OK);
	}
```

- - É indicado sempre devolver o status da requisição, como o ***HttpStatus* por exemplo

## Spring Boot Essentials 06 - Padrões REST e POST pt 02

```
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> save(@RequestBody Student student) {
		Student.studentList.add(student);
		return new ResponseEntity<>(student, HttpStatus.OK);
	}
```

## Spring Boot Essentials 07 - Padrões REST e PUT e DELETE pt 03

## Spring Boot Essentials 08 - Adicionando Spring Data JPA com MySQL pt 01

- - Adicionado a dependência do Spring Boot Data JPA
```
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>	
```

- - Criando um repositório com spring basta extender a classe CrudRepository

```
public interface StudentRepository extends CrudRepository<Student, Long>{
	
	List<Student> findByName(String name);
	
}
```