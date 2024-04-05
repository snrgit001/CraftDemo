package com.app.craftdemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Student> saveStudent(@RequestBody @Valid StudentDTO studentRequest){
		
		return new ResponseEntity<Student>(service.saveStudent(studentRequest), HttpStatus.CREATED);	
	}
	
	@GetMapping("/fetchAll")
	public ResponseEntity<List<Student>> getAllStudents(){
		
		return ResponseEntity.ok(service.getAllStudents());
		
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Student>> getStudent(@PathVariable Long id) throws StudentNotFoundException{
		
		return ResponseEntity.ok(service.getStudent(id));
		
	}


}
