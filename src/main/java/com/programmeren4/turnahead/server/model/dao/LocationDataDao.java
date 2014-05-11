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
	
	
	//methoden
	/**
	 * Opvragen (SELECT)
	 */
	
	
	
	/**
	 * Location toevoegen (INSERT) of wijzigen (UPDATE)
	 */
	public List<LocationDTO> getLocations() throws DAOException {
		List<LocationDTO> list = new ArrayList<LocationDTO>();
		ResultSet rs = null;
		
		try {
			DBConnector.getInstance().init();
			String query = "SELECT * FROM programmeren4.LOCATION";
			LocationDTO locationReturn = null;
			
			this.conn = DBConnector.getInstance().getConn();
			rs = conn.createStatement().executeQuery(query);

			while (rs.next()) {
				//locationReturn.setKarakterId(rs.getLong("CHARACTERID"));
				//locationReturn.setKarakterName(rs.getString("CHARACTERNAME"));
				//locationReturn.setCurrentLocation(rs.getString("CURRENTLOCATION"));

				list.add(locationReturn);
			}
			if (list.isEmpty()) {
				System.out.println("List fetched from database is empty.");
			}
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} finally {
			DBConnector.getInstance().close(rs);
			DBConnector.getInstance().closeConn();
		}
		return list;
	}
	
	/**
	 * Location verwijderen (DELETE)
	 */
	public void deleteLocationData(LocationDTO locationData) throws DAOException {
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
	 * List
	 */
	
	
	
	/**
	 * Methode om de eerste record van de table op te vragen<br>
	 * Default location (de eerste locatie in een tabel)
	 */
}
