package com.project.collegemanagement.entity;

public class Subject {
	private Long id;
	private String code;
	private String name;
	private String description;
	private Integer credits;
	private String courseName;
	private String deptName;
	private String semName;

	public Subject(Long id, String code, String name, String description, Integer credits, String courseName,
			String deptName) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.description = description;
		this.credits = credits;
		this.courseName = courseName;
		this.deptName = deptName;
	}

	public Subject() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getSemName() {
		return semName;
	}

	public void setSemName(String semName) {
		this.semName = semName;
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", code=" + code + ", name=" + name + ", description=" + description + ", credits="
				+ credits + ", courseName=" + courseName + ", deptName=" + deptName + ", semName=" + semName + "]";
	}

}
