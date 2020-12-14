package com.inesshasanoui.bibliotheekbeheersysteem.controller;

import com.inesshasanoui.bibliotheekbeheersysteem.model.User;
import com.inesshasanoui.bibliotheekbeheersysteem.service.CategoryService;
import com.inesshasanoui.bibliotheekbeheersysteem.service.LoanService;
import com.inesshasanoui.bibliotheekbeheersysteem.service.ReservationService;
import com.inesshasanoui.bibliotheekbeheersysteem.service.RoleUserService;
import com.inesshasanoui.bibliotheekbeheersysteem.service.ServiceClass;
import com.inesshasanoui.bibliotheekbeheersysteem.view.ManageReservationsPanel;
import com.inesshasanoui.bibliotheekbeheersysteem.view.View;

public class Controller {
	private View view;
	
	private  ServiceClass serviceClass;
	private LoginController loginController; 
	private LibrarianController librarianController; 
	private MemberController memberController; 
	private ManageMemberController manageMemberController;	
	private ManageItemController manageItemController;
	private ManageLoanController manageLoanController;
	private ManageReportController manageReportController;
	private ManageReservationController ManageReservationController;
	private LoanService loanService;
	private CategoryService categoryService;
	private RoleUserService roleUserService;
	private ReservationService reservationService;
	private User userLogin; 

	
	public Controller (View view,ServiceClass serviceClass)//UserService userService,ItemService itemService,AuthenticationService authenticationService) 
	{
		this.view = view;
		this.serviceClass=serviceClass;
		this.loginController = new LoginController(view,serviceClass.getAuthenticationService());
		this.librarianController = new LibrarianController(view,serviceClass.getUserService());
		this.memberController = new MemberController(view,serviceClass.getUserService());
		this.manageMemberController= new ManageMemberController(view,serviceClass.getUserService(),serviceClass.getRoleUserService(),serviceClass.getStateUserService());	
		this.manageItemController= new ManageItemController(view,serviceClass.getItemService(),serviceClass.getCategoryService(),serviceClass.getCopyItemService());
		User userLogin=loginController.getUserLogin();
		this.manageLoanController= new ManageLoanController(this.loginController,userLogin,view,serviceClass.getLoanService(),serviceClass.getUserService(),serviceClass.getItemService(),serviceClass.getCopyItemService());
		this.manageReportController= new ManageReportController(view);
		this.ManageReservationController= new ManageReservationController(view,serviceClass.getReservationService(),serviceClass.getUserService(), serviceClass.getItemService());
		System.out.print(userLogin+ "***********userlogin**************");
		
	}


	public User getUserLogin() {
		return userLogin;
	}


	public void setUserLogin(User userLogin) {
		this.userLogin = userLogin;
	}
	
}

