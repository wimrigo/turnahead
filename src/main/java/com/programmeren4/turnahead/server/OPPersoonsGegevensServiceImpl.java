package com.programmeren4.turnahead.server;

import com.programmeren4.turnahead.client.OPPersoonsGegevensService;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
 
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
 
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class OPPersoonsGegevensServiceImpl implements OPPersoonsGegevensService{
	
	private static final long serialVersionUID = 1L;
	 
	private static final Logger LOG = Logger.getLogger(OPPersoonsGegevensServiceImpl.class.getName());
 
	private static final PersistenceManagerFactory PMF = JDOHelper.getPersistenceManagerFactory("transactions-optional");
 
	@Override
	public String[] getPersoonsGegevens() {
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
//	}
// 
//	private PersistenceManager getPersistenceManager() {
//		return PMF.getPersistenceManager();
//	}
}
}
	
	
