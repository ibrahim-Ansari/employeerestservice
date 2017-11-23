package com.employee.service.employeeDao;

import java.sql.Connection;
import java.sql.DriverManager;

/***
 * Create DB connection for the application
 * @author Ibrahim
 *
 */
public class DBConnection {
	public static Connection getConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "root");
	}
}

