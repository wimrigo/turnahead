package com.programmeren4.turnahead.client.ui;

import com.google.gwt.user.client.ui.RootPanel;

public class RegistrationController {

	private RegistrationView register = new RegistrationView();

	public RegistrationController() {
		onLoad();
	}

	public void onLoad() {
		RootPanel.get().clear();
		RootPanel.get().add(register);
	}

}
