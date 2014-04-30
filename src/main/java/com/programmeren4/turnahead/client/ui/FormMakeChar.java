package com.programmeren4.turnahead.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class FormMakeChar extends Composite {

	private static CharAanmakenUiBinder uiBinder = GWT
			.create(CharAanmakenUiBinder.class);

	interface CharAanmakenUiBinder extends UiBinder<Widget, FormMakeChar> {
	}

	public FormMakeChar() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	Button OKbutton;
	Button cancelButton;
	TextBox name;
	TextBox geslacht;

//	@UiHandler("naam")
//	public String getName() {
//		// naam return die in textbox in ingegeven
//		return name.getText();
//
//	}
//
//	public String getGeslacht() {
//		// return geslacht dat in textbox geslacht is ingevuld
//		return geslacht.getText();
//
//	}

	@UiHandler("OKbutton")
	void onClickOKknop(ClickEvent e) {
		// char wordt toegevoegd aan databankwindow
		Window.alert("char toegevoegd aan databank");
		// char toevoegen aan databank

	}

	@UiHandler("cancelButton")
	void onClickcancelKnop(ClickEvent e) {
		// de bewerking wordt afgebroken en men wordt terug gestuurd naar de
		// overzichtspagina
		FormOverview formOverzichtspagina = new FormOverview();
		RootPanel.get().clear();
		RootPanel.get().add(formOverzichtspagina);
	}

}
