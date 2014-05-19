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
	//private String[] tabelvelden = {"","","",""};
	
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
		
		locationData.setLocationId(this.getLocationId(locationData));
		
		try {
			Class.forName(DBConnector.DRIVER_CLASS).newInstance();
			DBConnector.getInstance().init();
			this.conn = DBConnector.getInstance().getConn();
			sql = "SELECT * FROM programmeren4.LOCATION WHERE LOCATIONID=" + locationData.getLocationId();
			rs = conn.createStatement().executeQuery(sql);
			if (rs.next()) {
				locationReturn = new LocationDTO();
				locationReturn.setLocationId(rs.getLong("LOCATIONID"));
				locationReturn.setLocationName(rs.getString("LOCATIONNAME"));
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
	 * TODO
	 * Location toevoegen (INSERT) of wijzigen (UPDATE)
	 */
	public void addLocationData(LocationDTO locationData) throws DAOException {}
	
	
	/**
	 * Location verwijderen (DELETE)
	 */
	public void deleteLocationData(LocationDTO locationData) throws DAOException {
		
		locationData.setLocationId(this.getLocationId(locationData));
		
		try {
			Class.forName(DBConnector.DRIVER_CLASS).newInstance();
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
		List<LocationDTO> list = new ArrayList<LocationDTO>();
		ResultSet rs = null;
		
		try {
			Class.forName(DBConnector.DRIVER_CLASS).newInstance();
			DBConnector.getInstance().init();
			this.conn = DBConnector.getInstance().getConn();
			String query = "SELECT * FROM programmeren4.LOCATION";
			LocationDTO locationReturn = null;
			
			this.conn = DBConnector.getInstance().getConn();
			rs = conn.createStatement().executeQuery(query);

			while (rs.next()) {
				locationReturn.setLocationId(rs.getLong("LOCATIONID"));
				locationReturn.setLocationName(rs.getString("LOCATIONNAME"));

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
	 */
	public boolean checkLocation(LocationDTO locationData) throws DAOException{
		ResultSet rs = null;
		boolean inDatabase = false;
		
		locationData.setLocationId(this.getLocationId(locationData));
		
		try {
			Class.forName(DBConnector.DRIVER_CLASS).newInstance();
			DBConnector.getInstance().init();
			this.conn = DBConnector.getInstance().getConn();
			sql = "SELECT * FROM programmeren4.LOCATION WHERE LOCATIONID=" + locationData.getLocationId();
			rs = conn.createStatement().executeQuery(sql);
			//System.out.println("locationData LocationID: " + locationData.getLocationId());
						
			if (rs.next()){
				long a = new Long(rs.getLong("CHARACTERID"));
				//System.out.println(a);
				if ( a == locationData.getLocationId()){
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
	 * Methode om LocationID van een Locatie op te vragen
	 */
	public long getLocationId(LocationDTO locationData) throws DAOException{
		ResultSet rs = null;
		long locationId = 0;
		
		try {
			Class.forName(DBConnector.DRIVER_CLASS).newInstance();
			DBConnector.getInstance().init();
			this.conn = DBConnector.getInstance().getConn();
			sql = "SELECT * FROM programmeren4.LOCATION WHERE LOCATIONNAME=" + "'" + locationData.getLocationName()  + "'";
			rs = conn.createStatement().executeQuery(sql);
			//System.out.println("DTO: " +locationData.getLocationName());
			
			if (rs.next()){
				//System.out.println("Numbers of rows: " + rs.getRow());
				if (rs.getRow() == 1 & new String(rs.getString("LOCATIONNAME")).equals(locationData.getLocationName())){
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
	
	/**
	 * TODO
	 * Methode om de eerste record van de LOCATION tabel op te vragen<br>
	 * Default location (de eerste locatie in een tabel)
	 */
}
