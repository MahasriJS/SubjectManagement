
package com.project.collegemanagement.entity;

public class Staff {
	private Long id;
	private String name;
	private Integer age;
	private String dob;
	private String dateOfJoining;
	private Double salary;
	private String domain;
	private String designation;
	private String phno;
	private String email;
	private String address;
	private String departmentName;

	public Staff(Long id, String name, Integer age, String dob, String dateOfJoining, Double salary, String domain,
			String designation, String phno, String email, String address, String departmentName) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.dob = dob;
		this.dateOfJoining = dateOfJoining;
		this.salary = salary;
		this.domain = domain;
		this.designation = designation;
		this.phno = phno;
		this.email = email;
		this.address = address;
		this.departmentName = departmentName;
	}

	public Staff() {
		super();
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

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
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

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String dept_name) {
		this.departmentName = dept_name;
	}

	@Override
	public String toString() {
		return "Staff [id=" + id + ", name=" + name + ", age=" + age + ", dob=" + dob + ", dateOfJoining="
				+ dateOfJoining + ", salary=" + salary + ", domain=" + domain + ", designation=" + designation
				+ ", phno=" + phno + ", email=" + email + ", address=" + address + ", departmentName=" + departmentName
				+ "]";
	}

}
