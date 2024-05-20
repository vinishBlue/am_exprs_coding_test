package com.example.demo.dto;

import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

import lombok.Data;

@Data
public class AddStudentDto {
	
	@NotNull
	@NotEmpty
	private String name;
	
	private String dateOfBirth;
	
	private String dateOfJoining;
	
	private String className;

}
