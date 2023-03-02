package com.project.collegemanagement.service.implem;

import java.util.List;

import com.project.collegemanagement.dao.impl.SemesterManagementDaoImplem;
import com.project.collegemanagement.entity.Semester;
import com.project.collegemanagement.exception.DaoException;
import com.project.collegemanagement.exception.ServiceException;
import com.project.collegemanagement.service.SemesterManagementService;

public class SemesterManagementServiceImplem implements SemesterManagementService {
	SemesterManagementDaoImplem semDaoImpl = new SemesterManagementDaoImplem();

	public List<Semester> getAllSemester() throws ServiceException {
		List<Semester> semList;
		try {
			semList = semDaoImpl.getAllSemester();
		} catch (DaoException e) {
			System.out.println(e);
			throw new ServiceException(e.getMessage());
		}

		return semList;
	}

}
