package com.programmeren4.turnahead.server.model.jpa;



import java.io.Serializable;


public class Item implements Serializable{
	private static final long serialVersionUID = 7890731364995144947L;
	//attributen
    private long itemId; //Long itemId
	private String itemName;
	private String itemDescription;
	
	
	//constructor
	public Item(){
		
		
	}
	
	
	//getters en setters
	/**
	 * 
	 * @return
	 */
	public long getItemId() {
	        return itemId;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
 
	
	

}
