package com.revature.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="STUDENT")
public class Student {
	
	@Min(0) 
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO, generator="studentSequence")
	@SequenceGenerator(allocationSize=1, name="studentSequence", sequenceName="SQ_STUDENT_PK")
	@Column(name="STUDENT_ID")
	private int id;
	/*
	 * @NotNull // JSR303 validation
	 * 
	 * @ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
	 * 
	 * @JoinColumn(name="COURSE_ID") private Course course_id;
	 */
	private String name;
	@ManyToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	@JoinTable(name="STUDENT_COURSE",
	joinColumns = {@JoinColumn(name="STUDENT_ID")},
	inverseJoinColumns = {@JoinColumn(name="COURSE_ID")})
	private List<Course> courses = new ArrayList<>();
	
	/*
	 * @OneToMany(mappedBy = "student") Set<StudentCourse> scs;
	 */

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Student(@Min(0) int id, String name, List<Course> courses) {
		super();
		this.id = id;
		this.name = name;
		this.courses = courses;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
}
