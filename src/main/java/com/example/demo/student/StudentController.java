package com.example.demo.student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/V1/Student")
public class StudentController {
	
	//This class will have all the resources for API
	
	private final StudentService studentService;
	
	@Autowired
	public StudentController(StudentService studentService)
	{
		this.studentService = studentService;
	}
	
	@GetMapping
	public List<Student> getStudents()
	{
		return studentService.getStudents();
	}
}
