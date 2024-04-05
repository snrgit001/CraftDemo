package com.app.craftdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.craftdemo.entity.Student;
import com.app.craftdemo.exception.StudentNotFoundException;
import com.app.craftdemo.model.StudentDTO;
import com.app.craftdemo.repository.StudentRepo;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepo repository;
	
	public Student saveStudent(StudentDTO studentRequest) {
		
		Student Student = com.app.craftdemo.entity.Student.build(Long.parseLong("0"), studentRequest.getFirstName(), studentRequest.getLastName(), studentRequest.getDateOfBirth(),  studentRequest.getEmail(), studentRequest.getEnrolledActive());
		return repository.save(Student);
	}
	
	public List<Student> getAllStudents() {
		return repository.findAll();
		
	}
	
	public Optional<Student> getStudent(Long id) throws StudentNotFoundException {
		
		 Optional<Student> student = repository.findById(id);
		 
		 if(student.isPresent()) {
			 return student;
		 }else {
			throw new StudentNotFoundException("Student not found with Id : "+id); 
		 }
		
	}

}
