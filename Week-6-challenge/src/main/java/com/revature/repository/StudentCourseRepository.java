package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Student;
//import com.revature.model.StudentCourse;

@Repository
public interface StudentCourseRepository extends JpaRepository<Student, Integer>{
	//public boolean addCourse(int studentId, int courseId);

}
