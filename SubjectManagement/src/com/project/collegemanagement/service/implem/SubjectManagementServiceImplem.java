package com.project.collegemanagement.service.implem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.project.collegemanagement.dao.impl.SubjectManagementDaoImplem;
import com.project.collegemanagement.entity.Subject;
import com.project.collegemanagement.exception.DaoException;
import com.project.collegemanagement.exception.ServiceException;
import com.project.collegemanagement.exception.SubjectNotFoundException;
import com.project.collegemanagement.service.SubjectManagementService;

public class SubjectManagementServiceImplem implements SubjectManagementService {
	SubjectManagementDaoImplem subjectDaoImpl = new SubjectManagementDaoImplem();

	@Override
	public void addSubjectDetails(Subject subject, Long courseId, Long semId) throws ServiceException {

		try {
			subjectDaoImpl.addSubjectDetails(subject, courseId, semId);

		} catch (DaoException e) {
			System.out.println(e);
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public List<Subject> getAllSubject(Long courseId, Long semId) throws ServiceException, SubjectNotFoundException {
		List<Subject> subjectsList;
		try {

			subjectsList = new ArrayList<>();

			subjectsList = subjectDaoImpl.getAllSubject(courseId, semId);
			if (!subjectsList.isEmpty()) {
				Iterator<Subject> subjectsItr = subjectsList.iterator();
				while (subjectsItr.hasNext()) {
					subjectsItr.next();
				}
			} else {
				throw new SubjectNotFoundException("Subject Not found");
			}
		} catch (DaoException e) {
			System.out.println(e);
			throw new ServiceException(e.getMessage());
		}

		return subjectsList;
	}

}
