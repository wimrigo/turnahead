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
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.programmeren4.turnahead.client.services.UserDataService;
import com.programmeren4.turnahead.shared.dto.UserDataDTO;

public class RegistrationView extends Composite {

	private static RegistrationViewUiBinder uiBinder = GWT.create(RegistrationViewUiBinder.class);
	UserDataServiceAsync LoginAsync;
	
	interface RegistrationViewUiBinder extends
			UiBinder<Widget, RegistrationView> {
	}

	public RegistrationView() {
		initWidget(uiBinder.createAndBindUi(this));
		UserDataServiceAsync = GWT.create(UserDataService.class);
	}
	
	@UiField
	Label lblfname;
	@UiField
	TextBox fname;
	@UiField
	Label lbllname;
	@UiField
	TextBox lname;
		
	@UiField
	Label lblmail;
	@UiField
	TextBox mail;
	@UiField
	Label lblpassword;
	@UiField
	TextBox pass;

	@UiField
	Button register;
	@UiField
	Button reset;

	
	@UiHandler("register")
	void onClickButtonInloggen(ClickEvent e) {

		AsyncCallback<Boolean> callback = new AsyncCallback<Boolean>() {
			
			@Override
			public void onSuccess(Boolean result) {
				Window.alert("Gebruiker toegevoegd aan de DB");
			}

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Try again loser!");
			}
		};
		UserDataServiceAsync.createUser(new UserDataDTO(fname.getText(), lname.getText(), mail.getText(), pass.getText()), callback)
	}

	@UiHandler("reset")
	void onClickButtonResetten(ClickEvent e) {
		fname.setText("");
		lname.setText("");
		mail.setText("");
		pass.setText("");
	}
}
