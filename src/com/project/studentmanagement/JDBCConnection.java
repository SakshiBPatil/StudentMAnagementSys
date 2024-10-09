package com.project.studentmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {

	 static String url = "jdbc:mysql://localhost:3306/studentmanagementsystem";
	static String userName = "root";
	static String password = "root";
	
	public static Connection getConnection() {
			try {
				return DriverManager.getConnection(url, userName, password);
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
	}
	
	
	/*
	 * public static void main(String[] args) {
	 * 
	 * try { try { Class.forName("com.mysql.cj.jdbc.Driver"); } catch
	 * (ClassNotFoundException e) { e.printStackTrace(); }
	 * 
	 * 
	 * 
	 * Connection con =
	 * 
	 * if (con.isClosed()) { System.out.println("Connection closed"); } else {
	 * System.out.println("Connection created"); }
	 * 
	 * } catch (SQLException e) { e.printStackTrace(); }
	 * 
	 * 
	 * 
	 * 
	 * }
	 */

}
