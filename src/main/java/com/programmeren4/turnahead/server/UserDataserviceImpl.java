package com.programmeren4.turnahead.server;

import com.programmeren4.turnahead.client.UserDataService;
import com.programmeren4.turnahead.server.jpa.CharacterEnt;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class UserDataserviceImpl implements UserDataService{
	
	private static final long serialVersionUID = 1L;
	 
	//private static final Logger LOG = Logger.getLogger(OPPersoonsGegevensServiceImpl.clasUserDataImpltatic final PersistenceManagerFactory PMF = JDOHelper.getPersistenceManagerFactory("transactions-optional");

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("turnPU");
	EntityManager em = emf.createEntityManager();
 
	@Override
	public String[] getUserData() {
		return null;
		 // onderstaande is voorbeeld van hoe data uit de databank kan worden gehaald
		
	}
	
	@Override
	public boolean createChar(String characterName, String lastLogin, String registrationDate) {
		EntityTransaction tx = em.getTransaction();
		try
		{
		    tx.begin();
		    CharacterEnt character = new CharacterEnt(null, null, null);
		    em.persist(character);
		    tx.commit();
		}
		finally
		{
		    if (tx.isActive())
		    {
		        tx.rollback();
		    }
		    em.close();
		}
		return false;
	}

}
	
	
