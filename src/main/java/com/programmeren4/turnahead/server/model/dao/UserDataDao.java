package com.programmeren4.turnahead.server.model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.programmeren4.turnahead.server.database.DBConnector;
import com.programmeren4.turnahead.shared.dto.LoginDTO;
import com.programmeren4.turnahead.shared.dto.UserDataDTO;
import com.programmeren4.turnahead.shared.exception.DAOException;

public class UserDataDao {
	// attributen
	private Connection conn;
	private String sql;
	//private String tabelnaam = "USER";
	//private String[] tabelvelden = {"USERID","FIRSTNAME","LASTNAME","EMAIL","PASSWORD"};

	
	// constructor
	public UserDataDao() {
	}

	
	// getters en setters
	
	
	//SELECT - UPDATE - INSERT - DELETE - LIST
	/**
	 * SELECT<br>
	 * User/Gebruikerinformatie opvragen uit de database
	 */
	public UserDataDTO getUserData(UserDataDTO userData) throws DAOException {
		UserDataDTO userDataReturn = null;
		ResultSet rs = null;
		
		try {
			DBConnector.getInstance().init();
			this.conn = DBConnector.getInstance().getConn();
			
			sql = "SELECT * FROM programmeren4.USER WHERE USERID=" + userData.getUserId();
			rs = conn.createStatement().executeQuery(sql);
			if (!rs.isBeforeFirst() ) {    
				 System.out.println("No data"); 
			} 
			
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
			DBConnector.getInstance().close(rs);
			DBConnector.getInstance().closeConn();
		}
		return userDataReturn;
	}

	/**
	 * INSERT / UPDATE<br>
	 * User/Gebruiker toevoegen aan de database (INSERT) of een bestaande User/Gebruiker
	 * bijwerken (UPDATE)
	 */
	public void addUserData(UserDataDTO userData) throws DAOException {
		//Userid van UserDataDTO opvragen
		//userData.setUserId(this.getUserId(userData));
		
		// Controle (Bestaat User al in db ?)
		boolean userTest = this.verifyUserId(userData);
		
		try {
			DBConnector.getInstance().init();
			this.conn = DBConnector.getInstance().getConn();
				
			if (userTest == true) {	
				// JA -> UPDATE bestaande record
				// "UPDATE programmeren4.USER SET *='userData.getX()',*='userData.getY()', WHERE USERID="
				// + userData.getUserId();
				String sql = "UPDATE programmeren4.USER SET ";
				sql += "FIRSTNAME='" + userData.getFirstName() + "',";
				sql += "LASTNAME='" + userData.getLastName() + "',";
				sql += "EMAIL='" + userData.getEMail() + "',";
				sql += "PASSWORD='" + userData.getPassword() + "'";
				sql += " WHERE USERID=" + userData.getUserId();
				//System.out.println(sql);
				conn.createStatement().executeUpdate(sql);
			
			} else {
				// NEEN -> User toevoegen aan de database
				// INSERT INTO programmeren4.USER(Columns db) VALUES (userData.getXXX(),
				// userData.getXXX(), userData.getXXX())
				String sql = "INSERT INTO programmeren4.USER(FIRSTNAME, LASTNAME, EMAIL, PASSWORD) VALUES ('";
				sql += userData.getFirstName() + "', '";
				sql += userData.getLastName() + "', '" ;
				sql += userData.getEMail() + "', '";
				sql += userData.getPassword();
				sql += "')";
				System.out.println(sql);
				// ExecuteUpdate ook voor inserts
				conn.createStatement().executeUpdate(sql);
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
	 * DELETE<br>
	 * Gebruiker verwijderen (DELETE)
	 */
	public void deleteUserData(UserDataDTO userData) throws DAOException {
		try {
			DBConnector.getInstance().init();
			this.conn = DBConnector.getInstance().getConn();
			sql = "DELETE FROM programmeren4.USER WHERE USERID=" + userData.getUserId();
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
	 * LIST<br>
	 * Lijst van alle Users/Gebruikers (LIST)
	 */
	public List<UserDataDTO> getUsers() throws SQLException {
		String query = "SELECT * FROM programmeren4.USER";
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
			if (list.isEmpty()) {
				System.out.println("List fetched from database is empty.");
			}
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();	
		} finally {
			DBConnector.close(rs);
			DBConnector.getInstance().closeConn();
		}	
		return list;
	}
	
	//Overige methodes
	/**
	 * Methode om te controleren of een User/Gebruiker al aanwezig is (in de database)
	 * op basis van een UserID
	 */
	public boolean verifyUserId(UserDataDTO userData) throws DAOException{
		ResultSet rs = null;
		boolean inDatabase = false;
		
		try {
			DBConnector.getInstance().init();
			this.conn = DBConnector.getInstance().getConn();;
			sql = "SELECT * FROM programmeren4.USER WHERE USERID=" + userData.getUserId();
			rs = conn.createStatement().executeQuery(sql);
			//System.out.println("userData UserID: " + userData.getUserId());
						
			if (rs.next()){
				long a = new Long(rs.getLong("USERID"));
				//System.out.println(a);
				if ( a == userData.getUserId()){
					inDatabase = true;
					System.out.println("IF-true");
				} else { 
					inDatabase = false;
					System.out.println("IF-false");
				}
			}
				
			System.out.println(inDatabase);
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.getInstance().close(rs);
			DBConnector.getInstance().closeConn();
		}
		return inDatabase;
	}
	
	/**
	 * Methode om te controleren of een User/Gebruiker al aanwezig is (in de database) 
	 * op basis van de e-mail van de User/Gebruiker.
	 */
	public boolean verifyEmailUser(UserDataDTO userData) throws DAOException{
		ResultSet rs = null;
		boolean inDatabase = false;
		
		try {
			DBConnector.getInstance().init();
			this.conn = DBConnector.getInstance().getConn();
			sql = "SELECT * FROM programmeren4.USER WHERE EMAIL=" + "'" + userData.getEMail().toUpperCase() + "'";
			rs = conn.createStatement().executeQuery(sql);
			//System.out.println("DTO: " +userData.getEMail());
			
			if (rs.next()){
				//System.out.println("Numbers of rows: " + rs.getRow());
				if (rs.getRow() == 1 & new String(rs.getString("EMAIL").toUpperCase()).equals(userData.getEMail().toUpperCase())){
					inDatabase = true;
				} else { 
					inDatabase = false;
				}
			}
			System.out.println(inDatabase);
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.getInstance().close(rs);
			DBConnector.getInstance().closeConn();
		}
		return inDatabase;
	}
	
	/**
	 * Methode om de UserId van een User/Gebruiker op te vragen op basis van de 
	 * e-mail (case sensitive) van een User/Gebruiker 
	 */
	public long getUserId(UserDataDTO userData) throws DAOException{
		ResultSet rs = null;
		long userId = 0;
		
		try {
			DBConnector.getInstance().init();
			this.conn = DBConnector.getInstance().getConn();
			sql = "SELECT * FROM programmeren4.USER WHERE EMAIL=" + "'" + userData.getEMail() + "'";
			rs = conn.createStatement().executeQuery(sql);
			
			if (rs.next()){
				if (rs.getRow() == 1 & new String(rs.getString("EMAIL").toUpperCase()).equals(userData.getEMail().toUpperCase())){
					userId = rs.getLong("USERID");
				}
			}
			
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.getInstance().close(rs);
			DBConnector.getInstance().closeConn();
		}
		return userId;
	}
	
}
