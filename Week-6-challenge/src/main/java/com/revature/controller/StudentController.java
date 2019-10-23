package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Student;
import com.revature.service.StudentCourseService;
import com.revature.service.StudentService;

@RestController // @RestController = @Controller + @ResponseBody
@RequestMapping(value = "/student")
public class StudentController {

	private StudentService studentService;
	//private StudentCourseService scs;
	
	@Autowired
	private void setStudentService (StudentService studentService) {
		this.studentService = studentService;
	}
	
	/*
	 * @Autowired private void setStudentCourseService (StudentCourseService scs) {
	 * this.scs = scs; }
	 */
	
	/*
	 * @RequestMapping(value = "/add", method = RequestMethod.GET) // parameterize
	 * the path public ResponseEntity<Boolean> addCourse(@PathVariable int
	 * studentId, int courseId) { scs.addCourse(studentId,courseId);
	 * System.out.println("here"); return new ResponseEntity<>(true, HttpStatus.OK);
	 * }
	 */
	
	@RequestMapping(value = "/all", method = RequestMethod.GET) // parameterize the path
	public ResponseEntity<List<Student>> getAll() {
		return new ResponseEntity<>(this.studentService.getAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET) // parameterize the path
	public ResponseEntity<Student> getStudentById(@PathVariable int id) {
		Student s = this.studentService.getById(id);
		System.out.println(s);
		if (s == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(s, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE) // parameterize the path
	public ResponseEntity<List<Student>> deleteStudentById(@PathVariable int id) {
		Student s = this.studentService.getById(id);
		System.out.println(s);
		if (s == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			this.studentService.deleteById(id);
			return new ResponseEntity<List<Student>>(this.studentService.getAll(), HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT) // parameterize the path
	public ResponseEntity<Student> updateStudentById(@RequestParam("id") int id , @RequestParam("name") String name) {
		Student s = this.studentService.getById(id);
		if (s == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			s.setName(name);
			return new ResponseEntity<>(s, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.PUT) // parameterize the path
	public ResponseEntity<Student> createStudent(@RequestParam("id") int id , @RequestParam("name") String name) {
		Student s = new Student(id,name , null);
		return new ResponseEntity<>(this.studentService.createStudent(s), HttpStatus.OK);
	}
}
