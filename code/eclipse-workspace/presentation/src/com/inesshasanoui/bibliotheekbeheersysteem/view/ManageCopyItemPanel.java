package com.inesshasanoui.bibliotheekbeheersysteem.view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Panel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class ManageCopyItemPanel extends JPanel {
	private JTable tableCopies;
	private JTextField textIdItem;
	private JTextField textIsbn;
	private JTextField textCategory;
	private JLabel lblNewLabel_2;
	private JTextField textAuthor;
	private JLabel lblNewLabel_3;
	private JTextField textType;
	private JLabel lblNewLabel_4;
	private JTextField textTitle;
	private JLabel lblNewLabel_5;
	private JPanel panel;
	private JPanel panel_1;
	private JTextField textIdCopy;
	private JTextField textBarcode;
	private JTextField textState;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JTextField textField_9;
	private JButton btnSearchCopy;
	private JButton btnNewCopy;
	private JButton btnUpdateCopy;
	private JButton btnDeleteCopy;
	private JButton btnBack;
	private JButton btnAddCopy;
	private JComboBox comboBoxSearchCopy;

	/**
	 * Create the panel.
	 */
	public ManageCopyItemPanel() {
		setBorder(new TitledBorder(null, "Item", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(312, 204, 487, 349);
		add(scrollPane);
		
		tableCopies = new JTable();
		tableCopies.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Barcode", "State"
			}
		));
		scrollPane.setViewportView(tableCopies);
		
		panel = new JPanel();
		panel.setBounds(10, 11, 789, 106);
		add(panel);
		panel.setLayout(null);
		
		textIdItem = new JTextField();
		textIdItem.setEnabled(false);
		textIdItem.setBounds(85, 11, 114, 20);
		panel.add(textIdItem);
		textIdItem.setColumns(10);
		
		textIsbn = new JTextField();
		textIsbn.setEnabled(false);
		textIsbn.setBounds(85, 64, 114, 20);
		panel.add(textIsbn);
		textIsbn.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Id Item");
		lblNewLabel.setBounds(10, 14, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ISBN");
		lblNewLabel_1.setBounds(10, 67, 46, 14);
		panel.add(lblNewLabel_1);
		
		textType = new JTextField();
		textType.setEnabled(false);
		textType.setBounds(544, 64, 149, 20);
		panel.add(textType);
		textType.setColumns(10);
		
		lblNewLabel_4 = new JLabel("Type");
		lblNewLabel_4.setBounds(488, 67, 46, 14);
		panel.add(lblNewLabel_4);
		
		textCategory = new JTextField();
		textCategory.setEnabled(false);
		textCategory.setBounds(310, 11, 127, 20);
		panel.add(textCategory);
		textCategory.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Category");
		lblNewLabel_2.setBounds(233, 14, 76, 14);
		panel.add(lblNewLabel_2);
		
		textAuthor = new JTextField();
		textAuthor.setEnabled(false);
		textAuthor.setBounds(310, 64, 127, 20);
		panel.add(textAuthor);
		textAuthor.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Author");
		lblNewLabel_3.setBounds(233, 67, 70, 14);
		panel.add(lblNewLabel_3);
		
		textTitle = new JTextField();
		textTitle.setEnabled(false);
		textTitle.setBounds(544, 11, 149, 20);
		panel.add(textTitle);
		textTitle.setColumns(10);
		
		lblNewLabel_5 = new JLabel("Title");
		lblNewLabel_5.setBounds(488, 14, 46, 14);
		panel.add(lblNewLabel_5);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Copy", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 159, 272, 195);
		add(panel_1);
		panel_1.setLayout(null);
		
		textIdCopy = new JTextField();
		textIdCopy.setEnabled(false);
		textIdCopy.setBounds(128, 28, 86, 20);
		panel_1.add(textIdCopy);
		textIdCopy.setColumns(10);
		
		textBarcode = new JTextField();
		textBarcode.setBounds(128, 77, 86, 20);
		panel_1.add(textBarcode);
		textBarcode.setColumns(10);
		
		textState = new JTextField();
		textState.setBounds(128, 134, 86, 20);
		panel_1.add(textState);
		textState.setColumns(10);
		
		lblNewLabel_6 = new JLabel("Id Copy");
		lblNewLabel_6.setBounds(30, 31, 46, 14);
		panel_1.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Barcode");
		lblNewLabel_7.setBounds(30, 80, 131, 14);
		panel_1.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("State");
		lblNewLabel_8.setBounds(30, 137, 46, 14);
		panel_1.add(lblNewLabel_8);
		
		textField_9 = new JTextField();
		textField_9.setBounds(553, 159, 208, 27);
		add(textField_9);
		textField_9.setColumns(10);
		
		btnSearchCopy = new JButton("Search");
		btnSearchCopy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSearchCopy.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSearchCopy.setBounds(428, 128, 89, 58);
		add(btnSearchCopy);
		
		btnNewCopy = new JButton("New Copy");
		btnNewCopy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewCopy.setBounds(20, 391, 120, 34);
		add(btnNewCopy);
		
		btnUpdateCopy = new JButton("Update Copy");
		btnUpdateCopy.setBounds(140, 424, 120, 34);
		add(btnUpdateCopy);
		
		btnDeleteCopy = new JButton("Delete Copy");
		btnDeleteCopy.setBounds(20, 424, 120, 34);
		add(btnDeleteCopy);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBack.setBounds(10, 519, 89, 34);
		add(btnBack);
		
		btnAddCopy = new JButton("Add Copy");
		btnAddCopy.setBounds(140, 391, 120, 34);
		add(btnAddCopy);
		
		comboBoxSearchCopy = new JComboBox();
		comboBoxSearchCopy.setBounds(553, 126, 208, 27);
		add(comboBoxSearchCopy);

	}

	public JTable getTable() {
		return tableCopies;
	}

	public void setTable(JTable table) {
		this.tableCopies = table;
	}

	public JTextField getTextIdItem() {
		return textIdItem;
	}

	public JTextField getTextIsbn() {
		return textIsbn;
	}

	public JTextField getTextCategory() {
		return textCategory;
	}

	public JTextField getTextAuthor() {
		return textAuthor;
	}

	public JTextField getTextType() {
		return textType;
	}

	public JTextField getTextTitle() {
		return textTitle;
	}

	public JTextField getTextIdCopy() {
		return textIdCopy;
	}

	public JTextField getTextBarcode() {
		return textBarcode;
	}

	public JTextField getTextState() {
		return textState;
	}

	public JTextField getTextField_9() {
		return textField_9;
	}

	
	
	public JButton getBtnSearchCopy() {
		return btnSearchCopy;
	}

	public void setBtnSearchCopy(JButton btnSearchCopy) {
		this.btnSearchCopy = btnSearchCopy;
	}

	public JButton getBtnNewCopy() {
		return btnNewCopy;
	}

	public void setBtnNewCopy(JButton btnNewCopy) {
		this.btnNewCopy = btnNewCopy;
	}

	public JButton getBtnUpdateCopy() {
		return btnUpdateCopy;
	}

	public void setBtnUpdateCopy(JButton btnUpdateCopy) {
		this.btnUpdateCopy = btnUpdateCopy;
	}

	public JButton getBtnDeleteCopy() {
		return btnDeleteCopy;
	}

	public void setBtnDeleteCopy(JButton btnDeleteCopy) {
		this.btnDeleteCopy = btnDeleteCopy;
	}

	public JButton getBtnBack() {
		return btnBack;
	}

	public void setBtnBack(JButton btnBack) {
		this.btnBack = btnBack;
	}

	public JButton getBtnAddCopy() {
		return btnAddCopy;
	}

	public void setBtnAddCopy(JButton btnAddCopy) {
		this.btnAddCopy = btnAddCopy;
	}

	public JComboBox getComboBoxSearchCopy() {
		return comboBoxSearchCopy;
	}

	public void setComboBoxSearchCopy(JComboBox comboBoxSearchCopy) {
		this.comboBoxSearchCopy = comboBoxSearchCopy;
	}

	public JTable getTableCopies() {
		return tableCopies;
	}

	public JLabel getLblNewLabel_2() {
		return lblNewLabel_2;
	}

	public JLabel getLblNewLabel_3() {
		return lblNewLabel_3;
	}

	public JLabel getLblNewLabel_4() {
		return lblNewLabel_4;
	}

	public JLabel getLblNewLabel_5() {
		return lblNewLabel_5;
	}

	public JPanel getPanel() {
		return panel;
	}

	public JPanel getPanel_1() {
		return panel_1;
	}

	public JLabel getLblNewLabel_6() {
		return lblNewLabel_6;
	}

	public JLabel getLblNewLabel_7() {
		return lblNewLabel_7;
	}

	public JLabel getLblNewLabel_8() {
		return lblNewLabel_8;
	}

	public void addBackListener(ActionListener act) {
		btnBack.addActionListener(act);
	}
	
	public void addNewCopyListener(ActionListener act) {
		btnNewCopy.addActionListener(act);
	}
	public void addCopyListener(ActionListener act) {
		btnAddCopy.addActionListener(act);
	}
	public void addDeleteCopyListener(ActionListener act) {
		btnDeleteCopy.addActionListener(act);
	}
	public void addUpdateListener(ActionListener act) {
		btnUpdateCopy.addActionListener(act);
	}
	public void addSelectedCopyRowMouseListener(MouseListener mouseListener) {
		tableCopies.addMouseListener(mouseListener);
	}

}
