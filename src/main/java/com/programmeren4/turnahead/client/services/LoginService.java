package com.programmeren4.turnahead.client.services;


import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.programmeren4.turnahead.shared.dto.UserDataDTO;


@RemoteServiceRelativePath("loginservice")
public interface LoginService extends RemoteService{
	
	public boolean Login(UserDataDTO loginDTO);
	
}
