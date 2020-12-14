package com.inesshasanoui.bibliotheekbeheersysteem.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.inesshasanoui.bibliotheekbeheersysteem.service.UserService;
import com.inesshasanoui.bibliotheekbeheersysteem.view.MemberPanel;
import com.inesshasanoui.bibliotheekbeheersysteem.view.View;
import com.inesshasanoui.bibliotheekbeheersysteem.view.View.PanelEnum;


public class MemberController {
	private MemberPanel memberPanel;
	private View view;
	private UserService userService;
	
	public MemberController(View view, UserService userService) {
		super();
		this.view = view;
		this.userService = userService;
		this.memberPanel = view.getMemberPanel();
		this.memberPanel.addMyProfileListener(new AddMyProfileListener());
		this.memberPanel.addMyLoanedItemsListener(new AddMyLoanedItemsListener());
		this.memberPanel.addSearchItemsListener(new AddSearchItemsListener() );
		this.memberPanel.addEscListener(new AddEscListener());
	}
	
	class ManageMemberListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			view.switchToPanel(PanelEnum.manageMember);

		}
	}
	
	class AddMyProfileListener implements ActionListener {
		public void actionPerformed (ActionEvent e) {	
			view.switchToPanel(PanelEnum.addMyProfile);
		}
	}

	
	class AddMyLoanedItemsListener implements ActionListener {
			@Override
		public void actionPerformed(ActionEvent e) {
				view.switchToPanel(PanelEnum.addMyLoanedItems);	
		}
	}
	
	class AddSearchItemsListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			view.switchToPanel(PanelEnum.searchItem);
		}
	}

	class AddEscListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			view.switchToPanel(PanelEnum.login);
			
		}
}
}