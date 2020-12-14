package com.inesshasanoui.bibliotheekbeheersysteem.view;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RenewLoanPanel extends JPanel {
	private JTextField textCopyId;
	private JButton btnRenew;
	/**
	 * Create the panel.
	 */
	public RenewLoanPanel() {
		setLayout(null);
		
		textCopyId = new JTextField();
		textCopyId.setBounds(224, 83, 86, 20);
		add(textCopyId);
		textCopyId.setColumns(10);
		
		JLabel lblCopyId = new JLabel("Copy Id");
		lblCopyId.setBounds(115, 89, 46, 14);
		add(lblCopyId);
		
		 btnRenew = new JButton("Renew");
		btnRenew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRenew.setBounds(284, 222, 89, 23);
		add(btnRenew);

	}
	public JTextField getTextCopyId() {
		return textCopyId;
	}
	public void addConfirmRenewLoanListener(ActionListener actionListener) {
		btnRenew.addActionListener(actionListener);
	}
}
