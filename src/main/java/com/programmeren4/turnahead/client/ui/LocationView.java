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

public class LocationView extends Composite {

	private static LocationViewUiBinder uiBinder = GWT
			.create(LocationViewUiBinder.class);

	interface LocationViewUiBinder extends UiBinder<Widget, LocationView> {
	}

	public LocationView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	Button button1;

	@UiHandler("button1")
	void onClickButton(ClickEvent e) {
		Window.alert("button1 clicked");

	}
}
