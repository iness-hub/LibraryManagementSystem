package com.inesshasanoui.bibliotheekbeheersysteem.controller;

import com.inesshasanoui.bibliotheekbeheersysteem.service.UserService;
import com.inesshasanoui.bibliotheekbeheersysteem.view.View;

public class ManageReportController {
	private View view;
	private  UserService userService;

	public ManageReportController(View view) {
		super();
		this.view = view;
	
	}

}
