package com.programmeren4.turnahead.server.database;

import java.sql.*;


public class DBConnector {	
	//Gegevens DB programmeren4
	//JBDC Connection URL: ec2-50-19-213-178.compute-1.amazonaws.com:3306/programmeren4
	//DatabaseName: cb_programmeren4
	//USN: prog4
	//PW: programmeren4
	
	private static Connection CONN = null;
	public static final String URL = "ec2-50-19-213-178.compute-1.amazonaws.com:3306/programmeren4";
    public static final String USER = "prog4";
    public static final String PASSWORD = "programmeren4";
    public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver"; 
	
	
	//constructor 
	public DBConnector() {
		initConn();
	}
	
	//method
	private void initConn() {
		System.out.println("Connection initiated");
		try {
			DBConnector.CONN = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Connection set");
		} catch (SQLException e1) {
			System.out.println("Connection Failed");
		}		
		System.out.println("Connection confirmed");
	}
	
	public static Connection getConn() {
		return CONN;
	}
	
	public static void closeConn() {
		try {
			getConn().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
