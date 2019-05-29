package br.com.jfassis.endpoint;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.jfassis.errors.CustomErrorType;
import br.com.jfassis.errors.ResourceNotFoundException;
import br.com.jfassis.model.Student;
import br.com.jfassis.repository.StudentRepository;

@RestController// Essa anotação vem do Spring mvc versão 4
@RequestMapping("students")// Indicamos que o endereço de entrada desse endpoint é /students
public class StudentEndpoint {

	@Autowired
	private StudentRepository studentRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> listAll() {
		return new ResponseEntity<>(studentRepository.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	public ResponseEntity<?> getStudentById(@PathVariable("id") Long id) {
		verifyIfStudentExist(id);
		Student student = studentRepository.findOne(id);
		return new ResponseEntity<>(student, HttpStatus.OK);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> save(@RequestBody Student student) {
		return new ResponseEntity<>(studentRepository.save(student), HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		verifyIfStudentExist(id);
		studentRepository.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}	
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody Student student) {
		verifyIfStudentExist(student.getId());
		studentRepository.save(student);
		return new ResponseEntity<>(HttpStatus.OK);
	}		
	
	@GetMapping(path = "/findByName/{name}")
	public ResponseEntity<?> findStudentsByName(@PathVariable String name) {
		return new ResponseEntity<>(studentRepository.findByNameIgnoreCaseContains(name), HttpStatus.OK);
	}
	
	private void verifyIfStudentExist(Long id) {
		Student student = studentRepository.findOne(id);
		if (student == null) {
			throw new ResourceNotFoundException("Student not found for id: " + id);
		}		
	}
}
