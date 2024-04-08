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
	
	public Student addStudent(StudentDTO studentRequest) throws Exception {
		Student student = Student.builder().studentId(Long.parseLong("0")).firstName(studentRequest.getFirstName())
		.lastName(studentRequest.getLastName()).dateOfBirth(studentRequest.getDateOfBirth())
		.email(studentRequest.getEmail()).enrolledActive(studentRequest.getEnrolledActive()).build();
		
		return repository.save(student);
	}
	
	public List<Student> getAllStudents() throws Exception {
		List<Student> studentList = null;
		studentList = repository.findAll();
		if(studentList.isEmpty()) {
			throw new StudentNotFoundException("Students Not Found");
		}
		return studentList;		
	}
	
	public Student getStudent(Long id) throws StudentNotFoundException, Exception {
		
		 Optional<Student> student = repository.findById(id);
		 
		 if(student.isPresent()) {
			 return student.get();
		 }else {
			throw new StudentNotFoundException("Student not found with Id : "+id); 	 
		 }
		
	}
	
	public Student updateStudent(Long id, StudentDTO studentRequest) throws StudentNotFoundException{
		
		 Optional<Student> student = repository.findById(id);
		 
		 if(student.isPresent()) {
			 Student newStudent = student.get();
			 newStudent.setFirstName(studentRequest.getFirstName());
			 newStudent.setLastName(studentRequest.getLastName());
			 newStudent.setDateOfBirth(studentRequest.getDateOfBirth());
			 newStudent.setEmail(studentRequest.getEmail());
			 newStudent.setEnrolledActive(studentRequest.getEnrolledActive());
			 return repository.save(newStudent);
		 }else {
			throw new StudentNotFoundException("Student not found with Id : "+id); 	 
		 }
		
	}
	
	public void deleteStudent(Long id) throws StudentNotFoundException, Exception {
		Optional<Student> student = repository.findById(id);
		 
		 if(student.isPresent()) {
			 repository.deleteById(id);
		 }else {
			 throw new StudentNotFoundException("Student not found with Id : "+id); 	 
		 }
		 
	}


}
