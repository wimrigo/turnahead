package com.programmeren4.turnahead.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class LoginView extends Composite {

	private static LoginViewUiBinder uiBinder = GWT
			.create(LoginViewUiBinder.class);

	interface LoginViewUiBinder extends UiBinder<Widget, LoginView> {
	}

	public LoginView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	Label username;
	@UiField
	TextBox user;
	@UiField
	Label password;
	@UiField
	TextBox pass;
	@UiField
	Button inloggen;
	@UiField
	Button reset;

	@UiHandler("inloggen")
	void onClickButtonInloggen(ClickEvent e) {
		Window.alert("Je gaat naar het overzichtscherm zonder username/password");
		new Overview();
	}

	@UiHandler("reset")
	void onClickButtonResetten(ClickEvent e) {
		Window.alert("resetten");
	}

}
