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
import com.programmeren4.turnahead.client.services.LoginService;
import com.programmeren4.turnahead.client.services.LoginServiceAsync;
import com.programmeren4.turnahead.shared.dto.LoginDTO;

public class LoginView extends Composite {

	private static LoginViewUiBinder uiBinder = GWT.create(LoginViewUiBinder.class);
	LoginServiceAsync LoginAsync;

	interface LoginViewUiBinder extends UiBinder<Widget, LoginView> {
	}

	public LoginView() {
		initWidget(uiBinder.createAndBindUi(this));
		LoginAsync = GWT.create(LoginService.class);
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

		AsyncCallback<Boolean> callback = new AsyncCallback<Boolean>() {
			
			@Override
			public void onSuccess(Boolean result) {
				new Overview();
			}

			@Override
			public void onFailure(Throwable caught) {
//				Window.alert(caught.getMessage());
//				caught.printStackTrace();
				Window.alert("Try again loser!");
			}
		};
		
		//LoginAsync.Login(new LoginDTO("WARD.PEER@HOTMAIL.COM", "programmeren4"), callback);
		LoginAsync.Login(new LoginDTO(user.getText(), pass.getText()), callback);
	}

	@UiHandler("reset")
	void onClickButtonResetten(ClickEvent e) {
		user.setText("");
		pass.setText("");
	}

}
