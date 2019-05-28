package br.com.jfassis.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.jfassis.model.Student;

public interface StudentRepository extends CrudRepository<Student, Long>{
	
	List<Student> findByNameIgnoreCaseContains(String name);
	
}
