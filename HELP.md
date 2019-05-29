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

## Spring Boot Essentials 09 - Adicionando Spring Data JPA com MySQL pt 02

## Spring Boot Essentials 10 - Tratamento de erros em REST pt 01

- - Quando criamos uma exception, pode deixar programado qual o HttpStatus_code ela irá lanlar com a anotação **@ResponseStatus(HttpStatus.NOT_FOUND)**
```
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException(String message) {
		super(message);
	}
	
}

```

## Spring Boot Essentials 11 - Tratamento de erros em REST pt 02 - Exception Handler

- - Podemos criar uma classe que será chamada sempre que ocorrer um exception no Spring, utilizando a anotação **@ControllerAdvice**
```
@ControllerAdvice
public class RestExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException) {
		ResourceNotFoundDetails details = new ResourceNotFoundDetails("Resource not found", HttpStatus.NOT_FOUND.value(), resourceNotFoundException.getMessage(), new Date().getTime(), resourceNotFoundException.getClass().getName());
		
		return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
	}

}

```
- - Ao anotarmos um método com **@ExceptionHandler(ResourceNotFoundException.class)** dizemos que sempre que essa exceção for lançada, deverá chamar esse método

## Spring Boot Essentials 12 - Tratamento de erros em REST pt 03 - Transações

- - Podemos fazer com que, sempre que as tabelas forem criadas, usem a **engine InnoDB** que ajuda no controle de transações.
- - - Por padrão, no Linux as tabelas são criadas como InnoDB, e no windos, são criadas como MyISAM
- - - - application.properties
``` 
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect
```

- - Podemos adicionar a anotação **@Transactional** em um método que faça alteração no banco, e caso de um erro, um RuntimeException, o próprio spring se encarrega de fazer o rollback no banco de dados
```
@PostMapping
@Transactional
public ResponseEntity<?> save(@RequestBody Student student) {
	return new ResponseEntity<>(studentRepository.save(student), HttpStatus.OK);
}
```

