package com.programmeren4.turnahead.server.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.programmeren4.turnahead.server.database.DBConnector;
import com.programmeren4.turnahead.shared.dto.KarakterDTO;
import com.programmeren4.turnahead.shared.exception.DAOException;

public class KarakterDataDao {
	//attributen
	private Connection conn;
	private String sql;
	//private String tabelnaam = "KARAKTER";
	//private String[] tabelvelden = {"","","",""};
	
	//constructor
	public KarakterDataDao() {}
	
	
	//getters en setters
	
	
	//methoden
	/**
	 * Gegevens van een karakter opvragen (SELECT)
	 */
	public KarakterDTO getKarakterData(KarakterDTO karakterData) throws DAOException {
		KarakterDTO karakterReturn = null;
		ResultSet rs = null;
		try {
			Class.forName(DBConnector.DRIVER_CLASS).newInstance();
			DBConnector.getInstance().init();
			this.conn = DBConnector.getInstance().getConn();
			sql = "SELECT * FROM programmeren4.KARAKTER WHERE CHARACTERID=" + karakterData.getKarakterId();
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
	 * Karakter toevoegen (INSERT) of wijzigen (UPDATE)<br>
	 * 
	 */
	public void addKarakterData(KarakterDTO karakterData) throws DAOException {
			
		try {
			DBConnector.getInstance().init();
			this.conn = DBConnector.getInstance().getConn();
			
			// Controle (Karakter al in de database ?)
			if (this.checkKarakter(karakterData) == true) {
				// JA -> UPDATE bestaande record
				// "UPDATE programmeren4.KARAKTER SET *veld='karakterData.getX()',*veld='karakterData.getY()', 
				//"WHERE KARAKTERID=" + karakterData.getKarakterId();
				String sql = "UPDATE programmeren4.KARAKTER SET ";
				
				sql += "WHERE KARAKTERID=" + karakterData.getKarakterId();

				conn. createStatement().executeUpdate(sql);
			} else {
				// NEEN -> Karakter toevoegen aan de database>
				// INSERT INTO programmeren4.KARAKTER(Columns db) VALUES (karakterData.getXXX(),
				// karakterData.getYYY(), karakterData.getZZZ())
				String sql = "INSERT INTO programmeren4.KARAKTER VALUES ('";
				sql += karakterData.getKarakterId() + ",";
				sql += karakterData.getKarakterName() + ",";
				//we plaatsen het karakter default op de eerste locatie in de tabel Location
				sql += " 1,";
				sql += "')";
				conn.createStatement().executeUpdate(sql);
				// ExecuteUpdate ook voor inserts
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
	 * Methode om te controleren of een karakter al aanwezig is (in de database)
	 */
	public boolean checkKarakter(KarakterDTO karakterData) throws DAOException{
		ResultSet rs = null;
		boolean inDatabase = false;
		
		try {
			Class.forName(DBConnector.DRIVER_CLASS).newInstance();
			DBConnector.getInstance().init();
			this.conn = DBConnector.getInstance().getConn();
			sql = "SELECT * FROM programmeren4.KARAKTER WHERE CHARACTERID=" + karakterData.getKarakterId();
			rs = conn.createStatement().executeQuery(sql);
			
			
			if (rs.getLong("CHARACTERID")== karakterData.getKarakterId()){
				inDatabase = true;
			} else { 
				inDatabase = false;
			}

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
	 * Karakter verwijderen (DELETE)
	 */
	public void deleteKarakterData(KarakterDTO userData) throws DAOException {
		try {
			Class.forName(DBConnector.DRIVER_CLASS).newInstance();
			DBConnector.getInstance().init();
			this.conn = DBConnector.getInstance().getConn();
			sql = "DELETE FROM programmeren4.KARAKTER WHERE CHARACTERID=" + userData.getKarakterId();
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
	 * Lijst van alle karakters (LIST)
	 */
	public List<KarakterDTO> getKarakters() throws DAOException  {
		List<KarakterDTO> list = new ArrayList<KarakterDTO>();
		ResultSet rs = null;
		
		try {
			DBConnector.getInstance().init();
			String query = "SELECT * FROM programmeren4.KARAKTER";
			KarakterDTO karakterReturn = null;
			
			this.conn = DBConnector.getInstance().getConn();
			rs = conn.createStatement().executeQuery(query);

			while (rs.next()) {
				karakterReturn.setKarakterId(rs.getLong("CHARACTERID"));
				karakterReturn.setKarakterName(rs.getString("CHARACTERNAME"));
				karakterReturn.setCurrentLocation(rs.getString("CURRENTLOCATION"));

				list.add(karakterReturn);
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
			DBConnector.getInstance().close(rs);
			DBConnector.getInstance().closeConn();
		}
		return list;
	}
	

}
