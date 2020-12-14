package com.inesshasanoui.bibliotheekbeheersysteem.service;

import com.inesshasnaoui.bibliotheekbeheersysteem.dao.AuthenticationDao;
import com.inesshasnaoui.bibliotheekbeheersysteem.dao.CategoryDao;
import com.inesshasnaoui.bibliotheekbeheersysteem.dao.CopyItemDao;
import com.inesshasnaoui.bibliotheekbeheersysteem.dao.DaoClass;
import com.inesshasnaoui.bibliotheekbeheersysteem.dao.ItemDao;
import com.inesshasnaoui.bibliotheekbeheersysteem.dao.LoanDao;
import com.inesshasnaoui.bibliotheekbeheersysteem.dao.ReservationDao;
import com.inesshasnaoui.bibliotheekbeheersysteem.dao.RoleUserDao;
import com.inesshasnaoui.bibliotheekbeheersysteem.dao.StateUserDao;
import com.inesshasnaoui.bibliotheekbeheersysteem.dao.UserDao;


public class ServiceClass {
	private UserService userService;
	private ItemService itemService;
	private LoanService loanService;
	private CopyItemService copyItemService;
	private AuthenticationService authenticationService;
	private CategoryService categoryService;
	private RoleUserService roleUserService;
	private StateUserService stateUserService;
	private ReservationService reservationService;
	
	private ItemDao itemDao;
	private CopyItemDao copyItemDao;
	private UserDao userDao;
	private RoleUserDao roleUserDao;
	private LoanDao loanDao;	
	private AuthenticationDao authenticationDao;
	private CategoryDao categoryDao;
	private StateUserDao stateUserDao;
	private ReservationDao reservationDao;
	private DaoClass daoClass;
	
/*	public ServiceClass(ItemDao itemDao, UserDao userDao,AuthenticationDao authenticationDao) {
		super();
		this.itemDao = itemDao;
		this.userDao = userDao;
		this.loanDao = loanDao;
		this.authenticationDao = authenticationDao;
		this.userService = new UserServiceImpl(userDao);
		this.itemService = new ItemServiceImpl(itemDao);;
		this.authenticationService = new AuthenticationServiceImpl(authenticationDao);
	//	this.loanService = new LoanServiceImpl(loanServiceDao);
	}
*/
	public ServiceClass(DaoClass daoClass) {
		super();
		this.itemDao = daoClass.getItemDao();
		this.copyItemDao = daoClass.getCopyItemDao();
		this.userDao = daoClass.getUserDao();
		this.loanDao = daoClass.getLoanDao();
		this.authenticationDao = daoClass.getAuthenticationDao();
		this.categoryDao=daoClass.getCategoryDao();
		this.roleUserDao =daoClass.getRoleUserDao();
		this.stateUserDao = daoClass.getStateUserDao();
		this.reservationDao=daoClass.getReservationDao();
		
		this.userService = new UserServiceImpl(userDao);
		this.copyItemService = new CopyItemServiceImpl(copyItemDao);
		this.itemService = new ItemServiceImpl(itemDao,copyItemService);
		this.authenticationService = new AuthenticationServiceImpl(authenticationDao);
		this.categoryService = new CategoryServiceImpl (categoryDao);
		this.roleUserService = new RoleUserServiceImpl (roleUserDao);
		this.stateUserService =  new StateUserServiceImpl(stateUserDao);
		this.reservationService= new ReservationServiceImpl(reservationDao, copyItemDao);
		this.loanService = new LoanServiceImpl(loanDao,userService,itemService,copyItemService,stateUserService,reservationService);
		
	}
	public UserService getUserService() {
		return userService;
	}

	public ItemService getItemService() {
		return itemService;
	}

	public AuthenticationService getAuthenticationService() {
		return authenticationService;
	}

	public ItemDao getItemDao() {
		return itemDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public LoanDao getLoanDao() {
		return loanDao;
	}

	public AuthenticationDao getAuthenticationDao() {
		return authenticationDao;
	}
	public LoanService getLoanService() {
		return loanService;
	}
	public CategoryService getCategoryService() {
		return categoryService;
	}
	public RoleUserService getRoleUserService() {
		return roleUserService;
	}
	public void setRoleUserService(RoleUserService roleUserService) {
		this.roleUserService = roleUserService;
	}
	public RoleUserDao getRoleUserDao() {
		return roleUserDao;
	}
	
	
	public CopyItemService getCopyItemService() {
		return copyItemService;
	}

	public void setRoleUserDao(RoleUserDao roleUserDao) {
		this.roleUserDao = roleUserDao;
	}
	public StateUserDao getStateUserDao() {
		return stateUserDao;
	}
	public void setStateUserDao(StateUserDao stateUserDao) {
		this.stateUserDao = stateUserDao;
	}
	public StateUserService getStateUserService() {
		return stateUserService;
	}
	
	public ReservationService getReservationService() {
		return reservationService;
	}

	
	
	
}
