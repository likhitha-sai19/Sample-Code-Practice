package com.example.demo.student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	private final StudentRepository studentRepository;
	
	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public List<Student> getStudents()
	{
		return studentRepository.findAll();
		
//		List<Student> records = new ArrayList<Student>();
//		Student stu = new Student(1L,"Mariam", 23, LocalDate.of(2020, 5, 13), "Mariam.S@gmail.com");
//		records.add(stu);
//		return records;
	}
	
}
