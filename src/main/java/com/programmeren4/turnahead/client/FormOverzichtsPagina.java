package com.programmeren4.turnahead.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Window;

public class FormOverzichtsPagina extends Composite {
	
	private static Uibinder1UiBinder uiBinder = GWT
			.create(Uibinder1UiBinder.class);

	interface Uibinder1UiBinder extends UiBinder<Widget, FormOverzichtsPagina> {
	}

	public FormOverzichtsPagina() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	Button terugKnop;
	Button aanpassenKnop;
	Button verwijderCharKnop;
	Button nieuwCharKnop;
	
	CellList<String> karaktersGegevens;
	Label naam;
	Label voorNaam;
	Label email;
	Label geboortedatum;
	VerticalPanel persoonsGegevensLabel;
	
	public FormOverzichtsPagina(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
		terugKnop.setText(firstName);	
		
	}
	

	@UiHandler("terugKnop")
	// terug keren naar de homepagina
	void onClickTerugKnop(ClickEvent e) {
		Window.Location.assign("com.lucypeeters.test2.client.client.home.Home");
	}

	@UiHandler("verwijderCharKnop")
	// het karakter wordt verwijderd in de databank
	void onClickVerwijderen(ClickEvent e) {
		
	}
	
	@UiHandler("nieuwCharKnop")
	// er wordt een nieuwe pagina geladen waar en een nieuw karakter eigenschappen kan geven
	void onClickNieuw(ClickEvent e) {
		// Window.location.assign("")
	}
	
}
