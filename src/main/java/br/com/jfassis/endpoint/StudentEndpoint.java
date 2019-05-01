package br.com.jfassis.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.jfassis.errors.CustomErrorType;
import br.com.jfassis.model.Student;
import br.com.jfassis.util.DateUtil;

import static java.util.Arrays.asList;

import java.time.LocalDateTime;


@RestController// Essa anotação vem do Spring mvc versão 4
@RequestMapping("students")// Indicamos que o endereço de entrada desse endpoint é /students
public class StudentEndpoint {
	
	@Autowired// Faz parte da injeção de dependência
	private DateUtil dateUtil;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> listAll() {
		return new ResponseEntity<>(Student.studentList, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	public ResponseEntity<?> getStudentById(@PathVariable("id") int id) {
		Student student = new Student();
		student.setId(id);
		int index = Student.studentList.indexOf(student);
		if (index == -1) {
			return new ResponseEntity<>(new CustomErrorType("Student not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(Student.studentList.get(index), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> save(@RequestBody Student student) {
		Student.studentList.add(student);
		return new ResponseEntity<>(student, HttpStatus.OK);
	}
	
}
