package com.project.collegemanagement.entity;

public class Course {
	private Long id;
	private String code;
	private String name;
	private Integer duration;
	private String deptName;

	public Course() {
		super();
	}

	public Course(Long id, String code, String name, Integer duration, String deptName) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.duration = duration;
		this.deptName = deptName;
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

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", code=" + code + ", name=" + name + ", duration=" + duration + ", deptName="
				+ deptName + "]";
	}

}
