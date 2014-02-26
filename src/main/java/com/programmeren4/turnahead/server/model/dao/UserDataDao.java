package com.programmeren4.turnahead.server.model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.programmeren4.turnahead.server.model.EMFService;
import com.programmeren4.turnahead.server.model.jpa.UserData;
import com.programmeren4.turnahead.shared.exception.DAOException;


public class UserDataDao {
	EntityManager em;
	EntityTransaction tx;

	public UserData addUserData(UserData userData) throws DAOException {
		em = EMFService.get().createEntityManager();
		tx = em.getTransaction();
		tx.begin();
		try {
			em.persist(userData);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			Logger.getLogger("UserDataDao").log(Level.SEVERE, e.getMessage());
			throw new DAOException();
		} finally {
			em.close();
		}
		return userData;
	}
	
	@SuppressWarnings("unchecked")
	public List<UserData> getUsersData() {
		em = EMFService.get().createEntityManager();
		tx = em.getTransaction();
		Query q = em.createQuery("SELECT a FROM UserData a");
		List<UserData> userDataList = new ArrayList<UserData>(q.getResultList());
		em.close();
		return userDataList;
	}
}
