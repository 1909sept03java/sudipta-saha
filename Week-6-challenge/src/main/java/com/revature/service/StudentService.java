package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Student;
import com.revature.repository.StudentCourseRepository;
import com.revature.repository.StudentRepository;

@Service
public class StudentService {

	private StudentRepository studentRepository;
	
	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	public Student getById(int id){
		return this.studentRepository.getById(id);
	}
	
	public void deleteById(int id){
		this.studentRepository.deleteById(id);;
	}
	
	public List<Student> getAll(){
		return this.studentRepository.findAll();
	}
	
	public Student createStudent(Student s){
		return this.studentRepository.save(s);
	}

}
