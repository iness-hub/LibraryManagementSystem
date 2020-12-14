package com.inesshasanoui.bibliotheekbeheersysteem.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.border.TitledBorder;

public class ManageItemsPanel extends JPanel {

//	private JPanel NewAdherent;
	private JTextField isbnTextField;
	private JTextField titelTextField;
	private JTextField authorTextField;
	private JTextField summaryTextField;
	private JButton btnConfirm;
	private JComboBox typeComboBox;
	private JComboBox categoryComboBox ;
	private JButton AddCategoryButton;
	private JTable table;
	private JButton btnAddItem;
	private JButton btnUpdateItem;
	private JButton btnDeleteItem;
	private JTextField textIdItem;
	private JLabel lblNewLabel_8;
	private JTable tableItems;
	private JTextField textSearch;
	private JComboBox comboBoxSearch;
	private JButton btnSearch;
	private JButton btnBack;
	private JButton btnNewItem;
	private JPanel panel;
	private JButton btnManageCopy;
	/**
	 * Create the panel
	 */
	public ManageItemsPanel() {
		setBounds(100, 100, 895, 506);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBack.setBounds(65, 427, 89, 23);
		this.add(btnBack);
		
		btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnConfirm.setBounds(279, 427, 89, 23);
		this.add(btnConfirm);
		
		AddCategoryButton = new JButton("Add category");
		AddCategoryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		AddCategoryButton.setBounds(65, 366, 125, 40);
		add(AddCategoryButton);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(367, 11, 1, 346);
		add(separator);
		
		btnAddItem = new JButton("Add item");
		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAddItem.setBounds(189, 288, 125, 40);
		add(btnAddItem);
		
		btnUpdateItem = new JButton("Update item");
		btnUpdateItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUpdateItem.setBounds(65, 327, 125, 40);
		add(btnUpdateItem);
		
		btnDeleteItem = new JButton("Delete Item");
		btnDeleteItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDeleteItem.setBounds(189, 327, 125, 40);
		add(btnDeleteItem);
		
		btnManageCopy = new JButton("Manage Copy");
		btnManageCopy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnManageCopy.setBounds(188, 366, 125, 40);
		add(btnManageCopy);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(445, 120, 613, 359);
		add(scrollPane);
		
		tableItems = new JTable();
		tableItems.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Id", "Category", "Type", "Title", "identificatieNb", "Author", "Summary"
			}
		));
		scrollPane.setViewportView(tableItems);
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSearch.setBounds(546, 62, 89, 41);
		add(btnSearch);
		
		textSearch = new JTextField();
		textSearch.setBounds(669, 70, 194, 33);
		add(textSearch);
		textSearch.setColumns(10);
		
		 comboBoxSearch = new JComboBox();
		comboBoxSearch.setBounds(669, 31, 194, 22);
		add(comboBoxSearch);
		
		btnNewItem = new JButton("New Item");
		btnNewItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewItem.setBounds(65, 288, 125, 40);
		add(btnNewItem);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Item", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 42, 425, 235);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ISBN");
		lblNewLabel.setBounds(22, 54, 134, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Titel");
		lblNewLabel_2.setBounds(22, 85, 134, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Author");
		lblNewLabel_3.setBounds(22, 110, 134, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Category");
		lblNewLabel_4.setBounds(22, 185, 134, 14);
		panel.add(lblNewLabel_4);
		
		isbnTextField = new JTextField();
		isbnTextField.setBounds(126, 51, 280, 20);
		panel.add(isbnTextField);
		isbnTextField.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Summary");
		lblNewLabel_5.setBounds(22, 160, 134, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Type");
		lblNewLabel_6.setBounds(22, 135, 134, 14);
		panel.add(lblNewLabel_6);
		
		titelTextField = new JTextField();
		titelTextField.setBounds(126, 82, 280, 20);
		panel.add(titelTextField);
		titelTextField.setColumns(10);
		
		authorTextField = new JTextField();
		authorTextField.setBounds(126, 107, 280, 20);
		panel.add(authorTextField);
		authorTextField.setColumns(10);
		
		summaryTextField = new JTextField();
		summaryTextField.setBounds(126, 157, 281, 20);
		panel.add(summaryTextField);
		summaryTextField.setColumns(10);
		
		typeComboBox = new JComboBox();
		typeComboBox.setBounds(126, 131, 280, 20);
		panel.add(typeComboBox);
		
		categoryComboBox = new JComboBox();
		categoryComboBox.setBounds(126, 181, 281, 22);
		panel.add(categoryComboBox);
		
		table = new JTable();
		table.setBounds(412, 54, 1, 1);
		panel.add(table);
		
		textIdItem = new JTextField();
		textIdItem.setEnabled(false);
		textIdItem.setBounds(123, 23, 280, 20);
		panel.add(textIdItem);
		textIdItem.setColumns(10);
		
		lblNewLabel_8 = new JLabel("Id");
		lblNewLabel_8.setBounds(30, 26, 46, 14);
		panel.add(lblNewLabel_8);
	}
	public void addItemConfirmListener(ActionListener actionListener) {
        btnConfirm.addActionListener(actionListener);
       
    }
	
	
	
	public JButton getAddCategoryButton() {
		return AddCategoryButton;
	}
	
	public JButton getBtnAddItem() {
		return btnAddItem;
	}
	
	public JButton getBtnUpdateItem() {
		return btnUpdateItem;
	}
	
	public JButton getBtnDeleteItem() {
		return btnDeleteItem;
	}
	
	public JButton getBtnNewItem() {
		return btnNewItem;
	}
	
	public JComboBox getTypeCombo() {
		return typeComboBox;
	}
	
	public JComboBox getCategoryCombo() {
		return categoryComboBox;
	}
	public void setCategoryComboBox(JComboBox categoryComboBox) {
		this.categoryComboBox = categoryComboBox;
	}
	public void addcomboBoxListener(ActionListener actionListener) {
		typeComboBox.addActionListener(actionListener);
    }
	
	
	public JTable getTableItems() {
		return tableItems;
	}
	public void setTableItems(JTable tableItems) {
		this.tableItems = tableItems;
	}
	public JTextField getIsbnTextField() {
		return isbnTextField;
	}
	
	public JTextField getTitelTextField() {
		return titelTextField;
	}
	public JTextField getAuthorTextField() {
		return authorTextField;
	}
	

	public JTextField getSummaryTextField() {
		// TODO Auto-generated method stub
		return summaryTextField;
	}
	
	public JTextField getTextIdItem() {
		return textIdItem;
	}
	public void setTextIdItem(JTextField textIdItem) {
		this.textIdItem = textIdItem;
	}
	public JButton getBtnSearch() {
		return btnSearch;
	}
	
	public JTextField getTextSearch() {
		return textSearch;
	}
	public void setTextSearch(JTextField textSearch) {
		this.textSearch = textSearch;
	}
	public JComboBox getComboBoxSearch() {
		return comboBoxSearch;
	}
	public void setComboBoxSearch(JComboBox comboBoxSearch) {
		this.comboBoxSearch = comboBoxSearch;
	}
	
	public void setBtnSearch(JButton btnSearch) {
		this.btnSearch = btnSearch;
	}
	public void addItemListener(ActionListener actionListener) {
		btnAddItem.addActionListener(actionListener);
    }
	public void addSearchItemListener(ActionListener actionListener) {
		btnSearch.addActionListener(actionListener);
    }
	public void addSelectedRowMouseListener(MouseListener mouseListener) {
		tableItems.addMouseListener(mouseListener);
	}
	public void addBackListener(ActionListener actionListener) {
		btnBack.addActionListener(actionListener);
    }
	public void addNewItemListener(ActionListener actionListener) {
		btnNewItem.addActionListener(actionListener);
    }
	public void addUpdateItemListener(ActionListener actionListener) {
		btnUpdateItem.addActionListener(actionListener);
    }
	public void addDeleteItemListener(ActionListener actionListener) {
		btnDeleteItem.addActionListener(actionListener);
	}
	public void addManageCopyListener(ActionListener actionListener) {
		btnManageCopy.addActionListener(actionListener);
	}

}
