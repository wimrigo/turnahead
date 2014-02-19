package com.programmeren4.turnahead.server.jpa;

import javax.persistence.EntityManager;

public class Services {

	//UserServices
	/**
	 * Gebruiker aanmaken
	 */
	public void addUser(){
		EntityManager em = EMF.get().createEntityManager();
		User user = new User();
		
		em.persist(user);
		em.close();
	}
	/**
	 * Gebruiker verwijderen
	 */
	public void deleteUser(){
		EntityManager em = EMF.get().createEntityManager();
		try {
			
	    } finally {
	        em.close();
	    }
	
	}
	/**
	 * Bestaande gebruiker bijwerken
	 */
	public void updateUser(){
		EntityManager em = EMF.get().createEntityManager();
		try {
			
	    } finally {
	        em.close();
	    }
		
		
	}
	
	//CharacterServices
	/**
	 * Karakter toevoegen
	 */
	public void addCharacter(){
		EntityManager em = EMF.get().createEntityManager();
		
		CharacterEnt cha = new CharacterEnt(null, null, null);
		em.persist(cha);
		em.close();
	}
	/**
	 * Karakter verwijderen
	 */
	public void deleteCharacter(){
		EntityManager em = EMF.get().createEntityManager();
		try {
			
	    } finally {
	        em.close();
	    }
	}
	/**
	 * Bestaand Karakter bijwerken
	 */
	public void updateCharacter(){
		EntityManager em = EMF.get().createEntityManager();
		try {
			
	    } finally {
	        em.close();
	    }
	}
	
	
	//ItemServices
	/**
	 * Item toevoegen
	 */
	public void addItem(){
		EntityManager em = EMF.get().createEntityManager();
		
		//em.persist();
		em.close();
	}
	/**
	 * Item verwijderen
	 */
	public void deleteItem(){
		EntityManager em = EMF.get().createEntityManager();
		try {
			
	    } finally {
	        em.close();
	    }
	}
	/**
	 * Bestaand Item bijwerken / updaten
	 */
	public void updateItem(){
		EntityManager em = EMF.get().createEntityManager();
		try {
			
	    } finally {
	        em.close();
	    }
	}
		
	//LocationServices
	/**
	 * Nieuwe Locatie toevoegen
	 */
	public void addLocation(){
		EntityManager em = EMF.get().createEntityManager();
		
		//em.persist();
		em.close();
	}
	/**
	 * Nieuwe Locatie toevoegen
	 */
	public void deleteLocation(){
		EntityManager em = EMF.get().createEntityManager();
		try {
			
	    } finally {
	        em.close();
	    }
	}
	/**
	 * Nieuwe Locatie toevoegen
	 */
	public void updateLocation(){
		EntityManager em = EMF.get().createEntityManager();
		try {
			
	    } finally {
	        em.close();
	    }
	}
	
	//PathServices (ID, ID)
	/**
	 * Methode om een verbinding tussen twee locaties te leggen 
	 */
	public void addPath(){
		
	}
	/**
	 * Methode om een verbinding tussen twee locaties te verwijderen 
	 */
	public void deletePath(){
		
	}
	
	
}
