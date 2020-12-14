package com.inesshasanoui.bibliotheekbeheersysteem.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.inesshasanoui.bibliotheekbeheersysteem.controller.ManageItemController.AddItemListener;
import com.inesshasanoui.bibliotheekbeheersysteem.model.Constants;
import com.inesshasanoui.bibliotheekbeheersysteem.model.CopyItem;
import com.inesshasanoui.bibliotheekbeheersysteem.model.Item;
import com.inesshasanoui.bibliotheekbeheersysteem.model.Loan;
import com.inesshasanoui.bibliotheekbeheersysteem.model.Member;
import com.inesshasanoui.bibliotheekbeheersysteem.model.Operation;
import com.inesshasanoui.bibliotheekbeheersysteem.model.User;
import com.inesshasanoui.bibliotheekbeheersysteem.model.UserRole;
import com.inesshasanoui.bibliotheekbeheersysteem.model.UserState;
import com.inesshasanoui.bibliotheekbeheersysteem.service.CopyItemService;
import com.inesshasanoui.bibliotheekbeheersysteem.service.ItemService;
import com.inesshasanoui.bibliotheekbeheersysteem.service.LoanService;
import com.inesshasanoui.bibliotheekbeheersysteem.service.ServiceClass;
import com.inesshasanoui.bibliotheekbeheersysteem.service.UserService;
import com.inesshasanoui.bibliotheekbeheersysteem.service.exception.LoanException;
import com.inesshasanoui.bibliotheekbeheersysteem.view.ManageItemsPanel;
import com.inesshasanoui.bibliotheekbeheersysteem.view.ManageLoanPanel;
import com.inesshasanoui.bibliotheekbeheersysteem.view.ManageLoansPanel;
import com.inesshasanoui.bibliotheekbeheersysteem.view.RenewLoanPanel;
import com.inesshasanoui.bibliotheekbeheersysteem.view.ReturnCopyItemPanel;
import com.inesshasanoui.bibliotheekbeheersysteem.view.View;
import com.inesshasanoui.bibliotheekbeheersysteem.view.View.PanelEnum;

public class ManageLoanController {
	//private ManageLoanPanel manageLoanPanel;
	private ManageLoansPanel manageLoansPanel;
	private ReturnCopyItemPanel returnCopyItemPanel;
	private RenewLoanPanel renewLoanPanel;
	private LoanService loanService;
	private UserService userService;
	private ItemService itemService;
	private CopyItemService copyItemService;
	private Controller controller;
	private LoginController loginController;
	private View view;
	private User userLogin;

	public ManageLoanController(LoginController loginController,User userLogin,View view, LoanService loanService,UserService userService, ItemService itemService, CopyItemService copyItemService) {
		super();
		this.view = view;
		this.manageLoansPanel = view.getManageLoansPanel();
	//	this.manageLoanPanel=view.getManageLoanPanel();
		this.returnCopyItemPanel=view.getReturnCopyItemPanel();
		this.renewLoanPanel=view.getRenewLoanPanel();
		this.loanService = loanService;
		this.userService = userService;
		this.itemService = itemService;
		this.copyItemService = copyItemService;
		this.manageLoansPanel.addLoanListener(new AddLoanListener());
		this.manageLoansPanel.addNewLoanListener(new AddNewLoanListener());
		this.manageLoansPanel.addSearchLoanListener(new AddSearchLoanListener());
		this.manageLoansPanel.addIdMemberTextFieldListener(new IdMemberTextFieldListener());
		this.manageLoansPanel.addIdCopyItemrTextFieldListener(new IdCopyItemTextFieldListener());
		this.manageLoansPanel.addUpdateLoanListener(new AddUpdateLoanListener());
		this.manageLoansPanel.addRenewLoanListener(new AddRenewLoanListener());	
		this.manageLoansPanel.addBackListener(new AddBackListener());
		
////		this.manageLoanPanel.addReturnLoanListener(new AddReturnCopyItemListener());
///		this.manageLoanPanel.addRenewLoanListener(new AddRenewLoanListener());
//		this.manageLoanPanel.addReservationListener(new AddReservationListener ());
		this.manageLoansPanel.addSelectedRowMouseListener(new AddSelectedRowMouseListener());
		this.returnCopyItemPanel.returnCopyItemListener(new ConfirmReturnCopyItemListener());
		this.returnCopyItemPanel.addBackListener(new AddBackListener());
			
		this.loginController= loginController;
		this.userLogin = loginController.getUserLogin();
		fillComboSearch();
	}
	
	/*class AddLoanListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			view.switchToPanel(PanelEnum.addLoan);

		}
	}*/
	class AddLoanListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int copyId = GetIdCopyItemrFromPanelLoan(manageLoansPanel);
			int userId = GetIdUserFromPanelLoan(manageLoansPanel);
				 userLogin = loginController.getUserLogin();
				
			try {
				Loan loan=loanService.loanCopyItemToMember(userLogin,copyId, userId);
					JOptionPane.showMessageDialog(null, " loan with number Id"+ loan.getId()+ " is added");
								
			} catch (LoanException e1) {
				// messageBox met error vermelding
				view.messageAlertBox(e1.getMessage());
			}
			
		}
	}
	
	class AddNewLoanListener implements ActionListener  {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			resetLoanPanel();
			manageLoansPanel.getBtnUpdate().setEnabled(false);
			manageLoansPanel.getBtnRenew().setEnabled(false);
			manageLoansPanel.getBtnLoan().setEnabled(true);
		}
	
	}
	class AddUpdateLoanListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Loan loan = null;
			try {
				 loan=getLoanFromLoanPanel();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			loanService.update(loan);
			manageLoansPanel.getBtnUpdate().setEnabled(false);
			manageLoansPanel.getBtnRenew().setEnabled(true);
			manageLoansPanel.getBtnLoan().setEnabled(true);
			manageLoansPanel.getBtnNewLoan().setEnabled(true);
			
		}
		
	}
	class AddRenewLoanListener implements ActionListener  {
		public void actionPerformed(ActionEvent e) {
			Loan loan = null;
			try {
				loan = getLoanFromLoanPanel();
			} catch (ParseException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			try {
				loanService.renewLoanCopyItem(loan);
			} catch (LoanException e1) {
				view.messageAlertBox(e1.getMessage());
			}
			
	}
}
	
	class AddReturnCopyItemListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			view.switchToPanel(PanelEnum.returnCopy);

		}
	}
	
	class AddBackListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			view.switchToPanel(PanelEnum.librarian);
		}
	 }
	/*class ConfirmReturnCopyItemListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int copyId = GetIdCopyItemrFromPanelReturnLoan(returnCopyItemPanel);
			try {
				loanService.returnCopyItem(copyId);
			} catch (CopyAlreadyReturnedException e1) {
				// TODO Auto-generated catch block
				view.messageAlertBox(e1.getMessage());
			}
		}
	}*/
	class ConfirmReturnCopyItemListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int copyId = GetIdCopyItemrFromPanelReturnLoan(returnCopyItemPanel);
			try {
				Loan loan = loanService.returnCopyItem(copyId);
				if (loan.getPenality()>0)
				JOptionPane.showMessageDialog(null, " Copy with number Id"+ copyId+ " is returned, you have te pay penalty amount :"+ loan.getPenality());
				else JOptionPane.showMessageDialog(null, " Copy with number Id"+ copyId+ " is returned");
				
			} catch (LoanException e1) {
				// TODO Auto-generated catch block
				view.messageAlertBox(e1.getMessage());
			}
		}
	}
	class IdMemberTextFieldListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int id = GetIdUserFromPanelLoan(manageLoansPanel);
			User user = userService.get(id);
			manageLoansPanel.getMemberIdLoanPanel().setText(String.valueOf(id));
			setMemberManageLoansPanel(user);
			System.out.println(user + "get user from id");
			

		}

	}
	
	class IdCopyItemTextFieldListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int id = GetIdCopyItemrFromPanelLoan(manageLoansPanel);
			CopyItem copy = copyItemService.get(id);
			manageLoansPanel.getCopyIdLoanPanel().setText(String.valueOf(id));
		//	Item item= itemService.get(id);
			System.out.println(copy.getState() + "get copy from item");
			System.out.println(copy.getItem().getId() + "get idItem from item");
			System.out.println(copy.getBarcode() + "get barcode from copy");
			setCopyManageLoansPanel(copy);
			
			

		}

	}
	class AddReservationListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			view.switchToPanel(PanelEnum.makeReservation);	
	}
	}
	private int GetIdUserFromPanelLoan(ManageLoansPanel addLoanPanel) {
	
	return Integer.parseInt(addLoanPanel.getIdMember().getText());
	
}
private int GetIdCopyItemrFromPanelLoan(ManageLoansPanel manageloansPanel) {
	
	return Integer.parseInt(manageloansPanel.getIdCopy().getText());
	
}
private int GetIdCopyItemrFromPanelReturnLoan(ReturnCopyItemPanel returnCopyItemPanel) {
	return  Integer.parseInt(returnCopyItemPanel.getCopyId().getText());
}


private int GetIdCopyIdFromPanelRenewLoan(RenewLoanPanel renewLoanPanel) {
	return  Integer.parseInt(renewLoanPanel.getTextCopyId().getText());
	}


public Date addDays(Date date, int nbDay) { 
	  Calendar cal = Calendar.getInstance(); 
	  cal.setTime(date);  //setTime(date.getTime());
	  cal.add(Calendar.DATE, nbDay);
	  return cal.getTime();
	}

private void fillComboSearch() {
	manageLoansPanel.getComboBoxSearch().addItem("All");
	manageLoansPanel.getComboBoxSearch().addItem("by Id");
	manageLoansPanel.getComboBoxSearch().addItem("by Id Member");
	manageLoansPanel.getComboBoxSearch().addItem("by Id Copy");
	manageLoansPanel.getComboBoxSearch().addItem("by state");
	manageLoansPanel.getComboBoxSearch().addItem("by author");
}

class AddSearchLoanListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		String searchBy = manageLoansPanel.getComboBoxSearch().getSelectedItem().toString();
		intializeTableDataLoans();
		switch (searchBy) {
		case ("All"):
			List<Loan> loans= loanService.getAll();
			for (int i = 0; i < loans.size(); i++)
				setUpTableDataLoans(loans.get(i));
			break;

		case ("by Id"):
			int id = Integer.parseInt(manageLoansPanel.getTextSearch().getText());
				Loan loan = loanService.get(id);
				setUpTableDataLoans(loan);
			break;
	
	}
	}	
}
class AddSelectedRowMouseListener implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		setManageLoanssPanelFromJTable();
		manageLoansPanel.getBtnLoan().setEnabled(false);
		manageLoansPanel.getBtnNewLoan().setEnabled(true);
		manageLoansPanel.getBtnUpdate().setEnabled(true);
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

	void intializeTableDataLoans() {
		JTable jTable = manageLoansPanel.getTableLoans();
		DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
		tableModel.setRowCount(0);
	}

	private void setUpTableDataLoans(Loan loan) {
	JTable jTable = manageLoansPanel.getTableLoans();
	DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
	
	String[] data = new String[7];
	data[0] = String.valueOf(loan.getId());
	data[1] = String.valueOf(loan.getUserId());
	data[2] = String.valueOf(loan.getCopyId());
	data[3] =String.valueOf(loan.getDateLoaned());
	data[4] = String.valueOf(loan.getReturnDate());
	data[5] =  String.valueOf(loan.getReturnedDate());
	data[6] = String.valueOf(loan.getPenality());
	tableModel.addRow(data);
	manageLoansPanel.getTableLoans().setModel(tableModel);
}
	private void setMemberManageLoansPanel(User user) {
	manageLoansPanel.getStateMemberTextField().setText(user.getState().toString());
	manageLoansPanel.getFirstnameTextField().setText(user.getPerson().getFirstname());
	manageLoansPanel.getLastnameTextField().setText(user.getPerson().getLastname());
	//manageLoansPanel.getAdresTextField().setText(user.getPerson().getAdres());
//	manageLoansPanel.getEmailTextField().setText(user.getPerson().getEmail());
	manageLoansPanel.getPhonetextField().setText(String.valueOf(user.getPerson().getTel()));		
}

	private void setCopyManageLoansPanel(CopyItem copy) {
//	manageLoansPanel.getTitelTextField().setText(copy.getItem().getTitle());
	manageLoansPanel.getStateCopyTextField().setText(copy.getState().toString());
	manageLoansPanel.getBarcodeTextField().setText(String.valueOf(copy.getBarcode()));
//	manageLoansPanel.getAuthorTextField().setText(copy.getItem().getAuthor());
	
}
private Loan getLoanFromLoanPanel() throws ParseException {
	Loan loan = null;
	int id =Integer.parseInt(manageLoansPanel.getIdLoan().getText());
	 int copyId =Integer.parseInt(manageLoansPanel.getCopyIdLoanPanel().getText());
	 int userId = Integer.parseInt(manageLoansPanel.getMemberIdLoanPanel().getText());
	 SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	 Date returnDate = simpleDateFormat.parse(manageLoansPanel.getDateReturnLoanPanel().getText().toString());
	 Date returnedDate=null;
	 if(!manageLoansPanel.getDateReturnedLoanPanel().getText().toString().equals("null")) {
	  returnedDate =simpleDateFormat.parse(manageLoansPanel.getDateReturnedLoanPanel().getText().toString());}
	 Float penality =Float.valueOf(manageLoansPanel.getPenaltyLoanPanel().getText()).floatValue();
	 CopyItem copyItem;
	 Date dateLoaned = simpleDateFormat.parse(manageLoansPanel.getDateLoanedLoanPanel().getText().toString());
	 System.out.println(manageLoansPanel.getDateReturnedLoanPanel().getText().toString()+"manageLoansPanel.getDateReturnedLoanPanel().getText().toString()");
	 System.out.println("getLoanFromLoanPanel id"+ id);
	 System.out.println("getLoanFromLoanPanel userId"+ userId);
	 System.out.println("getLoanFromLoanPanel copyId"+ copyId);
	 System.out.println("getLoanFromLoanPanel dateLoaned"+ dateLoaned);
	 System.out.println("getLoanFromLoanPanel returnDate"+ returnDate);
	 System.out.println("getLoanFromLoanPanel returnedDate"+ returnedDate);
	 System.out.println("getLoanFromLoanPanel penality"+ penality);
	 
	 loan = new  Loan( id, userId, copyId, dateLoaned, returnDate, returnedDate,  penality);
	return loan;
	
}
private void setManageLoanssPanelFromJTable() {
	JTable jTable = manageLoansPanel.getTableLoans();
	int selectedRow = jTable.getSelectedRow();
	System.out.println(selectedRow);
	manageLoansPanel.getIdLoan().setText((String) jTable.getModel().getValueAt(selectedRow, 0));
	manageLoansPanel.getMemberIdLoanPanel().setText((String) jTable.getModel().getValueAt(selectedRow, 1));
	manageLoansPanel.getCopyIdLoanPanel().setText((String) jTable.getModel().getValueAt(selectedRow, 2));
	manageLoansPanel.getDateLoanedLoanPanel().setText((String) jTable.getModel().getValueAt(selectedRow,3));
	manageLoansPanel.getDateReturnLoanPanel().setText((String) jTable.getModel().getValueAt(selectedRow, 4));
	manageLoansPanel.getDateReturnedLoanPanel().setText((String) jTable.getModel().getValueAt(selectedRow, 5));
	manageLoansPanel.getPenaltyLoanPanel().setText((String) jTable.getModel().getValueAt(selectedRow, 6));
}

private void resetLoanPanel() {
	manageLoansPanel.getIdLoan().setText(null);
	manageLoansPanel.getMemberIdLoanPanel().setText(null);
	manageLoansPanel.getCopyIdLoanPanel().setText(null);
	manageLoansPanel.getDateLoanedLoanPanel().setText(null);
	manageLoansPanel.getDateReturnedLoanPanel().setText(null);
	manageLoansPanel.getDateReturnLoanPanel().setText(null);
	manageLoansPanel.getPenaltyLoanPanel().setText(null);
}


}


