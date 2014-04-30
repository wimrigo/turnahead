package com.programmeren4.turnahead.shared.dto;


/**
 * Locatie DTO
 * 
 */
public class LocationDTO {
	//attributen
	//private static final long serialVersionUID = 1L;
	private Long locationId; //int locationId;
    private String locationName;
    private String locationDescription;

    //constructor (?)
    
    
    //getters en setters
	public Long getLocationId() {
        return locationId;
    }
    
    public String getFirstName() {
        return locationName;
    }
    public void setFirstName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationDescription() {
        return locationDescription;
    }
    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LocationDTO other = (LocationDTO) obj;
		if (locationId == null) {
			if (other.locationId != null)
				return false;
		} else if (!locationId.equals(other.locationId))
			return false;
		return true;
	}
    

}
