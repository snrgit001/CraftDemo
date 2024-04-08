package com.app.craftdemo.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class StudentDTO {
	
	@NotBlank(message = "Firstname can't be null or blank")
	private String firstName;
	@NotBlank(message = "Lastname can't be null or blank")
	private String lastName;
	@Email(message = "invalid email address")
	private String email;
	@Pattern(regexp="(0[1-9]|1[1,2])\\/(0[1-9]|[12][0-9]|3[01])\\/(19|20)\\d{2}", message="Invalid Date Of Birth")
	private String dateOfBirth;
	@NotBlank(message = "enrolledActive can't be null or blank")
	private String enrolledActive;
}
