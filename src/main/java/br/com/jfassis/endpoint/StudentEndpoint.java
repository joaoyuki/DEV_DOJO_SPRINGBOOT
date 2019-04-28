package br.com.jfassis.endpoint;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.jfassis.model.Student;

import static java.util.Arrays.asList;


@RestController// Essa anotação vem do Spring mvc versão 4
@RequestMapping("student")// Indicamos que o endereço de entrada desse endpoint é /student
public class StudentEndpoint {

	@RequestMapping(method = RequestMethod.GET, path = "/list")
	public List<Student> listAll() {
		return asList(new Student("João"), new Student("Todoroki"));
	}
	
}
