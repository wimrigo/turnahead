package com.programmeren4.turnahead.client.ui;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class HelloWorld implements EntryPoint {
   public void onModuleLoad() {
      RootPanel.get().add(new Login());   
   }    
} 