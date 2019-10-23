package com.revature.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

//@Embeddable
public class StudentCourseKey implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1858874802988589211L;

	//@Column(name = "STUDENT_ID")
    int studentId;
 
    //@Column(name = "COURSE_ID")
    int courseId;
 

	public int getStudentId() {
		return studentId;
	}


	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}


	public int getCourseId() {
		return courseId;
	}


	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "StudentCourseKey [studentId=" + studentId + ", courseId=" + courseId + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + courseId;
		result = prime * result + studentId;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentCourseKey other = (StudentCourseKey) obj;
		if (courseId != other.courseId)
			return false;
		if (studentId != other.studentId)
			return false;
		return true;
	}


	public StudentCourseKey() {
		// TODO Auto-generated constructor stub
	}

}
