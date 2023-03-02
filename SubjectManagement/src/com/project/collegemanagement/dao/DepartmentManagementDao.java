package com.project.collegemanagement.dao;

import java.util.List;

import com.project.collegemanagement.entity.Department;
import com.project.collegemanagement.exception.DaoException;
import com.project.collegemanagement.exception.DataBaseCustomException;

public interface DepartmentManagementDao {
	/**
	 * 
	 * @return
	 * @throws DaoException
	 * @throws DataBaseCustomException
	 */
	List<Department> getAllDepartment() throws DaoException;
}
