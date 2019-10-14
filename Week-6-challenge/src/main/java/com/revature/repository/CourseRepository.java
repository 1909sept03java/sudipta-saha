package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
	public Course getById(int id);
}
