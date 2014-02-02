package com.programmeren4.turnahead.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface OPPersoonsGegevensServiceAsync {

	// asyn interface om array van string gegevens te krijgen uit de databank
	// voor de persoonsgegevens op de overzichtspagina
	void getPersoonsGegevens(AsyncCallback<String[]> callback);
}
