package com.inesshasanoui.bibliotheekbeheersysteem.view;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.JSplitPane;
import javax.swing.Box;
import java.awt.Component;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Panel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;

public class ManageLoansPanel extends JPanel {
	private JTextField idMemberTextField;
	private JTextField idCopyItemTextField;
	private JButton btnLoan;
	private JButton btnRenew;
	private JTextField firstnameTextField;
	private JTextField lastnameTextField;
	private JTextField phonetextField;
	private JTextField emailTextField;
	private JTextField stateMemberTextField;
	private JTextField barcodeTextField;
	private JLabel lblNewLabel_8;
	private JTextField stateCopyTextField;
	private JLabel lblNewLabel_10;
	private JTextField IdLoan;
	private JLabel lblNewLabel_13;
	private JTextField MemberIdLoanPanel;
	private JTextField copyIdLoanPanel;
	private JTextField dateLoanedLoanPanel;
	private JTextField dateReturnLoanPanel;
	private JTextField dateReturnedLoanPanel;
	private JTextField penaltyLoanPanel;
	private JLabel lblNewLabel_14;
	private JLabel lblNewLabel_15;
	private JLabel lblNewLabel_16;
	private JLabel lblNewLabel_17;
	private JLabel lblNewLabel_18;
	private JLabel lblNewLabel_19;
	private JTextField textSearch;
	private JButton searchLoanBtn;
	private JTable tableLoans;
	private Panel panel_1;
	private JComboBox comboBoxSearch;
	private JButton btnNewLoan;
	private JButton btnUpdate;
	private JButton btnBack;

	/**
	 * Create the panel.
	 */
	public ManageLoansPanel() {
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		btnLoan = new JButton("Add Loan");
		btnLoan.setBounds(190, 472, 102, 53);
		btnLoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btnLoan);
		
		btnRenew = new JButton("Renew");
		btnRenew.setBounds(190, 524, 102, 53);
		add(btnRenew);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUpdate.setBounds(93, 524, 99, 53);
		add(btnUpdate);
		
		btnNewLoan = new JButton("New Loan");
		btnNewLoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewLoan.setBounds(93, 472, 97, 55);
		add(btnNewLoan);
		
		textSearch = new JTextField();
		textSearch.setBounds(725, 290, 191, 43);
		add(textSearch);
		textSearch.setColumns(10);
		
		searchLoanBtn = new JButton("Search");
		searchLoanBtn.setBounds(600, 246, 94, 51);
		searchLoanBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		add(searchLoanBtn);
		
		comboBoxSearch = new JComboBox();
		comboBoxSearch.setBounds(721, 246, 195, 22);
		add(comboBoxSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(565, 344, 516, 339);
		add(scrollPane);
		
		tableLoans = new JTable();
		
		tableLoans.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Id Member", "Id Copy ", "Date Lending", "Date Return", "Date Returned", "Penality"
			}
		));
		scrollPane.setColumnHeaderView(tableLoans);
		scrollPane.setViewportView(tableLoans);
		Panel panel = new Panel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(30, 131, 916, 75);
		add(panel);
		panel.setLayout(null);
		
		idCopyItemTextField = new JTextField();
		idCopyItemTextField.setBounds(218, 7, 86, 20);
		panel.add(idCopyItemTextField);
		idCopyItemTextField.setColumns(10);
		
		JLabel IdCopyItemTextField = new JLabel("Id Copy");
		IdCopyItemTextField.setBounds(128, 10, 73, 14);
		panel.add(IdCopyItemTextField);
		
		barcodeTextField = new JTextField();
		barcodeTextField.setBounds(135, 47, 154, 20);
		panel.add(barcodeTextField);
		barcodeTextField.setColumns(10);
		
		lblNewLabel_8 = new JLabel("Barcode");
		lblNewLabel_8.setBounds(24, 50, 86, 14);
		panel.add(lblNewLabel_8);
		
		stateCopyTextField = new JTextField();
		stateCopyTextField.setBounds(455, 7, 115, 20);
		panel.add(stateCopyTextField);
		stateCopyTextField.setColumns(10);
		
		lblNewLabel_10 = new JLabel("State");
		lblNewLabel_10.setBounds(381, 10, 46, 14);
		panel.add(lblNewLabel_10);
		
		JLabel lblNewLabel_12 = new JLabel("Copy");
		lblNewLabel_12.setBounds(11, 11, 46, 14);
		panel.add(lblNewLabel_12);
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		panel_1 = new Panel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(30, 10, 916, 115);
		add(panel_1);
		panel_1.setLayout(null);
		
		idMemberTextField = new JTextField();
		idMemberTextField.setBounds(216, 16, 86, 20);
		panel_1.add(idMemberTextField);
		idMemberTextField.setColumns(10);
		
		JLabel IdMember = new JLabel("Id Member");
		IdMember.setBounds(133, 19, 86, 14);
		panel_1.add(IdMember);
		
		firstnameTextField = new JTextField();
		firstnameTextField.setBounds(133, 63, 153, 20);
		panel_1.add(firstnameTextField);
		firstnameTextField.setColumns(10);
		
		lastnameTextField = new JTextField();
		lastnameTextField.setBounds(133, 86, 153, 20);
		panel_1.add(lastnameTextField);
		lastnameTextField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Firstname");
		lblNewLabel.setBounds(27, 66, 101, 14);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("LastName");
		lblNewLabel_1.setBounds(27, 89, 79, 14);
		panel_1.add(lblNewLabel_1);
		
		phonetextField = new JTextField();
		phonetextField.setBounds(445, 63, 155, 20);
		panel_1.add(phonetextField);
		phonetextField.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Phone");
		lblNewLabel_5.setBounds(374, 66, 46, 14);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Email");
		lblNewLabel_6.setBounds(374, 89, 46, 14);
		panel_1.add(lblNewLabel_6);
		
		emailTextField = new JTextField();
		emailTextField.setBounds(445, 86, 155, 20);
		panel_1.add(emailTextField);
		emailTextField.setColumns(10);
		
		stateMemberTextField = new JTextField();
		stateMemberTextField.setBounds(445, 16, 115, 20);
		panel_1.add(stateMemberTextField);
		stateMemberTextField.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("State");
		lblNewLabel_7.setBounds(374, 19, 46, 14);
		panel_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_11 = new JLabel("Member");
		lblNewLabel_11.setBounds(10, 18, 107, 14);
		panel_1.add(lblNewLabel_11);
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		Panel panel_2 = new Panel();
		panel_2.setBackground(SystemColor.controlHighlight);
		panel_2.setBounds(30, 215, 529, 214);
		add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Loan");
		lblNewLabel_2.setBounds(-15, 11, 105, 20);
		panel_2.add(lblNewLabel_2);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		IdLoan = new JTextField();
		IdLoan.setBounds(219, 12, 86, 20);
		panel_2.add(IdLoan);
		IdLoan.setColumns(10);
		
		lblNewLabel_13 = new JLabel("Id Loan");
		lblNewLabel_13.setBounds(125, 15, 46, 14);
		panel_2.add(lblNewLabel_13);
		
		MemberIdLoanPanel = new JTextField();
		MemberIdLoanPanel.setBounds(100, 68, 86, 20);
		panel_2.add(MemberIdLoanPanel);
		MemberIdLoanPanel.setColumns(10);
		
		copyIdLoanPanel = new JTextField();
		copyIdLoanPanel.setBounds(360, 68, 86, 20);
		panel_2.add(copyIdLoanPanel);
		copyIdLoanPanel.setColumns(10);
		
		dateLoanedLoanPanel = new JTextField();
		dateLoanedLoanPanel.setBounds(100, 120, 139, 20);
		panel_2.add(dateLoanedLoanPanel);
		dateLoanedLoanPanel.setColumns(10);
		
		dateReturnLoanPanel = new JTextField();
		dateReturnLoanPanel.setBounds(100, 165, 139, 20);
		panel_2.add(dateReturnLoanPanel);
		dateReturnLoanPanel.setColumns(10);
		
		dateReturnedLoanPanel = new JTextField();
		dateReturnedLoanPanel.setBounds(360, 120, 139, 20);
		panel_2.add(dateReturnedLoanPanel);
		dateReturnedLoanPanel.setColumns(10);
		
		penaltyLoanPanel = new JTextField();
		penaltyLoanPanel.setBounds(360, 165, 139, 20);
		panel_2.add(penaltyLoanPanel);
		penaltyLoanPanel.setColumns(10);
		
		lblNewLabel_14 = new JLabel("Member Id");
		lblNewLabel_14.setBounds(8, 68, 82, 14);
		panel_2.add(lblNewLabel_14);
		
		lblNewLabel_15 = new JLabel("Copy Id");
		lblNewLabel_15.setBounds(272, 71, 46, 14);
		panel_2.add(lblNewLabel_15);
		
		lblNewLabel_16 = new JLabel("Date Lending");
		lblNewLabel_16.setBounds(8, 120, 82, 14);
		panel_2.add(lblNewLabel_16);
		
		lblNewLabel_17 = new JLabel("Date Return");
		lblNewLabel_17.setBounds(8, 168, 86, 14);
		panel_2.add(lblNewLabel_17);
		
		lblNewLabel_18 = new JLabel("Date Returned");
		lblNewLabel_18.setBounds(272, 125, 89, 10);
		panel_2.add(lblNewLabel_18);
		
		lblNewLabel_19 = new JLabel("Penalty");
		lblNewLabel_19.setBounds(272, 168, 46, 14);
		panel_2.add(lblNewLabel_19);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(45, 629, 89, 43);
		add(btnBack);

	}

	
	public JComboBox getComboBoxSearch() {
		return comboBoxSearch;
	}


	public JTable getTableLoans() {
		return tableLoans;
	}


	public void setTable(JTable table) {
		this.tableLoans = table;
	}
public JTextField getTextSearch() {
	return this.textSearch = textSearch;
}

	public JTextField getIdMember() {
		return idMemberTextField;
	}

/*	public void setIdMember(JTextField idMember) {
		this.idMember = idMember;
	}*/

	
	
	public JTextField getIdCopy() {
		return idCopyItemTextField;
	}
	
	
	public JButton getBtnLoan() {
		return btnLoan;
	}


	public void setBtnLoan(JButton btnLoan) {
		this.btnLoan = btnLoan;
	}


	public JButton getBtnRenew() {
		return btnRenew;
	}


	public void setBtnCancel(JButton btnCancel) {
		this.btnRenew = btnCancel;
	}


	public JButton getBtnNewLoan() {
		return btnNewLoan;
	}


	public void setBtnNewLoan(JButton btnNewLoan) {
		this.btnNewLoan = btnNewLoan;
	}


	public JButton getBtnUpdate() {
		return btnUpdate;
	}


	public void setBtnUpdate(JButton btnUpdate) {
		this.btnUpdate = btnUpdate;
	}


	public JTextField getCopyIdLoanPanel() {
		return copyIdLoanPanel;
	}

public JTextField getIdMemberTextField() {
		return idMemberTextField;
	}


	public void setIdMemberTextField(JTextField idMemberTextField) {
		this.idMemberTextField = idMemberTextField;
	}


	public JTextField getIdCopyItemTextField() {
		return idCopyItemTextField;
	}


	public void setIdCopyItemTextField(JTextField idCopyItemTextField) {
		this.idCopyItemTextField = idCopyItemTextField;
	}


	public JTextField getFirstnameTextField() {
		return firstnameTextField;
	}


	public void setFirstnameTextField(JTextField firstnameTextField) {
		this.firstnameTextField = firstnameTextField;
	}


	public JTextField getLastnameTextField() {
		return lastnameTextField;
	}


	public void setLastnameTextField(JTextField lastnameTextField) {
		this.lastnameTextField = lastnameTextField;
	}


	public JTextField getPhonetextField() {
		return phonetextField;
	}


	public void setPhonetextField(JTextField phonetextField) {
		this.phonetextField = phonetextField;
	}


	public JTextField getEmailTextField() {
		return emailTextField;
	}


	public void setEmailTextField(JTextField emailTextField) {
		this.emailTextField = emailTextField;
	}


	public JTextField getStateMemberTextField() {
		return stateMemberTextField;
	}


	public void setStateMemberTextField(JTextField stateMemberTextField) {
		this.stateMemberTextField = stateMemberTextField;
	}


	public JTextField getBarcodeTextField() {
		return barcodeTextField;
	}


	public void setBarcodeTextField(JTextField barcodeTextField) {
		this.barcodeTextField = barcodeTextField;
	}


	public JTextField getStateCopyTextField() {
		return stateCopyTextField;
	}


	public void setStateCopyTextField(JTextField stateCopyTextField) {
		this.stateCopyTextField = stateCopyTextField;
	}


	public JTextField getTextIdLoan() {
		return IdLoan;
	}


	public void setTextIdLoan(JTextField textIdLoan) {
		this.IdLoan = textIdLoan;
	}


	public JButton getSearchLoanBtn() {
		return searchLoanBtn;
	}


	public void setSearchLoanBtn(JButton searchLoanBtn) {
		this.searchLoanBtn = searchLoanBtn;
	}


	public JTextField getIdLoan() {
		return IdLoan;
	}


	public void setIdLoan(JTextField idLoan) {
		IdLoan = idLoan;
	}


	public JTextField getMemberIdLoanPanel() {
		return MemberIdLoanPanel;
	}


	public void setMemberIdLoanPanel(JTextField memberIdLoanPanel) {
		MemberIdLoanPanel = memberIdLoanPanel;
	}


	public JTextField getDateLoanedLoanPanel() {
		return dateLoanedLoanPanel;
	}


	public void setDateLoanedLoanPanel(JTextField dateLoanedLoanPanel) {
		this.dateLoanedLoanPanel = dateLoanedLoanPanel;
	}


	public JTextField getDateReturnLoanPanel() {
		return dateReturnLoanPanel;
	}


	public void setDateReturnLoanPanel(JTextField dateReturnLoanPanel) {
		this.dateReturnLoanPanel = dateReturnLoanPanel;
	}


	public JTextField getDateReturnedLoanPanel() {
		return dateReturnedLoanPanel;
	}


	public void setDateReturnedLoanPanel(JTextField dateReturnedLoanPanel) {
		this.dateReturnedLoanPanel = dateReturnedLoanPanel;
	}


	public JTextField getPenaltyLoanPanel() {
		return penaltyLoanPanel;
	}


	public void setPenaltyLoanPanel(JTextField penaltyLoanPanel) {
		this.penaltyLoanPanel = penaltyLoanPanel;
	}


	/*	public void setIdCopy(JTextField idCopy) {
		this.idCopy = idCopy;
	}*/
	public void addLoanListener(ActionListener actionListener) {
		btnLoan.addActionListener(actionListener);
	}

	public void addIdMemberTextFieldListener(ActionListener actionListener) {
		idMemberTextField.addActionListener(actionListener);
	}
	public void addIdCopyItemrTextFieldListener(ActionListener actionListener) {
		idCopyItemTextField.addActionListener(actionListener);
	}
	public void addSearchLoanListener (ActionListener actionListener) {
		searchLoanBtn.addActionListener(actionListener);
		}
	public void addSelectedRowMouseListener(MouseListener mouseListener) {
		tableLoans.addMouseListener(mouseListener);
	}
	public void addUpdateLoanListener(ActionListener actionListener) {
		btnUpdate.addActionListener(actionListener);
	}
	public void addAddLoanListener(ActionListener actionListener) {
		btnLoan.addActionListener(actionListener);
	}
	public void addNewLoanListener(ActionListener actionListener) {
		btnNewLoan.addActionListener(actionListener);
	}
	public void addRenewLoanListener(ActionListener actionListener) {
		btnRenew.addActionListener(actionListener);
	}
	public void addBackListener (ActionListener actionListener) {
		btnBack.addActionListener(actionListener);
		
	}
}
