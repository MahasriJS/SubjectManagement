package com.project.collegemanagement.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.project.collegemanagement.exception.DataBaseCustomException;

public class DBUtil {
	public static Connection getConnection() throws DataBaseCustomException {
		String url = "jdbc:mysql://localhost:3306/college";
		String username = "root";
		String pwd = "JesusLove@31";
		Connection con = null;
		try {
			// Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, pwd);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataBaseCustomException("Doesn't connect to data base");
		}
		return con;
	}
}