package com.app.craftdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.craftdemo.entity.Student;
import com.app.craftdemo.exception.StudentNotFoundException;
import com.app.craftdemo.model.StudentDTO;
import com.app.craftdemo.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@PostMapping("/enroll")
	public ResponseEntity<Student> addStudent(@RequestBody @Valid StudentDTO studentRequest){
		try {
			return new ResponseEntity<Student>(service.addStudent(studentRequest), HttpStatus.CREATED);	
		}catch (Exception ex) {
			System.out.println("Internal Server Error::"+ex);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	
	@GetMapping("/fetchAll")
	public ResponseEntity<List<Student>> getAllStudents() throws StudentNotFoundException{
		try {
			return ResponseEntity.ok(service.getAllStudents());
		}catch (StudentNotFoundException ex) {
			//return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			throw new StudentNotFoundException(ex.getMessage());
		}catch (Exception ex) {
			System.out.println("Internal Server Error::"+ex);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}

	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable Long id) throws StudentNotFoundException{
		try {
			return ResponseEntity.ok(service.getStudent(id));
		}catch (StudentNotFoundException ex) {
			//return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			throw new StudentNotFoundException(ex.getMessage());
		}catch (Exception ex) {
			System.out.println("Internal Server Error::"+ex);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	
	@PostMapping("/update/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody @Valid StudentDTO studentRequest)throws StudentNotFoundException{
		try {
			return new ResponseEntity<Student>(service.updateStudent(id, studentRequest), HttpStatus.OK);	
		}catch (StudentNotFoundException ex) {
			//return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			throw new StudentNotFoundException(ex.getMessage());
		}catch (Exception ex) {
			System.out.println("Internal Server Error::"+ex);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> deleteStudent(@PathVariable Long id)throws StudentNotFoundException{
		try {
			service.deleteStudent(id);
			//return new ResponseEntity<Student>(service.deleteStudent(id), HttpStatus.CREATED);	
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (StudentNotFoundException ex) {
			//return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			throw new StudentNotFoundException(ex.getMessage());
		}catch (Exception ex) {
			System.out.println("Internal Server Error::"+ex);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
