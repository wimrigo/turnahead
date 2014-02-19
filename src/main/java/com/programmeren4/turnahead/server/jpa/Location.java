package com.programmeren4.turnahead.server.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;


/**
 * Locatie
 *
 */
@Entity
public class Location {
	
	//attributen
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key locationId; //Long locationId
	private String locationName;
	private String locationDescription;
	
	//constructor
	
	
	//getters en setters
	public Key getLocationId() {
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
