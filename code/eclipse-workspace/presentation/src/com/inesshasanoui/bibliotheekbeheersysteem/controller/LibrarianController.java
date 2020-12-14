package com.inesshasanoui.bibliotheekbeheersysteem.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.inesshasanoui.bibliotheekbeheersysteem.controller.LoginController.LoginListener;
import com.inesshasanoui.bibliotheekbeheersysteem.service.UserService;
import com.inesshasanoui.bibliotheekbeheersysteem.view.LibrarianPanel;
import com.inesshasanoui.bibliotheekbeheersysteem.view.ManageItemsPanel;
import com.inesshasanoui.bibliotheekbeheersysteem.view.ManageLoanPanel;
import com.inesshasanoui.bibliotheekbeheersysteem.view.ManageMembersPanel;
import com.inesshasanoui.bibliotheekbeheersysteem.view.ManageLoansPanel;
import com.inesshasanoui.bibliotheekbeheersysteem.view.ReportPanel;
import com.inesshasanoui.bibliotheekbeheersysteem.view.View;
import com.inesshasanoui.bibliotheekbeheersysteem.view.View.PanelEnum;


public class LibrarianController {

	private LibrarianPanel librarianPanel;
	private View view;
	private UserService userService;

	public LibrarianController(View view, UserService userService) {
		super();
		this.view = view;
		this.userService = userService;
		this.librarianPanel = view.getLibrarianPanel();
		this.librarianPanel.addManageMemberListener(new ManageMemberListener());
		this.librarianPanel.addManageItemListener(new ManageItemListener());
		this.librarianPanel.addManageLoanListener(new ManageLoanListener());
		this.librarianPanel.addManageReturnListener(new AddManageReturnListener());
		this.librarianPanel.addManageReservationsListener(new AddManageReservationsListener());
		
	
		this.librarianPanel.addEscListener(new AddEscListener());
	}

	class ManageMemberListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
		view.switchToPanel(PanelEnum.manageMember);
		}
	}
	
	class ManageItemListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			view.switchToPanel(PanelEnum.manageItem);
			
		}
	}

	class ManageLoanListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			view.switchToPanel(PanelEnum.addLoan);
		}
	}

	class ReportListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			view.switchToPanel(PanelEnum.ManageReport);
		}
	}
	class AddEscListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			view.switchToPanel(PanelEnum.login);
		}
	}

	class AddManageReturnListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			view.switchToPanel(PanelEnum.returnCopy);
		}
	}
	class AddManageReservationsListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			view.switchToPanel(PanelEnum.makeReservation);
		}
	}
}
