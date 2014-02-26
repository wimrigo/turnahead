package com.programmeren4.turnahead.server.model;

import com.programmeren4.turnahead.server.model.dao.UserDataDao;
import com.programmeren4.turnahead.server.model.jpa.UserData;
import com.programmeren4.turnahead.shared.dto.UserDataDTO;
import com.programmeren4.turnahead.shared.exception.DAOException;

public class Services {
	UserDataDao userDataDao = new UserDataDao();

	// UserServices
	/**
	 * Gebruiker aanmaken
	 * 
	 * @throws DAOException
	 */
	public void addUser(UserDataDTO userDataDTO) throws DAOException {
		// TODO: Implement some checks
		UserData userData = new UserData(userDataDTO.getFirstName(), userDataDTO.getLastName(), userDataDTO.getEMail(), userDataDTO.getPassword());
		// TODO: Implement some more checks
		userDataDao.addUserData(userData);
	}

}
