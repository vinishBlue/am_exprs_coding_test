package com.example.demo.dto;

import java.time.format.DateTimeFormatter;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

import lombok.Data;

@Data
public class StudentDto {
	
	private Integer id;
	
	private String name;
	
	private String dateOfBirth;
	
	private String dateOfJoining;
	
	private String className;

	public StudentDto(Student st) {
		super();
		this.id = st.getId();
		this.name = st.getName();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(StudentService.DATE_FORMAT);
		this.dateOfBirth = st.getDateOfBirth().format(dtf);
		this.dateOfJoining = st.getDateOfJoining().format(dtf);
		this.className = st.getClassName();
	}

	
	
	
}
