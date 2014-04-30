package com.programmeren4.turnahead.shared.dto;

import java.io.Serializable;

/**
 * Item DTO<br>
 * Items die ofwel in een Basket van een Karakter of de Locationstore van een Locatie zitten
 * 
 */
public class ItemDTO implements Serializable{
	//attributen
	private static final long serialVersionUID = 1L;
	private Long itemId; //int itemId;
	private String itemName;
	private String description;
	
	
	//constructor
	public ItemDTO(Long itemId, String itemName, String description) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.description = description;
	}
	
	public ItemDTO() {
		super();
	}
	
	
	//getters en setters
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
		ItemDTO other = (ItemDTO) obj;
		if (itemId == null) {
			if (other.itemId != null)
				return false;
		} else if (!itemId.equals(other.itemId))
			return false;
		return true;
	}

}
