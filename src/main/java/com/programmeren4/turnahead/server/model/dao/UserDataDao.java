package com.programmeren4.turnahead.server.model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.programmeren4.turnahead.server.database.DBConnector;
import com.programmeren4.turnahead.shared.dto.UserDataDTO;
import com.programmeren4.turnahead.shared.exception.DAOException;

public class UserDataDao {
	// attributen
	private Connection conn;
	private String sql;

	// constructor
	public UserDataDao() {}

	
	//getters en setters
	
	
	//methoden
	/**
	 * Gebruikerinformatie opvragen uit de database
	 */
	public UserDataDTO getUserData(UserDataDTO userData) throws SQLException {
		UserDataDTO userDataReturn = null;
		ResultSet rs = null;
		try {
			Class.forName(DBConnector.DRIVER_CLASS).newInstance();
			this.conn = DBConnector.getInstance().getConn();
			sql = "SELECT * FROM USER WHERE USERID=" + userData.getUserId();
			rs = conn.createStatement().executeQuery(sql);
			if (rs.next()) {
				userDataReturn = new UserDataDTO();
				userDataReturn.setUserId(rs.getLong("USERID"));
				userDataReturn.setFirstName(rs.getString("FIRSTNAME"));
				userDataReturn.setLastName(rs.getString("LASTNAME"));
				userDataReturn.setEMail(rs.getString("EMAIL"));
				userDataReturn.setPassword(rs.getString("PASSWORD"));
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.close(rs);
			DBConnector.getInstance().closeConn();
		}
		return userDataReturn;
	}

	/**
	 * Gebruiker toevoegen aan de database (INSERT) of een bestaande gebruiker bijwerken (UPDATE)
	 */
	public void addUserData(UserDataDTO userData) throws SQLException {
		boolean indatabase = false;

		try {
			DBConnector.getInstance().init();
			this.conn = DBConnector.getInstance().getConn();
			//Controle (Bestaat User al in db ?)

			if (indatabase == true) {
				// JA -> UPDATE bestaande record 
				// "UPDATE USER SET *='userData.getX()',*='userData.getY()', WHERE USERID=" + userData.getUserId();
				String sql = "UPDATE USER SET "; 
				sql += "FIRSTNAME='" + userData.getFirstName() +  "',";
				sql += "LASTNAME='" + userData.getLastName() +  "',";
				sql += "EMAIL='" + userData.getEMail() +  "',";
				sql += "PASSWORD='" + userData.getPassword() +  "',";
				sql += " WHERE USERID=" + userData.getUserId();
				conn.createStatement().executeUpdate(sql);
			} else {
				// NEEN -> User toevoegen aan de database> 
				// INSERT INTO USER(Columns db) VALUES (userData.getXXX(), userData.getXXX(), userData.getXXX())
				String sql = "INSERT INTO USER(FIRSTNAME, LASTNAME, EMAIL, PASSWORD) VALUES (" ;
				sql += userData.getFirstName() + ", " + userData.getLastName() + ", " + userData.getEMail() + ", " + userData.getPassword() ;
				sql += ")";
				conn.createStatement().executeUpdate(sql);
				//ExecuteUpdate ook voor inserts
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.getInstance().closeConn();
		}
	}

	/**
	 * Gebruiker verwijderen uit de db
	 */
	public void deleteUserData(UserDataDTO userData) throws DAOException {

		try {
			Class.forName(DBConnector.DRIVER_CLASS).newInstance();
			this.conn = DBConnector.getInstance().getConn();
			sql = "DELETE FROM USER WHERE USERID=" + userData.getUserId();
			conn.createStatement().executeUpdate(sql);
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.getInstance().closeConn();
		}
	}

	/**
	 * Alle gebruikers uit de db ophalen
	 */
	public List<UserDataDTO> getUsers() throws SQLException {
		String query = "SELECT * FROM USER";
		List<UserDataDTO> list = new ArrayList<UserDataDTO>();
		UserDataDTO userDataReturn = null;
		ResultSet rs = null;
		try {
			DBConnector.getInstance().init();
			this.conn = DBConnector.getInstance().getConn();
			rs = conn.createStatement().executeQuery(query);

			while (rs.next()) {
				userDataReturn = new UserDataDTO();
				userDataReturn.setUserId(rs.getLong("USERID"));
				userDataReturn.setFirstName(rs.getString("FIRSTNAME"));
				userDataReturn.setLastName(rs.getString("LASTNAME"));
				userDataReturn.setEMail(rs.getString("EMAIL"));
				userDataReturn.setPassword(rs.getString("PASSWORD"));
				list.add(userDataReturn);
			}
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			DBConnector.close(rs);
			DBConnector.getInstance().closeConn();
		}
		return list;
	}
}
