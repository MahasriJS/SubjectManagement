package com.project.collegemanagement.entity;

public class Student {
	private Long id;
	private String name;
	private Integer age;
	private String dob;
	private String dateOfJoining;
	private String phno;
	private String email;
	private String address;
	private String courseName;
	private String departmentName;
		public Student() {
		super();
	}
	
	public Student(Long id, String name, Integer age, String dob, String dateOfJoining, String phno, String email,
			String address,  String departmentName) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.dob = dob;
		this.dateOfJoining = dateOfJoining;
		this.phno = phno;
		this.email = email;
		this.address = address;
		this.departmentName= departmentName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getCourseName() {
	return courseName;
	}
	public void setCourseName(String courseName) {
	this.courseName = courseName;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", dob=" + dob + ", dateOfJoining="
				+ dateOfJoining + ", phno=" + phno + ", email=" + email + ", address=" + address + ", departmentName="
				+ departmentName + "]";
	}
		
	

}
