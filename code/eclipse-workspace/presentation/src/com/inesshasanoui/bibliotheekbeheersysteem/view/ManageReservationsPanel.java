package com.inesshasanoui.bibliotheekbeheersysteem.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.ScrollPane;
import javax.swing.table.DefaultTableModel;

import com.inesshasanoui.bibliotheekbeheersysteem.model.Item;
import com.inesshasanoui.bibliotheekbeheersysteem.model.Member;
import javax.swing.JScrollPane;

public class ManageReservationsPanel extends JPanel {
	private JTextField idItem;
	private JTextField idMember;
	JButton btnMakeReservation ;
	private JTextField memberFirstname;
	private JTextField memberLastname;
	private JTextField memberState;
	private JTextField isbn;
	private JTextField titel;
	private JTextField author;
	private JTextField type;
	private JTable table;
	private JTextField category;
	private JTextField idReservation;
	private JTextField memberReservationId;
	private JTextField itemIdReservation;
	private JTextField idReservedCopy;
	private JTextField stateReservation;
	private JTextField reservationdate;
	private JTable tableReservations;
	private JTextField textField_2;
	private JButton btnSearch;
	private JButton btnBack;

	/**
	 * Create the panel.
	 */
	public ManageReservationsPanel() {
		
		btnMakeReservation = new JButton("Make Reservation");
		btnMakeReservation.setBounds(93, 544, 166, 36);
		btnMakeReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		setLayout(null);
		add(btnMakeReservation);
		
		Panel memberFirstnameP = new Panel();
		memberFirstnameP.setBounds(57, 31, 916, 98);
		memberFirstnameP.setLayout(null);
		memberFirstnameP.setBackground(Color.LIGHT_GRAY);
		add(memberFirstnameP);
		
		JLabel IdMember = new JLabel("Id Member");
		IdMember.setBounds(133, 19, 86, 14);
		memberFirstnameP.add(IdMember);
		
		memberFirstname = new JTextField();
		memberFirstname.setColumns(10);
		memberFirstname.setBounds(133, 63, 153, 20);
		memberFirstnameP.add(memberFirstname);
		
		memberLastname = new JTextField();
		memberLastname.setColumns(10);
		memberLastname.setBounds(442, 63, 153, 20);
		memberFirstnameP.add(memberLastname);
		
		JLabel lblNewLabel_2 = new JLabel("Firstname");
		lblNewLabel_2.setBounds(27, 66, 101, 14);
		memberFirstnameP.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("LastName");
		lblNewLabel_1_1.setBounds(363, 66, 79, 14);
		memberFirstnameP.add(lblNewLabel_1_1);
		
		memberState = new JTextField();
		memberState.setColumns(10);
		memberState.setBounds(445, 16, 115, 20);
		memberFirstnameP.add(memberState);
		
		JLabel lblNewLabel_7 = new JLabel("State");
		lblNewLabel_7.setBounds(374, 19, 46, 14);
		memberFirstnameP.add(lblNewLabel_7);
		
		JLabel lblNewLabel_11 = new JLabel("Member");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_11.setBounds(10, 18, 107, 14);
		memberFirstnameP.add(lblNewLabel_11);
		
		idMember = new JTextField();
		idMember.setBounds(206, 16, 86, 20);
		memberFirstnameP.add(idMember);
		idMember.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(57, 152, 916, 98);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "Item", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("ISBN");
		lblNewLabel_1.setBounds(318, 26, 134, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Titel");
		lblNewLabel_2_1.setBounds(23, 68, 90, 14);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Author");
		lblNewLabel_3_1.setBounds(318, 68, 134, 14);
		panel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("Category");
		lblNewLabel_4_1.setBounds(570, 68, 134, 14);
		panel.add(lblNewLabel_4_1);
		
		isbn = new JTextField();
		isbn.setColumns(10);
		isbn.setBounds(382, 23, 134, 20);
		panel.add(isbn);
		
		JLabel lblNewLabel_6_1 = new JLabel("Type");
		lblNewLabel_6_1.setBounds(570, 26, 134, 14);
		panel.add(lblNewLabel_6_1);
		
		titel = new JTextField();
		titel.setColumns(10);
		titel.setBounds(123, 65, 137, 20);
		panel.add(titel);
		
		author = new JTextField();
		author.setColumns(10);
		author.setBounds(382, 65, 134, 20);
		panel.add(author);
		
		type = new JTextField();
		type.setColumns(10);
		type.setBounds(622, 23, 158, 20);
		panel.add(type);
		
		table = new JTable();
		table.setBounds(412, 54, 1, 1);
		panel.add(table);
		
		JLabel lblNewLabel_8 = new JLabel("Id");
		lblNewLabel_8.setBounds(30, 26, 46, 14);
		panel.add(lblNewLabel_8);
		
		category = new JTextField();
		category.setColumns(10);
		category.setBounds(622, 65, 158, 20);
		panel.add(category);
		
		idItem = new JTextField();
		idItem.setBounds(121, 23, 137, 20);
		panel.add(idItem);
		idItem.setColumns(10);
		
		JButton btnNewButton = new JButton("Cancel Reservation");
		btnNewButton.setBounds(93, 583, 166, 36);
		add(btnNewButton);
		
		Panel panelReservation = new Panel();
		panelReservation.setBounds(61, 256, 250, 265);
		add(panelReservation);
		panelReservation.setLayout(null);
		
		idReservation = new JTextField();
		idReservation.setBounds(122, 11, 118, 20);
		panelReservation.add(idReservation);
		idReservation.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Id");
		lblNewLabel.setBounds(10, 14, 46, 14);
		panelReservation.add(lblNewLabel);
		
		JLabel lblNewLabel_9 = new JLabel("Id Member");
		lblNewLabel_9.setBounds(10, 49, 126, 14);
		panelReservation.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Id Item");
		lblNewLabel_10.setBounds(10, 92, 46, 14);
		panelReservation.add(lblNewLabel_10);
		
		memberReservationId = new JTextField();
		memberReservationId.setBounds(122, 46, 118, 20);
		panelReservation.add(memberReservationId);
		memberReservationId.setColumns(10);
		
		itemIdReservation = new JTextField();
		itemIdReservation.setBounds(122, 89, 118, 20);
		panelReservation.add(itemIdReservation);
		itemIdReservation.setColumns(10);
		
		idReservedCopy = new JTextField();
		idReservedCopy.setBounds(122, 125, 118, 20);
		panelReservation.add(idReservedCopy);
		idReservedCopy.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("Id Reserved Copy");
		lblNewLabel_12.setBounds(10, 128, 126, 14);
		panelReservation.add(lblNewLabel_12);
		
		stateReservation = new JTextField();
		stateReservation.setBounds(122, 196, 118, 20);
		panelReservation.add(stateReservation);
		stateReservation.setColumns(10);
		
		JLabel lblNewLabel_13 = new JLabel("State");
		lblNewLabel_13.setBounds(10, 199, 46, 14);
		panelReservation.add(lblNewLabel_13);
		
		reservationdate = new JTextField();
		reservationdate.setBounds(122, 165, 118, 20);
		panelReservation.add(reservationdate);
		reservationdate.setColumns(10);
		
		JLabel lblNewLabel_14 = new JLabel("Date Reservation");
		lblNewLabel_14.setBounds(10, 168, 126, 14);
		panelReservation.add(lblNewLabel_14);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(341, 337, 632, 327);
		add(scrollPane);
		
		tableReservations = new JTable();
		scrollPane.setColumnHeaderView(tableReservations);
		tableReservations.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "memberId", "itemId", "copyIdReserved", "dateReservation", "state"
			}
			
		));
		scrollPane.setColumnHeaderView(tableReservations);
		scrollPane.setViewportView(tableReservations);
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSearch.setBounds(430, 282, 89, 37);
		add(btnSearch);
		
		textField_2 = new JTextField();
		textField_2.setBounds(578, 290, 183, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(61, 649, 97, 36);
		add(btnBack);

	}
	
	
	
	
	
	
	
	public JTextField getIdItem() {
		return idItem;
	}







	public void setIdItem(JTextField idItem) {
		this.idItem = idItem;
	}







	public JTextField getIdMember() {
		return idMember;
	}







	public void setIdMember(JTextField idMember) {
		this.idMember = idMember;
	}







	public JTextField getMemberLastname() {
		return memberLastname;
	}

	public JTextField getMemberFirstname() {
		return memberFirstname;
	}



	public void setMemberLastname(JTextField memberLastname) {
		this.memberLastname = memberLastname;
	}



	public void setMemberFirstname(JTextField memberFirstname) {
		this.memberFirstname = memberFirstname;
	}


	public JTextField getMemberState() {
		return memberState;
	}



	public void setMemberState(JTextField memberState) {
		this.memberState = memberState;
	}


	public JTextField getIdReservation() {
		return idReservation;
	}


	public void setIdReservation(JTextField idReservation) {
		this.idReservation = idReservation;
	}


	public JTextField getMemberReservationId() {
		return memberReservationId;
	}

	public void setMemberReservationId(JTextField memberReservationId) {
		this.memberReservationId = memberReservationId;
	}

	public JTextField getItemIdReservation() {
		return itemIdReservation;
	}

	public void setItemIdReservation(JTextField itemIdReservation) {
		this.itemIdReservation = itemIdReservation;
	}

	public JTextField getStateReservation() {
		return stateReservation;
	}

	public void setStateReservation(JTextField stateReservation) {
		this.stateReservation = stateReservation;
	}


	public JTextField getReservationdate() {
		return reservationdate;
	}

	public void setReservationdate(JTextField reservationdate) {
		this.reservationdate = reservationdate;
	}


	public JTable getTableReservations() {
		return tableReservations;
	}

	public void setTableReservations(JTable tableReservations) {
		this.tableReservations = tableReservations;
	}


	public JTextField getIdReservedCopy() {
		return idReservedCopy;
	}


	public void setIdReservedCopy(JTextField idReservedCopy) {
		this.idReservedCopy = idReservedCopy;
	}

	

	public JTextField getIsbn() {
		return isbn;
	}


	public void setIsbn(JTextField isbn) {
		this.isbn = isbn;
	}


	public JTextField getTitel() {
		return titel;
	}


	public void setTitel(JTextField titel) {
		this.titel = titel;
	}


	public JTextField getAuthor() {
		return author;
	}


	public void setAuthor(JTextField author) {
		this.author = author;
	}







	public JTextField getType() {
		return type;
	}







	public void setType(JTextField type) {
		this.type = type;
	}







	public JTextField getCategory() {
		return category;
	}







	public void setCategory(JTextField category) {
		this.category = category;
	}







	public JButton getBtnMakeReservation() {
		return btnMakeReservation;
	}







	public JTable getTable() {
		return table;
	}







	public JTextField getTextField_2() {
		return textField_2;
	}







	public JButton getBtnSearch() {
		return btnSearch;
	}







	public JButton getBtnBack() {
		return btnBack;
	}







	public void addMakeReservationListener(ActionListener actionListener){
		btnMakeReservation.addActionListener(actionListener);
		
	}
	public void addSearchReservationListener(ActionListener actionListener){
		btnSearch.addActionListener(actionListener);
		
	}

	
	public void addSelectedRowMouseListener(MouseListener mouseListener) {
		tableReservations.addMouseListener(mouseListener);
	}
	
	public void addIdMemberTextFieldListener(ActionListener actionListener) {
		idMember.addActionListener(actionListener);
	}
	public void addIdCopyItemrTextFieldListener(ActionListener actionListener) {
		idItem.addActionListener(actionListener);
	}
	public void addBackTextFieldListener(ActionListener actionListener) {
		btnBack.addActionListener(actionListener);
	}
	
	
}
