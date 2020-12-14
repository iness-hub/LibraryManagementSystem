package com.inesshasanoui.bibliotheekbeheersysteem.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
//import com.inesshasanoui.bibliotheekbeheersysteem.controller.AddMemberController.AddMemberListener;
import com.inesshasanoui.bibliotheekbeheersysteem.controller.LibrarianController.ManageMemberListener;
import com.inesshasanoui.bibliotheekbeheersysteem.controller.LoginController.LoginListener;
import com.inesshasanoui.bibliotheekbeheersysteem.controller.ManageMemberController.AddMemberListener;
import com.inesshasanoui.bibliotheekbeheersysteem.model.Category;
import com.inesshasanoui.bibliotheekbeheersysteem.model.Member;
import com.inesshasanoui.bibliotheekbeheersysteem.model.Person;
import com.inesshasanoui.bibliotheekbeheersysteem.model.RoleUser;
import com.inesshasanoui.bibliotheekbeheersysteem.model.StateUser;
import com.inesshasanoui.bibliotheekbeheersysteem.model.TypeItem;
import com.inesshasanoui.bibliotheekbeheersysteem.model.User;
import com.inesshasanoui.bibliotheekbeheersysteem.model.UserFactory;
import com.inesshasanoui.bibliotheekbeheersysteem.model.UserRole;
import com.inesshasanoui.bibliotheekbeheersysteem.model.UserState;
import com.inesshasanoui.bibliotheekbeheersysteem.service.RoleUserService;
import com.inesshasanoui.bibliotheekbeheersysteem.service.StateUserService;
import com.inesshasanoui.bibliotheekbeheersysteem.service.UserService;
import com.inesshasanoui.bibliotheekbeheersysteem.service.exception.ItemException;
import com.inesshasanoui.bibliotheekbeheersysteem.view.ManageItemsPanel;
import com.inesshasanoui.bibliotheekbeheersysteem.view.ManageMembersPanel;
import com.inesshasanoui.bibliotheekbeheersysteem.view.View;
import com.inesshasanoui.bibliotheekbeheersysteem.view.View.PanelEnum;


public class ManageMemberController {

	private ManageMembersPanel manageMembersPanel;
	private UserService userService;
	private RoleUserService roleUserService;
	private StateUserService stateUserService;
	private View view;

	public ManageMemberController(View view, UserService userService, RoleUserService roleUserService,
			StateUserService stateUserService) {
		super();
		this.view = view;
		this.userService = userService;
		this.roleUserService = roleUserService;
		this.stateUserService = stateUserService;
		this.manageMembersPanel = view.getManageMembersPanel();

		fillComboRole(this.manageMembersPanel);
		fillComboState(this.manageMembersPanel);
		fillcomboSearch(this.manageMembersPanel);

	
		this.manageMembersPanel.addMemberListener(new AddMemberListener());
		this.manageMembersPanel.addTextIdUserListener(new IdUserTextFieldListener());
		this.manageMembersPanel.addBackListener(new AddBackListener());
		this.manageMembersPanel.addUpdateMemberListener(new AddUpdateMemberListener());
		this.manageMembersPanel.addDeleteMemberListener(new AddDeleteMemberListener());
		this.manageMembersPanel.addSearchMemberListener(new AddSearchMemberListener());
		this.manageMembersPanel.getTable().addMouseListener(new AddSelectedRowMouseListener());

	}

	class AddMemberListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			User user = GetUserFromManageMembersPanel(manageMembersPanel);
		
			user=userService.insert(user);
			intializeTableData(); 
			setUpTableData(user);
			initializeManageMembersPanel(manageMembersPanel);
		}
	}

	class AddBackListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			view.switchToPanel(PanelEnum.librarian);
		}
	}

	class DeleteMemberListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			view.switchToPanel(PanelEnum.deleteMember);
			
		}
	}

	
	class AddSelectedRowMouseListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {

		
			setManageMembersPanelFromJTable();
			manageMembersPanel.getBtnUpdate().setEnabled(true);
			manageMembersPanel.getBtnDelete().setEnabled(true);
			manageMembersPanel.getBtnAddMember().setEnabled(false);
	
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}

	private User GetUserFromManageMembersPanel(ManageMembersPanel manageMembersPanel) {
		User user = null;
		int id = 0;
		if (manageMembersPanel.getTextIdUser().getText().length() == 0)
			id = 0;
		else
			id = Integer.parseInt(manageMembersPanel.getTextIdUser().getText());

		System.out.println(id + "GetUserFromManageMembersPanel");
		String username = manageMembersPanel.getTextUsername().getText();
		String password = manageMembersPanel.getTextPassword().getText();
		String firstname = manageMembersPanel.getTextFirstname().getText();
		String lastname = manageMembersPanel.getTextLastname().getText();
		String adres ="";// manageMembersPanel.getTextAdres().getText();
		String email = manageMembersPanel.getTextEmail().getText();
		int tel = Integer.parseInt(manageMembersPanel.getTextTel().getText());
		UserState state = UserState.valueOf(manageMembersPanel.getComboBoxState().getSelectedItem().toString());
		UserRole role = UserRole.valueOf(manageMembersPanel.getComboBoxRole().getSelectedItem().toString());
		user =UserFactory.getUser(id, state, role, username, password, firstname, lastname, adres, email, tel);
		return user;
	}

	private void fillComboRole(ManageMembersPanel manageMembersPanel) {
		
		for (UserRole role : UserRole.values()) {
			manageMembersPanel.getComboBoxRole().addItem(role.toString());
		}

	}

	private void fillComboState(ManageMembersPanel manageMembersPanel) {
		
		for (UserState state : UserState.values()) {
			manageMembersPanel.getComboBoxState().addItem(state.toString());
		}
	}

	private void fillcomboSearch(ManageMembersPanel manageMembersPanel) {

		manageMembersPanel.getComboBoxSearch().addItem("All");
		manageMembersPanel.getComboBoxSearch().addItem("by Id");
		manageMembersPanel.getComboBoxSearch().addItem("by Lastname");

	}

	class IdUserTextFieldListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int id = Integer.parseInt(manageMembersPanel.getTextIdUser().getText());
			User user = userService.get(id);
			System.out.println(user + "get user from id");
			setManageMembersPanelFromUser(manageMembersPanel, user);

		}

	}

	private void setManageMembersPanelFromUser(ManageMembersPanel manageMembersPanel, User user) {
		manageMembersPanel.getTextIdUser().setText(Integer.toString(user.getId()));
		manageMembersPanel.getTextUsername().setText(user.getUsername());
		manageMembersPanel.getTextPassword().setText(user.getPassword());
		manageMembersPanel.getTextFirstname().setText(user.getPerson().getFirstname());
		manageMembersPanel.getTextLastname().setText(user.getPerson().getLastname());
//		manageMembersPanel.getTextAdres().setText(user.getPerson().getAdres());
		manageMembersPanel.getTextEmail().setText(user.getPerson().getEmail());
		manageMembersPanel.getTextTel().setText(Integer.toString(user.getPerson().getTel()));
		String state = user.getState().toString();
		manageMembersPanel.getComboBoxState().setSelectedItem(state);
		
	}
	


	class AddUpdateMemberListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			User user = null;// new Member();
			user = GetUserFromManageMembersPanel(manageMembersPanel);
		
			user = userService.update(user);
			System.out.println(user.getPerson().getTel() + "button update member controller");
			JOptionPane.showMessageDialog(null, " member with number Id"+ user.getId()+ " is updated");
			manageMembersPanel.getBtnAddMember().setEnabled(true);
			manageMembersPanel.getBtnUpdate().setEnabled(false);
			manageMembersPanel.getBtnDelete().setEnabled(false);
			intializeTableData();
			initializeManageMembersPanel(manageMembersPanel);
			
		}
	}

	class AddDeleteMemberListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			User user = GetUserFromManageMembersPanel(manageMembersPanel);
			System.out.println(user.getId()+ "button delete member controller");
			System.out.println(manageMembersPanel.getTextIdUser().getText());
			userService.delete(user);
			JOptionPane.showMessageDialog(null, " user with number Id" + user.getId() + " is deleted");
			
		}
	}

	class AddSearchMemberListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			String searchBy = manageMembersPanel.getComboBoxSearch().getSelectedItem().toString();
			intializeTableData();
			switch (searchBy) {
			case ("All"):
				List<User> users = userService.getAll();
				for (int i = 0; i < users.size(); i++)
					setUpTableData(users.get(i));
				
					break;

			case ("by Id"):
				int id = Integer.parseInt(manageMembersPanel.getTextSearch().getText());

				User user = userService.get(id);
				 intializeTableData();
				setUpTableData(user);
				break;
			}
		}
	}
	
	private void initializeManageMembersPanel(ManageMembersPanel manageMembersPanel) {
		manageMembersPanel.getTextIdUser().setText(null);
		manageMembersPanel.getTextUsername().setText(null);
		manageMembersPanel.getTextPassword().setText(null);
		manageMembersPanel.getTextFirstname().setText(null);
		manageMembersPanel.getTextLastname().setText(null);
//		manageMembersPanel.getTextAdres().setText(null);
		manageMembersPanel.getTextEmail().setText(null);
		manageMembersPanel.getTextTel().setText(null);
		manageMembersPanel.getComboBoxState().setSelectedIndex(0);
		manageMembersPanel.getComboBoxRole().setSelectedIndex(0);	
	}
	private void setUpTableData(User user) {
		JTable jTable = manageMembersPanel.getTable();
		DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();

		String[] data = new String[9];
		data[0] = String.valueOf(user.getId());
		data[1] = UserFactory.getRoleUser(user).toString();
		data[2] = user.getState().toString();
		data[3] = user.getUsername();
		data[4] = user.getPassword();
		data[5] = user.getPerson().getFirstname();
		data[6] = user.getPerson().getLastname();
		data[7] = String.valueOf(user.getPerson().getTel());
		data[8] = String.valueOf(user.getPerson().getEmail());

		tableModel.addRow(data);
		manageMembersPanel.getTable().setModel(tableModel);
	}
	private void setManageMembersPanelFromJTable() {
		JTable jTable = manageMembersPanel.getTable();
		int selectedRow = jTable.getSelectedRow();
		System.out.println(selectedRow);
		int id = Integer.parseInt((String) (jTable.getModel().getValueAt(selectedRow, 0)));
		System.out.println(id + "setManageMembersPanelFromJTable" );
		UserRole role = UserRole.valueOf((String)(jTable.getModel().getValueAt(selectedRow, 1)));
		UserState state = UserState.valueOf((String) (jTable.getModel().getValueAt(selectedRow, 2)));
		String username = (String) (jTable.getModel().getValueAt(selectedRow, 3));
		String password = (String) (jTable.getModel().getValueAt(selectedRow, 4));
		String firstname = (String) (jTable.getModel().getValueAt(selectedRow, 5));
		String lastname = (String) (jTable.getModel().getValueAt(selectedRow, 6));
		int tel = Integer.parseInt((String) (jTable.getModel().getValueAt(selectedRow, 7)));
		String email= (String) (jTable.getModel().getValueAt(selectedRow, 8));

		
		manageMembersPanel.getTextIdUser().setText(Integer.toString(id));
		manageMembersPanel.getTextUsername().setText(username);
		manageMembersPanel.getTextPassword().setText(password);
		manageMembersPanel.getTextFirstname().setText(firstname);
		manageMembersPanel.getTextLastname().setText(lastname);
		manageMembersPanel.getTextEmail().setText(email);
		manageMembersPanel.getTextTel().setText(Integer.toString(tel));
		
		
		manageMembersPanel.getComboBoxRole().setSelectedItem(role.toString());
		manageMembersPanel.getComboBoxState().setSelectedItem(state.toString());
	
	}
	private void intializeTableData() {
		JTable jTable = manageMembersPanel.getTable();
		DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
		tableModel.setRowCount(0);
	   
		
	}

	
	
}
