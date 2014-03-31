package com.programmeren4.turnahead.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class FormHome extends Composite {

	private static Form1UiBinder uiBinder = GWT.create(Form1UiBinder.class);
	private String firstName = "Stefaan";
	private String lastName = "Stefaan";
	private String password= "test";
	private String eMail= "faandg@gmail.com";
	//UserDataServiceAsync userDataAsync;
	
	interface Form1UiBinder extends UiBinder<Widget, FormHome> {
	}

	public FormHome() {
		initWidget(uiBinder.createAndBindUi(this));
		//userDataAsync = GWT.create(UserDataService.class);
	}

	 
	
	@UiField
	Button buttonAanmelden;
	@UiField
	Button buttonRegisteren;	
	@UiField
	Button buttonMakeUser;
	@UiField
	Button buttonGetUser;

	public FormHome(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
		buttonAanmelden.setText("aanmelden");
		buttonRegisteren.setText("registeren");
	}

	@UiHandler("buttonAanmelden")
	void onClickLogin(ClickEvent e) {
		// open new window ipv hello login scherm
		Window.alert("aanmelden window");
		
	}
	
	@UiHandler("buttonRegisteren")
	void onClickRegister(ClickEvent e) {
		Window.alert("registeren window");
		
	}
	
	@UiHandler("buttonMakeUser")
	void onClickMakeUser(ClickEvent e) {
		AsyncCallback<Boolean> callback = new  AsyncCallback<Boolean>() {	
			
			@Override
			public void onSuccess(Boolean result) {
				if (result) {
					Window.alert("Saved");
				}
			}
			
			@Override
			public void onFailure(Throwable caught) {
				Window.alert(caught.getMessage());
				caught.printStackTrace();
				
			}
		};
		//userDataAsync.createUser(new UserDataDTO(firstName, lastName, eMail, password), callback);
		
	}
	
	@UiHandler("buttonGetUser")
	void onClickGetUser(ClickEvent e) {
			AsyncCallback<Boolean> callback = new  AsyncCallback<Boolean>() {	
			
			@Override
			public void onSuccess(Boolean result) {
				if (result) {
					Window.alert("Saved");
				}
			}
			
			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Not saved :(");
				
			}
		};
		//userDataAsync.getUserData();;
		
	}
}
