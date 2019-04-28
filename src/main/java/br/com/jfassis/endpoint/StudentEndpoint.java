package br.com.jfassis.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.jfassis.model.Student;
import br.com.jfassis.util.DateUtil;

import static java.util.Arrays.asList;

import java.time.LocalDateTime;


@RestController// Essa anotação vem do Spring mvc versão 4
@RequestMapping("student")// Indicamos que o endereço de entrada desse endpoint é /student
public class StudentEndpoint {
	
	@Autowired// Faz parte da injeção de dependência
	private DateUtil dateUtil;

	@RequestMapping(method = RequestMethod.GET, path = "/list")
	public List<Student> listAll() {
		System.out.println("--" + dateUtil.formatLocalDateTimeToDatebaseStyle(LocalDateTime.now()));
		return asList(new Student("João"), new Student("Todoroki"));
	}
	
}
