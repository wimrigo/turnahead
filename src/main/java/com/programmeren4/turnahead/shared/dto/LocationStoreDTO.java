package com.programmeren4.turnahead.shared.dto;

import java.io.Serializable;

/**
 * Location Store DTO (Items beschikbaar op een locatie)
 * 
 */
public class LocationStoreDTO implements Serializable{
	//attributen
	private static final long serialVersionUID = 1L;
	private Long locationStoreID; //int locationStoreID;
	private String karakterName;
	private Long ltemID;
	private String itemName;
	
	
	//constructor
	
	
	//getters en setters 
	public Long getLocationStoreID() {
		return locationStoreID;
	}
	public void setLocationStoreID(Long locationStoreID) {
		this.locationStoreID = locationStoreID;
	}

	public String getKarakterName() {
		return karakterName;
	}
	public void setKarakterName(String karakterName) {
		this.karakterName = karakterName;
	}

	public Long getLtemID() {
		return ltemID;
	}
	public void setLtemID(Long ltemID) {
		this.ltemID = ltemID;
	}

	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	
	//methoden
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LocationStoreDTO other = (LocationStoreDTO) obj;
		if (locationStoreID == null) {
			if (other.locationStoreID != null)
				return false;
		} else if (!locationStoreID.equals(other.locationStoreID))
			return false;
		return true;
	}
	
}
