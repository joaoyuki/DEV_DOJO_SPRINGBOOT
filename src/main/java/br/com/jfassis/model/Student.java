package br.com.jfassis.model;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Student extends AbstractEntity{

	@NotEmpty
	private String name;
	
	@Email
	@NotEmpty
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
