package com.example.demo.student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	public void addNewStudent(Student student)
	{
		//If email doesn't exist then save student else throw an exception.
		
		// Business Logic
		Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
		if(studentOptional.isPresent())
		{
			throw new IllegalStateException("email taken");
		}
		
		//Check if student is valid or not - need to implement
		
		studentRepository.save(student);
		
		System.out.println(student);
		
		
	}
	
	public void deleteStudent(Long studentId)
	{
		boolean exists = studentRepository.existsById(studentId);
		if(!exists)
		{
			throw new IllegalStateException("student with id" + studentId + "does not exists");
		}
		
		studentRepository.deleteById(studentId);
	}
	
	@Transactional
	public void updateStudent(Long studentId, String name, String email)
	{
		Student student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException("student with id " + studentId + "does not exist"));
		
		if(name != null && name.length() > 0 && !Objects.equals(student.getName(), name))
		{
			student.setName(name);
		}
		
		if(email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email))
		{
			student.setEmail(email);
		}
	}
}