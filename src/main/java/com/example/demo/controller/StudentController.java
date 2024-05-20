package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AddStudentDto;
import com.example.demo.dto.UpdateStudentDto;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping
	public ResponseEntity<?> addStudent(@Validated @RequestBody AddStudentDto dto) {

		return studentService.addStudent(dto);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getStudent(@PathVariable("id") Integer id) {

		return studentService.getStudent(id);
	}

	@PutMapping
	public ResponseEntity<?> updateStudent(@Validated @RequestBody UpdateStudentDto dto) {

		return studentService.updateStudent(dto);
	}

}
