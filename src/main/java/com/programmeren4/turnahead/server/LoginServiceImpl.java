package com.programmeren4.turnahead.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.programmeren4.turnahead.client.services.LoginService;
import com.programmeren4.turnahead.server.model.Services;
import com.programmeren4.turnahead.shared.dto.UserDataDTO;

public class LoginServiceImpl extends RemoteServiceServlet implements LoginService{
	
	private static final long serialVersionUID = 1L;
	 
	Services services = new Services();

	@Override
	public boolean Login(UserDataDTO loginDTO) {
		// TODO Auto-generated method stub
		return false;
	}

}
	
	
