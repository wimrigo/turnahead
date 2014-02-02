package com.programmeren4.turnahead.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class Namebox extends Composite {

	private static NameboxUiBinder uiBinder = GWT.create(NameboxUiBinder.class);

	interface NameboxUiBinder extends UiBinder<Widget, Namebox> {
	}

	public Namebox() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@UiField 
	TextBox nametext;
	
	@UiField
	Button namebutton;
	
	 @UiHandler("namebutton")
	  void handleClick(ClickEvent e) {
	    Window.alert("Hello world!");
	  }
	
	
	
	

}
