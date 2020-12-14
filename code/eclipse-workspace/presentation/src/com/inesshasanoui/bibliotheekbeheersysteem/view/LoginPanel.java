package com.inesshasanoui.bibliotheekbeheersysteem.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginPanel extends JPanel {

	private JTextField username;
	private JPasswordField password;
	private JButton btnLogin;
	private JButton btnReset ;

	public LoginPanel() {
		setBounds(200, 200,900, 600);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(293, 86, 900, 600);
		add(panel);
		panel.setLayout(null);
		
				username = new JTextField();
				username.setBounds(220, 87, 180, 35);
				panel.add(username);
				username.setColumns(10);
				
						password = new JPasswordField();
						password.setBounds(220, 158, 180, 35);
						panel.add(password);
						
								JLabel lblNewLabel = new JLabel("Username");
								lblNewLabel.setBounds(66, 86, 127, 37);
								panel.add(lblNewLabel);
								
										JLabel lblNewLabel_1 = new JLabel("Password");
										lblNewLabel_1.setBounds(66, 158, 118, 24);
										panel.add(lblNewLabel_1);
										
												btnLogin = new JButton("LOGIN");
												btnLogin.setBounds(107, 231, 89, 35);
												panel.add(btnLogin);
												
														 btnReset = new JButton("RESET");
														btnReset.setBounds(286, 231, 89, 35);
														panel.add(btnReset);
														btnReset.addActionListener(new ActionListener() {
															public void actionPerformed(ActionEvent e) {
															}
														});
												btnLogin.addActionListener(new ActionListener() {
													public void actionPerformed(ActionEvent e) {
													}
												});
	}

	
	
	
	public void addLoginListener(ActionListener mal) {
		btnLogin.addActionListener(mal);
	}
	public void addResetListener(ActionListener mal) {
		btnReset.addActionListener(mal);
	}

	public JTextField getUsername() {
		return username;
	}

	
	public JPasswordField getPassword() {
		return password;
	}

	}
