package com.project.collegemanagement.client;

import com.project.collegemanagement.exception.ServiceException;
import com.project.collegemanagement.exception.SubjectNotFoundException;

public interface SubjectManagementClient {
	/**
	 * 
	 */
	void insertSubject();

	/**
	 * 
	 * @throws SubjectNotFoundException
	 * @throws ServiceException
	 */
	void getAllSubject();
}
