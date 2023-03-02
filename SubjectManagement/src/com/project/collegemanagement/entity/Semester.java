package com.project.collegemanagement.entity;

public class Semester {
	private Long id;
	private String name;

	public Semester() {
		super();
	}

	public Semester(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	@Override
	public String toString() {
		return "Semester [id=" + id + ", name=" + name + "]";
	}

}
