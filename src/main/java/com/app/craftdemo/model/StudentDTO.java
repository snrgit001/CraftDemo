package com.app.craftdemo.model;


import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class StudentDTO {
	
	@NotNull(message = "Firstname shouldn't be null")
	private String firstName;
	@NotNull(message = "Lastname shouldn't be null")
	private String lastName;
	@Email(message = "invalid email address")
	private String email;
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
	@DateTimeFormat( pattern="MM/dd/yyyy")
	private String dateOfBirth;
	@NotBlank(message = "enrolledActive can't be null or blank")
	private String enrolledActive;
}
