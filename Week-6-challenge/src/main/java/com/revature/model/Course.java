package com.revature.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="COURSE")
public class Course {
	@Min(0) 
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO, generator="courseSequence")
	@SequenceGenerator(allocationSize=1, name="courseSequence", sequenceName="SQ_COURSE_PK")
	@Column(name="COURSE_ID")
	private int id;
	@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Student> students;
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", description=" + description +  ", getId()=" + getId()
				+ ", getDescription()=" + getDescription() +  "]";
	}

	public Course(@Min(0) int id, String description) {
		super();
		this.id = id;
		this.description = description;
	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	private String description;
	//private List <Student> student_id;
	
	
	
}
