package com.example.demo.dto;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class UpdateStudentDto {
	
	@NotNull(message = "ID Can't be Empty")
	private Integer id;
	
	@NotEmpty
	private String name;
	
	@NotEmpty(message = "DOB Can't be Empty")
	private String dateOfBirth;
	
	@NotEmpty(message = "DOJ Can't be Empty")
	private String dateOfJoining;
	
	@NotEmpty(message = "Class Name Can't be Empty")
	private String className;
	
}
