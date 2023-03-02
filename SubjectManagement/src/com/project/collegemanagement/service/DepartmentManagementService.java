package com.project.collegemanagement.service;

import java.util.List;

import com.project.collegemanagement.entity.Department;
import com.project.collegemanagement.exception.DataBaseCustomException;
import com.project.collegemanagement.exception.ServiceException;

public interface DepartmentManagementService {
	/**
	 * 
	 * @return
	 * @throws ServiceException
	 * @throws DataBaseCustomException
	 */
	List<Department> getAllDepartment() throws ServiceException;
}
