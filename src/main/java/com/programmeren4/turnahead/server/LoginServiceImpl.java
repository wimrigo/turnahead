package com.programmeren4.turnahead.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.programmeren4.turnahead.client.services.LoginService;
import com.programmeren4.turnahead.server.model.dao.LoginDao;
import com.programmeren4.turnahead.shared.dto.LoginDTO;
import com.programmeren4.turnahead.shared.exception.DAOException;

public class LoginServiceImpl extends RemoteServiceServlet implements
		LoginService {

	private static final long serialVersionUID = 1L;
	LoginDao loginDao = new LoginDao();

	@Override
	public boolean Login(LoginDTO loginFromClient) {
		boolean result = false;
		System.out.println("e-mail gegeven door invoerveld   : " +loginFromClient.getEMail());
		System.out.println("paswoord gegeven door invoerveld : " +loginFromClient.getPassword());
		try {
			result = loginFromClient.equals(loginDao.checkLogin(loginFromClient)) ? true : false;
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return result;
	}
}
