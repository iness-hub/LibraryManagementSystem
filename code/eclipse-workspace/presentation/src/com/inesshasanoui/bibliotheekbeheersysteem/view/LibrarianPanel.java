package com.inesshasanoui.bibliotheekbeheersysteem.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class LibrarianPanel extends JPanel {

	private JButton btnManageMember;
	private JButton btnManageItem;
	private JButton btnManageLoan;
	private JButton btnEsc;
	private JButton btnManageReturn;
	private JButton btnManageReservations;
	/**
	 * Create the panel
	 */
	public LibrarianPanel() {

		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);

		btnManageMember = new JButton("Manage Members");
		btnManageMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnManageMember.setBounds(427, 169, 157, 23);
		this.add(btnManageMember);

		btnManageItem = new JButton("Manage Items");
		btnManageItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnManageItem.setBounds(427, 203, 157, 23);
		this.add(btnManageItem);

		btnManageLoan = new JButton("Manage Loans");
		btnManageLoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnManageLoan.setBounds(427, 276, 157, 23);
		this.add(btnManageLoan);

		JLabel lblNewLabel = new JLabel("Welcome Librarian");
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		lblNewLabel.setBounds(22, 27, 157, 14);
		this.add(lblNewLabel);

		btnEsc = new JButton("Back");
		btnEsc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEsc.setBounds(111, 340, 94, 33);
		this.add(btnEsc);
		
		btnManageReservations = new JButton("Manage Reservations");
		btnManageReservations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnManageReservations.setBounds(427, 310, 157, 23);
		add(btnManageReservations);
		
		btnManageReturn = new JButton("Manage Returns");
		btnManageReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnManageReturn.setBounds(427, 237, 157, 23);
		add(btnManageReturn);
	}

	public void addManageMemberListener(ActionListener actionListener) {
		btnManageMember.addActionListener(actionListener);
	}

	public void addManageItemListener(ActionListener actionListener) {
		btnManageItem.addActionListener(actionListener);
	}



	public void addManageLoanListener(ActionListener actionListener) {
		btnManageLoan.addActionListener(actionListener);
	}

	public void addManageReturnListener(ActionListener actionListener) {
		btnManageReturn.addActionListener(actionListener);
	}

	public void addEscListener(ActionListener actionListener) {
		btnEsc.addActionListener(actionListener);
	}

	public void addManageReservationsListener(ActionListener actionListener) {
		btnManageReservations.addActionListener(actionListener);
	}
}
