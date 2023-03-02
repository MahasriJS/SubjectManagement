package com.project.collegemanagement.service;

import java.util.List;

import com.project.collegemanagement.entity.Subject;
import com.project.collegemanagement.exception.DataBaseCustomException;
import com.project.collegemanagement.exception.ServiceException;
import com.project.collegemanagement.exception.SubjectNotFoundException;

public interface SubjectManagementService {
	/**
	 * 
	 * @param Subject
	 * @throws ServiceException
	 * @throws DataBaseCustomException
	 * @throws SemesterNotFoundException
	 * @throws DepartmentNotFoundException
	 */
	void addSubjectDetails(Subject Subject, Long courseId, Long semId) throws ServiceException;

	/**
	 * 
	 * @return
	 * @throws ServiceException
	 * @throws SubjectNotFoundException
	 * @throws DataBaseCustomException
	 * @throws DepartmentNotFoundException
	 * @throws CourseNotFoundException
	 * @throws SemesterNotFoundException
	 */

	List<Subject> getAllSubject(Long courseId, Long semId) throws ServiceException, SubjectNotFoundException;

}
