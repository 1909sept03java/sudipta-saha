package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Course;
import com.revature.service.CourseService;

@RestController // @RestController = @Controller + @ResponseBody
@RequestMapping(value = "/course")
public class CourseController {
	private CourseService courseService;
	
	@Autowired
	public CourseController(CourseService courseService) {
		this.courseService = courseService;
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET) // parameterize the path
	public ResponseEntity<List<Course>> getAll() {
		return new ResponseEntity<>(this.courseService.getAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET) // parameterize the path
	public ResponseEntity<Course> getCourseId(@PathVariable int id) {
		Course s = this.courseService.getById(id);
		System.out.println(s);
		if (s == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(s, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE) // parameterize the path
	public ResponseEntity<List<Course>> deleteStudentById(@PathVariable int id) {
		Course s = this.courseService.getById(id);
		System.out.println(s);
		if (s == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			this.courseService.deleteById(id);
			return new ResponseEntity<List<Course>>(this.courseService.getAll(), HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT) // parameterize the path
	public ResponseEntity<Course> updateStudentById(@RequestParam("id") int id , @RequestParam("name") String name) {
		Course s = this.courseService.getById(id);
		if (s == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			s.setDescription(name);
			return new ResponseEntity<>(s, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.PUT) // parameterize the path
	public ResponseEntity<Course> createCourse(@RequestParam("id") int id , @RequestParam("name") String name) {
		Course s = new Course(id,name);
		return new ResponseEntity<>(this.courseService.createCourse(s), HttpStatus.OK);
	}

}
