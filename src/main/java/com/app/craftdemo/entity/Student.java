package com.app.craftdemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name= "STUDENTS")
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
@Data
@Builder
public class Student {
	
	@Id
	@GeneratedValue
	private Long studentId;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String email;	
	private String enrolledActive;

}
