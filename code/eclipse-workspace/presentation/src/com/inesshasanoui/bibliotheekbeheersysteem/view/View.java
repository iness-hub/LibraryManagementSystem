package com.inesshasanoui.bibliotheekbeheersysteem.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class View  {

	private JPanel contentPane;
	private JFrame homeFrame;
	private LoginPanel loginPanel;
	private LibrarianPanel librarianPanel;
	private MemberPanel memberPanel;
	private ManageMembersPanel manageMembersPanel;
	private ManageItemsPanel manageItemsPanel;
	private ManageCopyItemPanel manageCopyItemPanel;
	private ManageLoanPanel manageLoanPanel;
	private ManageLoansPanel manageLoansPanel;
	private RenewLoanPanel renewLoanPanel;
	private ReturnCopyItemPanel returnCopyItemPanel;
	private ReportPanel reportPanel;
	private ManageReservationsPanel makeReservationPanel;
	
	CardLayout cl = new CardLayout();
	public enum PanelEnum  {login,librarian,member,addMyProfile,addMyLoanedItems,makeReservation,manageLoan,manageMember,manageItem, manageCopy,addMember,updateMember,deleteMember,addItem,deleteItem,searchItem,updateItem,addLoan,renewLoan,returnCopy,ManageReport};
	

	/**
	 * Create the frame.
	 */
	public View() {
		
		this.homeFrame = new JFrame();
		homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		homeFrame.setBounds(100, 100, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(cl);
		homeFrame.setContentPane(contentPane);
		
	
		this.loginPanel = new LoginPanel();
		this.librarianPanel = new LibrarianPanel();
		this.memberPanel = new MemberPanel();
		this. manageMembersPanel= new ManageMembersPanel();
		
		this.manageLoanPanel= new ManageLoanPanel();
		this.reportPanel = new ReportPanel();
		
		this.manageItemsPanel = new ManageItemsPanel();
		this.manageCopyItemPanel = new ManageCopyItemPanel();
				
		this.manageCopyItemPanel = new ManageCopyItemPanel();
		contentPane.add(manageCopyItemPanel, PanelEnum.manageCopy.toString());	
		
		this.manageLoansPanel = new ManageLoansPanel();
		this.renewLoanPanel = new RenewLoanPanel();
		this.returnCopyItemPanel = new ReturnCopyItemPanel();
		contentPane.add(loginPanel, PanelEnum.login.toString());
		
		this.makeReservationPanel = new ManageReservationsPanel();
		contentPane.add(makeReservationPanel, PanelEnum.makeReservation.toString());
		
		
		contentPane.add(librarianPanel, PanelEnum.librarian.toString());
		contentPane.add(memberPanel, PanelEnum.member.toString());
	
		contentPane.add(manageMembersPanel, PanelEnum.manageMember.toString());
	
		contentPane.add(manageItemsPanel, PanelEnum.manageItem.toString());
	
		
		contentPane.add(manageLoanPanel, PanelEnum.manageLoan.toString());
		contentPane.add(manageLoansPanel, PanelEnum.addLoan.toString());
		contentPane.add(renewLoanPanel, PanelEnum.renewLoan.toString());
		contentPane.add(returnCopyItemPanel, PanelEnum.returnCopy.toString());
		
		contentPane.add(reportPanel, PanelEnum.ManageReport.toString());
		homeFrame.setVisible(true);
		switchToPanel(PanelEnum.login);
		
		
	}
public void messageAlertBox (String message) {
	JOptionPane.showMessageDialog(null, message);
	
	
}
	public void switchToPanel(PanelEnum panelEnum){
		cl.show(contentPane,panelEnum.toString());
	}
	
	public JPanel getContentPane() {
		return contentPane;
	}

	public JFrame getHomeFrame() {
		return homeFrame;
	}

	public LoginPanel getLoginPanel() {
		return loginPanel;
	}

	public LibrarianPanel getLibrarianPanel() {
		return librarianPanel;
	}

	public ManageMembersPanel getManageMembersPanel() {
		return manageMembersPanel;
	}
	public ManageLoanPanel getManageLoanPanel() {
		return manageLoanPanel;
	}

	public ReturnCopyItemPanel getReturnCopyItemPanel() {
		return returnCopyItemPanel;
	}
	
	public ReportPanel getReportPanel() {
		return reportPanel;
	}

	public CardLayout getCl() {
		return cl;
	}

	public ManageItemsPanel getManageItemsPanel() {
		return manageItemsPanel;
	}

	public ManageReservationsPanel getMakeReservationPanel() {
		return makeReservationPanel;
	}

	public ManageLoansPanel getManageLoansPanel() {
		return manageLoansPanel;
	}

	public RenewLoanPanel getRenewLoanPanel() {
		return renewLoanPanel;
	}
	public MemberPanel getMemberPanel() {
		return memberPanel;
	}
	public void setContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
	}
	public void setHomeFrame(JFrame homeFrame) {
		this.homeFrame = homeFrame;
	}
	public void setLoginPanel(LoginPanel loginPanel) {
		this.loginPanel = loginPanel;
	}
	public void setLibrarianPanel(LibrarianPanel librarianPanel) {
		this.librarianPanel = librarianPanel;
	}
	public void setMemberPanel(MemberPanel memberPanel) {
		this.memberPanel = memberPanel;
	}
	public void setManageMembersPanel(ManageMembersPanel manageMembersPanel) {
		this.manageMembersPanel = manageMembersPanel;
	}
	
	public void setManageItemsPanel(ManageItemsPanel manageItemsPanel) {
		this.manageItemsPanel = manageItemsPanel;
	}
	
	
	public void setRenewLoanPanel(RenewLoanPanel renewLoanPanel) {
		this.renewLoanPanel = renewLoanPanel;
	}
	public void setReturnCopyItemPanel(ReturnCopyItemPanel returnCopyItemPanel) {
		this.returnCopyItemPanel = returnCopyItemPanel;
	}
	public void setReportPanel(ReportPanel reportPanel) {
		this.reportPanel = reportPanel;
	}
	public void setMakeReservationPanel(ManageReservationsPanel makeReservationPanel) {
		this.makeReservationPanel = makeReservationPanel;
	}
	public ManageCopyItemPanel getManageCopyItemPanel() {
		return manageCopyItemPanel;
	}
	public void setCl(CardLayout cl) {
		this.cl = cl;
	}

	
}



