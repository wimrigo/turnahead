package com.programmeren4.turnahead.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class FormHome extends Composite {

	private static Form1UiBinder uiBinder = GWT.create(Form1UiBinder.class);

	interface Form1UiBinder  extends UiBinder<Widget, FormHome> {
	}

	public FormHome() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	Button buttonAanmelden;
	@UiField
	Button buttonRegisteren;
	

	public FormHome(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
		buttonAanmelden.setText("aanmelden");
		buttonRegisteren.setText("registeren");
	}

	@UiHandler("buttonAanmelden")
	void onClick(ClickEvent e) {
		// open new window ipv hello login scherm
		Window.alert("aanmelden window");
		
	}
	@UiHandler("buttonRegisteren")
	void onClick1(ClickEvent e) {
		Window.alert("registeren window");
		
	}

	

}
