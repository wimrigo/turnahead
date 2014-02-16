package com.programmeren4.turnahead.server;

import com.programmeren4.turnahead.client.UserDataservice;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
 

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class UserDataserviceImpl implements UserDataservice{
	
	private static final long serialVersionUID = 1L;
	 
	//private static final Logger LOG = Logger.getLogger(OPPersoonsGegevensServiceImpl.clasUserDataImpltatic final PersistenceManagerFactory PMF = JDOHelper.getPersistenceManagerFactory("transactions-optional");

 
	@Override
	public String[] getUserData() {
		return null;
		 // onderstaande is voorbeeld van hoe data uit de databank kan worden gehaald
		
		
		
//		PersistenceManager pm = getPersistenceManager();
//		List<String> symbols = new ArrayList<String>();
// 
//		try {
//			String query = "select from " + Note.class.getName();
//			List<Note> Notes = (List<Note>) pm.newQuery(query).execute();
// 
//			for (Note Note : Notes) {
//				symbols.add(Note.getNote());
//			}
//		} finally {
//			pm.close();
//		}
// 
//		String[] ret = new String[symbols.size()];
// 
//		int i = 0;
//		for (String s : symbols) {
//			ret[i] = s;
//			i++;
//		}
// 
//		return ret;
	}
// 
//	private PersistenceManager getPersistenceManager() {
//		return PMF.getPersistenceManager();
//	}

}
	
	
