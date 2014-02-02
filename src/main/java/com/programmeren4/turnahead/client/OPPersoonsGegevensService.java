package com.programmeren4.turnahead.client;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

// methode om gegevens van speler op te vragen uit databank
// om te kunnen tonen op de OverzichtsPagina.java
@RemoteServiceRelativePath("note")
public interface OPPersoonsGegevensService extends RemoteService{
	public String[] getPersoonsGegevens();
}
