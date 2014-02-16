package com.programmeren4.turnahead.client.ui;


import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class Home implements EntryPoint  {
	
	private Form1 form = new Form1();

	@Override
	public void onModuleLoad() {
		Form1 form = new Form1();

		RootPanel.get().add(form);
        //alert('Hello world');


	}

}
