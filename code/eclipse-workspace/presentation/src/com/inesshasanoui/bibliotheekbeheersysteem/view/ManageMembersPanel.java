package com.inesshasanoui.bibliotheekbeheersysteem.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
/*import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;*/
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Font;

public class ManageMembersPanel extends JPanel {
	private JTextField textFirstname;
	private JTextField textLastname;
	private JTextField textUsername;
	private JTextField textPassword;
	private JTextField textEmail;
	private JTextField textTel;
	private JComboBox comboBoxRole;
	private JComboBox comboBoxState; 
	private JTextField textIdUser;
	private JButton btnAddMember;
	private JButton btnBack;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JTable tableUsers;
	private JTextField textSearch;
	private JComboBox comboBoxSearch;
	private JButton btnSearch;
	/**
	 * 
	 * Create the panel.
	 */
	public ManageMembersPanel() {

		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);

		JLabel lblFirstname = new JLabel("First Name");
		lblFirstname.setBounds(36, 135, 108, 14);
		this.add(lblFirstname);

		JLabel lblLastname = new JLabel("Last Name");
		lblLastname.setBounds(36, 161, 127, 14);
		this.add(lblLastname);

		textFirstname = new JTextField();
		textFirstname.setBounds(108, 132, 226, 20);
		this.add(textFirstname);
		textFirstname.setColumns(10);

		textLastname = new JTextField();
		textLastname.setBounds(108, 158, 226, 20);
		this.add(textLastname);
		textLastname.setColumns(10);

		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(36, 186, 127, 14);
		this.add(lblNewLabel);

		textUsername = new JTextField();
		textUsername.setBounds(108, 183, 226, 20);
		this.add(textUsername);
		textUsername.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(36, 211, 137, 14);
		this.add(lblNewLabel_1);

		textPassword = new JTextField();
		textPassword.setBounds(108, 211, 226, 20);
		this.add(textPassword);
		textPassword.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Email");
		lblNewLabel_3.setBounds(36, 261, 149, 14);
		this.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Phone");
		lblNewLabel_4.setBounds(36, 236, 149, 14);
		this.add(lblNewLabel_4);

		textEmail = new JTextField();
		textEmail.setBounds(108, 258, 226, 21);
		this.add(textEmail);
		textEmail.setColumns(10);

		textTel = new JTextField();
		textTel.setBounds(108, 236, 226, 20);
		this.add(textTel);
		textTel.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Role");
		lblNewLabel_2.setBounds(36, 32, 86, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_5 = new JLabel("State");
		lblNewLabel_5.setBounds(38, 65, 84, 14);
		add(lblNewLabel_5);
		
		 comboBoxRole = new JComboBox();
		comboBoxRole.setBounds(141, 28, 193, 22);
		add(comboBoxRole);
		
		comboBoxState = new JComboBox();
		comboBoxState.setBounds(141, 61, 193, 22);
		add(comboBoxState);
		
		 btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDelete.setBounds(234, 388, 89, 30);
		add(btnDelete);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUpdate.setBounds(134, 388, 89, 30);
		add(btnUpdate);
		
		btnBack	 = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBack.setBounds(0, 500, 89, 30);
		add(btnBack);
		
		btnAddMember = new JButton("Add");
		btnAddMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAddMember.setBounds(36, 388, 89, 30);
		add(btnAddMember);
		
		textIdUser = new JTextField();
		textIdUser.setBounds(108, 104, 226, 20);
		add(textIdUser);
		textIdUser.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Id User");
		lblNewLabel_6.setBounds(36, 105, 108, 14);
		add(lblNewLabel_6);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(367, 104, 654, 391);
		add(scrollPane);
		
		tableUsers = new JTable();
		scrollPane.setViewportView(tableUsers);
		tableUsers.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"IdUser", "Role","State", "FirstName", "Lastname", "Username", "Password", "Phone", "Email" 
			}
		));
		
		comboBoxSearch = new JComboBox();
		comboBoxSearch.setBounds(676, 11, 180, 40);
		add(comboBoxSearch);
		
		textSearch = new JTextField();
		textSearch.setBounds(676, 62, 181, 31);
		add(textSearch);
		textSearch.setColumns(10);
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSearch.setBounds(546, 27, 89, 52);
		add(btnSearch);
	}

	

	public JTextField getTextFirstname() {
		return textFirstname;
	}

	public JTextField getTextLastname() {
		return textLastname;
	}

	
	/*public JTextField getTextAdres() {
		return textAdres;
	}*/

	

	public JTextField getTextUsername() {
		return textUsername;
	}

	public JTextField getTextPassword() {
		return textPassword;
	}

	public JTextField getTextEmail() {
		return textEmail;
	}

	public JTextField getTextTel() {
		return textTel;
	}

	public JComboBox getComboBoxRole() {
		return comboBoxRole;
	}

	public void setComboBoxRole(JComboBox comboBoxRole) {
		this.comboBoxRole = comboBoxRole;
	}
	
	public JTextField getTextIdUser() {
		return textIdUser;
	}



	public void setTextIdUser(JTextField textIdUser) {
		this.textIdUser = textIdUser;
	}

	public JComboBox getComboBoxState() {
		return comboBoxState;
	}
	
	
	public  JTable getTable() {
		return tableUsers;
	}

	public void setTable(JTable table) {
		this.tableUsers = table;
	}



	public JTextField getTextSearch() {
		return textSearch;
	}

	

	public JButton getBtnAddMember() {
		return btnAddMember;
	}



	public void setBtnAddMember(JButton btnAddMember) {
		this.btnAddMember = btnAddMember;
	}



	public JButton getBtnUpdate() {
		return btnUpdate;
	}



	public void setBtnUpdate(JButton btnUpdate) {
		this.btnUpdate = btnUpdate;
	}



	public JButton getBtnDelete() {
		return btnDelete;
	}



	public void setBtnDelete(JButton btnDelete) {
		this.btnDelete = btnDelete;
	}



	public void setComboBoxState(JComboBox comboBoxState) {
		this.comboBoxState = comboBoxState;
	}
	public JComboBox getComboBoxSearch () {
		return comboBoxSearch;
	}
	public void addcomboBoxRoleListener(ActionListener actionListener) {
		comboBoxRole.addActionListener(actionListener);
    }
	
	public void addcomboBoxStateListener(ActionListener actionListener) {
		comboBoxState.addActionListener(actionListener);
    }
	
	
	public void addMemberListener(ActionListener actionListener) {
		btnAddMember.addActionListener(actionListener);
	}

	public void addBackListener(ActionListener actionListener) {
		btnBack.addActionListener(actionListener);
	}
	public void addTextIdUserListener(ActionListener actionListener) {
		textIdUser.addActionListener(actionListener);
	}
	public void addUpdateMemberListener(ActionListener actionListener) {
		btnUpdate.addActionListener(actionListener);
	}
	public void addDeleteMemberListener(ActionListener actionListener) {
		btnDelete.addActionListener(actionListener);
	}
	public void addSearchMemberListener(ActionListener actionListener) {
		btnSearch.addActionListener(actionListener);
	}
	
	public void addSelectedRowMouseListener(MouseListener mouseListener) {
		tableUsers.addMouseListener(mouseListener);
	}
	
	
	
}
