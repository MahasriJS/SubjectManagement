package com.project.collegemanagement.service;

import java.sql.SQLException;
import java.util.List;

import com.project.collegemanagement.entity.Course;
import com.project.collegemanagement.exception.DataBaseCustomException;
import com.project.collegemanagement.exception.ServiceException;

public interface CourseManagementService {
	/**
	 * 
	 * @param departmentId
	 * @return
	 * @throws ServiceException
	 * @throws DataBaseCustomException
	 * @throws SQLException
	 * @throws CourseNotFoundException
	 */
	List<Course> getAllCourseByDept(Long departmentId) throws ServiceException;
}
