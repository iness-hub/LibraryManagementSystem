package com.inesshasanoui.bibliotheekbeheersysteem.view;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.event.ActionEvent;

public class ReturnCopyItemPanel extends JPanel {
	private JTextField copyId;
	JButton confirmReturn;
	private JButton btnBack;

	/**
	 * Create the panel.
	 */
	public ReturnCopyItemPanel() {
		setLayout(null);
		
		copyId = new JTextField();
		copyId.setBounds(127, 121, 86, 20);
		add(copyId);
		copyId.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("id copy");
		lblNewLabel.setBounds(38, 122, 46, 14);
		add(lblNewLabel);
		
		confirmReturn = new JButton("Confirm Return");
		confirmReturn.setBounds(279, 114, 161, 34);
		add(confirmReturn);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBack.setBounds(67, 236, 89, 34);
		add(btnBack);

	}
	
	public void returnCopyItemListener(ActionListener actionListener) {
		confirmReturn.addActionListener(actionListener);
	}
	public void addBackListener(ActionListener actionListener) {
		btnBack.addActionListener(actionListener);
	}
	public JTextField getCopyId() {
		return copyId;
	}

	public void setCopyId(JTextField copyId) {
		this.copyId = copyId;
	}

	public JButton getConfirmReturn() {
		return confirmReturn;
	}
	
	
}
