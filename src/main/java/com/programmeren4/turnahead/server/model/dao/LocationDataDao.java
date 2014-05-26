package com.programmeren4.turnahead.server.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.programmeren4.turnahead.server.database.DBConnector;
import com.programmeren4.turnahead.shared.dto.LocationDTO;
import com.programmeren4.turnahead.shared.exception.DAOException;

public class LocationDataDao {
	//attributen
	private Connection conn;
	private String sql;
	//private String tabelnaam = "LOCATION";
	//private String[] tabelvelden = {"LOCATIONID","LOCATION_NAME","LOCATION_DESCRIPTION"};
	
	//constructor
	public LocationDataDao() {}
	
	
	//getters en setters
	
	
	//SELECT - UPDATE - INSERT - DELETE - LIST
	/**
	 * Gegevens van een Location opvragen (SELECT)
	 */
	public LocationDTO getLocationData(LocationDTO locationData) throws DAOException {
		LocationDTO locationReturn = null;
		ResultSet rs = null;

		try {
			DBConnector.getInstance().init();
			this.conn = DBConnector.getInstance().getConn();
			sql = "SELECT * FROM programmeren4.LOCATION WHERE LOCATIONID=" + locationData.getLocationId();
			rs = conn.createStatement().executeQuery(sql);
			if (!rs.isBeforeFirst() ) {    
				 System.out.println("No data"); 
			} 
			
			if (rs.next()) {
				locationReturn = new LocationDTO();
				locationReturn.setLocationId(rs.getLong("LOCATIONID"));
				locationReturn.setLocationName(rs.getString("LOCATION_NAME"));
				locationReturn.setLocationDescription(rs.getString("LOCATION_DESCRIPTION"));
				System.out.println(locationReturn);
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.getInstance().close(rs);
			DBConnector.getInstance().closeConn();
		}
		return locationReturn;
	}
	
	
	/**
	 * Location toevoegen (INSERT) of wijzigen (UPDATE)
	 */
	public void addLocationData(LocationDTO locationData) throws DAOException {		
		// Controle (Bestaat Locatie al in tabel Location ?)
		boolean locationTest = this.verifyLocationId(locationData);
		
		try {
			DBConnector.getInstance().init();
			this.conn = DBConnector.getInstance().getConn();
			
			if (locationTest == true) {
				// JA -> UPDATE bestaande record
				// "UPDATE programmeren4.LOCATION SET *veld='locationData.getX()',*veld='locationData.getY()', 
				// "WHERE LOCATIONID=" + karakterData.getKarakterId();
				String sql = "UPDATE programmeren4.LOCATION SET";
				sql += " LOCATION_NAME='" + locationData.getLocationName().toUpperCase() + "',";
				sql += " LOCATION_DESCRIPTION='" + locationData.getLocationDescription() + "'";
				sql += " WHERE LOCATIONID=" + locationData.getLocationId();
				conn.createStatement().executeUpdate(sql);
				
			} else {
				// NEEN -> INSERT toevoegen aan de database>
				// INSERT INTO programmeren4.LOCATION(Columns db) VALUES (locationData.getX(),
				// locationData.getY(), locationData.getZ())
				String sql = "INSERT INTO programmeren4.LOCATION(";
				sql += " LOCATION_NAME, LOCATION_DESCRIPTION) VALUES ('";
				sql += locationData.getLocationName().toUpperCase() +"', '";
				sql += locationData.getLocationDescription();
				sql += "')";
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
	 * Location verwijderen (DELETE)
	 */
	public void deleteLocationData(LocationDTO locationData) throws DAOException {
		
		try {
			DBConnector.getInstance().init();
			this.conn = DBConnector.getInstance().getConn();
			sql = "DELETE FROM programmeren4.LOCATION WHERE LOCATIONID=" + locationData.getLocationId();
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
	 * Lijst van alle Locations (LIST)
	 */
	public List<LocationDTO> getLocations() throws DAOException  {
		String query = "SELECT * FROM programmeren4.LOCATION";
		List<LocationDTO> list = new ArrayList<LocationDTO>();
		LocationDTO locationReturn = null;
		ResultSet rs = null;
		
		try {
			DBConnector.getInstance().init();
			this.conn = DBConnector.getInstance().getConn();
			rs = conn.createStatement().executeQuery(query);

			while (rs.next()) {
				locationReturn = new LocationDTO();
				locationReturn.setLocationId(rs.getLong("LOCATIONID"));
				locationReturn.setLocationName(rs.getString("LOCATION_NAME"));
				locationReturn.setLocationName(rs.getString("LOCATION_DESCRIPTION"));
				
				list.add(locationReturn);
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
	

	//Overige methoden
	/**
	 * Methode om te controleren of een Locatie al aanwezig is in de database
	 * (Op basis van ID)
	 */
	public boolean verifyLocationId(LocationDTO locationData) throws DAOException{
		ResultSet rs = null;
		boolean inDatabase = false;
		
		try {
			DBConnector.getInstance().init();
			this.conn = DBConnector.getInstance().getConn();
			sql = "SELECT * FROM programmeren4.LOCATION WHERE LOCATIONID=" + locationData.getLocationId();
			rs = conn.createStatement().executeQuery(sql);
			//System.out.println("locationData LocationID: " + locationData.getLocationId());
						
			if (rs.next()){
				long a = new Long(rs.getLong("LOCATIONID"));
				if ( a == locationData.getLocationId()){
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
	 * Methode om te controleren of een Locatie al aanwezig is in de database
	 * (Op basis van naam)
	 */
	public boolean verifyLocationName(LocationDTO locationData) throws DAOException{
		ResultSet rs = null;
		boolean inDatabase = false;
		
		try {
			DBConnector.getInstance().init();
			this.conn = DBConnector.getInstance().getConn();
			sql = "SELECT * FROM programmeren4.LOCATION WHERE LOCATION_NAME='" + locationData.getLocationName().toUpperCase() + "'";
			rs = conn.createStatement().executeQuery(sql);
			//System.out.println("locationData LocationID: " + locationData.getLocationName().toUpperCase());
						
			if (rs.next()){
				if (rs.getRow() == 1 & new String(rs.getString("LOCATION_NAME").toUpperCase()).equals(locationData.getLocationName().toUpperCase())){
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
	 * Methode om LocationID van een Locatie op te vragen
	 */
	public long getLocationId(LocationDTO locationData) throws DAOException{
		ResultSet rs = null;
		long locationId = 0;
		
		try {
			DBConnector.getInstance().init();
			this.conn = DBConnector.getInstance().getConn();
			sql = "SELECT * FROM programmeren4.LOCATION WHERE LOCATION_NAME='" + locationData.getLocationName().toUpperCase()  + "'";
			rs = conn.createStatement().executeQuery(sql);
			//System.out.println("DTO: " +locationData.getLocationName());
			
			if (rs.next()){
				//System.out.println("Numbers of rows: " + rs.getRow());
				if (rs.getRow() == 1 & new String(rs.getString("LOCATION_NAME").toUpperCase()).equals(locationData.getLocationName().toUpperCase())){
					locationId = rs.getLong("LOCATIONID");
				}
				//System.out.println(locationId);
			}
			
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.getInstance().close(rs);
			DBConnector.getInstance().closeConn();
		}
		return locationId;
	}
	
	/**
	 * Methode om de eerste record van de LOCATION tabel op te vragen<br>
	 * Default location (= de eerste locatie in de tabel Location)
	 */
	public long getFirstLocationId(LocationDTO locationData) throws DAOException{
		ResultSet rs = null;
		long locationId = 0;
		
		try {
			DBConnector.getInstance().init();
			this.conn = DBConnector.getInstance().getConn();
			sql = "SELECT * FROM location LIMIT 1";
			rs = conn.createStatement().executeQuery(sql);
			//System.out.println("DTO: " + locationData.getLocationName());
			
			if (!rs.isBeforeFirst() ) {    
				 System.out.println("No data"); 
			} 
			if (rs.next()){
				//System.out.println("Numbers of rows: " + rs.getRow());
				if (rs.getRow() == 1 & new String(rs.getString("LOCATION_NAME")).equals(locationData.getLocationName())){
					locationId = rs.getLong("LOCATIONID");
				}
				System.out.println(locationId);
			}

			
			
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.getInstance().close(rs);
			DBConnector.getInstance().closeConn();
		}
		return locationId;
	}	
		
	
}
