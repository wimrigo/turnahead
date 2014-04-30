package com.programmeren4.turnahead.server;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.programmeren4.turnahead.client.services.UserDataService;
import com.programmeren4.turnahead.server.model.dao.UserDataDao;
import com.programmeren4.turnahead.shared.dto.UserDataDTO;

public class UserDataServiceImpl extends RemoteServiceServlet implements UserDataService{
	
	private static final long serialVersionUID = 1L;
	 
	
	UserDataDao userDataDao = new UserDataDao();
 
	/*@Override
	public List<UserData> getUserData() {
		return null;
		 // onderstaande is voorbeeld van hoe data uit de databank kan worden gehaald
		
	}*/
	
	@Override
	public boolean createUser(UserDataDTO userDataDTO) {
		try {
			userDataDao.addUserData(userDataDTO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	@Override
	public List<UserDataDTO> getUserData(){
		List<UserDataDTO> userList = new ArrayList<UserDataDTO>();
		try {
			userList.addAll(userDataDao.getUsers());
			if (userList.isEmpty()){
				System.out.println("The returned arraylist is empty");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList;
		
	}
	
	

		

}
	
	
