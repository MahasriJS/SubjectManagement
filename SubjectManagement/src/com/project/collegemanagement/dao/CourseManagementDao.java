package com.project.collegemanagement.dao;

import java.util.List;

import com.project.collegemanagement.entity.Course;
import com.project.collegemanagement.exception.DaoException;

public interface CourseManagementDao {
	/**
	 * 
	 * @param departmentId
	 * @return
	 * @throws DaoException
	 */
	List<Course> getAllCourseByDept(Long departmentId) throws DaoException;

}
