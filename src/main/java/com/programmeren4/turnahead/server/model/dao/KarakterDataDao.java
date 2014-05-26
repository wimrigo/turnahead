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
	
	
	//SELECT - UPDATE - INSERT - DELETE - LIST
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
	 * TODO: default location (locationDAO),
	 */
	public void addKarakterData(KarakterDTO karakterData) throws DAOException {
		
		karakterData.setKarakterId(this.getKarakterId(karakterData));
		boolean karakterTest = this.checkKarakter(karakterData);
		
		try {
			DBConnector.getInstance().init();
			this.conn = DBConnector.getInstance().getConn();
			
			// Controle (Karakter al in de database ?)
			if (karakterTest == true) {
				// JA -> UPDATE bestaande record
				// "UPDATE programmeren4.KARAKTER SET *veld='karakterData.getX()',*veld='karakterData.getY()', 
				//"WHERE KARAKTERID=" + karakterData.getKarakterId();
				String sql = "UPDATE programmeren4.KARAKTER SET ";
				sql += "CHARACTERNAME=" + karakterData.getKarakterName();
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
	 * Karakter verwijderen (DELETE)
	 */
	public void deleteKarakterData(KarakterDTO karakterData) throws DAOException {
		
		karakterData.setKarakterId(this.getKarakterId(karakterData));
		
		try {
			Class.forName(DBConnector.DRIVER_CLASS).newInstance();
			DBConnector.getInstance().init();
			this.conn = DBConnector.getInstance().getConn();
			sql = "DELETE FROM programmeren4.KARAKTER WHERE CHARACTERID=" + karakterData.getKarakterId();
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
	
	//Overige methodes
	/**
	 * Methode om te controleren of een karakter al aanwezig is (in de database)
	 */
	public boolean checkKarakter(KarakterDTO karakterData) throws DAOException{
		ResultSet rs = null;
		boolean inDatabase = false;
		
		karakterData.setKarakterId(this.getKarakterId(karakterData));
		
		try {
			Class.forName(DBConnector.DRIVER_CLASS).newInstance();
			DBConnector.getInstance().init();
			this.conn = DBConnector.getInstance().getConn();
			sql = "SELECT * FROM programmeren4.KARAKTER WHERE CHARACTERID=" + karakterData.getKarakterId();
			rs = conn.createStatement().executeQuery(sql);
			//System.out.println("karakterData KarakterID: " + userData.getUserId());
						
			if (rs.next()){
				long a = new Long(rs.getLong("CHARACTERID"));
				//System.out.println(a);
				if ( a == karakterData.getKarakterId()){
					inDatabase = true;
					//System.out.println("IF-true");
				} else { 
					inDatabase = false;
					//System.out.println("IF-false");
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
	 * Methode om KarakterID van een Karakter op te vragen
	 */
	public long getKarakterId(KarakterDTO karakterData) throws DAOException{
		ResultSet rs = null;
		long karakterId = 0;
		
		try {
			Class.forName(DBConnector.DRIVER_CLASS).newInstance();
			DBConnector.getInstance().init();
			this.conn = DBConnector.getInstance().getConn();
			sql = "SELECT * FROM programmeren4.KARAKTER WHERE CHARACTERNAME=" + "'" + karakterData.getKarakterName()  + "'";
			rs = conn.createStatement().executeQuery(sql);
			//System.out.println("DTO: " +userData.getEMail());
			
			if (rs.next()){
				//System.out.println("Numbers of rows: " + rs.getRow());
				if (rs.getRow() == 1 & new String(rs.getString("CHARACTERNAME")).equals(karakterData.getKarakterName())){
					karakterId = rs.getLong("CHARACTERID");
				}
				System.out.println(karakterId);
			}
			
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.getInstance().close(rs);
			DBConnector.getInstance().closeConn();
		}
		return karakterId;
	}

}
