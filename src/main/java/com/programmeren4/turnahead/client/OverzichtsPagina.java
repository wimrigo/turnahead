package com.programmeren4.turnahead.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;


public class OverzichtsPagina  implements EntryPoint {
		
		private FormOverzichtsPagina form = new FormOverzichtsPagina();

		@Override
		public void onModuleLoad() {
			RootPanel.get().add(form);
		
			
		}

		}

