package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Course;
import com.revature.model.Student;
import com.revature.repository.CourseRepository;

@Service
public class CourseService {

	private CourseRepository courseRepository;
	
	@Autowired
	public CourseService (CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}
	
	public Course getById(int id){
		return this.courseRepository.getById(id);
	}
	
	
	public void deleteById(int id){
		this.courseRepository.deleteById(id);;
	}
	
	public List<Course> getAll(){
		return this.courseRepository.findAll();
	}
	
	public Course createCourse(Course s){
		return this.courseRepository.save(s);
	}

}
