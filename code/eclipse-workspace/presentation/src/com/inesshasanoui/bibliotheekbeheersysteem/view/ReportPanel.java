package com.inesshasanoui.bibliotheekbeheersysteem.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class ReportPanel extends JPanel {

		

	/**
	 * Create the panel.
	 */
	public ReportPanel() {
	
		setBounds(100, 100, 450, 300);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(contentPane);
		this.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UNDER CONSTRUCTION");
		lblNewLabel.setFont(new Font("Stencil", Font.PLAIN, 16));
		lblNewLabel.setBounds(84, 70, 265, 93);
		this.add(lblNewLabel);
	}

}
