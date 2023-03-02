package com.project.collegemanagement.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.project.collegemanagement.dao.SemesterManagementDao;
import com.project.collegemanagement.entity.Semester;
import com.project.collegemanagement.exception.DaoException;
import com.project.collegemanagement.exception.DataBaseCustomException;
import com.project.collegemanagement.util.DBUtil;

public class SemesterManagementDaoImplem implements SemesterManagementDao {

	@Override
	public List<Semester> getAllSemester() throws DaoException {
		List<Semester> semList = new ArrayList<>();
		try (Connection con = DBUtil.getConnection();) {
			Statement st = con.createStatement();
			String query = "SELECT *FROM Semester";

			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				semList.add(new Semester(rs.getLong(1), rs.getString(2)));
			}
		} catch (SQLException | DataBaseCustomException e) {
			e.printStackTrace();
			throw new DaoException(e.getMessage());
		}
		return semList;

	}

}
