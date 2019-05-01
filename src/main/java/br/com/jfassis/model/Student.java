package br.com.jfassis.model;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;

public class Student {
	
	static { // Bloco static é sempre executado logo que a classe é criada
		studentsRepository();
	}
	
	private int id;
	
	private String name;
	
	public static List<Student> studentList;

	public Student(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Student(String name) {
		this.name = name;
	}
	
	public Student() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static List<Student> getStudentList() {
		return studentList;
	}

	public static void setStudentList(List<Student> studentList) {
		Student.studentList = studentList;
	}
	
	private static void studentsRepository() {
		studentList = new ArrayList<>(asList(new Student(1, "João"), new Student(2, "Todoroki")));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
