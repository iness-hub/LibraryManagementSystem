package com.inesshasanoui.bibliotheekbeheersysteem.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import com.inesshasanoui.bibliotheekbeheersysteem.model.Librarian;
import com.inesshasanoui.bibliotheekbeheersysteem.model.Member;
import com.inesshasanoui.bibliotheekbeheersysteem.model.User;
import com.inesshasanoui.bibliotheekbeheersysteem.service.AuthenticationService;
import com.inesshasanoui.bibliotheekbeheersysteem.service.ServiceClass;
import com.inesshasanoui.bibliotheekbeheersysteem.service.UserService;
import com.inesshasanoui.bibliotheekbeheersysteem.service.exception.AuthenticationException;
import com.inesshasanoui.bibliotheekbeheersysteem.view.LibrarianPanel;
import com.inesshasanoui.bibliotheekbeheersysteem.view.LoginPanel;
import com.inesshasanoui.bibliotheekbeheersysteem.view.View;
import com.inesshasanoui.bibliotheekbeheersysteem.view.View.PanelEnum;


public class LoginController {

	private LoginPanel loginPanel;
	private View view;
	private ServiceClass serviceClass;
	private AuthenticationService authenticationService;
	private Controller controller;
	private User userLogin; 

	public LoginController(View view, AuthenticationService authenticationService) {
		super();
		this.view = view;
		this.authenticationService = authenticationService;
		this.controller = controller;
		this.serviceClass = serviceClass;
		this.loginPanel = view.getLoginPanel();
		this.loginPanel.addLoginListener(new LoginListener());
		this.loginPanel.addResetListener(new AddResetListener());

	}

	class LoginListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String usernameLogin = loginPanel.getUsername().getText();
			String passwordLogin = loginPanel.getPassword().getText().toString();
			int userId;
			try {
				userLogin =authenticationService.login(usernameLogin, passwordLogin);
			} catch (AuthenticationException e1) {
				view.messageAlertBox(e1.getMessage());
			//	e1.printStackTrace();
			}
		//	controller.setUserLogin(userLogin);
			if (userLogin instanceof Member ) view.switchToPanel(PanelEnum.member);
			if (userLogin instanceof Librarian ) view.switchToPanel(PanelEnum.librarian);
					
		}
	}
	class AddResetListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			userLogin = null;
			loginPanel.getUsername().setText(null);
			loginPanel.getPassword().setText(null);
			
		}
		
	}

	public User getUserLogin() {
		return userLogin;
	}

	public void setUserLogin1(User userLogin) {
		this.userLogin = userLogin;
	}


	
}
