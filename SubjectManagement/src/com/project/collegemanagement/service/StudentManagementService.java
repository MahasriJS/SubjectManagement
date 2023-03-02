package com.project.collegemanagement.service;

import com.project.collegemanagement.entity.Student;
import com.project.collegemanagement.exception.DataBaseCustomException;
import com.project.collegemanagement.exception.ServiceException;
import com.project.collegemanagement.exception.StudentNotFoundException;

public interface StudentManagementService {
	/**
	 * 
	 * @param Student
	 * @param departmentId
	 * @throws ServiceException
	 */
	void addStudentDetails(Student Student, Long departmentId) throws ServiceException;

	/**
	 * 
	 * @param userOption
	 * @param Student
	 * @param updateDeptId
	 * @throws ServiceException
	 */

	void updateStudentDetails(Integer userOption, Student Student, Long updateDeptId) throws ServiceException;

	/**
	 * 
	 * @param student
	 * @throws ServiceException
	 */

	void deleteStudentDetails(Student student) throws ServiceException;

	/**
	 * 
	 * @throws ServiceException
	 * @throws StudentNotFoundException
	 */

	void getAllStudent() throws ServiceException, StudentNotFoundException;

	/**
	 * 
	 * @param email
	 * @return
	 * @throws StudentNotFoundException
	 * @throws ServiceException
	 * @throws DataBaseCustomException
	 */

	Student getStudentByEmail(String email) throws StudentNotFoundException, ServiceException;

}
