package com.programmeren4.turnahead.client.ui;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class Home implements EntryPoint {

	private HomeView form = new HomeView();

	@Override
	public void onModuleLoad() {
		RootPanel.get().add(form);
	}

}
