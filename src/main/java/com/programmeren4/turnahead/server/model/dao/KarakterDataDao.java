package com.programmeren4.turnahead.server.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.programmeren4.turnahead.server.database.DBConnector;
import com.programmeren4.turnahead.shared.dto.KarakterDTO;
import com.programmeren4.turnahead.shared.exception.DAOException;

public class KarakterDataDao {
	//attributen
	private Connection conn;
	private String sql;
	
	//constructor
	public KarakterDataDao() {}
	
	
	//getters en setters
	
	
	//methoden
	/**
	 * Opvragen
	 */
	public KarakterDTO getUserData(KarakterDTO userData) throws DAOException {
		KarakterDTO karakterReturn = null;
		ResultSet rs = null;
		try {
			Class.forName(DBConnector.DRIVER_CLASS).newInstance();
			DBConnector.getInstance().init();
			this.conn = DBConnector.getInstance().getConn();
			sql = "SELECT * FROM KARAKTER WHERE CHARACTERID=" + userData.getKarakterId();
			rs = conn.createStatement().executeQuery(sql);
			if (rs.next()) {
				karakterReturn = new KarakterDTO();
				karakterReturn.setKarakterId(rs.getLong("CHARACTERID"));
				karakterReturn.setKarakterName(rs.getString("CHARACTERNAME"));
				karakterReturn.setCurrentLocation(rs.getString("CURRENTLOCATION"));
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.getInstance().close(rs);
			DBConnector.getInstance().closeConn();
		}
		return karakterReturn;
	}
	
	/**
	 * Toevoegen wijzigen
	 */
	
	
	/**
	 * Verwijderen
	 */
	public void deleteUserData(KarakterDTO userData) throws DAOException {
		try {
			Class.forName(DBConnector.DRIVER_CLASS).newInstance();
			DBConnector.getInstance().init();
			this.conn = DBConnector.getInstance().getConn();
			sql = "DELETE FROM KARAKTER WHERE CHARACTERID=" + userData.getKarakterId();
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
	 * List
	 */
}
