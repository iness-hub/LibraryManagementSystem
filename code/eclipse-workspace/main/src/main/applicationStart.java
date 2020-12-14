package main;


import com.inesshasanoui.bibliotheekbeheersysteem.controller.Controller;
import com.inesshasanoui.bibliotheekbeheersysteem.service.ServiceClass;
import com.inesshasanoui.bibliotheekbeheersysteem.view.View;
import com.inesshasnaoui.bibliotheekbeheersysteem.dao.ConnectDB;
import com.inesshasnaoui.bibliotheekbeheersysteem.dao.ConnectSql;
import com.inesshasnaoui.bibliotheekbeheersysteem.dao.DaoClass;

public class applicationStart {

	
	private static Controller controller;
	private static ConnectDB connectSql;
	private static View view;
	private static ServiceClass serviceClass;
	private static DaoClass daoClass;
	

	public static void main(String[] args) {
		connectSql = new ConnectSql();
		view = new View();
		daoClass = new DaoClass(connectSql);
		serviceClass = new ServiceClass(daoClass);
		controller = new Controller(view, serviceClass);
	
	}
	

}
