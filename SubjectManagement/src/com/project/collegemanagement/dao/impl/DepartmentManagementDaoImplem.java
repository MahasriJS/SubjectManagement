package com.project.collegemanagement.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.project.collegemanagement.dao.DepartmentManagementDao;
import com.project.collegemanagement.entity.Department;
import com.project.collegemanagement.exception.DaoException;
import com.project.collegemanagement.exception.DataBaseCustomException;
import com.project.collegemanagement.util.DBUtil;

public class DepartmentManagementDaoImplem implements DepartmentManagementDao {

	@Override
	public List<Department> getAllDepartment() throws DaoException {
		List<Department> deptList = new ArrayList<>();
		try (Connection con = DBUtil.getConnection();) {
			Statement st = con.createStatement();
			String query = "SELECT * FROM department";
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				deptList.add(new Department(rs.getLong(1), rs.getString(2), rs.getString(3)));
			}
		} catch (SQLException | DataBaseCustomException e) {
			e.printStackTrace();
			throw new DaoException(e.getMessage());
		}
		return deptList;

	}

}