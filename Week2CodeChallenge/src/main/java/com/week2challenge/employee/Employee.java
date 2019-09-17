package com.week2challenge.employee;

public class Employee {
	private int id;
	private String firstName;
	private String lastName;
	private int depratment_id;
	private String email;
	private int avg;
	private String depName;
	public Employee(int depratment_id, String depName, int avg) {
		super();
		this.depratment_id = depratment_id;
		this.avg = avg;
		this.depName = depName;
	}
	public int getAvg() {
		return avg;
	}
	public void setAvg(int avg) {
		this.avg = avg;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int id, String firstName, String lastName, int depratment_id, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.depratment_id = depratment_id;
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getDepratment_id() {
		return depratment_id;
	}
	public void setDepratment_id(int depratment_id) {
		this.depratment_id = depratment_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	
	
}
