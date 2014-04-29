package com.programmeren4.turnahead.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.programmeren4.turnahead.client.services.UserDataService;
import com.programmeren4.turnahead.server.model.Services;
import com.programmeren4.turnahead.shared.dto.UserDataDTO;
import com.programmeren4.turnahead.shared.exception.DAOException;

public class UserDataServiceImpl extends RemoteServiceServlet implements UserDataService{
	
	private static final long serialVersionUID = 1L;
	 
	Services services = new Services();
 
	/*@Override
	public List<UserData> getUserData() {
		return null;
		 // onderstaande is voorbeeld van hoe data uit de databank kan worden gehaald
		
	}*/
	
	@Override
	public boolean createUser(UserDataDTO userDataDTO) throws DAOException {
		//services.addUser(userDataDTO);
		return true;
	}
		

}
	
	
