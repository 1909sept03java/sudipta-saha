package com.expensereimbursementsystem.beans;

public class Employee_Table {
	private int employee_id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private int isAdmin;
	private int manager_id;
	private String m_f;
	private String m_l;
	private Reimbursement_Table rtable;
	public String getM_f() {
		return m_f;
	}
	public void setM_f(String m_f) {
		this.m_f = m_f;
	}
	public String getM_l() {
		return m_l;
	}
	public void setM_l(String m_l) {
		this.m_l = m_l;
	}
	public Reimbursement_Table getRtable() {
		return rtable;
	}
	public void setRtable(Reimbursement_Table rtable) {
		this.rtable = rtable;
	}
	public Employee_Table(int employee_id, String firstName, String lastName, int isAdmin, int manager_id) {
		super();
		this.employee_id = employee_id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.isAdmin = isAdmin;
		this.manager_id = manager_id;
	}
	public Employee_Table(int employee_id, String username, String password, String firstName, String lastName,
			int isAdmin, int manager_id) {
		super();
		this.employee_id = employee_id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.isAdmin = isAdmin;
		this.manager_id = manager_id;
	}
	public Employee_Table() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public int getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}
	public int getManager_id() {
		return manager_id;
	}
	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}
	@Override
	public String toString() {
		return "Employee_Table [employee_id=" + employee_id + ", username=" + username + ", password=" + password
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", isAdmin=" + isAdmin + ", manager_id="
				+ manager_id + ", m_f=" + m_f + ", m_l=" + m_l + ", rtable=" + rtable + "]";
	}
	public Employee_Table(int employee_id, String firstName, String lastName, int isAdmin, int manager_id, String m_f,
			String m_l, Reimbursement_Table rtable) {
		super();
		this.employee_id = employee_id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.isAdmin = isAdmin;
		this.manager_id = manager_id;
		this.m_f = m_f;
		this.m_l = m_l;
		this.rtable = rtable;
	}

}
