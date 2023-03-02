package com.project.collegemanagement.service.implem;

import java.util.List;

import com.project.collegemanagement.dao.impl.DepartmentManagementDaoImplem;
import com.project.collegemanagement.entity.Department;
import com.project.collegemanagement.exception.DaoException;
import com.project.collegemanagement.exception.ServiceException;
import com.project.collegemanagement.service.DepartmentManagementService;

public class DepartmentManagementServiceImplem implements DepartmentManagementService {
	DepartmentManagementDaoImplem deptDaoImpl = new DepartmentManagementDaoImplem();

	public List<Department> getAllDepartment() throws ServiceException {
		List<Department> deptList;
		try {
			deptList = deptDaoImpl.getAllDepartment();
		} catch (DaoException e) {
			System.out.println(e);
			throw new ServiceException(e.getMessage());
		}
		return deptList;
	}

}
