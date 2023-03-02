package com.project.collegemanagement.client;

import com.project.collegemanagement.exception.InvalidChoiceException;
import com.project.collegemanagement.exception.ServiceException;
import com.project.collegemanagement.exception.StudentCustomException;
import com.project.collegemanagement.exception.StudentNotFoundException;

public interface StudentManagementClient {
	/**
	 * 
	 * @throws StudentCustomException
	 */
	void insertStudent();

	/**
	 * 
	 * @throws InvalidChoiceException
	 */
	void updateStudent();

	/**
	 * 
	 * @throws StudentNotFoundException
	 * @throws ServiceException
	 */
	void deleteStudent();

	/**
	 * 
	 * @throws StudentNotFoundException
	 * @throws ServiceException
	 */
	void getAllStudent();

	/**
	 * 
	 * @throws StudentNotFoundException
	 * @throws ServiceException
	 */
	void getStudentByEmail();
}
