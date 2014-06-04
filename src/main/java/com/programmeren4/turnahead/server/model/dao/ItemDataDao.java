package com.programmeren4.turnahead.server.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.programmeren4.turnahead.server.database.DBConnector;
import com.programmeren4.turnahead.shared.dto.ItemDTO;
import com.programmeren4.turnahead.shared.exception.DAOException;

public class ItemDataDao {
	//attributen
	private Connection conn;
	private String sql;
	//private String tabelnaam = "ITEM";
	//private String[] tabelvelden = {"ITEMID","ITEMNAME","ITEM_DESCRIPTION"};
	
	//constructor
	public ItemDataDao() {}
	
	
	//getters en setters
	
	
	//SELECT - UPDATE - INSERT - DELETE
	/**
	 * Gegevens van een Item opvragen (SELECT)
	 */
	public ItemDTO getItemData(ItemDTO itemData) throws DAOException {
		ItemDTO itemReturn = null;
		ResultSet rs = null;

		try {
			DBConnector.getInstance().init();
			this.conn = DBConnector.getInstance().getConn();
			sql = "SELECT * FROM programmeren4.ITEM WHERE ITEMID=" + itemData.getItemId();
			rs = conn.createStatement().executeQuery(sql);
			if (!rs.isBeforeFirst() ) {    
				 System.out.println("No data"); 
			} 
			
			if (rs.next()) {
				itemReturn = new ItemDTO();
				itemReturn.setItemId(rs.getLong("ITEMID"));
				itemReturn.setItemName(rs.getString("ITEMNAME"));
				itemReturn.setDescription(rs.getString("ITEM_DESCRIPTION"));
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.getInstance().close(rs);
			DBConnector.getInstance().closeConn();
		}
		return itemReturn;
	}
	
	
	/**
	 * Item toevoegen aan de database (INSERT) of een bestaand Item
	 * bijwerken (UPDATE)
	 */
	public void addItemData(ItemDTO itemData) throws DAOException {		
		// Controle (Bestaat Locatie al in tabel Location ?)
		boolean itemTest = this.verifyItemId(itemData);
		
		try {
			DBConnector.getInstance().init();
			this.conn = DBConnector.getInstance().getConn();
			
			if (itemTest == true) {
				// JA -> UPDATE bestaande record
				// "UPDATE programmeren4.ITEM SET *veld='itemData.getX()',*veld='itemData.getY()', 
				// "WHERE ITEMID=" + itemData.getKarakterId();
				String sql = "UPDATE programmeren4.ITEM SET";
				sql += " ITEMNAME='" + itemData.getItemName().toUpperCase() + "', ";
				sql += " ITEM_DESCRIPTION='" + itemData.getDescription() + "'";
				sql += " WHERE ITEMID=" + itemData.getItemId();
				conn.createStatement().executeUpdate(sql);
				
			} else {
				// NEEN -> INSERT toevoegen aan de database>
				// INSERT INTO programmeren4.ITEM(Columns db) VALUES (locationData.getX(),
				// locationData.getY(), locationData.getZ())
				String sql = "INSERT INTO programmeren4.ITEM(";
				sql += "ITEMNAME, ITEM_DESCRIPTION) VALUES ('";
				sql += itemData.getItemName().toUpperCase() +"', '";
				sql += itemData.getDescription();
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
	 * Item verwijderen (DELETE)
	 */
	public void deleteItemData(ItemDTO itemData) throws DAOException {
		
		try {
			DBConnector.getInstance().init();
			this.conn = DBConnector.getInstance().getConn();
			sql = "DELETE FROM programmeren4.ITEM WHERE ITEMID=" + itemData.getItemId();
			conn.createStatement().executeUpdate(sql);
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.getInstance().closeConn();
		}
	}
	
	
	//LIST
	/**
	 * Lijst van alle Items (LIST)
	 */
	public List<ItemDTO> getItems() throws DAOException  {
		String query = "SELECT * FROM programmeren4.ITEM";
		List<ItemDTO> list = new ArrayList<ItemDTO>();
		ItemDTO itemReturn = null;
		ResultSet rs = null;
		
		try {
			DBConnector.getInstance().init();
			this.conn = DBConnector.getInstance().getConn();
			rs = conn.createStatement().executeQuery(query);

			while (rs.next()) {
				itemReturn = new ItemDTO();
				itemReturn.setItemId(rs.getLong("ITEMID"));
				itemReturn.setItemName(rs.getString("ITEMNAME"));
				itemReturn.setItemName(rs.getString("ITEM_DESCRIPTION"));
				
				list.add(itemReturn);
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
	 * Methode om te controleren of een Item al aanwezig is in de database
	 * (Op basis van ID)
	 */
	public boolean verifyItemId(ItemDTO itemData) throws DAOException{
		ResultSet rs = null;
		boolean inDatabase = false;
		
		try {
			DBConnector.getInstance().init();
			this.conn = DBConnector.getInstance().getConn();
			sql = "SELECT * FROM programmeren4.ITEM WHERE ITEMID=" + itemData.getItemId();
			rs = conn.createStatement().executeQuery(sql);
			//System.out.println("itemData ItemID: " + itemData.getItemId();
						
			if (rs.next()){
				long a = new Long(rs.getLong("ITEMID"));
				if ( a == itemData.getItemId()){
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
	 * Methode om te controleren of een Item al aanwezig is in de database
	 * (Op basis van Naam)
	 */
	public boolean verifyItemName(ItemDTO itemData) throws DAOException{
		ResultSet rs = null;
		boolean inDatabase = false;
		
		try {
			DBConnector.getInstance().init();
			this.conn = DBConnector.getInstance().getConn();
			sql = "SELECT * FROM programmeren4.ITEM WHERE ITEMNAME='" + itemData.getItemName().toUpperCase() + "'";
			rs = conn.createStatement().executeQuery(sql);
			//System.out.println("itemData ItemID: " + itemData.getItemId();
						
			if (rs.next()){
				if (rs.getRow() == 1 & new String(rs.getString("ITEMNAME").toUpperCase()).equals(itemData.getItemName().toUpperCase())){
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
	
}

