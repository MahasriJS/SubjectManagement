package com.project.collegemanagement.service.implem;

import java.util.List;

import com.project.collegemanagement.dao.CourseManagementDao;
import com.project.collegemanagement.dao.impl.CourseManagementDaoImplem;
import com.project.collegemanagement.entity.Course;
import com.project.collegemanagement.exception.DaoException;
import com.project.collegemanagement.exception.ServiceException;
import com.project.collegemanagement.service.CourseManagementService;

public class CourseManagementServiceImplem implements CourseManagementService {
	CourseManagementDao courseDaoImpl = new CourseManagementDaoImplem();

	@Override
	public List<Course> getAllCourseByDept(Long departmentId) throws ServiceException {
		List<Course> courseList;
		try {
			courseList = courseDaoImpl.getAllCourseByDept(departmentId);
		} catch (DaoException e) {
			System.out.println(e);
			throw new ServiceException(e.getMessage());
		}

		return courseList;
	}

}
