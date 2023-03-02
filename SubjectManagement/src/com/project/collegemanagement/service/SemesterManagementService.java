package com.project.collegemanagement.service;

import java.util.List;

import com.project.collegemanagement.entity.Semester;
import com.project.collegemanagement.exception.DataBaseCustomException;
import com.project.collegemanagement.exception.ServiceException;

public interface SemesterManagementService {
	/**
	 * 
	 * @return
	 * @throws DataBaseCustomException
	 * @throws SemesterNotFoundException
	 */
	List<Semester> getAllSemester() throws ServiceException;

}
