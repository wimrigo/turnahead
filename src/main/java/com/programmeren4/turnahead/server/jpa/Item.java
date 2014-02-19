package com.programmeren4.turnahead.server.jpa;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.google.appengine.api.datastore.Key;


@Entity
public class Item {
	
	//attributen
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Key itemId; //Long itemId
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
	public Key getItemId() {
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
