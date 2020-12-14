package com.inesshasanoui.bibliotheekbeheersysteem.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManageLoanPanel extends JPanel {
	private JButton btnNewLoan;
	private JButton btnReturnLoan;
	private JButton btnRenewLoan;
	private JButton btnUpdateLoan;
	private JButton btnReservation;

	public ManageLoanPanel() {
		setBounds(100, 100, 450, 300);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		// setContentPane(contentPane);
		this.setLayout(null);

		btnNewLoan = new JButton("New Loan");
		btnNewLoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewLoan.setBounds(168, 68, 120, 23);
		this.add(btnNewLoan);

		btnReturnLoan = new JButton("Return Loan");
		btnReturnLoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnReturnLoan.setBounds(168, 136, 120, 23);
		this.add(btnReturnLoan);

		btnRenewLoan = new JButton("Renew Loan");
		btnRenewLoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRenewLoan.setBounds(168, 102, 120, 23);
		this.add(btnRenewLoan);

		btnUpdateLoan = new JButton("Update Loan");
		btnUpdateLoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUpdateLoan.setBounds(168, 170, 120, 23);
		this.add(btnUpdateLoan);
		
		btnReservation = new JButton("Reservation");
		btnReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnReservation.setBounds(168, 211, 120, 23);
		add(btnReservation);
	}

	public void addLoanListener(ActionListener actionListener) {
		btnNewLoan.addActionListener(actionListener);
	}

	public void addReturnLoanListener(ActionListener actionListener) {
		btnReturnLoan.addActionListener(actionListener);
	}

	public void addUpdateLoanListener(ActionListener actionListener) {
		btnUpdateLoan.addActionListener(actionListener);
	}

	public void addRenewLoanListener(ActionListener actionListener) {
		btnRenewLoan.addActionListener(actionListener);
	}

	public void addReservationListener(ActionListener actionListener) {
		btnReservation.addActionListener(actionListener);
	}

}
