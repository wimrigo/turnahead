package com.programmeren4.turnahead.server.database;

import java.sql.*;


public class DBConnector {	
	//Gegevens DB programmeren4
	//JBDC Connection URL: ec2-50-19-213-178.compute-1.amazonaws.com:3306/programmeren4
	//DatabaseName: cb_programmeren4
	//USN: prog4
	//PW: programmeren4
	
	public static final String URL = "us-cdbr-cb-east-01.cleardb.net:3306/cb_faandgtestdb";
    public static final String USER = "bb747cf5e0067f";
    public static final String PASSWORD = "554e032d";
    public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver"; 
    private static DBConnector _instance = null;
	private Connection conn = null;
	
	
    public static synchronized DBConnector getInstance() {
		if (_instance == null) {
			_instance = new DBConnector();
		}
		return _instance;
	}
    
    public void init(){
    	System.out.println("Connection initiated");
		try {
			this.conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Connection set");
			
		} catch (SQLException e1) {
			System.out.println("Connection Failed");
		}		
		System.out.println("Connection confirmed");
    }
	
	public Connection getConn() {
		return this.conn;
	}
	
	public void closeConn() {
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
