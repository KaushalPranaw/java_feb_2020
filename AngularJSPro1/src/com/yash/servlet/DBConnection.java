package com.yash.servlet;

import java.sql.*;

public class DBConnection {
	static Connection getConnection() throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
	}
}
