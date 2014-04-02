package com.programmeren4.turnahead.server.model.jpa;

import java.io.Serializable;


/**
 * Locatie
 *
 */
public class Location implements Serializable {
	private static final long serialVersionUID = 1615273709260526458L;
	//attributen
	private long locationId; //Long locationId
	private String locationName;
	private String locationDescription;
	
	//constructor
	
	
	//getters en setters
	public long getLocationId() {
        return locationId;
    }
	
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	
	public String getLocationDescription() {
		return locationDescription;
	}
	public void setLocationDescription(String locationDescription) {
		this.locationDescription = locationDescription;
	}
	
}
