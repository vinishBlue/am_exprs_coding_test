package com.example.demo.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.exception.DataNotFoundException;
import com.example.demo.model.Student;
import com.example.demo.repo.StudentRepo;
import com.example.demo.repo.dto.AddStudentDto;
import com.example.demo.repo.dto.StudentDto;
import com.example.demo.repo.dto.UpdateStudentDto;

@Service
public class StudentService {

	@Autowired
	private StudentRepo studentRepo;
	
	public final static String DATE_FORMAT = "yyyy-MM-dd";

	public ResponseEntity<?> addStudent(AddStudentDto dto) {

		Student st = new Student();
		st.setName(dto.getName());
		st.setClassName(dto.getClassName());

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(DATE_FORMAT);

		LocalDate dob = LocalDate.parse(dto.getDateOfBirth(), dtf);

		LocalDate doj = LocalDate.parse(dto.getDateOfJoining(), dtf);

		st.setDateOfBirth(dob);
		st.setDateOfJoining(doj);

		studentRepo.save(st);

		return new ResponseEntity<>("Sudent Added Successfully", HttpStatus.OK);
	}

	public ResponseEntity<StudentDto> getStudent(Integer id) {

		Student student = studentRepo.findById(id).orElseThrow(() -> new DataNotFoundException("Student Not Found"));

		StudentDto dto = new StudentDto(student);

		return new ResponseEntity<>(dto, HttpStatus.OK);

	}

	public ResponseEntity<?> updateStudent(UpdateStudentDto dto) {

		Student st = studentRepo.findById(dto.getId()).orElseThrow(() -> new DataNotFoundException("Student Not Found"));
		st.setName(dto.getName());
		st.setClassName(dto.getClassName());

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(DATE_FORMAT);

		LocalDate dob = LocalDate.parse(dto.getDateOfBirth(), dtf);

		LocalDate doj = LocalDate.parse(dto.getDateOfJoining(), dtf);

		st.setDateOfBirth(dob);
		st.setDateOfJoining(doj);

		studentRepo.save(st);

		return new ResponseEntity<>("Student Updated Sucessfully", HttpStatus.OK);
	}

}
