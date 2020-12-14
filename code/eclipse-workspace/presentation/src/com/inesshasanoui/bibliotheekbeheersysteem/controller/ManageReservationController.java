package com.inesshasanoui.bibliotheekbeheersysteem.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.inesshasanoui.bibliotheekbeheersysteem.model.Item;
import com.inesshasanoui.bibliotheekbeheersysteem.model.ItemFactory;
import com.inesshasanoui.bibliotheekbeheersysteem.model.Loan;
import com.inesshasanoui.bibliotheekbeheersysteem.model.Member;
import com.inesshasanoui.bibliotheekbeheersysteem.model.Reservation;
import com.inesshasanoui.bibliotheekbeheersysteem.model.User;
import com.inesshasanoui.bibliotheekbeheersysteem.service.ItemService;
import com.inesshasanoui.bibliotheekbeheersysteem.service.ReservationService;
import com.inesshasanoui.bibliotheekbeheersysteem.service.UserService;
import com.inesshasanoui.bibliotheekbeheersysteem.view.ManageLoansPanel;
import com.inesshasanoui.bibliotheekbeheersysteem.view.ManageReservationsPanel;
import com.inesshasanoui.bibliotheekbeheersysteem.view.View;
import com.inesshasanoui.bibliotheekbeheersysteem.view.View.PanelEnum;

public class ManageReservationController {

	private ManageReservationsPanel manageReservationsPanel;
	private View view;
	private ReservationService reservationService;
	private UserService userService;
	private ItemService itemService;
	
	public ManageReservationController( View view,ReservationService reservationService,UserService userService, ItemService itemService ) {
		super();
		this.manageReservationsPanel = view.getMakeReservationPanel();
		this.manageReservationsPanel.addMakeReservationListener(new AddMakeReservationListener() );
		this.manageReservationsPanel.addSelectedRowMouseListener(new AddSelectedRowMouseListener());
		this.manageReservationsPanel.addIdMemberTextFieldListener(new AddIdMemberTextFieldListener ());;
		this.manageReservationsPanel.addIdCopyItemrTextFieldListener(new AddIdCopyItemrTextFieldListener());
		this.manageReservationsPanel.addSearchReservationListener(new AddSearchReservationListener());
		this.manageReservationsPanel.addBackTextFieldListener(new AddBackTextFieldListener());
		this.reservationService=reservationService;
		this.userService = userService;
		this.itemService = itemService;
		this.view = view;
	}
	
	class AddMakeReservationListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			 int userId =getIdUserFromMakeReservationPanel(manageReservationsPanel);
			 int itemId=getIdItemrFromMakeReservationPanel(manageReservationsPanel);
			 Date dateReservation = null;
			  reservationService.makeReservation(itemId,userId);
			
			
		}
	}
	class AddIdMemberTextFieldListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			int userId =getIdUserFromMakeReservationPanel(manageReservationsPanel);
			User user = userService.get(userId);
			
			setMemberManageReservationsPanel(user);
			System.out.println(user + "get user from id");
			
		}
			}
	
	class AddIdCopyItemrTextFieldListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			int itemId = getIdItemrFromMakeReservationPanel(manageReservationsPanel);
			Item item = itemService.get(itemId);
			setItemManageReservationsPanel(item); 
			
		}
			}
	
	class AddSearchReservationListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			intializeTableData();
			List<Reservation> reservations= reservationService.getAll();
			for (int i = 0; i < reservations.size(); i++)
				setUpTableData(reservations.get(i));
			
		}
		
	}
	 class AddBackTextFieldListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			view.switchToPanel(PanelEnum.librarian);
			
		}
		 
	 }
		

	
	class AddSelectedRowMouseListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	private int getIdItemrFromMakeReservationPanel(ManageReservationsPanel manageReservationsPanel) {
		
		return Integer.parseInt(manageReservationsPanel.getIdItem().getText());
		
	}
	
	private int getIdUserFromMakeReservationPanel( ManageReservationsPanel manageReservationsPanel) {
		
		return Integer.parseInt(manageReservationsPanel.getIdMember().getText());
		
	}

private void intializeTableData() {
	JTable jTable = manageReservationsPanel.getTableReservations();
	DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
	tableModel.setRowCount(0);
   	
}

private void setUpTableData(Reservation reservation) {
	JTable jTable = manageReservationsPanel.getTableReservations();
	DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
	
	String[] data = new String[9];
	data[0] = String.valueOf(reservation.getId());
	data[1] =String.valueOf(reservation.getUserId());
	data[2] = String.valueOf(reservation.getItemId());
	data[3] = String.valueOf(reservation.getCopyIdReserved());
	data[4] = String.valueOf(reservation.getDateReservation());
	data[5] = reservation.getStateReservation().toString();
	tableModel.addRow(data);
	 manageReservationsPanel.getTableReservations().setModel(tableModel);
}

private void setRerservationPanelFromJTable() {
	JTable jTable = manageReservationsPanel.getTableReservations();
	int selectedRow = jTable.getSelectedRow();
	System.out.println(selectedRow);
	manageReservationsPanel.getIdReservation().setText((String) jTable.getModel().getValueAt(selectedRow, 0));
	manageReservationsPanel.getMemberReservationId().setText((String) jTable.getModel().getValueAt(selectedRow, 1));
	manageReservationsPanel.getItemIdReservation().setText((String) jTable.getModel().getValueAt(selectedRow, 2));
	
}
private void setMemberManageReservationsPanel(User user) {
	manageReservationsPanel.getMemberState().setText(user.getState().toString());
	manageReservationsPanel.getMemberFirstname().setText(user.getPerson().getFirstname());
	manageReservationsPanel.getMemberLastname().setText(user.getPerson().getLastname());
	
}
private void setItemManageReservationsPanel(Item item) {
	manageReservationsPanel.getIsbn().setText(Integer.toString(item.getIsbn()));
	manageReservationsPanel.getAuthor().setText(item.getAuthor());
	manageReservationsPanel.getTitel().setText(item.getTitle());
//	manageReservationsPanel.getCategory().setText(item.getCategory().getName().toString());
	manageReservationsPanel.getType().setText(ItemFactory.getTypeItem(item).toString());
	System.out.println(ItemFactory.getTypeItem(item).toString() + "item.getTypeItem().toString()");
			}
}
