package com.programmeren4.turnahead.client.services;


import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.programmeren4.turnahead.shared.dto.UserDataDTO;
import com.programmeren4.turnahead.shared.exception.DAOException;

// methode om gegevens van speler op te vragen uit databank
// om te kunnen tonen op de OverzichtsPagina.java
@RemoteServiceRelativePath("userservice")
public interface UserDataService extends RemoteService{
	public boolean createUser(UserDataDTO userDataDTO) throws DAOException;
	//public List<UserData> getUserData();
}
